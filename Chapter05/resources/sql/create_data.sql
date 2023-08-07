-- 테이블 삭제
DROP TABLE s_dept;
DROP TABLE s_emp;

-- 부서 테이블
CREATE TABLE s_dept (
	dept_id 	NUMBER(7)	CONSTRAINT s_dept_id_nn NOT NULL,  -- 부서 아이디
	name 		VARCHAR(25) CONSTRAINT s_dept_name_nn NOT NULL,  -- 부서 이름
    CONSTRAINT s_dept_id_pk PRIMARY KEY (dept_id)
);

-- 직원 테이블
CREATE TABLE s_emp(
	id 	NUMBER(7)	CONSTRAINT s_emp_id_nn NOT NULL,  -- 직원 아이디
	name 		VARCHAR(25) CONSTRAINT s_emp_name_nn NOT NULL,  -- 직원 이름
    dept_id 	number(7),
    constraint s_emp_id_pk primary key (id)
);

alter table s_emp add constraint s_emp_dept_id_fk
	foreign key (dept_id) references s_dept (dept_id);
    
insert into s_dept values(1, '개발부');
insert into s_emp values(1, '둘리' 1);
insert into s_emp values(2, '도우너', 1);
