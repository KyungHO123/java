package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentDAO {

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

	boolean insertComment(@Param("co")CommentVO comment);

	CommentVO selectComment(@Param("cm_num")int cm_num);

	boolean deleteComment(@Param("cm_num")int cm_num);

	boolean updateComment(@Param("co")CommentVO comment);

}