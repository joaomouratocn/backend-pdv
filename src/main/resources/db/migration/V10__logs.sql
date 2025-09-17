CREATE TABLE logs (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    action VARCHAR(100) NOT NULL,
    description TEXT,
    entity VARCHAR(50), -- ex: 'product', 'sale', 'stock_movement'
    entity_id UUID,
    created_at TIMESTAMP DEFAULT NOW()
);