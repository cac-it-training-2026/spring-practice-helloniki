package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {

	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/add/input")
	public String input() {
		return "practice05/05/fruit_input";
	}

	@PostMapping("/fruits/add/complete")
	public String complete(FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruitsSeason = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruitsSeason, "fruitId");
		fruitsSeason = fruitsSeasonRepository.save(fruitsSeason);
		FruitsSeasonBean seasonBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitsSeason, seasonBean);
		model.addAttribute("fruit", seasonBean);

		return "practice05/05/fruit_detail";
	}

}
