package lv.library.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {

	@GetMapping("/home")
	public String HomePage(Model model){
		return "index";
	}
	
	@PostMapping("/home")
	public String Homepage(Model model, @RequestParam(value="action", required=true) String action) {
		if(action == "allreader") {
			return "redirect:/reader/readerall";
		}
		return "index";
	}

}
