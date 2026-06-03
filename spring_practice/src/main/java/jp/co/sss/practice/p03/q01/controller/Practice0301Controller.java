package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice0301Controller {

	@RequestMapping(path = "/input", method = RequestMethod.GET)
	public String inPut() {
		return "practice03/01/input_form";
	}

	@RequestMapping(path = "/send/get_method", method = RequestMethod.GET)
	public String getme(String color) {
		System.out.println("GET メソッドで受け取りました");
		System.out.println("パラメータの値:" + color);
		return "practice03/01/get_result";
	}

	@RequestMapping(path = "/send/post_method", method = RequestMethod.POST)
	public String postme(String color) {
		System.out.println("POST メソッドで受け取りました");
		System.out.println("パラメータの値:" + color);
		return "practice03/01/post_result";
	}

}
