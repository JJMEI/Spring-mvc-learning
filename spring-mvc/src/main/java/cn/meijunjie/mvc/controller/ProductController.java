package cn.meijunjie.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.meijunjie.mvc.po.Product;
import cn.meijunjie.mvc.po.ProductForm;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	@RequestMapping(value="product_input")
	public String inputProduct()
	{
		logger.info("inputProduct called");
		return "ProductForm";
	}
	
	/**
	 * Spring MVC 在一次请求处理方法被调用时，都会创建一个Model对象实例，用于增加要在视图中显示的属性
	 * @param productForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="product_save")
	public String saveProduct(ProductForm productForm, Model model)
	{
		logger.info("saveProduct called");
		Product product = new Product();
		
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (NumberFormatException e) {
			logger.info("出现异常 {}" + e);
		}
		
		//add product 将对象添加到model
		model.addAttribute("product",product);
		return "ProductDetails";
	}
	
}
