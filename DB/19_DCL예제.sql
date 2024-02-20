create user 'kyungho'@'%' identified by 'asd154'; # 사용자 추가

set password for 'kyungho'@'%' = 'asd456'; # 사용자 비번 변경

drop user 'kyungho'@'%'; # 사용자 삭제

select user , host from mysql.user;

# 권한 부여 : grant 권한종류 db명.테이블명 to '사용자명'@'호스트명';
grant all privileges on`shoppingmall`.product to 'kyungho'@'%';

# 권한 제거 : revoke 권한 종류 on db명.테이블명 from '사용자명'@'호스트명';
revoke all privileges on `shoppingmall`.product from 'kyungho'@'%';

grant all privileges on`shoppingmall`.* to 'kyungho'@'%';