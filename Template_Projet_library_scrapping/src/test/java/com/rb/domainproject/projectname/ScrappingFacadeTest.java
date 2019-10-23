package com.rb.domainproject.projectname;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rb.domainproject.projectname.config.AppConfig;
import com.rb.domainproject.projectname.modele.Event;
import com.rb.domainproject.projectname.scrappers.ScrappingFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ScrappingFacadeTest {
	
	@Autowired
	private ScrappingFacade scrappingFacade;

	
	/* **************
	 * *	NOTES	*
	 * **********************************************************************************
	 * *																				*
	 * *	The project has been abandonned because there are too many protections 		*
	 * *	against the crawlers. I get my account banned very often, and it is very 	*
	 * *	hard to create a new account with an e-mail address and a phone number 		*
	 * *	already used... 															*
	 * *																				*
	 * **********************************************************************************
	 */
	
	
	@Test
	public void getRatioForEventTest() {
		//Arrange
		String link = "";
		Event event = new Event("Test event", link);
		
		// Action
		Double ratioEvent = 0d;
		try {
			ratioEvent = scrappingFacade.GetRatioForEvent(event);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
		//Assert
		Assert.assertThat(ratioEvent, CoreMatchers.not(0));		
	}
	
	@Test
	public void gatherNewEventsTest() {
		Assert.fail("Test not implemented yet");
	}

	public ScrappingFacade getScrappingFacade() {
		return scrappingFacade;
	}

	public void setScrappingFacade(ScrappingFacade scrappingFacade) {
		this.scrappingFacade = scrappingFacade;
	}
	
}
