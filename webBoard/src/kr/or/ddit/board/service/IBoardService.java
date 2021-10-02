package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {
	public List<BoardVO> boardList (Map<String, Integer> map);
	
	public int boardCount();
	
	public BoardVO boardDetail(int no);
	
	public void boardInsert (BoardVO vo);
	
	public int boardUpdate(BoardVO vo);
	
	public int boardDelete(int no);
	
	public int boardCnt(int no);
	
	public List<BoardVO> searchBoard(String board_title);
}
