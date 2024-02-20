/*
SQL 문법 정리
select * from table명 ;
	- table명의 column을 전부 조회 
    
 # count(*) #
select count(*) from table명 ;
	-  table명의 데이터 갯수를 조회하고 싶을때 사용
    
# group by #
select columnA, count(*) from table명 group by columnA;  #(count(*)을 없애면 중복만 없애서 조회)
	- table명에 있는 columnA의 안에 같은 값을 가진 행들을 그룹으로 만들어 조회함 
    - EX) columnA에 A A A B B B B 라는 값이 있으면 다음과 같이 실행됨.
		columnA   count(*)
			A 		3
            B		4		
            
# columnA #
select columnA from table명 ;
	- table명에 있는 column명만 조회 

# limit #
select columnA from table명 limit 10; 
	- table명에 있는 columnA중 10개만 조회 

# order by columnA #
select * from table명 order by columnA limit 10; 
	- table명을 전부 조회후 오름차순으로 정렬
   
# desc #
select * from table명 order by columnA desc limit 10; 
	- table명을 전부 조회후 내림차순으로 정렬
    
# where #
select * from table명 where columnA = '예시1' ; // 문자 종류일때는 ''을 사용
	- where columnA = '예시'는  columnA가 '예시1'의 값만 찾을때 사용

# and #
select * from table명 where columnA = '예시1' and columnB = '예시2';
	- 2개의 값을 찾을때는 and문을 써서 조회한다. 
    
# or #
select * from table명 where columnA = '예시1' or columnB = '예시2';
	- 예시1이거나 예시2의 값이 있을때 조회 하고 싶으면 or문을 써서 조회한다.

# case when then end #
select columnA,columnB,
	case when columnA <= 10 then '10이하'
    case when columnA > 10 then '10초과' 
    또는 else '10초과'
    end // end를 붙혀줘야함
 from table명  
	- columnA가 case when then의 조건과 일치하면 문자로 표현할때 사용
    
# like / not like #
select * from table명 where columnA like '%가 나%';
	- columnA like'%가 나%' 는 columnA의 값에 가나 가 붙어있는 단어를 모두 조회함
    - '가 나%'로 앞에 %를 없앨시 가나로 시작되는 데이터 값만 조회
    - '%가 나'로 뒤에 %를 없앨시 가나로 끝나는 데이터 값만 조회
    
select * from table명 where columnA not like '%가 나%';
	- columnA not like'%가 나%' 는 columnA의 값에 가나 가 붙어있는 단어만 빼고 조회함.
    
 # join #   
 select columnA_1,columnA_2 
 from table명1 join table명2 
 on coA_columnA_1 = cloumnA_1
 
 -두 테이블을 연결해서 값을 가져올때 사용 단, 위 처럼 사용 시 외래키를 가져와야함. 


# 서브 쿼리 #
1.
SELECT FROM (
select columnA, count(*) columnB 
from table명 group by columnA
 ) a 
 where columnB > 100
 - columnB가 100을 초과한 값들만 조회
 
 2.
 SELECT a.*
 , case when columnB <= 100 then'100이하'
else '100이상' end
 FROM (
select columnA, count(*) columnB 
from table명 group by columnA
 ) a 
- 서브쿼리는 1번만 사용할 수 있는게 아니라 여러번 사용이 가능함.
- 조건에 맞는 문자를 출력함 
*/