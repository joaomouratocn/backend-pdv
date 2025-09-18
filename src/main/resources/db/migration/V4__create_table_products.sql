CREATE TABLE products(
    id UUID PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    barcode VARCHAR(100) UNIQUE,
    cost_price DECIMAL(10,2) NOT NULL DEFAULT 0,
    sale_price DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock_quantity DECIMAL(10,2) NOT NULL DEFAULT 0,
    min_stock DECIMAL(10,2) DEFAULT 0,
    enable BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);