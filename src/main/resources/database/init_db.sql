create table tb_category
(
    id bigserial not null primary key,
    name varchar(100) not null unique
);

create table tb_menu
(
    id bigserial not null primary key,
    menu_type varchar,
    name varchar(100) not null unique,
    calories int,
    price int not null,
    carbohydrates double precision,
    structure varchar(200),
    strength int
);

create table tb_category_menu
(
    menu_id bigserial references tb_menu(id) not null ,
    category_id bigserial references tb_category(id) not null
);