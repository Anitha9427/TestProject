package testClasses;

import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUser;

import org.testng.Assert;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	ManageUser mp;

	@Test
	public void verifyAllTilesDisplayedOnHomePage() throws InterruptedException {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		boolean actRes = hp.isAllTilesDisplayed();
		Assert.assertTrue(actRes);

	}

	@Test
	public void verifyTheToolTipCalculatorIsShowingWhileHoveringTheMouseOnCalculator() throws InterruptedException {
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.moveTheMouseToTheCalculator();
		String disAct = hp.getAttributeValueOfCalculatorButton("data-original-title");
		Assert.assertTrue(disAct.contains("Calculator"));
		System.out.println(disAct);
	}

	

	@Test
	public void verifySuccessfulSignOut() {

		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		lp = hp.signOutFromHomePage();
		String actualRes = hp.getTextOfDemo_POSHeadingInLoginPage();
		String expectedRes = "Demo POS";
		Assert.assertEquals(actualRes, expectedRes);
		System.out.println("Signed Out Successfully!!!");

	}

	
	

}
