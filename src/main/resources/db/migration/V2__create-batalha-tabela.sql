CREATE TABLE batalhas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    teatro_id BIGINT NOT NULL,
    resultado VARCHAR(100) NOT NULL,
    CONSTRAINT fk_teatro FOREIGN KEY (teatro_id) REFERENCES teatros(id)
);
