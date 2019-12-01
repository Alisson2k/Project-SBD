#######################################################################################

# SQL script that creates database

# @authors		Alisson Guimarães, João Antônio Nardini and Nathan Augusto
# @date			2019-12-01, sunday 3:45 pm

#######################################################################################

CREATE DATABASE appSBD;
USE appSBD;

CREATE TABLE PERSON (
	id_person int auto_increment,
    phone varchar(16),
    country varchar(64),
    fname varchar(64),
    lname varchar(64),
	cpf varchar(16),
    state varchar(64),
    email varchar(128),
    address varchar(128),
    bdate date,
    primary key (id_person)
);

# DROP TABLE PERSON;

CREATE TABLE CLIENT_REPORT (
	id_person int,
    average_rate decimal(2,1),
    satisfaction_level decimal(2,1),
    shopping_number int,
    prefer_category varchar(64),
    foreign key (id_person) references PERSON(id_person)
);

# DROP TABLE CLIENT_REPORT

CREATE TABLE PRODUCT (
	id_prod int auto_increment,
    name varchar(128),
    unit_price float,
    description varchar(512),
    rating int,
    amount int,
    primary key (id_prod)
);

# DROP TABLE PRODUCT

CREATE TABLE PRODUCT_DETAIL (
	id_prod int,
    name varchar(128),
    gross_weigth float,
    net_weigth float,
    type_of_material varchar(32),
    color varchar(32),
    model varchar(32),
    brand varchar(32),
    category varchar(64),
    foreign key (id_prod) references PRODUCT(id_prod)
);

# DROP TABLE PRODUCT_DETAIL

CREATE TABLE COMPANY (
	id_company int auto_increment,
    email varchar(128),
    cep varchar(16),
    state varchar(64),
    cnpj varchar(16),
    category varchar(64),
    name varchar(128),
    city varchar(64),
    country varchar(64),
    phone varchar(16),
    address varchar(128),
    primary key (id_company)
);

# DROP TABLE COMPANY

CREATE TABLE ORDERS (
	id_order int auto_increment,
    order_date datetime,
    order_state enum('Em andamento', 'Aprovado', 'Cancelado'),
    quantity int,
    type_of_payment enum('B', 'C'), # Boleto ou cartão 
    due_date date,
    primary key (id_order)
);

# DROP TABLE ORDERS

CREATE TABLE PURCHASE_HISTORY (
	id_purch int auto_increment,
    purchase_date datetime,
    type_of_payment enum('B','C'),
    # order_state > change to id_order
    # carrier_name > change to id_company (SHIPPER)
    primary key (id_purch)
);

# DROP TABLE PURCHASE_HISTORY

CREATE TABLE SHOPPING_CART (
	id_cart int auto_increment,
    quantity int,
    total_price float,
    primary key (id_cart)
);

# DROP TABLE SHOPPING_CART

CREATE TABLE CUSTOMER (
	id_customer int auto_increment,
    id_person int,
    nickname varchar(128),
    primary key (id_customer),
    foreign key (id_person) references PERSON(id_person)
);

# DROP TABLE CUSTOMER

CREATE TABLE SUPPLIER (
	id_supplier int auto_increment,
    id_person int,
    contact_name varchar(128),
	primary key (id_supplier),
	foreign key (id_person) references PERSON(id_person)
);

# DROP TABLE SUPPLIER

CREATE TABLE SHIPPER (
	id_shipper int auto_increment,
    id_company int,
    type varchar(64),
    work_schedule varchar(128),  # AVALIAR O TIPO AQUI
    shipping_price float,
    description varchar(512),
    primary key (id_company),
    foreign key (id_company) references COMPANY(id_company)
);

# DROP TABLE SHIPPER

CREATE TABLE SUPPLIER (
	id_supplier int auto_increment,
    id_company int,
    contact_name varchar(128),
    primary key (id_supplier),
    foreign key (id_company) references COMPANY(id_company)
);

# DROP TABLE SUPPLIER