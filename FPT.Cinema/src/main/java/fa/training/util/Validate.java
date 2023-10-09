package fa.training.util;

import java.text.SimpleDateFormat;



/**
 * 
 * @author HP
 *
 */
public class Validate {
//	public boolean checkID(String id) throws InvalidStudentAge {
//		Pattern pattern = Pattern.compile("^(LT)[0-9]{6}$");
//		if (!pattern.matcher(id).find()) {
//			throw new InvalidStudentAge();
//		}
//		return true;
//	}
/**
 * 
 * @param id
 * @param candidates
 * @return
 * @throws IDDulicateException
 */
	
	public static boolean checkImporthDay(String birthDay)  {
		SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dFormat.format(DateUtils.convertStringToDate(birthDay));		
		} catch (Exception e) {
			return false;
		}
		return true;
	}
//	public static boolean checkDuplicateAppointment(String dateString, Session session) {
//		Query<Appointment> query = session.createQuery("from Appointment");
////		int count = 0;
//		List<Appointment> appointments = query.list();
//		for(int i = 0; i < appointments.size(); i++) {
//			String dbDateString = DateUtils.convertDateToString(appointments.get(i).getDate());
//			if(dbDateString.equals(dateString)) {
//				return true;
//			}
//		}return false;
//	}
	
//	public static Appointment getAppByDate(Date date, Session session) {
//		Query<Appointment> query = session.createQuery("from Appointment where APP_DATE= :searchDate");
//		query.setParameter("searchDate", date);
//		List<Appointment> getAppointments = query.list();
//		return getAppointments.get(0);
//	}
	public static boolean checkNull(String feild) {
		if(feild.equals(null) || feild.trim().equals("")) {
			return true;
		}else {
			return false;
		}
	}

}
