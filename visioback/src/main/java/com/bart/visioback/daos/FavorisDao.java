package com.bart.visioback.daos;

import com.bart.visioback.entitys.Favoris;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavorisDao {
    private  final JdbcTemplate jdbcTemplate;

    public FavorisDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private  final RowMapper<Favoris> favorisRowMapper = (rs, _) -> new Favoris(
            rs.getInt("movie_id"),
            rs.getInt("user_id")

    );
    public List<Favoris> findAll() {
        String sql = "SELECT * FROM favoris";
        return jdbcTemplate.query(sql, favorisRowMapper);
    }
    public Favoris save(Favoris favoris) {

        String sql = "INSERT INTO favoris (user_id, movie_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favoris.getUser_id(),favoris.getMovie_id());


        return favoris;
    }

    // méthode utilitaire à mettre en bas du fichier
    public boolean delete(int id) {
        String sql = "DELETE FROM favoris WHERE movie_id = ? and user_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0;
    }


}
