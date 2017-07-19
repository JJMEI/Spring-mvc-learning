package cn.meijunjie.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.meijunjie.mvc.po.Employee;

@Controller
public class EmployeeController {
		
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(value="/employee_input")
	public String inputEmployee(Model model)
	{
		logger.info("成功进入方法内部。。。");
		model.addAttribute(new Employee());
		return "EmployeeForm";
	}
	
	@RequestMapping(value="/employee_save")
	public String saveEmployee(@ModelAttribute Employee employee,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			FieldError fieldError = result.getFieldError();
			logger.info("Code: " + fieldError.getCode() + ", field:" + fieldError.getField());
			return "EmployeeForm";
		}
		
		model.addAttribute("employee", employee);
		return "EmployeeDetails";
	}
}
