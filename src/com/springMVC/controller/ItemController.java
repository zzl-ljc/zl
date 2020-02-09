package com.springMVC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springMVC.pojo.Items;
import com.springMVC.pojo.QueryVo;
import com.springMVC.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList() {
		
		//查询数据库数据
		List<Items> list = itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	
	//修改页面入参id
//	@RequestMapping(value = "/itemEdit.action")
//	public ModelAndView toEdit(HttpServletRequest request, HttpServletResponse response,
//			HttpSession session, Model model) {
//		//原始servlet
//		String id = request.getParameter("id");
//		Items item = itemService.selectItemById(Integer.parseInt(id));
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("item", item);
//		mav.setViewName("editItem");
//		return mav;
//		
//	}
	
	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEdit(Integer id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
	//简单参数类型绑定
		Items item = itemService.selectItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
		
	}
	
	//提交修改页面入参为Item对象(POJO参数绑定)
	//页面渲染的name属性和POJO的属性名称一致,和形参items没有关系
//	@RequestMapping(value = "/updateitem.action")
//	public ModelAndView updateItem(Items items) {
//		//修改
//		itemService.updateItemsById(items);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("success");
//		return mav;
//	}
	
	
	//用包装类型QueryVo
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateItem(QueryVo vo) {
		//修改
		itemService.updateItemsById(vo.getItems());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
}
