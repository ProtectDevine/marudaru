package marudaru.board.service;

import java.util.List;
import java.util.Map;

import javax.swing.tree.ExpandVetoException;

import marudaru.common.common.CommandMap;

public interface BoardService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	
	void insertBoard(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void insertJoin(Map<String, Object> map) throws Exception;
	
	void updateBoard(Map<String, Object> map) throws Exception;
	
	void deleteBoard(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectBoardListTab(Map<String, Object> map) throws Exception;

	
	

}

