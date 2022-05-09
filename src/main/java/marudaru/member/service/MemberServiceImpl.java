package marudaru.member.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import marudaru.member.dao.MemberDAO;
import marudaru.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{


	@Resource(name="memberDAO")
	private MemberDAO memberDAO;

	
	@Override
	public int idChk(Map<String, Object> map, Object object) throws Exception {
		map.putAll(convertToMap(object)); 
		
		for(Object keySet : map.values()) {
			System.out.println("idchk" + keySet);
		}
		
		int result = memberDAO.checId(map);
		return result;
	}

	
	@Override
	public void insertJoinMember(Map<String, Object> map, Object object) throws Exception {
		map.putAll(convertToMap(object)); 
		
		for(String keySet : map.keySet()) {
			System.out.println(keySet);
		}
		memberDAO.insertJoinMember(map);
	}
	
	
	public static Map<String, Object> convertToMap(Object obj) throws IllegalAccessException, InstantiationException,
	IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if (obj == null) {
			return Collections.emptyMap();
		}

		Map<String, Object> convertMap = new HashMap<String, Object>();

		Field[] fields = obj.getClass().getDeclaredFields();
		
		for (Field field : fields) {
			field.setAccessible(true);
			convertMap.put(field.getName(), field.get(obj));
			System.out.println(convertMap.values());
		}
		return convertMap;
	}


}

	
	
	
	
