package jp.co.sss.practice.p05.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0502Controller {
	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/list/sort/season")
	public String all(Model model) {
		model.addAttribute("fruits", fruitsSeasonRepository.findAllByOrderBySeasonMonthAsc());
		return "practice05/02/fruits_list";
	}

}
