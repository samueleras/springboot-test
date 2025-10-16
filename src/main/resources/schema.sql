DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";
DROP SEQUENCE IF EXISTS authors_id_seq;

CREATE SEQUENCE authors_id_seq START 1;


CREATE TABLE "authors"
(
    "authorid" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("authorid")
);

CREATE TABLE "books"
(
    "isbn" text NOT NULL,
    "title" text,
    "authorid" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (authorid)
    REFERENCES authors (authorid)
);
