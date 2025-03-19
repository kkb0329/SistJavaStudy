--rollup 함수
--자동으로 소개/합계를 구해주는 함수
--groupby절에 주어진 조건으로 소계구해준다

select deptno,position,sum(pay) from professor group by position,rollup(deptno);

select position,count(*),sum(pay) from professor group by rollup(position);

--cube 전체 총합계까지 출력하려면 rollup처럼 각소계에 총계까지 구해준다
select deptno,count(*),sum(pay) from professor group by cube (deptno);

--emp에서 직업별 인원수 최대급여 최소급여 구하세요
select job,count(job),max(sal),min(sal) from emp group by job;

--emp에서 부서번호,인원수,급여평균,급여의 합 조회
select deptno,count(*),round(avg(sal),1),sum(sal) from emp group by deptno;

--입사년도별 인원수,sal의 평균 출력하되 입사년도의 오름차순 
select to_char(hiredate,'yyyy'),count(*),avg(sal) from emp group by to_char(hiredate,'yyyy') order by to_char(hiredate,'yyyy');

--[DML]
--102 유아교육과 200
--103 미술교육과 400
--201 영문학과   500
--202 국문학과   600
insert into department (deptno,dname,part) VALUES (102,'유아교육과',200);
insert into department (deptno,dname,part) VALUES (103,'미술교육과',400);
insert into department (deptno,dname,part) VALUES (201,'영문학과',500);
insert into department (deptno,dname,part) VALUES (202,'국문학과',600);

--공과대학,인문대학 삭제
DELETE from department where deptno=10;
DELETE from department where deptno=20;

--professor 데이터 입력
--5001,손흥민,loveme,정교수,500,입사일:오늘,보너스없음,301,
insert into professor (profno,name,id,position,pay,hiredate,deptno) 
VALUES(5001,'손흥민','loveme','정교수',500,sysdate,301);

--조교수들의 보너스를 일괄 100만원으로 인상해주세요
update professor set bonus=100 where position='조교수';

--손흥민교수와 동일한 직급을 가진 교수들중 500이 안되는 교수들의 급여를 15*인상하세요
update professor set pay=pay*1.15 where position=(select position from professor where name ='손흥민')
and pay<500;

--dept2에서 부서번호 1001~1009 사이의 매장들을 모두 삭제해주세요
delete from dept2 where dcode BETWEEN 1001 and 1009;

--alter 테이블의 구조변경
--dept2를 복제하여 dept3를 만들어주세요
create table dept3 as select * from dept2;

--dept3에 loc를 추가하고 기본값으로 대한민국이라고 넣을것
alter table dept3 add loc varchar(20) default'대한민국';

--포항본사의 loc를 포항시청앞으로 수정해주세요
update dept3 set loc='포항시청앞' where area='포항본사';
--
update dept3 set loc='광화문' where area='서울지사';
update dept3 set loc='울산시청' where area='울산지사';

--emp테이블에 totsal 열을 하나더 추가해주세요 number(20)
alter table emp add totsal number(20);
--sal+commd을 더해서 데이터를 추가해주세요
update emp set totsal=sal+nvl(comm,0);
select * from emp;
commit;
--과제테이블-------------------------------------

--1.sequence : seqshop (1부터 2씩증가 캐쉬없음)
create sequence seqshop start with 1 increment by 2 nocache;
--2테이블 :Myshop
-- no  number(5) 기본키,(시퀀스)
--sangpum varchar2(30)
--su number(10)
--price number(10)
--size varchar2(30)
--ipgoday  date  (오늘날짜)
create table myshop(no number(5)primary key,sangpum varchar2(30),
su number(10),price number(10),"size" varchar2(30),ipgoday date);

--최소 5개 이상 insert 해볼것!!
insert into myshop values(seqshop.nextval,'마스크',5,1500,'소형',sysdate);
insert into myshop values(seqshop.nextval,'신발',10,12000,'소형',sysdate);
insert into myshop values(seqshop.nextval,'수박',25,6000,'대형',sysdate);
insert into myshop values(seqshop.nextval,'아이스크림',50,4500,'중형',sysdate);
insert into myshop values(seqshop.nextval,'과자',30,1000,'중형',sysdate);

select * from myshop;

commit;

