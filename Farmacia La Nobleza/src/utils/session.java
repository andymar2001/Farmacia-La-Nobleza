package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class session {

	
	public void saveString (HttpServletRequest request, String key, String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	public void saveBoolean (HttpServletRequest request, String key, Boolean value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
	public void saveTimeOut(HttpServletRequest request, int time) {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(time);
	}
	
	public void invalidateSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	public void saveInt(HttpServletRequest request,String key,int value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}
	
}
