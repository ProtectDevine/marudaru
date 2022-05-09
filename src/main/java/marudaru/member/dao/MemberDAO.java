package marudaru.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import marudaru.common.logger.AbstractDAO;
import marudaru.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO{
	public void insertJoinMember(Map<String, Object> map) throws Exception{
		insert("member.insertJoinMember", map);
	}
	
	public int checId(Map<String, Object> map) throws Exception{
		int result = (Integer) selectOne("member.checkId", map);
		return result;
	}
	
	public int checId2(Map<String, Object> map) throws Exception{
		int result = (Integer) selectOne("member.checkId2", map);
		return result;
	}
	
}
