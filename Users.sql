USE UserDB;

drop table if exists Users;
CREATE TABLE Users(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('VOTER', 'ADMIN'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

USE UserDB;
select * from Users;

