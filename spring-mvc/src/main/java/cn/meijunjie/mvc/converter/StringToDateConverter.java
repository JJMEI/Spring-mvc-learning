package cn.meijunjie.mvc.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{

	private static final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);
	
	private String datePattern;
	public StringToDateConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
		logger.info("设置转换模式。。。{}" + datePattern);
	}



	@Override
	public Date convert(String s) {
		
		try 
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
			simpleDateFormat.setLenient(false);
			return simpleDateFormat.parse(s);
			
		} catch (ParseException e) {
			throw new IllegalArgumentException("invalida date format. Please use this pattern\""+datePattern+"\"");
		}
		
	}

}
