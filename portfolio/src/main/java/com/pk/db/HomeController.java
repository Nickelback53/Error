package com.pk.db;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pk.db.domain.Item;
import com.pk.db.service.ItemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//Service ��ü�� ����
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {;
		//���� �޼ҵ� ȣ��
		List<Item> list = itemService.allItem(request);
		//������ ����
		model.addAttribute("list", list);
	
		return "home";
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model) {;
		//���� �޼ҵ� ȣ��
		Item item = itemService.getItem(request);
		//������ ����
		model.addAttribute("item", item);
	
		return "detail";
	}
	
	
	@RequestMapping(value = "/detail/{itemid}", method = RequestMethod.GET)
	public String detail(HttpServletRequest request, Model model,
			@PathVariable int itemid) {;
		//���� �޼ҵ� ȣ��
		Item item = itemService.getItem(request, itemid);
		//������ ����
		model.addAttribute("item", item);
	
		return "detail";
	}
	
	@RequestMapping(value="/item.xls", method=RequestMethod.GET)
	public String excel(HttpServletRequest request, Model model) {
		//���� �޼ҵ� ȣ��
		List<Item> list = itemService.allItem(request);
		//������ ����
		model.addAttribute("list", list);
		//���̸��� ����
		return "excel";
	}
}

