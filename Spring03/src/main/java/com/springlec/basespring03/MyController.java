package com.springlec.basespring03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class MyController {
	
	@RequestMapping("/view")
	public String view() {
		return "test/view";
	}

}
