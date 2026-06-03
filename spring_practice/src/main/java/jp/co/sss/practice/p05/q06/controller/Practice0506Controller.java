package jp.co.sss.practice.p05.q06.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {

	@Autowired
	FruitsSeasonRepository fruitsSeasonRepository;

	@GetMapping("/fruits/update")
	public String update(Model model) {
		List<FruitsSeason> fruitsSeasons = fruitsSeasonRepository.findAll();
		model.addAttribute("fruits", fruitsSeasons);
		return "practice05/06/fruit_select";
	}

	@PostMapping("/fruits/update/input")
	public String input(Integer fruitId, Model model) {
		FruitsSeason fruitsSeason = fruitsSeasonRepository.findById(fruitId).get();
		FruitsSeasonBean seasonBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitsSeason, seasonBean);
		model.addAttribute("fruit", seasonBean);

		return "practice05/06/fruit_input";
	}

	@PostMapping("/fruits/update/complete/{fruitId}")
	public String completever(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {

		FruitsSeason fruitsSeason = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruitsSeason);
		fruitsSeason = fruitsSeasonRepository.save(fruitsSeason);
		FruitsSeasonBean seasonBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitsSeason, seasonBean);
		fruitsSeason.setFruitId(fruitId);
		model.addAttribute("fruit", seasonBean);

		return "practice05/06/fruit_detail";
	}

}
