package jp.co.sss.practice.p05.q04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller

public class Practice0504Controller {

	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/search/input")
	public String input() {
		return "practice05/04/fruits_select_season";
	}

	@GetMapping("/fruits/list")
	public String all(Integer season, Model model) {

		List<FruitsSeason> fruitsList = fruitsSeasonRepository.findBySeasonMonth(season);

		model.addAttribute("fruits", fruitsList);

		String seasonText;

		if (season == 13) {
			seasonText = "通年";
		} else {
			seasonText = season + "月";
		}

		model.addAttribute("seasonText", seasonText);

		return "practice05/04/fruits_list";
	}

}
