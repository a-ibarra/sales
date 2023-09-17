CREATE TABLE BRAND
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE PRICE
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id   BIGINT,
    start_date TIMESTAMP      NOT NULL,
    end_date   TIMESTAMP      NOT NULL,
    price_list INT            NOT NULL,
    product_id BIGINT         NOT NULL,
    priority   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    curr       VARCHAR(3)     NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES BRAND (id)
);

CREATE INDEX idx_brand_id ON PRICE (brand_id);
CREATE INDEX idx_start_date ON PRICE (start_date);
CREATE INDEX idx_end_date ON PRICE (end_date);
CREATE INDEX idx_product_id ON PRICE (product_id);

INSERT INTO BRAND(id, name)
VALUES (1, 'ZARA');

INSERT INTO PRICE(brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
       (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
       (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
       (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');
