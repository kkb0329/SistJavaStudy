DROP SEQUENCE seq_shop;

DROP TABLE cart1;
DROP TABLE cart2;
DROP TABLE shop;


create sequence seq_shop START WITH 1  nocache;

create table shop(num number(5) PRIMARY key,
sanpum varchar2(30),color varchar2(20)
);

INSERT INTO shop VALUES (seq_shop.nextval,'요가매트','핑크');
INSERT INTO shop VALUES (seq_shop.nextval,'아령','블랙');
INSERT INTO shop VALUES (seq_shop.nextval,'나시티','블루');
INSERT INTO shop VALUES (seq_shop.nextval,'레깅스','블랙');
INSERT INTO shop VALUES (seq_shop.nextval,'양말','화이트');

create table cart1(idx number(5) PRIMARY key,
num number(5) CONSTRAINT cart_fk_num REFERENCES shop(num),
cnt number(5),guipday date
);

create table cart2(idx number(5) PRIMARY key,
num number(5) CONSTRAINT cart2_fk_num REFERENCES shop(num)on delete cascade,
cnt number(5),guipday date
);


INSERT INTO cart1 VALUES (seq_shop.nextval,1,2,sysdate);
INSERT INTO cart1 VALUES (seq_shop.nextval,5,2,sysdate);
INSERT INTO cart1 VALUES (seq_shop.nextval,5,3,sysdate);
INSERT INTO cart1 VALUES (seq_shop.nextval,1,2,sysdate);
INSERT INTO cart1 VALUES (seq_shop.nextval,2,1,sysdate);
INSERT INTO cart1 VALUES (seq_shop.nextval,3,3,sysdate);


INSERT INTO cart2 VALUES (seq_shop.nextval,3,3,sysdate);
INSERT INTO cart2 VALUES (seq_shop.nextval,2,4,sysdate);
INSERT INTO cart2 VALUES (seq_shop.nextval,5,3,sysdate);
INSERT INTO cart2 VALUES (seq_shop.nextval,2,1,sysdate);
INSERT INTO cart2 VALUES (seq_shop.nextval,2,6,sysdate);
INSERT INTO cart2 VALUES (seq_shop.nextval,1,5,sysdate);


SELECT 
    c.idx, 
    s.num, 
    s.sanpum, 
    s.color, 
    c.cnt, 
    c.guipday
FROM 
    (
        SELECT idx, num, cnt, guipday FROM cart1
        UNION
        SELECT idx, num, cnt, guipday FROM cart2
    ) c
JOIN shop s
    ON c.num = s.num;



