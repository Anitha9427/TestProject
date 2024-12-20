package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ManageUser;
import pageClasses.ProductListPageClass;

public class ManageUserTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageUser mp;
	ProductListPageClass pl;
	
	@Test
	public void verifyTheManageUsersPageIsOpenWhileClickingOnUsers() throws InterruptedException {
		lp = new LoginPageClass(driver);
		hp = lp.login("admin", "123456");
		hp.clickOnEndTour();
		hp.clickOnUserManagement();
		mp = hp.clickOnUsers();
		String actualRes = mp.GetTextOfManageUsersHeading();
		Assert.assertTrue(actualRes.contains("Manage"));

	}
	
  @Test
  public void addANewUser() throws InterruptedException {
	  lp=new LoginPageClass(driver)  ;
		hp=lp.login("admin","123456");
		hp.clickOnEndTour();
		hp.clickOnUserManagement();
		mp=hp.clickOnUsers();
		mp.addUserInManageUsers("Poornima","poornima@gmail.com", "123456","123456");
        mp.searchAddedUserUsingSearchBar("Poornima");
		boolean actName=mp.isCreatedNameDisplayed();
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(actName);
		soft.assertAll();
		System.out.println("User Poornima added successfully!!!");

		}
}
