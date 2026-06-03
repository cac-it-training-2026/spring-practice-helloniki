package jp.co.sss.practice.p06.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
class Practice0601Controller {

	@Autowired
	FruitsAreaRepository fruitsAreaRepository;

	@GetMapping("/fruits/area/list/all")
	public String all(Model model) {
		//		List<FruitsArea> fruitsAreaList = fruitsAreaRepository.findAll();

		model.addAttribute("fruitarea", fruitsAreaRepository.findAll());
		return "practice06/01/fruits_list";
	}

}
