package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.config.BuildedSqlMapClient;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	
	private SqlMapClient client;
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static IBoardDao getDao() {
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}

	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) throws SQLException {
		return client.queryForList("board.boardList", map);
	}

	@Override
	public int boardCount() throws SQLException {
		return (Integer)client.queryForObject("board.boardCount");
	}

	@Override
	public BoardVO boardDetail(int no) throws SQLException {
		return (BoardVO)client.queryForObject("board.boardDetail", no);
	}

	@Override
	public void boardInsert(BoardVO vo) throws SQLException {
		client.insert("board.boardInsert", vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) throws SQLException {
		return client.update("board.boardUpdate", vo);
	}

	@Override
	public int boardDelete(int no) throws SQLException {
		return client.delete("board.boardDelete", no);
	}

	@Override
	public int boardCnt(int no) throws SQLException {
		return client.update("board.boardCnt", no);
	}

	@Override
	public List<BoardVO> searchBoard(String board_title) throws SQLException {
		return client.queryForList("board.searchBoard", board_title);
	}
}
