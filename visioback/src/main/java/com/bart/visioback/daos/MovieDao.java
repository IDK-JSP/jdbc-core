package com.bart.visioback.daos;

import com.bart.visioback.entitys.Movie;
import com.bart.visioback.exceptions.ResourceNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {
    private  final JdbcTemplate jdbcTemplate;

    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private  final RowMapper<Movie> movieRowMapper = (rs, _) -> new Movie(
            rs.getInt("movie_id"),
            rs.getString("title"),
            rs.getString("poster_path")
    );
    public List<Movie> findAll() {
        String sql = "SELECT * FROM movie";
        return jdbcTemplate.query(sql, movieRowMapper);
    }

    public Movie findById(int id) {
        String sql = "SELECT * FROM movie WHERE id = ?";
        return jdbcTemplate.query(sql, movieRowMapper, id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec l'ID : " + id + " n'existe pas"));
    }
    public Movie save(Movie movie) {

        String sql = "INSERT INTO movie (movie_id, title, poster_path) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, movie.getMovie_id(), movie.getTitle(),movie.getPoster_path());

        String sqlGetId = "SELECT LAST_INSERT_ID()";
        int id = jdbcTemplate.queryForObject(sqlGetId, int.class);

        movie.setMovie_id(id);
        return movie;
    }

    // méthode utilitaire à mettre en bas du fichier
    private boolean movieExists(int id) {
        String checkSql = "SELECT COUNT(*) FROM movie WHERE id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, id);
        return count > 0;
    }
    public boolean delete(int id) {
        String sql = "DELETE FROM movie WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }


}
