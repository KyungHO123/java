package kr.kh.app.service;

import java.util.ArrayList;

import javax.servlet.http.Part;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public interface BoardService {

	boolean insertBoard(BoardVO board, ArrayList<Part> partList);

	ArrayList<CommunityVO> getCommunityList();

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getTotalCount(Criteria cri);

	BoardVO getBoard(int num);

	boolean updateView(int num);

	boolean deleteBoard(int num, MemberVO user);

	boolean updateBoard(BoardVO board, MemberVO user, ArrayList<Integer> nums, ArrayList<Part> fileList);

	ArrayList<FileVO> getFile(int num);

}