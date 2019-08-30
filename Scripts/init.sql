use ncs_exam;
-- 내 스키마
DROP SCHEMA IF EXISTS ncs_exam;

-- 내 스키마
CREATE SCHEMA ncs_exam;

-- 제품
CREATE TABLE ncs_exam.product (
	code CHAR(4)     NOT NULL COMMENT '제품코드', -- 제품코드
	name VARCHAR(20) NULL     COMMENT '제품명' -- 제품명
)
COMMENT '제품';

-- 제품
ALTER TABLE ncs_exam.product
	ADD CONSTRAINT PK_product -- 제품 기본키
		PRIMARY KEY (
			code -- 제품코드
		);

-- 판매현황
CREATE TABLE ncs_exam.sale (
	no         INT     NOT NULL COMMENT '번호', -- 번호
	price      INT     NOT NULL COMMENT '가격', -- 가격
	saleCnt    INT     NOT NULL COMMENT '판매량', -- 판매량
	marginRate INT     NOT NULL COMMENT '마진율', -- 마진율
	code       CHAR(4) NOT NULL COMMENT '제품코드' -- 제품코드
)
COMMENT '판매현황';

-- 판매현황
ALTER TABLE ncs_exam.sale
	ADD CONSTRAINT PK_sale -- 판매현황 기본키
		PRIMARY KEY (
			no -- 번호
		);
alter table ncs_exam.sale
modify column no int auto_increment;
set foreign_key_checks = 0;
-- 판매현황
ALTER TABLE ncs_exam.sale
	ADD CONSTRAINT FK_product_TO_sale -- 제품 -> 판매현황
		FOREIGN KEY (
			code -- 제품코드
		)
		REFERENCES ncs_exam.product ( -- 제품
			code -- 제품코드
		);
	
	desc ncs_exam.sale;
-- 순위 구하는 프로시저
DROP PROCEDURE IF EXISTS ncs_exam.price_rank;

DELIMITER $$
$$
CREATE definer=root@localhost PROCEDURE ncs_exam.price_rank(in isSale boolean)
begin
	set @rank := 0, @price := 0;

	select *, greatest(@rank := if(@price = if(isSale, salePrice, marginPrice), @rank, @rank + 1), least(0, @price := if(isSale, salePrice, marginPrice))) as rank
	from (select product.code, name, no, price, saleCnt, marginRate, (@salePrice := saleCnt * price) as salePrice,
		ceiling( @addTax := (@salePrice / 11) ) as addTax,
		ceiling( @supplyTax := (@salePrice - @addTax) ) as supplyTax,
		round(@supplyTax * marginRate / 100) as marginPrice from product join sale on product.code = sale.code) t
		order by if(isSale, salePrice, marginPrice) desc;
END$$
DELIMITER ;