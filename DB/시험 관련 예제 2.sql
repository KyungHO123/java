# 계정 생성 시 비밀번호는 생략될 수 있지만 보안을 위해 비번을 설정해야 함
# 계정 생성 권한이 있는 사용자만 계정을 추가할 수 있다.
CREATE USER 'qwe'@localhost identified by 'qwe';
# qwe 계정으로 접속해서 계정 추가를 시도하면
# you need the CREATE USER privilege(s) for this operation   에러 발생
# create user 권한을 부여하면 계정을 생성할 수 있다.
grant create user on *.* to 'qwe'@localhost;

SELECT * FROM mysql.user;

# 권한을 적용
flush privileges;


# %가 들어간 문자열을 검색할 때. %와 같이 기능이 있는 문자는 앞에 \를 추가해서 작성
SELECT * FROM 테이블명 WHERE 속성명 LIKE '%\%%';

# AND와 OR 연산자 중에서 우선순위가 AND가 높다. 그래서 OR 연산자를 먼저하려면 ()를 반드시 붙여야 한다.
# 속성값이 NULL이 아닌 경우만 조회하는 쿼리
SELECT * FROM 테이블명 WHERE 속성 IS NOT NULL;


# =============================================================
# 조건에 집계함수 결과를 이용하려면 HAVING절에 조건을 추가해야 함.
SELECT 테이블명.*, COUNT(속성명2) AS 개수 FROM 테이블명
GROUP BY 속성명
HAVING 개수 >= 5;

# ROW_NUMBER() OVER(ORDER BY 속성) : 검색 결과에 순서를 부여
# ROW_NUMBER() 검색 결과를 이용하여 조건을 작업하려면 서브쿼리를 이용해야 한다.
SELECT * FROM
(SELECT 속성들, ROW_NUMBER() OVER(ORDER BY 속성 DESC) AS 순서 FROM 테이블명)
WHERE 순서 > 3;

# 테이블A의 a속성이 테이블B의 b속성에 참조 되는 경우 join하는 쿼리
SELECT * FROM A JOIN B ON a = b;
# 테이블A의 a속성이 테이블B의 a속성에 참조 되는 경우 join하는 쿼리
SELECT * FROM A JOIN B ON A.a = B.a;
SELECT * FROM A JOIN B USING(a);