CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuarios (login, clave) VALUES ('admin', '$2a$10$Y50UaEVPw9hsj8p9JI2BLe.n9Wv.N92y6N8v6S.n9Wv.N92y6N8v6');
-- Nota: La clave es '123456' encriptada con BCrypt.