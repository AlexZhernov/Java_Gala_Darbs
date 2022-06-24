package lv.library.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.library.demo.model.Reader;
import lv.library.demo.services.IReaderService;



@Controller
@RequestMapping("/reader")
public class ReaderController {
	
	@Autowired
	private IReaderService readercrud;
	
	@GetMapping("/readerall")
	public String AllReader(Model model){
		ArrayList<Reader> list = readercrud.getAllReader();
		model.addAttribute("package", list);
		return "readerall";
	}
	
	@PostMapping("/readerall")
	public String AllReader(Model model, @RequestParam(value="action", required=true) String action) {
		if(action.equals("home")) {
			System.out.println("Kas iet");
			return "redirect:/home";
		}
		return "redirect:/reader/readerall";
	}


}
