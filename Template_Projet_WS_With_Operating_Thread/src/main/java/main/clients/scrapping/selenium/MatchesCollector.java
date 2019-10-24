package main.clients.scrapping.selenium;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.clients.IMatchCollector;

public class MatchesCollector implements IMatchCollector {

	private String WEBSITE_URL = "";
	
	private WebDriver flashResultDriver;
	
	public MatchesCollector() {
		ChromeOptions options = new ChromeOptions();
//		options.addArguments(arguments)
//		options.addArguments("--headless");
		
		this.flashResultDriver = new ChromeDriver(options);
		this.flashResultDriver.get(WEBSITE_URL);
	}
	
	@Override
	public List<String> collectDatasForWebSite() {
		
		return null;
	}


}
