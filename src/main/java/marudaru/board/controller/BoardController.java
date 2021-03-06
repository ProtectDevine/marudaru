package marudaru.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import marudaru.board.service.BoardService;
import marudaru.common.common.CommandMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Command;
import org.slf4j.*;


@Controller
public class BoardController {
	
	Logger log = LoggerFactory.getLogger(BoardController.class);
	
	
	@Resource(name="boardService")
	private BoardService boardService;

	@RequestMapping(value="/boardList")
	public ModelAndView openBoardList(HttpServletRequest request,Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		String tab = (String) request.getParameter("tab");
		if(tab != null) {
			commandMap.put("TAB", tab);
			List<Map<String, Object>> list = boardService.selectBoardListTab(commandMap);
			mv.addObject("list", list);
			return mv;
		}
		
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		mv.addObject("list", list);
		int i;
		for(i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return mv;
	}
	
	
	@RequestMapping(value="/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("");
		
		if(commandMap.isEmpty() == false){
			Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
			Entry<String,Object> entry = null;
			while(iterator.hasNext()){
				entry = iterator.next();
				log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
			}
		}
		return mv;

	}
	
	@RequestMapping(value="/openBoardWrite")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardWrite");
		
		return mv;
	}

	
	@RequestMapping(value ="/insertBoard")
	public ModelAndView insertBoard(HttpServletRequest request, CommandMap commandMap) throws Exception {
		
		String contents = (String) request.getParameter("editordata");
		String title = (String) request.getParameter("TITLE");
		commandMap.put("TITLE", title);
		commandMap.put("CONTENTS", contents);
		
		System.out.println(title);
		System.out.println(contents);
		
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		
		boardService.insertBoard(commandMap.getMap());
		return mv;
	}

	@RequestMapping(value = "/openBoardDetail")
	public ModelAndView openBoardDetail(HttpServletRequest request, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		String idx = (String) request.getParameter("IDX");
		commandMap.put("IDX", idx);
		System.out.println(idx);
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());		
		
		mv.addObject("map", map);
		return mv;
	}
	
	
	@RequestMapping(value = "/sample/login")
	public ModelAndView login(HttpServletRequest request, CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("login");
		boardService.insertJoin(commandMap.getMap());

		
		return mv;
	}
	
	
	@RequestMapping("/openBoardUpdate")
	public ModelAndView openBoardUpdate(HttpServletRequest request, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardUpdate");
				
		String idx = (String) request.getParameter("IDX");
		commandMap.put("IDX", idx);
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map);		
		System.out.println(idx);

		return mv;
	}
	
	@RequestMapping("/updateBoard")
	public ModelAndView updateBoard(@RequestParam String TITLE, String CONTENTS, String IDX, HttpServletRequest request, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");

		request.setCharacterEncoding("utf-8");
		/*
		 * String idx = (String) request.getParameter("IDX"); String title = (String)
		 * request.getParameter("TITLE"); String contents = (String)
		 * request.getParameter("CONTENTS");
		 * System.out.println("글 수정번호"+idx+"TITLE"+title+"CONTENTS"+contents);
		 */
		System.out.println("글 수정번호 = "+IDX+"TITLE = "+TITLE+"CONTENTS = "+CONTENTS);
		commandMap.put("IDX", IDX);
		commandMap.put("TITLE", TITLE);
		commandMap.put("CONTENTS", CONTENTS);
		boardService.updateBoard(commandMap.getMap());
		return mv;
	}
	
	@RequestMapping("/deleteBoard")
	public ModelAndView deleteBoard(@RequestParam String IDX, CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/boardList");
		commandMap.put("IDX", IDX);
		System.out.println("삭제 IDX" + IDX);
		boardService.deleteBoard(commandMap.getMap());
		
		return mv; 
	}

	

	
	
}
	
	
