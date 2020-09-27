CREATE TABLE burger
(
    id       BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'PK. Identificador unico definido com auto_increment',
    quantity INTEGER             NULL COMMENT 'Quantidade de burgers',
    bread    VARCHAR(255)        NOT NULL COMMENT 'Tipo de pão',
    cheese   VARCHAR(255)        NOT NULL COMMENT 'Tipo de queijo',
    salad    VARCHAR(255)        NOT NULL COMMENT 'Tipo de salada',
    sauce    VARCHAR(255)        NOT NULL COMMENT 'Tipo de molho',
    size     VARCHAR(255)        NOT NULL COMMENT 'Tamanho do burger',
    isdouble TINYINT(1)          NOT NULL COMMENT 'Flag para se é 2 hamburguers.',
    creation TIMESTAMP           NOT NULL COMMENT 'Data de criacao do registro.',
    updated  TIMESTAMP           NOT NULL COMMENT 'Data de atualizacao do registro.',
    PRIMARY KEY burger_pk (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT 'Tabela para armazenamento dos burgers';
