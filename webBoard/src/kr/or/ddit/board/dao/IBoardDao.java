package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDao {

	public List<BoardVO> boardList (Map<String, Integer> map) throws SQLException;
	
	public int boardCount() throws SQLException;
	
	public BoardVO boardDetail(int no) throws SQLException;
	
	public void boardInsert (BoardVO vo) throws SQLException;
	
	public int boardUpdate(BoardVO vo) throws SQLException;
	
	public int boardDelete(int no) throws SQLException;
	
	public int boardCnt(int no) throws SQLException;
	
	public List<BoardVO> searchBoard(String board_title) throws SQLException;
}
