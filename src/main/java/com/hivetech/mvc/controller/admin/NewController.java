package com.hivetech.mvc.controller.admin;

import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.service.impl.NewService;
import com.hivetech.mvc.service.impl.NewServiceJPAImpl;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	private NewService newService;
	@Autowired
	private NewServiceJPAImpl newServiceJPA;

	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		NewDTO model =new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page-1,limit);
		model.setListResult(newServiceJPA.finaAll(pageable));
		model.setTotalItem(newServiceJPA.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}

//	public ModelAndView showList(@ModelAttribute("model") NewEntity model) {
//		ModelAndView mav = new ModelAndView("admin/new/list");
//		newService.findAll();
//		mav.addObject("model",model);
//		return mav;
//	}

	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value ="id",required = false)Long id) {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		if(id != null){}
		return mav;
	}
}
