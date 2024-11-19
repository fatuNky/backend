INSERT INTO CATEGORY (name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Books', 'Fiction and non-fiction books'),
('Fashion', 'Clothing and accessories');

INSERT INTO TAG (name) VALUES
('New'),
('Used'),
('Discounted'),
('Popular');

INSERT INTO ITEM (title, description, price, condition, date_added, category_id) VALUES
('Smartphone', 'Latest model with 128GB storage', 699.99, 'New', '2024-11-01', 1),
('Laptop', 'Lightweight laptop for work and travel', 1099.50, 'New', '2024-10-15', 1),
('Novel', 'Bestselling fiction novel', 14.99, 'New', '2024-09-20', 2),
('T-shirt', 'Cotton T-shirt with graphic print', 19.99, 'New', '2024-11-05', 3);


INSERT INTO OFFER (offered_price, date_offered, message, item_id) VALUES
(650.00, '2024-11-12', 'Would you accept $650 for this?', 1),
(1000.00, '2024-11-14', 'Is the laptop still available?', 2),
(12.00, '2024-11-15', 'Can I get a discount?', 3);

INSERT INTO ITEM_TAG (item_id, tag_id) VALUES
(1, 1), -- Smartphone is "New"
(2, 1), -- Laptop is "New"
(3, 4), -- Novel is "Popular"
(4, 1); -- T-shirt is "New"
