#######################################################################################

# SQL script that insert datas in database

# @authors		Alisson Guimarães, João Antônio Nardini and Nathan Augusto
# @date			2019-12-01, sunday 7:14 pm

#######################################################################################

INSERT INTO PERSON (id_person, phone, country, fname, lname, cpf, state, email, address, bdate)
values	(DEFAULT, '(15)7533-7027', 'Brazil', 'Diego', 'Lima', '422.108.117-16', 'SP', 'diegolimarocha@mail.com', 'Rua Professor José Odin de Arruda, 1413','1974-06-29'),
		(DEFAULT, '(61)2180-5442', 'Brazil', 'Nicolas', 'Almeida', '189.828.295-12', 'DF', 'nicolasalmeidabarbosa@mail.com', 'Quadra SQS 112 Bloco F, 819','1980-06-03'),
		(DEFAULT, '(63)2479-8252', 'Brazil', 'Juieta', 'Barbosa', '114.994.475-74', 'TO', 'julietabarbosabarros@mail.com', 'Rua Josefa Alves da Cunha, 1332','1990-12-03'),
        (DEFAULT, '(91)3396-9873', 'Brazil', 'Breno', 'Rocha', '332.777.838-80', 'PA', 'brenorochaalmeida@mail.com', 'Rua Louis Pasteur, 375','1988-09-29'),
        (DEFAULT, '(71)5291-5884', 'Brazil', 'Carolina', 'Goncalves', '126.115.850-40', 'BA', 'carolinagoncalvesferreira@mail.com', 'Estrada do Cemitério, 735','1998-02-14'),
        (DEFAULT, '(21) 5727-5082', 'Brazil', 'Luis', 'Lima', '547.490.650-13', 'RJ', 'luislimacalvacanti@mail.com', 'Rua Dona Jove, 573','1996-01-25');

INSERT INTO CLIENT_REPORT (id_person, average_rate, satisfaction_level, shopping_number, prefer_category)
values	(1, 7.2, 4, 22, 'Eletrônicos'),
		(3, 8.1, 5, 6, 'Roupas e Acessórios'),
        (4, 4.9, 2, 9, 'Móveis'),
        (6, 7.8, 4, 5, 'Eletrônicos');

INSERT INTO CUSTOMER (id_person, nickname)
values	(1, 'Digao'),
		(3, 'Ju'),
        (4, 'Brenim'),
        (6, 'Lu');

INSERT INTO SUPPLIER_PERSON (id_person, contact_name)
values	(2, 'Nicolas Almeida'),
		(5, 'Carolina Goncalves');

INSERT INTO PRODUCT (id_prod, name, unit_price, description, rating, amount)
values	(DEFAULT, 'Smart TV 4K', 4599.99, 'Smart Tv 4k Samsung Led 75 , Hdmi, Wifi, Usb - 75ru7100', 9, 23),
		(DEFAULT, 'Vestido Justo Feminino', 59.99, 'Vestido Midi Justo Canelado Moda Roupas Femininas', 7, 78),
        (DEFAULT, 'Violão Elétrico', 530.00, 'Violão Eletroacustico Tagima Memphis Md-18 + Kit Completo', 8, 9);

INSERT INTO PRODUCT_DETAIL (id_prod, gross_weigth, net_weigth, type_of_material, color, model, brand, category)
values	(1, 37.7, 37.7, 'LED', 'Preto', 'Midi', 'SAMSUNG', 'Eletrônicos'),
		(2, 0.5, 0.5, 'Canelado', 'Rosa', 'UN75RU7100GXZD', 'UBER MODAS', 'Roupas e Acessórios'),
        (3, 2.2, 2.2, 'Tilia', 'Bege', 'Memphis', 'Tagima', 'Instrumentos Musicais');

INSERT INTO COMPANY (id_company, email, cep, state, cnpj, name, city, country, phone, address)
values	(DEFAULT, 'ubermodas@mail.com', '31578-020', 'MG', '69.825.065/0001-72', 'UBER MODAS', 'Belo Horizonte', 'Brazil', '(31)99671-8080', 'Rua Orlando Mendes, 995'),
		(DEFAULT, 'tagima@mail.com', '21512-200', 'RJ', '48.834.360/0001-15', 'Tagima', 'Rio de Janeiro', 'Brazil', '(21)21118-8202', 'Rua de Bonsucesso, 494'),
        (DEFAULT, 'froidshipper@mail.com', '03681-030', 'SP', '46.353.414/0001-03', 'Froid Shipper', 'São Paulo', 'Brazil', '(11)60907-3062', 'Rua Filomeno Batista de Araújo, 242');

INSERT INTO ORDERS ()
values	()

INSERT INTO SHOPPING_CART (id_person,id_prod,total_price) VALUES (1, 3, 530);

INSERT INTO SHIPPER (id_shipper, id_company, type, work_schedule, shipping_price, description)
values	(DEFAULT, 3, 'Encomendas', 'SEG-SEX 08:00:00-18:00:00 SAB 08:00:00-12:00:00', 3800.00, "Froid Shipper. Rápido, fácil, flexível.");

INSERT INTO SUPPLIER_COMPANY (id_supplier, id_company, contact_name)
values 	(DEFAULT, 1, "Uber Modas"),
		(DEFAULT, 2, "Tagima Instrumentos");


