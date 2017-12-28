package com.project.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.dao.CategoryDao;
import com.project.dao.ProductDao;
import com.project.model.Category;
import com.project.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;

	@Autowired
	HttpSession session;
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	Product product;
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/admin/AddProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model m) {
		productDao.addProduct(product);

		session.getServletContext().setAttribute("product", product);

		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);

		return "upload";
	}

	@RequestMapping(value = "/admin/updateProduct/{productId}", method = RequestMethod.GET)
	public String updateProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDao.getProduct(productId);
		
		this.product = product;
		m.addAttribute("categoryList", categoryDao.retrieveCategory());

		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "redirect:/proPage";
	}

	@RequestMapping(value = "/admin/deleteProduct/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") int productId, Model m) {
		Product product = productDao.getProduct(productId);
		productDao.deleteProduct(product);
		m.addAttribute("product", new Product());

		m.addAttribute("categories", categoryDao.retrieveCategory());
		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "Product";
	}

	@RequestMapping(value = "/admin/uploadFile", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println("Image upload controller reached.");
		Product product = (Product) session.getServletContext().getAttribute("product");
		System.out.println("Adding image for:" + product.getProductName());
		String name1 = product.getProductName();

		if (!file.isEmpty()) {
			try {
				String rootPath = request.getServletContext().getRealPath("/resources/image");
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				String filePath = dir + File.separator + name1 + ".jpg";
				File dest = new File(filePath);
				System.out.println("------- Image uploaded to " + dest + "-------");
				file.transferTo(dest);
				return "redirect:/Product";
			} catch (Exception e) {
				return "You failed to upload " + name1 + " => " + e.getMessage();
			}
		} else {
			List<Product> listProduct = productDao.retrieveProducts();
			model.addAttribute("product", listProduct);
			return "upload";
		}
	}

	@RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
	public String ProductPage(@ModelAttribute Product product, Model model) {
		model.addAttribute("product", new Product());

		return "product";
	}

	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
	public String CategoryPage(@ModelAttribute Category category, Model model) {
		model.addAttribute("category", new Category());
		return "category";
	}
	
	@RequestMapping(value = "/proPage")
	public String showProductPage(Model m) {
		
		m.addAttribute("product", this.product);

		m.addAttribute("categories", categoryDao.retrieveCategory());
		List<Product> listProduct = productDao.retrieveProducts();
		m.addAttribute("productList", listProduct);
		return "Product";
	}

}
