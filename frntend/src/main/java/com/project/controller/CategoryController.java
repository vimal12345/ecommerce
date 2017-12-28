package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.project.dao.CategoryDao;
import com.project.model.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	CategoryDao categoryDao;

	@RequestMapping(value = "/Category", method = RequestMethod.GET)
	public String showCategory(Model m) {
		Category category = new Category();
		m.addAttribute(category);

		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "Category";
	}

	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Category category, Model m) {
		categoryDao.addCategory(category);

		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);

		return "Category";
	}

	@RequestMapping(value = "/updateCategory/{catId}", method = RequestMethod.GET)
	public String updateCategory(@PathVariable("catId") int catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		m.addAttribute(category);

		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "Category";
	}

	@RequestMapping(value = "/deleteCategory/{catId}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("catId") int catId, Model m) {
		Category category = categoryDao.getCategory(catId);
		categoryDao.deleteCategory(category);
		category = new Category();
		m.addAttribute(category);
		List<Category> listCategory = categoryDao.retrieveCategory();
		m.addAttribute("categoryList", listCategory);
		return "Category";
	}
}
