package com.nifal.springBootProject.myFirsWebProject.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello() {
		return "hello !!!";
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayhelloJsp() {
		return "sayhello";
	}

}
