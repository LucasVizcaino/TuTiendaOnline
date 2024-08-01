-- Insertar productos en la tabla products
INSERT INTO products (name, description, price, stock, category_id) VALUES
('Smartphone XYZ', 'Latest model with advanced features', 799.99, 50, (SELECT id FROM category WHERE name = 'NONE')),
('Laptop ABC', 'High-performance laptop for gaming and work', 1299.99, 30, (SELECT id FROM category WHERE name = 'NONE')),
('Wireless Headphones', 'Noise-cancelling over-ear headphones', 199.99, 100, (SELECT id FROM category WHERE name = 'NONE'));
