create database codecoolshop
	with owner postgres;

create table if not exists product_category
(
	id serial not null
		constraint product_category_pk
			primary key,
	name text not null,
	description text,
	department text
);

alter table product_category owner to postgres;

create table if not exists supplier
(
	id serial not null
		constraint supplier_pk
			primary key,
	name text not null,
	description text
);

alter table supplier owner to postgres;

create table if not exists product
(
	id serial not null
		constraint products_pk
			primary key
		constraint product_category_id
			references product_category
		constraint supplier_id
			references supplier,
	name text not null,
	description text not null,
	default_price double precision not null,
	default_currency text not null
);

alter table product owner to postgres;

create table if not exists cart
(
	id serial not null
		constraint cart_pk
			primary key
		constraint product_id
			references product
);

alter table cart owner to postgres;

create table if not exists "user"
(
	id serial not null
		constraint user_pk
			primary key
		constraint cart_id
			references cart,
	name text not null
);

alter table "user" owner to postgres;


