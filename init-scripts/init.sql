--CREATE DATABASE library;
--GRANT ALL PRIVILEGES ON DATABASE library TO user;
\c library

CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) ,
    genre VARCHAR(255)
);

-- Insert initial data
--INSERT INTO books (name, author, genre) VALUES ('Foundation', 'Isaac Asimov', 'Sci-Fi');