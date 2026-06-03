package jp.co.sss.practice.p02.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0201Controller {
	@RequestMapping(path = "/first")
	public String first() {
		return "practice02/01/before_redirect";
	}

	@RequestMapping(path = "/second")
	public String second() {
		return "redirect:/third";
	}

	@RequestMapping(path = "/third")
	public String third() {
		return "practice02/01/after_redirect";

	}
}
