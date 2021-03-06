package marudaru.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import marudaru.common.logger.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO{
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}
	
	public void insertBoard(Map<String, Object> map) throws Exception {
		insert("sample.insertBoard", map);
	}
	
	public void updateHitCnt(Map<String, Object> map) throws Exception {
		update("sample.updateHitCnt", map);
		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
	}
	
	
	public void insertJoin(Map<String, Object> map) throws Exception {
		insert("sample.insertJoin", map);
	}
	
	public void updateBoard(Map<String, Object> map) throws Exception {
		update("sample.updateBoard", map);
	}
	
	public void deleteBoard(Map<String, Object> map) throws Exception{
		delete("sample.deleteBoard", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardListTap(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("sample.selectBoardListTap", map);
	}
	
	
	

}
