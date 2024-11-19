CREATE TABLE IF NOT EXISTS CATEGORY (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS TAG (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS ITEM (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    condition VARCHAR(50) NOT NULL,
    date_added DATE DEFAULT CURRENT_DATE,
    category_id INT,
    CONSTRAINT fk_item_category FOREIGN KEY (category_id) REFERENCES CATEGORY (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS OFFER (
    id SERIAL PRIMARY KEY,
    offered_price DECIMAL(10, 2) NOT NULL CHECK (offered_price >= 0),
    date_offered DATE DEFAULT CURRENT_DATE,
    message TEXT,
    item_id INT,
    CONSTRAINT fk_offer_item FOREIGN KEY (item_id) REFERENCES ITEM (id) ON DELETE CASCADE
);

-- Create the Many-to-Many relationship table for Item and Tag
CREATE TABLE IF NOT EXISTS ITEM_TAG (
    item_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (item_id, tag_id),
    CONSTRAINT fk_item_tag_item FOREIGN KEY (item_id) REFERENCES ITEM (id) ON DELETE CASCADE,
    CONSTRAINT fk_item_tag_tag FOREIGN KEY (tag_id) REFERENCES TAG (id) ON DELETE CASCADE
);
