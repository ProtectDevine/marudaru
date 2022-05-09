package marudaru.member.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import marudaru.common.common.CommandMap;
import marudaru.member.service.MemberService;
import marudaru.member.validation.MemberValidator;
import marudaru.member.vo.MemberVO;

@Controller
public class memberController {

	BeanUtils beanUtils;
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name="commandMap")
	private CommandMap commandMap;
	
	@RequestMapping("/loginMember")
	public ModelAndView loginMember() {
		ModelAndView mv = new ModelAndView("/member/loginMember");
		return mv;
	}
	
	@RequestMapping("/joinMember")
	public ModelAndView joinMember(@ModelAttribute MemberVO memberVO) {
		ModelAndView mv = new ModelAndView("/member/joinMember");
		mv.addObject("memberVO", memberVO);
		return mv;
	}

	@RequestMapping(value = "/joinMember2", method= RequestMethod.POST)
	public ModelAndView joinMemberSubmit(@ModelAttribute @Valid MemberVO memberVO, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {

		int resultId = memberService.idChk(commandMap.getMap(), memberVO);
		
		if(resultId==1) {
			String message = "아이디가 존재합니다.";
			ModelAndView mv = new ModelAndView("/member/joinMember");
			mv.addObject("message", message);
			return mv;
		}else {
			memberService.insertJoinMember(commandMap.getMap(), memberVO);
			return new ModelAndView("/main/main");
		}
		
		
	}
}
