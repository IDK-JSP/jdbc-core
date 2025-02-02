CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE movie (
    movie_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    poster_path VARCHAR(255)
);

CREATE TABLE favoris (
    user_id INT,
    movie_id INT,
    PRIMARY KEY (user_id, movie_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ,
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

CREATE TABLE my_list (
    user_id INT,
    movie_id INT,
    PRIMARY KEY (user_id, movie_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ,
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);

CREATE TABLE seen_movie (
    user_id INT,
    movie_id INT,
    PRIMARY KEY (user_id, movie_id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id)
);