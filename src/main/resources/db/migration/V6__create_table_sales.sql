CREATE TABLE sales(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID REFERENCES users(id),
    total DECIMAL(10,2) NOT NULL,
    discount DECIMAL(10,2) DEFAULT 0,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR DEFAULT 'COMPLETED',
    created_at TIMESTAMP DEFAULT NOW(),
    synced BOOLEAN DEFAULT FALSE
);