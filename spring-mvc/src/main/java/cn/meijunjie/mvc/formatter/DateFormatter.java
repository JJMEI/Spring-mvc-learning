package cn.meijunjie.mvc.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
/**
 * Formatter 和 Converter一样，也是讲一种类型转换成另一种类型，但是Formatter的类必须是一个String，而Converter则适合任意的源类型
 * Formatter更适合web层，而Converter适用于任意层中，为了转换SpringMVC 应用程序中的用户输入，应该始终选择Formatter
 * 而不是Converter
 * @author leeco
 *
 */
public class DateFormatter  implements Formatter<Date>{
	
	private static final Logger logger = LoggerFactory.getLogger(DateFormatter.class);
	
	private String dataPattern;
	private SimpleDateFormat dateFormat;
	
	public DateFormatter(String datePattern) {
		this.dataPattern = datePattern;
		dateFormat = new SimpleDateFormat(datePattern);
		
		dateFormat.setLenient(false);//不使用严格解析
	}

	@Override
	public String print(Date date, Locale locale) {
		return dateFormat.format(date);
	}

	@Override
	public Date parse(String s, Locale locale) throws ParseException {
		try {
			return dateFormat.parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("invlida date format. please use this pattern\"" + dataPattern+"\"");
		}
		
	}

}
