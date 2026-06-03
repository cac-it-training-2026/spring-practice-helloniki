package jp.co.sss.practice.p07.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0701Controller {

	@Autowired
	FruitsShopItemRepository fruitsShopItemRepository;

	@GetMapping("/fruits_shop")
	public String shop(Model model) {
		model.addAttribute("items", fruitsShopItemRepository.findAll());
		return "practice07/01/items_list";
	}

}
