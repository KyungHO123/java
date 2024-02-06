-- 모든 제품을 조회하는 쿼리
SELECT 
    *
FROM
    product;

-- 모든 카테고리를 조회하는 쿼리
SELECT 
    *
FROM
    category;

-- 제품별 카테고리를 조회. 카테고리, 제품을 조회

select ca_name as 카테고리, pr_title as 제품명 from product join category on ca_num = pr_ca_num;

-- 기타 카테고리에 포함된 모든 제품을 조회 
SELECT 
    ca_name, product.*
FROM
    product
        JOIN
    category ON ca_num = pr_ca_num
WHERE
    ca_name = '기타';

-- abc123회원이 주문한 제품 목록을 조회
SELECT 
    or_date, or_state, or_amount, or_total_price, pr_title
FROM
    `order`
        JOIN
    product ON pr_code = or_pr_code
WHERE
    or_me_id = 'abc123';

-- 제품별 판매수량을 조회하는 쿼리 

SELECT 
    product.*, IFNULL(SUM(or_amount),0) AS '판매수량'
FROM
   `order`
       RIGHT JOIN
    product ON pr_code = or_pr_code
WHERE OR_STATE NOT IN('반품','환불') OR OR_STATE IS NULL
GROUP BY pr_code;

-- 인기 제품 조회. 인기 제품은 누적 판매량을 기준으로 상위 5개 제품
SELECT 
    product.*, IFNULL(SUM(or_amount),0) AS '판매수량'
FROM
   `order`
       RIGHT JOIN
    product ON pr_code = or_pr_code
WHERE OR_STATE NOT IN('반품','환불') OR OR_STATE IS NULL
GROUP BY pr_code
ORDER BY 판매수량 DESC,PR_PRICE ASC
LIMIT 0,5;

-- 가격이 제일 비싼 제품을 조회
SELECT 
    *
FROM
    product
ORDER BY pr_price DESC
LIMIT 0 , 1;

