package idv.ren.init_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping("/")
	public ModelAndView doIndex() {
		ModelAndView view = new ModelAndView("index");
		
		return view;
	}
}
