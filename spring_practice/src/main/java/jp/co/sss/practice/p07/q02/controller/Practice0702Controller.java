package jp.co.sss.practice.p07.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {

	@Autowired
	TypeRepository typeRepository;
	@Autowired
	EntityManager entityManager;

	@GetMapping("/fruits_shop/named/input")
	public String input(Model model) {
		model.addAttribute("types", typeRepository.findAll());
		return "practice07/02/search_input";
	}

	@GetMapping("/fruits_shop/named/result")
	public String result(Integer minPrice, Integer maxPrice, Integer typeId, Model model) {
		Type type = typeRepository.findByTypeId(typeId);
		Query query = entityManager.createNamedQuery("findNamedQueryByPriceRangeAndType");
		query.setParameter("type", type);
		query.setParameter("min", minPrice);
		query.setParameter("max", maxPrice);
		model.addAttribute("types_with_query", query.getResultList());

		return "practice07/02/items_list";
	}

}
