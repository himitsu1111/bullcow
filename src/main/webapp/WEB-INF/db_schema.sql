CREATE TABLE gamesession
(
    id SERIAL PRIMARY KEY NOT NULL,
    secret_number VARCHAR,
    user_id INT,
    score INT
);
CREATE TABLE gamesession_id_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE scores
(
    id SERIAL PRIMARY KEY NOT NULL,
    userid INT,
    finalscore REAL,
    triesnumber INT
);
CREATE TABLE scores_id_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE users
(
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR NOT NULL,
    pas VARCHAR NOT NULL
);
CREATE TABLE users_id_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
ALTER TABLE gamesession ADD FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE scores ADD FOREIGN KEY (userid) REFERENCES users (id);
CREATE UNIQUE INDEX unique_login ON users (login);
