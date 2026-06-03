package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {
	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/list/sort/id")
	public String all(Model model) {
		model.addAttribute("fruits", fruitsSeasonRepository.findAllByOrderByFruitIdAsc());
		return "practice05/03/fruits_list";
	}

	@GetMapping("/fruits/detail/{fruitId}")
	public String detail(@PathVariable Integer fruitId, Model model) {
		FruitsSeason fruitsSeason = fruitsSeasonRepository.findById(fruitId).get();
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();
		fruitsSeasonBean.setFruitId(fruitsSeason.getFruitId());
		fruitsSeasonBean.setFruitName(fruitsSeason.getFruitName());
		fruitsSeasonBean.setSeasonMonth(fruitsSeason.getSeasonMonth());
		model.addAttribute("fruit", fruitsSeasonBean);
		return "practice05/03/fruit_detail";
	}

}
