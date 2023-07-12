CREATE TABLE IF NOT EXISTS inquiry
(
    id       INT          NOT NULL AUTO_INCREMENT,
    name     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    contents VARCHAR(500) NOT NULL,
    created  DATETIME     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS survey
(
    id           INT      NOT NULL AUTO_INCREMENT,
    age          INT      NOT NULL,
    satisfaction INT      NOT NULL,
    comment      VARCHAR(100),
    created      DATETIME NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS test_tbl
(
    id       INT          NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    age      INT,
    PRIMARY KEY (id)
);
