
drop table if exists public.product_category;
drop sequence if exists public.product_category_id_seq;
create table product_category
(
	id serial not null
		constraint product_category_pk
			primary key,
	name text not null,
	description text,
	department text
);

drop table if exists public.supplier;
drop sequence if exists public.supplier_id_seq;
create table supplier
(
	id serial not null
		constraint supplier_pk
			primary key,
	name text not null,
	description text
);

drop table if exists public.product;
drop sequence if exists public.products_id_seq;
create table product
(
	id serial not null
		constraint products_pk
			primary key,
	name text not null,
	description text not null,
	default_price double precision not null,
	default_currency text not null,
    product_category_id integer not null,
    supplier_id integer not null
);

ALTER TABLE ONLY product
ADD CONSTRAINT fk_product_category_id FOREIGN KEY (product_category_id) REFERENCES product_category(id);

ALTER TABLE ONLY product
ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES supplier(id);


drop table if exists public.buyer;
drop sequence if exists public.buyer_id_seq;
create table buyer
(
	id serial not null
		constraint buyer_pk
			primary key,
	name text not null
);


