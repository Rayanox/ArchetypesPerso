package main.controllers;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.authentication.ServerTokenProvider;
import main.model.ErrorBuilder;
import main.utils.Converter;

@RestController
public class MainController {

	@Autowired
	ServerTokenProvider serverTokenProvider;
	
    @RequestMapping(value = "/getMainController", method = RequestMethod.GET)
    public String GetMainController(@RequestParam(value = "token") String token) throws AuthenticationException {
    	String failedAuthMessage = processAuthorization(token);
    	if(failedAuthMessage != null)
    		return failedAuthMessage;
    	
    	String result = "COUCOU";
    	try {
    		return result;
    	}catch(Exception e) {
    		return result + ErrorBuilder.buildError(formatStringException(e));
    	}
    }
    
    
    
    
    
    
    
    
    
    /*
     *  Private tools
     */
    

    private String formatStringException(Exception e) {
    	return e.getMessage() + "       -----||-----     " + e.getClass().getName() + " ----- " + Converter.convertStacktraceToString(e.getStackTrace());
    }
    
    private String processAuthorization(String token) throws AuthenticationException {
    	if(!serverTokenProvider.AuthorizeRequestToken(token)) {
    		return ErrorBuilder.buildError("The token does not equal the server-side token.");
    	}else {
    		return null;
    	}
    }
}
