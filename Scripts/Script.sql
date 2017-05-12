drop database ncs_erp_1;

create database ncs_erp_1;



-- 테스트
DROP SCHEMA IF EXISTS test0510;

-- 테스트
CREATE SCHEMA test0510;

-- 직책
CREATE TABLE test0510.title (
	tcode INT(11)     NOT NULL COMMENT '직책번호', -- 직책번호
	tname VARCHAR(10) NULL     COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE test0510.title
	ADD CONSTRAINT PK_title -- 직책 기본키
		PRIMARY KEY (
			tcode -- 직책번호
		);

-- 사원
CREATE TABLE test0510.employee (
	eno      INT(11)     NOT NULL COMMENT '사번', -- 사번
	ename    VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
	salary   INT(11)     NULL     COMMENT '급여', -- 급여
	dno      INT(11)     NULL     COMMENT '부서', -- 부서
	gender   TINYINT(1)  NULL     COMMENT '성별', -- 성별
	joindate DATE        NULL     COMMENT '입사일', -- 입사일
	title    INT(11)     NULL     COMMENT '직책' -- 직책
)
COMMENT '사원';

-- 사원
ALTER TABLE test0510.employee
	ADD CONSTRAINT PK_employee -- 사원 기본키
		PRIMARY KEY (
			eno -- 사번
		);

-- 부서
CREATE TABLE test0510.department (
	dcode INT(11)  NOT NULL COMMENT '부서번호', -- 부서번호
	dname CHAR(10) NOT NULL COMMENT '부서명', -- 부서명
	floor INT(11)  NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE test0510.department
	ADD CONSTRAINT PK_department -- 부서 기본키
		PRIMARY KEY (
			dcode -- 부서번호
		);

-- 사원
ALTER TABLE test0510.employee
	ADD CONSTRAINT FK_title_TO_employee -- 직책 -> 사원
		FOREIGN KEY (
			title -- 직책
		)
		REFERENCES test0510.title ( -- 직책
			tcode -- 직책번호
		);

-- 사원
ALTER TABLE test0510.employee
	ADD CONSTRAINT FK_department_TO_employee -- 부서 -> 사원
		FOREIGN KEY (
			dno -- 부서
		)
		REFERENCES test0510.department ( -- 부서
			dcode -- 부서번호
		);
		
show tables like 'employee';
show tables in ncs_erp_rcg like 'employee';
show DATABASES like 'ncs_erp_rcg';