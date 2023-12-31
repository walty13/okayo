/* 
    Script de création de la base de données
    A exécuter dans un terminal MySQL
*/

CREATE TABLE facture (
    ref VARCHAR(50) NOT NULL PRIMARY KEY,
    date_echeance DATE NOT NULL,
    date_facture DATE NOT NULL,
    total_ht DECIMAL(18,2) NOT NULL,
    total_ttc DECIMAL(18,2) NOT NULL
);

CREATE TABLE line (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ref VARCHAR(50) NOT NULL,
    designation VARCHAR(255) NOT NULL,
    pu_ht DECIMAL(18,2) NOT NULL,
    tva DECIMAL(5,2) NOT NULL,
    quantite INT NOT NULL
);

CREATE TABLE client (
    code_client VARCHAR(50) NOT NULL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    code_postal VARCHAR(5) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telephone VARCHAR(10) NOT NULL
);

CREATE TABLE tva (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    valeur DECIMAL(5,2) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE
);

CREATE TABLE product (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    designation VARCHAR(255) NOT NULL,
    pu_ht DECIMAL(18,2) NOT NULL
);

CREATE TABLE facture_line (
    id BIGINT NOt NULL PRIMARY KEY AUTO_INCREMENT,
    ref_facture VARCHAR(50) NOT NULL,
    id_line BIGINT NOT NULL,
    FOREIGN KEY (ref_facture) REFERENCES facture(ref),
    FOREIGN KEY (id_line) REFERENCES line(id)
);

CREATE TABLE facture_client (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ref_facture VARCHAR(50) NOT NULL,
    code_client VARCHAR(50) NOT NULL,
    FOREIGN KEY (ref_facture) REFERENCES facture(ref),
    FOREIGN KEY (code_client) REFERENCES client(code_client)
);

CREATE TABLE product_tva (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_product BIGINT NOT NULL,
    id_tva BIGINT NOT NULL,
    FOREIGN KEY (id_product) REFERENCES product(id),
    FOREIGN KEY (id_tva) REFERENCES tva(id)
);

INSERT INTO tva (valeur, date_debut, date_fin) VALUES (0.2, '2019-01-01', NULL);
INSERT INTO tva (valeur, date_debut, date_fin) VALUES (0.07, '2014-01-01', '2023-12-31');
INSERT INTO tva (valeur, date_debut, date_fin) VALUES (0.055, '2012-01-01', '2023-12-31');

INSERT INTO product (designation, pu_ht) VALUES ('Produit 1', 7000.0);
INSERT INTO product (designation, pu_ht) VALUES ('Produit 2', 3000.0);
INSERT INTO product (designation, pu_ht) VALUES ('Produit 3', 5000.0);

INSERT INTO product_tva (id_product, id_tva) VALUES (1, 1);
INSERT INTO product_tva (id_product, id_tva) VALUES (2, 2);
INSERT INTO product_tva (id_product, id_tva) VALUES (3, 3);

INSERT INTO client (code_client, nom, adresse, code_postal, email, telephone) VALUES ('C1', 'Client 1', 'Adresse 1', '75016', 'test@gmail.com', '0695588351');

