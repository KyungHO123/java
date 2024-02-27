package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	boolean insertBoard(BoardVO board);

}
