#######################################################################################

# SQL script that creates database

# @authors		Alisson Guimarães, João Antônio Nardini and Nathan Augusto
# @date			2019-12-01, sunday 3:45 pm

#######################################################################################

CREATE DATABASE appSBD;
USE appSBD;

CREATE TABLE person (
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

CREATE TABLE CUSTOMER (
    id_person int,
    nickname varchar(128),
    foreign key (id_person) references PERSON(id_person)
);

CREATE TABLE SUPPLIER_PERSON (
    id_person int,
    contact_name varchar(128),
	foreign key (id_person) references PERSON(id_person)
);

CREATE TABLE CLIENT_REPORT (
	id_person int,
    average_rate decimal(2,1), # {0, 10}
    satisfaction_level int, # {1, 5}
    shopping_number int,
    prefer_category varchar(64),
    foreign key (id_person) references PERSON(id_person)
);

CREATE TABLE PURCHASE_HISTORY (
	id_purch int auto_increment,
    id_order int,
	id_company int,	# SUPPLIER
    purchase_date datetime,
    type_of_payment enum('B','C'),
    primary key (id_purch),
    foreign key (id_order) references ORDERS(id_order),
    foreign key (id_company) references COMPANY(id_company)
);

CREATE TABLE PRODUCT (
	id_prod int auto_increment,
    name varchar(128),
    unit_price float,
    description varchar(512),
    rating int,
    amount int,
    primary key (id_prod)
);

CREATE TABLE PRODUCT_DETAIL (
	id_prod int,
    gross_weigth float,
    net_weigth float,
    type_of_material varchar(32),
    color varchar(32),
    model varchar(32),
    brand varchar(32),
    category varchar(64),
    foreign key (id_prod) references PRODUCT(id_prod)
);

CREATE TABLE SHOPPING_CART (
	id_cart int auto_increment,
    id_person int,
    id_prod int,
    quantity int,
    total_price float,
    primary key (id_cart),
    foreign key (id_person) references PERSON(id_person),
    foreign key (id_prod) references PRODUCT(id_prod)
);

CREATE TABLE ORDERS (
	id_order int auto_increment,
    id_prod int,
    order_date datetime,
    order_state enum('Em andamento', 'Aprovado', 'Cancelado'),
    quantity int,
    type_of_payment enum('B', 'C'), # Boleto ou cartão 
    due_date date,
    primary key (id_order),
    foreign key (id_prod) references PRODUCT(id_prod)
);

CREATE TABLE COMPANY (
	id_company int auto_increment,
    email varchar(128),
    cep varchar(16),
    state varchar(64),
    cnpj varchar(32),
    name varchar(128),
    city varchar(64),
    country varchar(64),
    phone varchar(16),
    address varchar(128),
    primary key (id_company)
);

CREATE TABLE SHIPPER (
	id_shipper int auto_increment,
    id_company int,
    type varchar(64),
    work_schedule varchar(128),
    shipping_price float,
    description varchar(512),
    primary key (id_shipper),
    foreign key (id_company) references COMPANY(id_company)
);

CREATE TABLE SUPPLIER_COMPANY (
	id_supplier int auto_increment,
    id_company int,
    contact_name varchar(128),
    primary key (id_supplier),
    foreign key (id_company) references COMPANY(id_company)
);

### ARRUMAR NO DIAGRAMA EER AS TABELAS ###
# PURCHASE_HISTORY > trocar 'order_state' e 'carrier_name' por 2 FK, id_order, id_company
# PRODUCT_DETAIL > remover atributo 'name' > já está na tabela product