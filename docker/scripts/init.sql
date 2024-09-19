DO
$$
BEGIN
   IF NOT EXISTS (
      SELECT FROM pg_database
      WHERE datname = 'dbrpe'
   ) THEN
      PERFORM dblink_exec('dbname=postgres', 'CREATE DATABASE dbrpe');
   END IF;
END
$$;

\c dbrpe;

DROP TABLE IF EXISTS card;

CREATE TABLE card (
    card_id BIGSERIAL PRIMARY KEY,
    card_number VARCHAR(20) UNIQUE NOT NULL,
    card_password VARCHAR(255) NOT NULL,
    card_status VARCHAR(10) CHECK (card_status IN ('ATIVO', 'BLOQUEADO', 'CANCELADO')) NOT NULL,
    client_id BIGSERIAL NOT NULL,
    card_holder_name VARCHAR(255) NOT NULL,
    product_id BIGSERIAL NOT NULL,
    card_date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    card_date_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES client(client_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES product(product_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);