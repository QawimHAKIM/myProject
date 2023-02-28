package tek.capstone.bdd.framework.pages;

import tek.capstone.bdd.framework.base.BaseSetup;

public class POMFactory extends BaseSetup{

	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;
	
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}
	
	public RetailHomePage homePage() {
		return this.homePage;
	}
	
	public RetailSignInPage signInPage() {
		return this.signInPage;
	}
	
	public RetailAccountPage accountPage() {
		return accountPage;
	}
	
	public RetailOrderPage orderPage() {
		return orderPage;
	}
	
	
}
