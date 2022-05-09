package marudaru.member.controller;

import java.awt.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import marudaru.common.common.CommandMap;
import marudaru.member.service.LoginService;

@Controller
public class LoginController {

	@Resource(name="loginService")
	LoginService loginService;
	
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(HttpSession session, HttpServletRequest request, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/main");
		ModelAndView mv2 = new ModelAndView("/member/loginMember");
		String memId = (String) request.getParameter("memId");
		String memPass = (String) request.getParameter("memPass");
		
		
		commandMap.put("MEM_ID", memId);
		commandMap.put("MEM_PASS", memPass);
		
		int idchk = loginService.loginIdchk(commandMap.getMap());
		
		if(idchk == 1) {
			
			String password = (String) loginService.passwordChk(commandMap.getMap());
			if(memPass.equals(password)) {
				
				Map<String, Object> login =  loginService.login(commandMap.getMap());
				
				session.setAttribute("session_MEM_ID", commandMap.get("MEM_ID"));
				String message = "로그인 완료";
				mv.addObject("message", message);
				return mv;
			}else {
				String message = "비밀번호가 맞지않습니다.";
				mv2.addObject("message", message);
				return mv2;
			}
		}else {
			String message = "ID가 맞지않습니다.";
			mv2.addObject("message", message);
			return mv2;
		}
	}
	
	
	@RequestMapping("/doLogout")
	public ModelAndView doLogout(HttpSession session) {
		
		
		session.invalidate();
		
		return new ModelAndView("redirect:/main");
	}
	
	
	
}
