CREATE TABLE cash_register(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id),
    open_at TIMESTAMP DEFAULT NOW(),
    closed_at TIMESTAMP,
    opening_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    closing_amount DECIMAL(10,2),
    status VARCHAR(20) DEFAULT 'OPEN'
);