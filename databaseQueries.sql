CREATE TABLE category(
  id IDENTITY,
  name VARCHAR (50),
  description VARCHAR (50),
  image_url VARCHAR (50),
  is_active BOOLEAN,

  CONSTRAINT pk_category_id PRIMARY KEY(id)

);

INSERT INTO category (name, description, image_url, is_active) VALUES ('Mobile', 'Mobile Description','CAT_1.png',true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('TV', 'TV Description','CAT_2.png',true);
INSERT INTO category (name, description, image_url, is_active) VALUES ('Laptop', 'Laptop Description','CAT_3.png',true);

CREATE TABLE user_detail(
  id IDENTITY ,
  first_name VARCHAR (50),
  last_name VARCHAR (50),
  role VARCHAR (50),
  enabled BOOLEAN,
  password VARCHAR (50),
  email VARCHAR (100),
  contact_number VARCHAR (20),

  CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Naseef','Mohammed','ADMIN',true,'admin','naseefmohammed012@gmail.com','01875072919');

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Sabbir','Ridwan','SUPPLIER',true,'sabbir','sabbir@gmail.com','010291');

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Shaneela','Sharif','SUPPLIER',true,'shaneela','shaneela@gmail.com','017172712');

CREATE TABLE product(
  id IDENTITY ,
  code VARCHAR (20),
  name VARCHAR (50),
  brand VARCHAR (50),
  description VARCHAR (255),
  unit_price DECIMAL (10,2),
  quantity INT,
  is_active BOOLEAN,
  category_id INT ,
  supplier_id INT,
  purchases INT DEFAULT 0,
  views INT DEFAULT 0,

  CONSTRAINT pk_product_id PRIMARY KEY (id),
  CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
  CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX','iphone 5s','apple','one of the best phones available','50000',10,TRUE ,1,2);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC456GHIJX','samsung s7','samsung','samsung is awesome','32000',50,TRUE ,1,3);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC789GHIJX','samsung s6','samsung','high quality mobile','30000',20,TRUE ,1,2);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDEF123KLMX','dell laptop','dell','high quality laptop','45000',10,TRUE ,3,3);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF789KLMX','asus laptop','asus','reasonable laptop','35000',25,TRUE ,3,3);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDTVS789DEFX','samsung TV','samsung','high quality tv','150000',5,TRUE ,2,2);


