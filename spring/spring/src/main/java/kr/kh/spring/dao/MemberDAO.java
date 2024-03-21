package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	public int selectMemberCount();

	public MemberVO selectMember(@Param("id")String id);

	public boolean insertMember(MemberVO member);

	public void updatePassword(@Param("id")String id,@Param("pw") String encPw);

	public boolean updateMember(@Param("me")MemberVO member);

	public void updateMemberCookie(@Param("user")MemberVO user);

	public MemberVO selectMemberByCookie(@Param("session_id")String sessionId);

}
