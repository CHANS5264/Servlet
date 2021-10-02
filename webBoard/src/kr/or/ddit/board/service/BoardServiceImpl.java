package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao dao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	
	@Override
	public List<BoardVO> boardList(Map<String, Integer> map) {
		List<BoardVO> boardVo = null;
		
		try {
			boardVo = dao.boardList(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardVo;
	}

	@Override
	public int boardCount() {
		int cnt = 0;
		
		try {
			cnt = dao.boardCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public BoardVO boardDetail(int no) {
		BoardVO vo = null;
		
		try {
			vo = dao.boardDetail(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public void boardInsert(BoardVO vo) {
		try {
			dao.boardInsert(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		int code = 0;
		
		try {
			code = dao.boardUpdate(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return code;
	}

	@Override
	public int boardDelete(int no) {
		int cnt = 0;
		
		try {
			cnt = dao.boardDelete(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int boardCnt(int no) {
		int cnt = 0;
		
		try {
			cnt = dao.boardCnt(no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> searchBoard(String board_title) {
		List<BoardVO> list = null;
		
		try {
			list = dao.searchBoard(board_title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}













