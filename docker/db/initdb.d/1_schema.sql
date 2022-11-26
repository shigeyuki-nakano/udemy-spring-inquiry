DROP TABLE IF EXISTS inquiry;
DROP TABLE IF EXISTS survey;
DROP TABLE IF EXISTS test_tbl;


CREATE TABLE inquiry
(
    id       INT          NOT NULL AUTO_INCREMENT,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    contents VARCHAR(500) NOT NULL,
    created  TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE survey
(
    id           INT      NOT NULL AUTO_INCREMENT,
    age          INT      NOT NULL,
    satisfaction INT      NOT NULL,
    comment      VARCHAR(100),
    created      TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE test_tbl
(
    id       INT          NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    age      INT,
    PRIMARY KEY (id)
);
