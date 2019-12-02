#######################################################################################

# SQL TRIGGER - decrease amount product after insert in orders table

# @authors		Alisson Guimarães, João Antônio Nardini and Nathan Augusto
# @date			2019-12-01, sunday 9:22 pm

#######################################################################################

DELIMITER $

CREATE TRIGGER Trg_New_Order_Cart AFTER INSERT 
ON ORDERS FOR EACH ROW

BEGIN

    DELETE FROM SHOPPING_CART
    WHERE SHOPPING_CART.id_prod = NEW.id_prod; 

END$

DELIMITER;