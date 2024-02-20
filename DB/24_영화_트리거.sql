
use movie;

# 상영관에 좌석이 추가되면 상영관 전체 좌석수와 영화관 전체 좌석수를 업데이트하는 트리거
# seat 테이블에 좌석이 추가되면, Screen 테이블과 theater 테이블의 좌석수를 수정하는 트리거

drop trigger if exists insert_seat;

delimiter //
create trigger insert_seat after insert on seat
for each row
begin
	declare _sc_num int;
	declare _sc_seat int;
    declare _th_num int;
    declare _th_seat int;
    
    # 상영관 번호
    set _sc_num = new.se_sc_num;
    # 상영관에 있는 전체 좌석수 계산
    set _sc_seat = (select count(*) from seat where se_sc_num = _sc_num);
    # 상영관에 있는 전체 좌석수를 업데이트
	update screen set sc_seat = _sc_seat where sc_num = _sc_num;
    
    # 영화관 번호
	set _th_num = (select sc_th_num from screen where sc_num = _sc_num);
    # 영화관 전체 좌석 수
    set _th_seat = 
    (SELECT COUNT(*)FROMseat
	 WHERE se_sc_num IN (SELECT sc_num FROM screen WHERE sc_th_num = 1));
     
     # 영화관에 있는 전체 좌석수를 업데이트
     update theater set th_seat = _th_seat where th_num = _th_num;

end //
delimiter ;

SELECT COUNT(*)FROMseat
WHERE se_sc_num IN (SELECT sc_num FROM screen WHERE sc_th_num = 1);

# 상영관이 추가되면 영화관의 전체 상영관수를 업데이트하는 트리거
drop trigger if exists insert_screen;

delimiter //
CREATE TRIGGER  insert_screen AFTER INSERT ON screen 
FOR EACH ROW 
 BEGIN 
	declare _th_num int;
    declare _th_screen int;
    
	# 영화관 번호
	set _th_num = new.sc_th_num;
    # 영화관 상영관수
    set _th_screen = (select count(*) from screen where sc_th_num = _th_num); 
	# 영화관에 있는 전체 좌석수를 업데이트
	update theater set th_screen = _th_screen where th_num = _th_num;
    
    
END//
delimiter ;

insert into screen(sc_name,sc_seat,sc_th_num) values(4,0,1);

select * from theater;







