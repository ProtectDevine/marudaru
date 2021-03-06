package marudaru.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import marudaru.board.dao.BoardDAO;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	protected Log log = LogFactory.getLog(BoardService.class);
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
		boardDAO.insertBoard(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		Map<String, Object> resultMap = boardDAO.selectBoardDetail(map);
		return resultMap;
	}

	@Override
	public void insertJoin(Map<String, Object> map) throws Exception {
		boardDAO.insertJoin(map);
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
		boardDAO.updateBoard(map);
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		boardDAO.deleteBoard(map);
	}

	@Override
	public List<Map<String, Object>> selectBoardListTab(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardListTap(map);
	}

	
	
	
	
}
