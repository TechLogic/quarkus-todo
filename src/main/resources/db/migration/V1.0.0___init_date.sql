CREATE TABLE todo
(
    id bigint NOT NULL,
    text varchar(255),
    CONSTRAINT todoentry_pkey PRIMARY KEY (id)
);

INSERT INTO todo VALUES (1,'Hello World!');