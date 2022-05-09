package marudaru.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import marudaru.common.logger.AbstractDAO;
import marudaru.member.dao.LoginDAO;
import marudaru.member.dao.MemberDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="memberDAO")
	MemberDAO memberDAO;
	
	@Resource(name="loginDAO")
	LoginDAO loginDAO;
	
	@Override
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		Map<String, Object> list = loginDAO.loginDO(map);
		
		return list;
	}

	@Override
	public int loginIdchk(Map<String, Object> map) throws Exception {
		int result = memberDAO.checId2(map);
		return result;
	}

	@Override
	public String passwordChk(Map<String, Object> map) throws Exception {
		String passwordChk = (String) loginDAO.passwordChk(map);
		return passwordChk;
	}

	
	
	
	
	
}
