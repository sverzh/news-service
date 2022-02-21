DROP TABLE  IF EXISTS comments;
DROP TABLE  IF EXISTS news;


CREATE TABLE news
(
    id    int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    text  VARCHAR(255) NOT NULL,
    date  timestamp    NOT NULL
);

CREATE TABLE comments
(
    id       int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    text     VARCHAR(255) NOT NULL,
    date     TIMESTAMP    NOT NULL,
    news_id  INTEGER NOT NULL,
    FOREIGN KEY (news_id) REFERENCES news (id) ON DELETE CASCADE
);