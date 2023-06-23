create table movies
(
    id      varchar(255) not null
        primary key,
    title   varchar(255) not null,
    year    varchar(4)   not null,
    genre   varchar(50)  not null,
    imdb_id varchar(50)  null
);

