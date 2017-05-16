drop database ncs_erp_1;

create database ncs_erp_rcg;


-- 직책
CREATE TABLE ncs_erp_rcg.title (
	tcode INT(11) NOT NULL,
	tname VARCHAR(10) NULL
);

-- 직책
ALTER TABLE ncs_erp_rcg.title
	ADD CONSTRAINT PK_title -- 직책 기본키
		PRIMARY KEY (
			tcode -- 직책번호
		);
drop table ncs_erp_rcg.employee;
-- 사원
CREATE TABLE ncs_erp_rcg.employee (
	eno      INT(11)     NOT null COMMENT '사번', -- 사번
	ename    VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
	salary   INT(11)     NULL     COMMENT '급여', -- 급여
	dno      INT(11)     NULL     COMMENT '부서', -- 부서
	gender   TINYINT(1)  NULL     COMMENT '성별', -- 성별
	joindate DATE        NULL     COMMENT '입사일', -- 입사일
	title    INT(11)     NULL     COMMENT '직책' -- 직책
)
COMMENT '사원';

-- 사원
ALTER TABLE ncs_erp_rcg.employee
	ADD CONSTRAINT PK_employee -- 사원 기본키
		PRIMARY KEY (
			eno -- 사번
		);


-- 사원
ALTER TABLE ncs_erp_rcg.employee
	ADD CONSTRAINT FK_title_TO_employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책
		)
		REFERENCES ncs_erp_rcg.title ( -- 직책
			tcode -- 직책번호
		);

-- 사원
ALTER TABLE ncs_erp_rcg.employee
	ADD CONSTRAINT FK_department_TO_employee -- 부서 -> 사원
		FOREIGN KEY (
			dno -- 부서
		)
		REFERENCES ncs_erp_rcg.department ( -- 부서
			dcode -- 부서번호
		);
				
		
		
		
-- 부서
CREATE TABLE ncs_erp_rcg.department (
	dcode INT(11)  NOT null COMMENT '부서번호', -- 부서번호
	dname CHAR(10) NOT NULL COMMENT '부서명', -- 부서명
	floor INT(11)  NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE ncs_erp_rcg.department
	ADD CONSTRAINT PK_department -- 부서 기본키
		PRIMARY KEY (
			dcode -- 부서번호
		);

show tables like 'employee';
show tables in ncs_erp_rcg like 'employee';
show DATABASES like 'ncs_erp_rcg';