package marudaru.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import marudaru.common.logger.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {

	public String passwordChk(Map<String, Object> map) {
		
		String memPass = (String) selectOne("member.passwordChk", map);
		
		return memPass;
	}
	
	public Map<String, Object> loginDO(Map<String, Object> map) {
		
		@SuppressWarnings("unchecked")
		Map<String, Object> list = (Map<String, Object>) selectOne("member.loginDO", map);
		
		return list;
	}
	
}
