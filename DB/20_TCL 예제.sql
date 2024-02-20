start transaction; # 트랜잭션 시작
#begin / begin work  

use shoppingmall ;
# FOO002 가격을 2000원으로 수정
update product set pr_price = 2000 where pr_code = 'FOO002';

savepoint A;

update product set pr_price = 1000 where pr_code = 'FOO002';

rollback to A;

commit;
select * from product;