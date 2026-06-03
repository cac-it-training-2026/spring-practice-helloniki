package jp.co.sss.practice.p06.q02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {
	@Autowired
	FruitsAreaRepository fruitsAreaRepository;
	@Autowired
	AreaRepository areaRepository;

	@GetMapping("/fruits/select/area")
	public String area(Model model) {
		List<Area> area = areaRepository.findAllByOrderByAreaIdAsc();
		model.addAttribute("areas", area);
		return "practice06/02/area_select";
	}

	@GetMapping("/fruits/select/area/result")
	public String result(Integer areaId, Model model) {
		String area = areaRepository.findByAreaId(areaId).getAreaName();

		model.addAttribute("resultarea", area);
		model.addAttribute("resultfruits", fruitsAreaRepository.findAllByAreaAreaIdOrderByFruitIdAsc(areaId));
		return "practice06/02/fruits_list";
	}

}