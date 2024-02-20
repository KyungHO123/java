use community;

# 회원 상태를 추가하는 쿼리(이용 중, 기간 정지, 영구 정지, 탈퇴)
insert into member_state values('이용중'),('기간정지'),('영구정지'),('탈퇴');

# 3명이 각각 회원 가입을 진행할 때 필요한 쿼리

# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.co.kr,  권한 : user
insert into member(me_id,me_pw,me_email,me_ms_state) 
values('abc123','abc123','abc123@kh.co.kr','이용중');

# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.co.kr,  권한 : user
insert into member(me_id,me_pw,me_email,me_ms_state) 
values('qwe123','qwe123','qwe123@kh.co.kr','이용중');

# 아이디 : admin, 비번 : admin, 이메일 : admin@kh.co.kr ,권한 : ADMIN
insert into member(me_id,me_pw,me_email,me_authority,me_ms_state)
values('admin','admin','admin@kh.co.kr','admin','이용중');

select * from member;

# 관리자가 커뮤니티를 등록 (공지, 자유, 토론, 공부)

insert into community(co_name) values('공지');
insert into community(co_name) values('자유');
insert into community(co_name) values('토론');
insert into community(co_name) values('공부');

# abc123회원이 자유 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 테스트  내용 : 테스트 입니다. 첨부파일 : 없음
insert into board(bo_co_num, bo_me_id, bo_title, bo_content)
values(2,'abc123','테스트','테스트입니다.');

insert into board(bo_co_num, bo_me_id, bo_title, bo_content)
select co_num,'abc123','테스트','테스트입니다.' from community where co_name = '자유';

# admin 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다. 첨부파일 : 공지사항1.jpg
# 첨부파일은 서버업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드 함.
# 업로드된 첨부파일은 /2024/02/14/파일명으로 저장

insert into board(bo_co_num, bo_me_id, bo_title, bo_content)
select co_num,'admin','공지사항','공지사항입니다.' from community where co_name = '공지';

insert file(fi_bo_num, fi_name, fi_ori_name)
values(3,'/2024/02/14/공지사항1.jpg','공지사항1.jpg');

select * from board;

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리

select * from board where bo_title = '공지사항';

select * from board join community on bo_co_num = co_num where co_name='공지';

# 공지 커뮤니티에 등록된 게시글 중 1페이지에 해당하는 게시글을 조회하는 쿼리
SELECT 
    *
FROM
    board
        JOIN
    community ON bo_co_num = co_num
WHERE
    co_name = '공지'
ORDER BY bo_num DESC
LIMIT 0 , 10;

# 3번 게시글을 상세 조회했을 때 실행되는 쿼리
# 1. 3번 게시글의 조회수를 증가하는 쿼리
update board set bo_view = bo_view + 1 where bo_num = 3;
# 2. 3번 게시글 조회하는 쿼리
select * from board where bo_num = 3;

# 게시글 목록에서 abc123 아이디를 클릭했을 때 실행되는 쿼리
# 1. qwe123회원이 1번 게시글에 추천한 기록을 조회
select * from recommend where re_me-id = 'abc123' and re_bo_num = 1;
# 2-1. 추천한 기록이 없다면 추천을 추가
insert into recommend(re_me_id, re_bo_num, re_state)
values('abc123',1,1);
# 2-2. 추천한 기록이 있다면 추천을 수정
# 2-2-1. 추천한 기록이 추천인 경우 => 추천을 취소
update recommend set re_state = 0 where re_bo_num = 1 and re_me_id = 'abc123';
# 2-2-2. 추천한 기록이 추천이 아닌 경우 => 비추천이거나 추천/비추천을 취소한 경우
update recommend set re_state = 1 where re_bo_num = 1 and re_me_id = 'abc123';

# 아이디와 게시글이 주어졌을 때 추천을 추가하거나 수정하는 프로시저
drop procedure if exists board_recommend;

delimiter // 
create procedure board_recommend(
	in _id varchar(13),
    in _bo_num int,
    in _state int # 1이면 추천, -1이면 비추천
)
begin
	declare _new_state int;
	declare _re_num int;
    declare _re_state int;
    
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장
    set _re_num = 
    (select re_num from recommend where re_me_id = _id and re_bo_num = _bo_num);
    
    # 2-1. 추천 번호가 null이면
    if _re_num is null then
		insert into recommend(re_me_id, re_bo_num, re_state)
        values(_id, _bo_num, _state);
        
    # 2-2. 추천 번호가 null이 아니면
    else
    
		# 2-2-0. 추천 번호에 맞는 추천 상태를 가져옴
        set _re_state = 
			(select re_state from recommend where re_num = _re_num);
            
		# update문 2번 쓰기
        # 2-2-1. 추천 상태가 _state와 같으면 취소(0) = > 0으로 수정 
       --  if _re_state = _state then
-- 			update recommend set re_state = 0
-- 			where re_bo_num = _bo_num and re_me_id = _id;

--         # 2-2-2. 추천 상태가 _state와 다르면 _state로 수정
-- 		else
-- 			update recommend set re_state = _state
-- 			where re_bo_num = _bo_num and re_me_id = _id;
-- 		end if;

		# update문 1번만 쓰기
		# 2-2-1. 추천 상태가 _state와 같으면 취소(0) = > 0으로 수정 
         if _re_state = _state then
			set _new_state = 0;
        # 2-2-2. 추천 상태가 _state와 다르면 _state로 수정
		else
			set _new_state = _state;
		end if;
			update recommend set re_state = _new_state
				where re_bo_num = _bo_num and re_me_id = _id;
	end if;
end //
delimiter ;

call board_recommend('abc123',1,1);
select * from recommend;


use community;
# 공지 커뮤니티 1페이지에 등록된 게시글 목록을 조회하는 쿼리
select * from board where bo_co_num = (select co_num from community where co_name = '공지');
# 3번 게시글을 상세 조회하는 쿼리
select * from board where bo_num=3;

# abc123회원이 3번 게시글에 '확인했습니다' 라고 댓글을 달았을 때 쿼리
insert into camment(cm_bo_num, cm_me_id, cm_content)
values(3, 'abc123','확인했습니다.');

# 3번 게시글에 등록된 댓글 1페이지를 조회하는 쿼리
select * from comment where cm_bo_num = 3 order by cm_num desc limit 0,5;

# 신고 사유 등록(욕설, 허위사실 유포, 광고, 음란, 커뮤니티에 맞지 않음, 기타)
insert into report_type values('욕설'),('허위사실 유포'),('광고'),('음란'),('기타');

# admin이 1번 댓글을 '기타'로 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content, rp_state, rp_target)
values('admin','기타','comment','','신고접수', 1);

# 관리자가 신고 내역을 조회 => 신고접수된 내역을 조회
select * from report where rp_state = '신고접수';

# 관리자가 1번 신고내역을 '신고반려'로 처리
update report set rp_state = '신고반려' where rp_num = 1;

# ABC123회원이 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID, RP_RT_NAME, RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('ABC123','기타','BOARD','','신고접수', 1);
# QWE123회원이 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID,RP_RT_NAME,RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('QWE123','기타','BOARD','','신고접수', 1);
# ADMIN 관리자가 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID,RP_RT_NAME,RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('ADMIN','기타','BOARD','','신고접수', 1);

# 관리자가 1번 게시글 신고 내역을 모두 '신고처리'로 처리
UPDATE REPORT SET RP_STATE = '신고처리'
WHERE RP_TARGET = 1 AND RP_TABLE = 'BOARD' AND RP_STATE = '신고접수';

select count(*) from report where rp_taget = 1 and rp_table = 'board' and rp_state = '신고처리');
 
# 3번 신고된 1번 게시글을 삭제하고, 1번 게시글을 작성한 작성자에게 1달 이용정지를 적용 
# 1번 게시글을 삭제하기 위해 1번 게시글에 달린 댓글들을 삭제
DELETE FROM COMMENT WHERE CM_BO_NUM =1;
# 1번 게시글을 삭제하기 위해 1번 게시글을 추천한 정보를 삭제
DELETE FROM RECOMMEND WHERE RE_BO_NUM =1;
# 1번 게시글을 삭제
DELETE FROM BOARD WHERE BO_NUM =1;
# ABC123 회원을 한달 간 이용 정지
UPDATE MEMBER 
SET 
    ME_MS_STATE = '기간정지',
    ME_STOP = DATE_ADD(NOW(), INTERVAL 1 MONTH)
WHERE
    ME_ID = 'ABC123';

# QWE123회원이 회원을 탈퇴
UPDATE MEMBER SET ME_MS_STATE = '탈퇴' WHERE ME_ID = 'QWE123';






