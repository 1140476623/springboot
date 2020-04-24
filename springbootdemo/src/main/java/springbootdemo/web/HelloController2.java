package springbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("hello2")
public class HelloController2 {

	@RequestMapping("/hello1")
	@ResponseBody
	public String hello1(){
		return "Hello1 Word!!!2017-8-21";
	}
	@RequestMapping("/hello2")
	@ResponseBody
	public String hello2(){
		return "hello2 -2017-8-21";
	}

}
