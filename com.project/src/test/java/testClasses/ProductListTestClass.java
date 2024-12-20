package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import UtilityClasses.FileUpload;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.ProductListPageClass;

public class ProductListTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	ProductListPageClass pl;
	
  @Test
  public void verifyTheListOfProductPageIsOpenedWhilwClickingOnListProducts() {
	  
	  lp=new LoginPageClass(driver)  ;
		hp=lp.login("admin","123456");
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl=hp.clickOnListProducts();
		String res=pl.verifyProductPageIsOpened();
		Assert.assertTrue(res.contains("Manage your products"));
		
  }
  
  @Test
  public void verifyToCreateAnewProduct() throws InterruptedException {
	  lp=new LoginPageClass(driver)  ;
		hp=lp.login("admin","123456");
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl=hp.clickOnListProducts(); 
	    pl.clickOnAddProduct();
	    pl.addNewProduct("Id card","121",System.getProperty("user.dir")+"\\src\\test\\resources\\Aggregation.jpg" ,"12", "50");
	    pl.searchAlreadyAddedProductInSearchBox("Id card");
	    pl.scrollToFindDeleteSelectedButton();
	    String actR=pl.toGetTheTextOfNameFieldAfterSearch();
	    System.out.println(actR);
	     SoftAssert soft=new SoftAssert();
	     soft.assertTrue(actR.contains("Id"), "The product not added successfully");
	    soft.assertAll();
	    System.out.println("Product added successfully");
	    
  }
  @Test
  public void verifyToDeleteTheAddedProduct() throws InterruptedException {
	  
	  lp=new LoginPageClass(driver)  ;
		hp=lp.login("admin","123456");
		hp.clickOnEndTour();
		hp.clickOnProductButton();
		pl=hp.clickOnListProducts(); 
		pl.searchAlreadyAddedProductInSearchBox("Id card");
		
		
	//	pl.scrollToFindActionButton();
		
		
		pl.deleteAddedProduct();
		
		boolean actualRes=pl.isNoRecordsDisplayedAfterDeletion();
		System.out.println(actualRes);
		Assert.assertTrue(actualRes);
		System.out.println("Product deleted Successfully");
  }
  
 
}
