package com.cwm.springboot.mytodoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class HelloController {

	@RequestMapping("hello")
	@ResponseBody
	public String printHello() {
		return "hello";
	}

	@RequestMapping("hello-html")
	@ResponseBody
	public String printHtml() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>\r\n" + "<head>\r\n" + "<title>Spring boot</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "\r\n" + "<h1>This is a Heading</h1>\r\n" + "<p>This is a paragraph.</p>\r\n" + "\r\n" + "</body>\r\n"
				+ "</html>");
		return builder.toString();
	}

//	/WEB-INF/jsp/hello.jsp  -> we have to return like this if we don't mention prefix and suffix in prop.file
	// suffix -> .jsp
	// prefix -> /WEB-INF/jsp/
	@RequestMapping("hello-jsp")
	public String printJsp() {
		return "hello";
	}
}
