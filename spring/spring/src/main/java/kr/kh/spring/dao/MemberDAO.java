package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	public int selectMemberCount();

	public MemberVO selectMember(@Param("id")String id);

}
