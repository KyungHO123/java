
-- -- 사용자가 아이디가 abc123, 비번이asd123으로 회원가입을 진행 
-- INSERT INTO member VALUES('abc123', 'asd123', 'USER');

-- -- 사용자가 아이디가 qwe123, 비번이 qweqwe으로 회원가입을 진행 
-- INSERT INTO member (me_id, me_pw) VALUES('qwe123', 'qweqwe');

-- -- 관리자가 아이디가 admin, 비번이 admin으로 회원 가입을 진행 
-- INSERT INTO member VALUES('admin', 'admin', 'ADMIN');

-- CGV에서 영화 웡카를 관리자가 등록하려고 한다. 이때 해야하는 쿼리를 순서대로 써보세요. 
-- 영화 정보(제목, 내용, 개봉일, 상영시간), 감독, 배우들, 장르, 연령, 제작 국가, 트레일터, 스틸컷
-- 0. 모든 국가를 nation테이블에 추가(한국, 미국, 영국, 일본, 중국)
INSERT INTO nation VALUES('한국'),('미국'),('영국'),('일본'),('중국');

-- 1. 폴킹,  티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨 정보를 
-- charater 테이블에 추가
INSERT INTO `character` VALUES
(null, '폴킹', '1978-07-29', '', '미국'),
(null, '티모시 샬라메', '1995-12-27', '', '미국'),
(null, '칼라 레인', '2009-04-20', '', '미국'),
(null, '올리비아 콜맨', '1974-01-30', '', '영국'),
(null, '톰 데이비스', '1979-04-27', '', '영국'),
(null, '휴 그랜트', '1960-09-09', '', '영국'),
(null, '샐리 호킨', '1976-04-27', '', '영국');

-- 2. 폴킹,  티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨 정보를 
-- movie_person 테이블에 추가(1에서 추가한 정보를 이용)
INSERT INTO movie_person(mp_role, mp_pic, mp_ch_num) VALUES
('감독','',1),
('배우','',2),
('배우','',3),
('배우','',4),
('배우','',5),
('배우','',6),
('배우','',7);

-- 3. 모든 연령을 age 테이블에 추가(전체관람가, 12세 이상 관람가, 15세 이상 관람가, 청소년 관람불가, 제한관람가)
INSERT INTO age VALUES('전체관람가'), ('12세 이상 관람가'), ('15세 이상 관람가'), ('청소년 관람불가'), ('제한관람가');

-- 4. 영화 정보를 이용하여 영화를 등록(movie 테이블)
INSERT INTO movie(mo_title, mo_date, mo_content, mo_running, mo_ag_name) VALUES ('웡카','2024-01-31','세상에서 가장 달콤한 여정', 116, '전체관람가');

-- 5. 폴킹,  티모시 샬라메 ,  칼라 레인 ,  올리비아 콜맨 ,  톰 데이비스 ,  휴 그랜트 ,  샐리 호킨 정보를 
-- join 테이블에 추가(2,3에서 추가한 정보를 이용), 배역을 모르면 ""로 
INSERT INTO `join`(jo_casting, jo_mo_num, jo_mp_num) VALUES
('감독', 1, '1'),
('', 1, '2'),
('', 1, '3'),
('', 1, '4'),
('', 1, '5'),
('', 1, '6'),
('', 1, '7');

-- 6. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 환타지, 코미디, 로맨스, 스릴러, 공포, 멜로) 
INSERT INTO genre VALUES('액션'),('범죄'),('SF'),('드라마'),('환타지'),('코미디'),('로맨스'),('스릴러'),('공포'),('멜로');

-- 7. 트레일러 정보를 추가. 파일명은 임의로 정해서 추가. 트래일러 3개, 스틸컷 4개 
INSERT INTO movie_file(mf_filename, mf_type, mf_mo_num) VALUES
('웡카_트래일러1.mp4','트래일러',1),
('웡카_트래일러2.mp4','트래일러',1),
('웡카_트래일러3.mp4','트래일러',1),
('웡카_스틸컷1.png','스틸컷',1),
('웡카_스틸컷2.png','스틸컷',1),
('웡카_스틸컷3.png','스틸컷',1),
('웡카_스틸컷4.png','스틸컷',1);

-- 8. 영화 제작에 영화와 제작 국가 정보를 추가
INSERT INTO production_nation(pn_na_name, pn_mo_num) VALUES('미국',1),('영국',1);

-- 9. 장르 포함에 영화아 장르를 추가 
INSERT INTO genre_include(gi_mo_num, gi_ge_name) VALUES(1, '환타지'),(1,'드라마');

-- 지역을 추가하는 쿼리
-- (서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주)
INSERT INTO region VALUES ('서울'), ('경기'), ('인천'), ('강원'), ('대전/충청'), ('대구'), ('부산/울산'), ('경상'), ('광주/전라/제주');

-- 영화관을 추가하는 쿼지
-- CGV 강남, 서울특별시 강남구 역삼동, 좌석수 : 0, 상영관수 : 3, 서울
-- CGV 영등포, 서울특별시 영등포구 4가 , 좌석수 : 0, 상영관수 : 4, 서울
INSERT INTO theater VALUES
(null, 'CGV 강남', '서울특별시 강남구 역삼동', 0, 3, '서울'),
(null, 'CGV 영등포', '서울특별시 영등포구 4가', 0, 4, '서울');

-- CGV 강남에 상영관과 좌석을 추가하는 쿼리
-- 1관, 10좌석, 2관, 12좌석, 3관 6좌석
-- 1관 : A1~A3, B1~B3, C1~C4
-- 2관 : A1~A4, B1~B4, C1~C4
-- 3관 : A1,A2, B1,B2, C1,C2

-- (null, 'A1~A3', 1), (null, 'B1~B3', 1), (null, 'C1~C4', 1), (null, 'A1~A4', 2), (null, 'B1~B4', 2), (null, 'C1~C4', 2),
INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (1, 10, 1);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 1), ('A2', 1), ('A3', 1), 
('B1', 1), ('B2', 1), ('B3', 1),
('C1', 1), ('C2', 1), ('C3', 1), ('C4', 1);

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (2, 12, 1);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 2), ('A2', 2), ('A3', 2), ('A4', 2), 
('B1', 2), ('B2', 2), ('B3', 2), ('B3', 2),
('C1', 2), ('C2', 2), ('C3', 2), ('C4', 2);

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (3, 6, 1) ;
INSERT INTO seat (se_name, se_sc_num) VALUES ('A1', 3), ('A2', 3), ('B1', 3), ('B2', 3), ('C1', 3), ('C2', 3);

UPDATE theater 
SET 
    th_seat = 28
WHERE
    th_name = 'CGV 강남';

-- 서브 쿼리를 이용하여 CGV 강남에 등록된 좌석수를 계산해서 영화관 전체 좌석수에 업데이트 하는 쿼리
-- 서브 쿼리로 A테이블을 업데이트할 때, 서브 쿼리에 A테이블을 단순 이용하면 업데이트가 되지 않음
-- 이럴 때, A테이블이 아닌 A테이블을 조회한 결과를 이용하면 가능
-- 서브 쿼리가 select count(*) from A일때, A 대신 select count(*) from (select * from A) AS 임시이름을 이용해야 한다.
UPDATE theater 
SET 
    th_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON se_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th On sc_th_num = th_num
        WHERE
            th_name = 'CGV 강남')
WHERE
    th_name = 'CGV 강남';

-- CGV 영등포에 상영관과 좌석을 추가하는 쿼리
-- 1관, 14좌석, 2관, 16좌석, 3관 10좌석, 4관 25좌석
-- 1관 : A1~A3, B1~B3, C1~C4, D1~D4
-- 2관 : A1~A4, B1~B4, C1~C4, D1~D4
-- 3관 : A1,A2, B1,B2, C1,C2, D1,D2, E1, E2
-- 4관 : A1~A5, B1~B5, C1~C5, D1~D5, E1~E5

SELECT * FROM SCREEN;
SELECT * FROM Seat;

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (1, 14, 2);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 4), ('A2', 4), ('A3', 4),
('B1', 4), ('B2', 4), ('B3', 4),
('C1', 4), ('C2', 4), ('C3', 4), ('C4', 4),
('D1', 4), ('D2', 4), ('D3', 4), ('D4', 4);

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (2, 16, 2);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 5), ('A2', 5), ('A3', 5), ('A4', 5),
('B1', 5), ('B2', 5), ('B3', 5), ('B4', 5),
('C1', 5), ('C2', 5), ('C3', 5), ('C4', 5),
('D1', 5), ('D2', 5), ('D3', 5), ('D4', 5);

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (3, 10, 2);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 6), ('A2', 6), 
('B1', 6), ('B2', 6), 
('C1', 6), ('C2', 6), 
('D1', 6), ('D2', 6), 
('E1', 6), ('E2', 6);

INSERT INTO screen (sc_name, sc_seat, sc_th_num) VALUES (4, 25, 2);
INSERT INTO seat (se_name, se_sc_num) VALUES 
('A1', 7), ('A2', 7), ('A3', 7), ('A4', 7), ('A5', 7),
('B1', 7), ('B2', 7), ('B3', 7), ('B4', 7), ('B5', 7),
('C1', 7), ('C2', 7), ('C3', 7), ('C4', 7), ('C5', 7),
('D1', 7), ('D2', 7), ('D3', 7), ('D4', 7), ('D5', 7), 
('E1', 7), ('E2', 7), ('E3', 7), ('E4', 7), ('E5', 7);

UPDATE theater 
SET 
    th_seat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON se_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th On sc_th_num = th_num
        WHERE
            th_name = 'CGV 영등포')
WHERE
    th_name = 'CGV 영등포';
    
-- 상영 시간 추가
-- CGV 강남 1관 상영시간
-- 웡카 - 2월 9일 10:30, 13:00, 16:00, 18:10, 20:30
INSERT INTO schedule (sh_date, sh_time, sh_morning, sh_sc_num, sh_mo_num) values
("2024-02-09", "10:30", 1, 1, 1),
("2024-02-09", "13:00", 0, 1, 1),
("2024-02-09", "16:00", 0, 1, 1),
("2024-02-09", "18:10", 0, 1, 1),
("2024-02-09", "20:30", 0, 1, 1);

-- CGV 강남 2관 상영시간
-- 웡카 - 2월 9일 11:30, 14:00, 15:00, 19:10, 21:30
INSERT INTO schedule (sh_date, sh_time, sh_morning, sh_sc_num, sh_mo_num) values
("2024-02-09", "11:30", 1, 2, 1),
("2024-02-09", "14:00", 0, 2, 1),
("2024-02-09", "15:00", 0, 2, 1),
("2024-02-09", "19:10", 0, 2, 1),
("2024-02-09", "21:30", 0, 2, 1);

-- CGV 강남 3관 상영시간
-- 웡카 - 2월 9일 12:20, 14:30, 17:30, 19:50
INSERT INTO schedule (sh_date, sh_time, sh_morning, sh_sc_num, sh_mo_num) values
("2024-02-09", "12:20", 0, 3, 1),
("2024-02-09", "14:30", 0, 3, 1),
("2024-02-09", "17:30", 0, 3, 1),
("2024-02-09", "19:50", 0, 3, 1);

select *
from schedule;
-- 영화 웡카의 영화 정보를 검색하는 쿼리(배우X, 감독 X, 제작국가 X, 장르 X)
SELECT *
FROM movie 
WHERE mo_title = '웡카';

-- 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리 
SELECT 
    mo_title AS 제목, ch_name AS 이름, mp_role AS 구분
FROM
    movie
        JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
      JOIN
   `character` on mp_ch_num = ch_num
WHERE 
   mo_title = '웡카';
    
-- CGV 강남 1상영관에 등록된 좌석을 조회하는 쿼리
SELECT 
    se_num AS '좌석 번호', se_name AS '좌석 이름', sc_name AS '상영관', th_name AS '영화관' 
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    theater ON sc_th_num = th_num
WHERE
    sc_name = '1' AND th_name ='CGV 강남';
    
-- CGV 강남에 등록된 좌석을 조회하는 쿼리
SELECT 
    se_num AS '좌석 번호', se_name AS '좌석 이름', sc_name AS '상영관', th_name AS '영화관' 
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    (SELECT 
      *
   FROM 
      theater) AS th ON sc_th_num = th_num
WHERE
    th_name ='CGV 강남';
    
-- CGV 강남에 등록된 좌석수를 조회하는 쿼리
SELECT 
    COUNT(*) AS '좌석수'
FROM
    seat
        JOIN
    screen ON se_sc_num = sc_num
        JOIN
    (SELECT 
      *
   FROM 
      theater) AS th ON sc_th_num = th_num
WHERE
    th_name ='CGV 강남';
    
-- 영화 웡카를 상영하고 있는 극장을 조회하는 쿼리
SELECT DISTINCT
    th_name AS '극장명', mo_title AS '영화 제목'
FROM
    theater
        JOIN
    `screen` ON th_num = sc_th_num
        JOIN
    `schedule` ON sc_num = sh_sc_num
        JOIN
    `movie` ON sh_mo_num = mo_num
WHERE
    mo_num = 1;
    
-- CGV 강남 1상영관에 웡카 상영 시간을 조회하는 쿼리
SELECT DISTINCT
    th_name AS '극장명', mo_title AS '영화 제목', sh_time AS '상영 시간'
FROM
   schedule
        JOIN
    `screen` ON sh_sc_num = sc_num
        JOIN
    `theater` ON th_num = sc_th_num
        JOIN
    `movie` ON sh_mo_num = mo_num
WHERE
    th_name = 'CGV 강남' AND sc_num = 1 AND mo_title = '웡카';
    
# CGV강남 1상영관에 있는 좌석들을 조회하는 쿼리
SELECT 
    sh_date, sh_time, se_name
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    theater ON th_num = sc_th_num
        JOIN
    schedule ON sh_sc_num = sc_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';
# 2월 9 일 10:30분 CGV강남 1상영관에서 상영하는 웡카의 좌석을 조회하는 쿼리


# 기본 요금 등록
insert into price values(null,'성인',14000),(null,'청소년',10000),
(null,'성인조조',11200),(null,'청소년',8000);
# abc123 호원이 웡카를 예매했을 때 쿼리
# CGV강남 1상영관 10:30 영화를 성인 2명, A1, A2를 예매
# ticketing 테이블에 데이터 추가
insert into ticketing values(null,2,0,11200*2,1,'abc123');
# ticketing_list 테이블에 데이터 추가
insert ticketing_list(tl_ti_num,tl_se_num)
values(1,1),(1,2);

#CGV강남 1상영관 2월9일 10시:30분 웡카를 예매한 좌석들을 조회

select * from 


