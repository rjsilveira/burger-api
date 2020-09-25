CREATE TABLE burger
(
    idt_burger   BIGINT(20) UNSIGNED                                                                               NOT NULL AUTO_INCREMENT COMMENT 'PK. Identificador unico definido com auto_increment',
    num_quantity INTEGER                                                                                           NULL COMMENT 'Quantidade de burgers',
    des_bread    ENUM ('KAISER_ROLL','ONION_ROLL','POTATO_ROLL','PRETZEL_ROLL', 'SESAME_SEED_BUN', 'SLICED_BREAD') NOT NULL COMMENT 'Tipo de pão',
    des_cheese   ENUM ('CHEDDAR','SWISS','BRIE','GOUDA')                                                           NOT NULL COMMENT 'Tipo de queijo',
    des_salad    ENUM ('LETTUCE','ARUGULA','CHARD')                                                                NOT NULL COMMENT 'Tipo de salada',
    des_sauce    ENUM ('ITALIAN','SPICY')                                                                          NOT NULL COMMENT 'Tipo de molho',
    des_size     ENUM ('SMALL','MEDIUM','BIG')                                                                     NOT NULL COMMENT 'Tamanho do burger',
    flg_double   TINYINT(1)                                                                                        NOT NULL COMMENT 'Flag para se é 2 hamburguers.',
    dat_created  TIMESTAMP                                                                                         NOT NULL COMMENT 'Data de criacao do registro.',
    dat_updated  TIMESTAMP                                                                                         NOT NULL COMMENT 'Data de atualizacao do registro.',
    PRIMARY KEY burger_pk (idt_burger)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT 'Tabela para armazenamento dos burgers';
