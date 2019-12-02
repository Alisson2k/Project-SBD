#######################################################################################

# SQL TRIGGER - remove from shopping cart after insert in orders table

# @authors		Alisson Guimarães, João Antônio Nardini and Nathan Augusto
# @date			2019-12-01, sunday 9:22 pm

#######################################################################################

DELIMITER $

CREATE TRIGGER Trg_New_Order AFTER INSERT
ON ORDERS FOR EACH ROW 

BEGIN
    UPDATE PRODUCT SET AMOUNT  = AMOUNT - NEW.quantity
    WHERE NEW.id_prod = PRODUCT.id_prod;
END$

DELIMITER;