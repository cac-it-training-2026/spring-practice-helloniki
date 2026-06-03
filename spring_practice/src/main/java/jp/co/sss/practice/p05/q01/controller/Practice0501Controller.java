package jp.co.sss.practice.p05.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0501Controller {
	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/list/all")
	public String all(Model model) {
		model.addAttribute("fruits", fruitsSeasonRepository.findAll());
		return "practice05/01/fruits_list";
	}

}
