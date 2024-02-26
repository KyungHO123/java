package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);


	MemberVO selectMember(@Param("loginDto")LoginDTO loginDto);


	MemberVO selectMember(@Param("id")String id);

}
