package marudaru.main.controller;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import marudaru.board.service.BoardService;

@Controller
public class MainController {

	private static final Log log = LogFactory.getLog(MainController.class);
	
	@RequestMapping(value="/main")
	public ModelAndView main() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/main");
		log.debug("debuglog");
		log.info("Infolog");
		return mv;
	}

	
	
	
}
