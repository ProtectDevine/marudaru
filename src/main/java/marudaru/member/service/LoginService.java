package marudaru.member.service;

import java.util.Map;


public interface LoginService {

	Map<String, Object> login(Map<String, Object> map) throws Exception;
	
	int loginIdchk(Map<String, Object> map) throws Exception;
	
	String passwordChk(Map<String, Object> map) throws Exception;
	
	
}
