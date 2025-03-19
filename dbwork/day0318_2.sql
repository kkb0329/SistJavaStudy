DROP SEQUENCE seq_food;
DROP SEQUENCE seq_order;

DROP TABLE foodorder;
DROP TABLE FOODMENU;


create sequence seq_food START WITH 1 INCREMENT BY 3  nocache;

create table FOODMENU(fno number(5) PRIMARY key,
foodname varchar2(30),price number(10), 
shopname varchar2(30),loc varchar2(30)
);

INSERT INTO FOODMENU VALUES (seq_food.nextval, '알리올리오', 15000, '쏘렌토', '역삼역2번출구');
INSERT INTO FOODMENU VALUES (seq_food.nextval, '선덕칼국수', 12000, '선덕칼국수', '역삼역1번출구');
INSERT INTO FOODMENU VALUES (seq_food.nextval, '스매쉬치즈버거', 11000, '스매쉬치즈버거', '역삼역3번출구');
INSERT INTO FOODMENU VALUES (seq_food.nextval, '돈가스', 15000, '갓포돈', '역삼역4번출구');
INSERT INTO FOODMENU VALUES (seq_food.nextval, '비빔밥', 13000, '서진식당', '역삼역5번출구');



create sequence seq_order START WITH 20 INCREMENT BY 1  nocache;

create table foodorder(idx number(5) PRIMARY key,
ordername varchar2(30),
fno number(5) CONSTRAINT order_fk_num REFERENCES foodmenu(fno),
addr varchar2(30)
);




INSERT INTO foodorder VALUES (seq_order.nextval,'일영지',1,'역삼동');
INSERT INTO foodorder VALUES (seq_order.nextval,'이영지',4,'역삼동');
INSERT INTO foodorder VALUES (seq_order.nextval,'삼영지',7,'역삼동');
INSERT INTO foodorder VALUES (seq_order.nextval,'사영지',10,'역삼동');
INSERT INTO foodorder VALUES (seq_order.nextval,'오영지',13,'역삼동');


SELECT * FROM FOODMENU;


SELECT 
    foodorder.fno, 
    foodorder.ordername, 
    foodmenu.foodname, 
    foodmenu.price, 
    foodmenu.shopname,  -- 올바른 컬럼명
    foodmenu.loc,       -- 올바른 컬럼명
    foodorder.addr
FROM 
    foodmenu, foodorder
WHERE
    foodmenu.fno = foodorder.fno
order by  ordername;



