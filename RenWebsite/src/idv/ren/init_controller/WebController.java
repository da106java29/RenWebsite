package idv.ren.init_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import idv.ren.init_service.WebService;

@Controller
public class WebController {
	
	@Autowired
	private WebService ws;
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

		ModelAndView view = new ModelAndView("demo/demo");
		
		ws.show();
		
		return view;
    }
	
//	@RequestMapping("/")
//	public String index() {
//		ws.show();
//		return "demo/demo";
//	}
	
}
