CREATE TABLE cash_movements(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cash_register_id UUID NOT NULL REFERENCES cash_register(id),
    movement_type VARCHAR(20) NOT NULL, -- sangria, suprimento, venda
    amount DECIMAL(10,2) NOT NULL,
    user_id UUID REFERENCES users(id),
    note TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);