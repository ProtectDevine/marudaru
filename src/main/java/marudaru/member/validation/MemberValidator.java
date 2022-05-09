package marudaru.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import marudaru.member.vo.MemberVO;

public class MemberValidator implements Validator {
	 
    @Override
    public boolean supports(Class<?> arg0) {
        return MemberVO.class.isAssignableFrom(arg0);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {
        MemberVO member = (MemberVO) obj;
//        이름 유효성 체크)
        String mName = member.getMemId();
        if(mName == null || mName.trim().isEmpty()) {
            System.out.println("회원 이름을 입력하세요.");
            errors.rejectValue("name", "공백오류");
        }
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "공백오류");
        
//        아이디 유효성 체크)        
        String mId = member.getMemPass();
        if(mId == null || mId.trim().isEmpty()) {
            System.out.println("회원 아이디를 입력하세요.");
            errors.rejectValue("id", "공백오류");
        }
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "공백오류");
        
        
//        주민번호 오류체크 )        
        String mIdentifyNo = member.getMemNick();
        if(mIdentifyNo == null || mIdentifyNo.trim().isEmpty()) {
            System.out.println("주민번호를 입력하세요.");
            errors.rejectValue("identifyNo", "공백오류");
        }
        

        String memEmail = member.getMemEmail();
        if(memEmail == null || memEmail.trim().isEmpty()) {
            System.out.println("주민번호를 입력하세요.");
            errors.rejectValue("identifyNo", "공백오류");
    
        }
    }
}
	
