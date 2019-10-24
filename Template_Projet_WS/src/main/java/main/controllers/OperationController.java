package main.controllers;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.controllers.common.AbstractController;
import main.model.ErrorBuilder;

@RestController
public class OperationController extends AbstractController{
	
	public static final String UPDATE_PLAYLIST_PATH = "/UpdatePlaylist";
	
	@GetMapping(value = UPDATE_PLAYLIST_PATH)
	public String UpdateOperation(@RequestParam String token) throws AuthenticationException {
		String failedAuthMessage = processAuthorization(token);
    	if(failedAuthMessage != null)
    		return failedAuthMessage;
		
    	try {
			System.out.println("Operation done.");
			return "Success";
			
    	}catch(Exception e) {
    		return ErrorBuilder.buildError(formatStringException(e));
    	}
	}
	
}
