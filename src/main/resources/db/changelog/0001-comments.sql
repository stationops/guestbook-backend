-- liquibase formatted sql

-- changeset liquibase:1
create table comments(
    id int NOT NULL AUTO_INCREMENT,

    comment TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id));