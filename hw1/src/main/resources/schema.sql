create table if not exists users (
                       ID               BIGSERIAL NOT NULL,
                       FIRSTNAME        VARCHAR(50) NOT NULL,
                       LASTNAME         VARCHAR(50) NOT NULL,
                       LOGIN            VARCHAR(50) NOT NULL,
                       BIRTHDATE        DATE,
                       EMAIL            VARCHAR(50) NOT NULL,
                       PASSWORD         VARCHAR(120) NOT NULL,
                       GENDER           VARCHAR(20),
                       HOBBY            VARCHAR(120),
                       CITY             VARCHAR(20),
                       ROLE             VARCHAR(20),
                       PRIMARY KEY (ID)
);