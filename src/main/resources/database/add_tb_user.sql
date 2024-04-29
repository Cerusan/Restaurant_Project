create table tb_user
(
    id bigserial not null primary key,
    name varchar(100) not null,
    surname varchar(100) not null,
    login varchar(100) not null,
    password varchar not null,
    role varchar not null
)