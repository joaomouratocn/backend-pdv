CREATE TABLE products(
    id UUID PRIMARY KEY gen_random_uuid(),
    name VARCHAR(150) NOT NULL,
    description TEXT,
    barcode VARCHAR(100) UNIQUE,
    cost_price DECIMAL(10,2) NOT NULL DEFAULT 0,
    sale_price DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock_quantity DECIMAL(10,2) NOT NULL DEFAULT 0,
    min_stock DECIMAL(10,2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT NOW()
    updated_at TIMESTAMP DEFAULT NOW()
);