package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookiesSave {

	
	public void saveCookie(HttpServletResponse response, String key, String value) {
		
		Cookie cookie = new Cookie(key, value);
		response.addCookie(cookie);
		
	}
	
	public void deleteCookie(HttpServletResponse response, String key) {
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(0); //Es en segundos - tiempo de expiracion 
		response.addCookie(cookie);
	}
	
}
