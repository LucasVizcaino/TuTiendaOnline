-- Crear tabla Category
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE INDEX name_category
    on company("name");

-- Crear tabla Products
CREATE TABLE products (
    id SERIA5) NOL PRIMARY KEY,
    name VARCHAR(25T NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    name_category BIGINT,
    FOREIGN KEY (id_category) 
    REFERENCES category(id)
);

