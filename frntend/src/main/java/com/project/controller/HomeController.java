package com.project.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.CategoryDao;
import com.project.dao.ProductDao;
import com.project.model.Product;

@Controller
public class HomeController {

	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = { "/", "/index" })
	public String getIndexpage(Model m) {
		m.addAttribute("categoryList", categoryDao.retrieveCategory());

		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "index";
	}

	@RequestMapping(value = { "/page" })
	public String getPage(Model m) {

		request.getServletContext().setAttribute("categoryList", categoryDao.retrieveCategory());

		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "index";
	}

	@RequestMapping(value = { "/getProductByCat/{id}" })
	public String getProductByCategory(Model m, @PathVariable("id") int id) {

		Product product = new Product();
		m.addAttribute("product", product);

		m.addAttribute("categories", categoryDao.retrieveCategory());
		List<Product> listProduct = productDao.getProductByCategory(id);
		m.addAttribute("productList", listProduct);
		return "Product";
	}

	@RequestMapping(value = { "/login" })
	public String getpage() {
		return "login";
	}

	@RequestMapping("/show/product/{productId}")
	public String getProduct(@PathVariable int productId, Model model) {

		model.addAttribute("product", productDao.getProduct(productId));

		return "showProduct";
	}

	@RequestMapping(value = "Product", method = RequestMethod.GET)
	public String showProduct(Model m) {
		Product product = new Product();
		m.addAttribute("product", product);

		m.addAttribute("categories", categoryDao.retrieveCategory());
		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "Product";
	}
}
