package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rb.common.api.logging.LogLevel;
import com.rb.common.api.logging.LogManager;
import com.rb.common.api.logging.LoggingAction;

import main.core.ThreadCore;

/**
 * By implementing ApplicationListener<ContextRefreshedEvent>, this class will be loaded after loading all the beans 
 * 
 * @author Megaport
 *
 */
@Component
public class StartingRun  implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	ThreadCore coreThread;
	
	@Autowired
	LogManager logger;
	
	private boolean isCoreThreadStarted = false;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(!isCoreThreadStarted) {
			this.coreThread.start();
			this.isCoreThreadStarted = true;
		} else
			logger.log("The 'StartingRun' tries to instantiate a other instance of 'ThreadCore', but it cannot (normal behaviour)", LogLevel.INFO, LoggingAction.Stdout);
	}
}
