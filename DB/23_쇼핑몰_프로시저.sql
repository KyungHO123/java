
# 제품을 추가하는 프로시저 
# 제품 코드는 영문3자리(주어짐), 숫자3자리(같은 카테고리로 등록된 제품들 수를 이용)
# 주어지는 정보 : 제품코드영문3자리, 제품명, 내용, 가격, 카테고리명 
# 프로시저 실행 결과 : 제품이 등록 
USE SHOPPINGMALL;

DROP PROCEDURE IF EXISTS INSERT_PRODUCT;
DELIMITER //
CREATE PROCEDURE INSERT_PRODUCT(
    IN _AMOUNT INT,
	IN _ID VARCHAR(13),
    IN _PR_CODE VARCHAR(15)
)
BEGIN
	DECLARE _PRICE INT; # 제품가격
	DECLARE _TOTAL_PRICE INT; # 제품 총 가격
    # 제품 가격을 가져옴
	SET _PRICE =(SELECT PR_PRICE FROM PRODUCT WHERE PR_CODE = _PR_CODE);
    # 제품 총 가격을 계산
    SET _TOTAL_PRICE = _PRICE * _AMOUNT;
    # ORDER 테이블에 데이터를 추가
    INSERT INTO `ORDER`(OR_AMOUNT, OR_TOTAL_PRICE, OR_ME_ID, OR_PR_CODE)
    VALUES(_AMOUNT, _TOTAL_PRICE, _ID, _PR_CODE);
END //
DELIMITER ;
CALL INSERT_ORDER (3,'qwe123','ABC004');