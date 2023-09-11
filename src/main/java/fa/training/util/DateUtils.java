package fa.training.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author HP
 *
 */
public class DateUtils {
	/**
	 * 
	 * @param dt
	 * @return
	 */
	public static java.sql.Date convertStringToDate(String dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			return  new java.sql.Date(sdf.parse(dt).getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
/**
 * 
 * @param date
 * @return
 */
	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date convertUtilToSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
/**
 * 
 * @param date
 * @return
 */
	public static Date convertSqlToUtilDate(java.sql.Date date) {
		return new Date(date.getTime());
	}
}
