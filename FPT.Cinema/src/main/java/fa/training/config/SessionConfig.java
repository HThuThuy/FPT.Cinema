package fa.training.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig implements HttpSessionListener {

	// Định nghĩa thời gian chờ tối đa cho một session là 60 phút
	private static final int MAX_INACTIVE_SESSION_TIME = 60 * 60; 

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Ngày sinh: 13/07/1992
	 * Khi một session mới được tạo, phương thức này sẽ được gọi và thiết lập thời gian chờ tối đa cho session
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(MAX_INACTIVE_SESSION_TIME);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}
}