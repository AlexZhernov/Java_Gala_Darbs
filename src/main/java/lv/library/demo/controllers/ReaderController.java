package lv.library.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.library.demo.model.Reader;
import lv.library.demo.services.IReaderService;



@Controller
@RequestMapping("/reader")
public class ReaderController {
	
	@Autowired
	private IReaderService readercrud;
	
	@GetMapping("/readerall")
	public String HomePage(Model model){
		ArrayList<Reader> list = readercrud.getAllReader();
		model.addAttribute("package", list);
		return "readerall";
	}


}
