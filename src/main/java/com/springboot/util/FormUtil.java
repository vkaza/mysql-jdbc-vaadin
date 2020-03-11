package com.springboot.util;

import org.springframework.stereotype.Component;

/*@Configuration classes are just like regular @Components classes, except that methods annotated 
with @Bean are used to factory beans. Note that a @Component with @Bean annotated methods works the same way, 
except that scopes are not respected and the @Bean methods are re-invoked (no caching in play), 
so @Configuration is preferred, even though it requires CGLIB*/
@Component
public class FormUtil {
	
//check if string is numeric
	public boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Long d = Long.parseLong(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}
