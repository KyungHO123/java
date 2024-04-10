package kr.kh.spring3.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> selectBoardList(Criteria cri);

	int getBoardTotalCount(Criteria cri);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	ArrayList<CommunityVO> selectCommunity();

	void updateView(int bo_num);

	BoardVO getBoard(int bo_num);

	ArrayList<FileVO> getFileList(int bo_num);

}
