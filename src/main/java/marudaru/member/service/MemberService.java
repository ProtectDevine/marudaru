package marudaru.member.service;

import java.util.Map;

import marudaru.member.vo.MemberVO;

public interface MemberService {

	void insertJoinMember(Map<String, Object> map, Object object) throws Exception;
	
	int idChk(Map<String, Object> map, Object object) throws Exception;
}
