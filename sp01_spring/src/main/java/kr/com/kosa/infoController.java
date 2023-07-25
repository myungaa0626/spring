package kr.com.kosa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class infoController {
	
	
	@RequestMapping(value = "/info")
	public String info(Model model) {
		// 이름, 주소, 연락처 데이터 출력하기

		String name = "명관";
		String address = "서울";		
		String phone = "010-1234-5678";

		model.addAttribute("name", name);
		model.addAttribute("address", address);
		model.addAttribute("phone", phone);

		return "info";
	
	}

}
