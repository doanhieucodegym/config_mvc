package com.hivetech.mvc.controller.admin;

import com.hivetech.mvc.entity.NewEntity;
import com.hivetech.mvc.model.NewModel;
import com.hivetech.mvc.service.impl.NewService;
import com.hivetech.mvc.service.impl.NewServiceJPAImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	private NewService newService;
	@Autowired
	private NewServiceJPAImpl newServiceJPA;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute("model")NewEntity model) {
		ModelAndView mav = new ModelAndView("admin/new/list");
		newServiceJPA.finaAll();
		mav.addObject("model",model);
		return mav;
	}

//	public ModelAndView showList(@ModelAttribute("model") NewEntity model) {
//		ModelAndView mav = new ModelAndView("admin/new/list");
//		newService.findAll();
//		mav.addObject("model",model);
//		return mav;
//	}

	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}
}
