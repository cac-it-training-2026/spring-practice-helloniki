package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping(path = "/numguess/start", method = RequestMethod.GET)
	public String start(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		session.setAttribute("answer", hitNumber);
		System.out.println(hitNumber);
		return "practice04/02/numguess_start";
	}

	@RequestMapping(path = "/numguess/input", method = RequestMethod.GET)
	public String input() {
		return "practice04/02/numguess_input";
	}

	@GetMapping("/numguess/judge")
	public String judge(HttpSession session, Integer inputNum) {

		Integer answer = (Integer) session.getAttribute("answer");
		if (answer.equals(inputNum)) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}

	@GetMapping("/numguess/hit")
	public String hit(Model model, HttpSession session) {
		int answer = (int) session.getAttribute("answer");
		session.setAttribute("hitmess", "当たりです！ 正解は" + answer + "でした。");
		session.removeAttribute("answer");

		return "practice04/02/numguess_end";

	}

}
