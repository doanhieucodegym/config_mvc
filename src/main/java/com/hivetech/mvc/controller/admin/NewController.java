package com.hivetech.mvc.controller.admin;

import com.hivetech.mvc.dto.NewDTO;
import com.hivetech.mvc.service.impl.CategoryServiceJPAImpl;
import com.hivetech.mvc.service.impl.NewService;
import com.hivetech.mvc.service.impl.NewServiceJPAImpl;
import com.hivetech.mvc.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "newControllerOfAdmin")
public class NewController {
    @Autowired
    private NewService newService;
    @Autowired
    private NewServiceJPAImpl newServiceJPA;
    @Autowired
    private CategoryServiceJPAImpl categoryServiceJpa;
    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        NewDTO model = new NewDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/new/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(newServiceJPA.finaAll(pageable));
        model.setTotalItem(newServiceJPA.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
           Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messager",message.get("message"));
			mav.addObject("alert",message.get("massage"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/edit");
        NewDTO model = new NewDTO();
        if (id != null) {
            model = newServiceJPA.findById(id);
        }
        if (request.getParameter("message") != null) {
          Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("messager",message.get("message"));
			mav.addObject("alert",message.get("massage"));
        }
        mav.addObject("category", categoryServiceJpa.finAll());
        mav.addObject("model", model);
        return mav;
    }
}
