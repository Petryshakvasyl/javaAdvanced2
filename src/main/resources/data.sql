create database i_shop;

use i_shop;

create table bucket(
			id int not null primary key auto_increment,
            purchase_date timestamp not null
            );

create table users(
	id int not null primary key auto_increment,
    email varchar(75) not null unique,
    first_name varchar(75) not null,
    last_name varchar(100) not null,
    password varchar(30) not null,
    role varchar(50) not null,
    bucket_id int not null,
    foreign key (bucket_id) references bucket(id)
    );

create table products(
		id int not null primary key auto_increment,
        name varchar(75) not null unique,
        description TEXT not null,
        price decimal(8,2) not null,
        count int not null
        );

create table bucket_product (
	bucket_id int not null,
    product_id int not null,
    product_count int not null,
    foreign key (bucket_id) references bucket(id),
    foreign key (product_id) references products(id)
    );
