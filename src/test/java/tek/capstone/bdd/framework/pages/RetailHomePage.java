package tek.capstone.bdd.framework.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.capstone.bdd.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath="//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;
	
	@FindBy(id = "search")
	public WebElement allDepartmentDropDown;
	
	@FindBy(id = "searchInput")
	public WebElement searchBar;
	
	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton;
	
	@FindBy(id = "accountLink")
	public WebElement accountBtn;
	
	@FindBy(id = "orderLink")
	public WebElement ordersBtn;
	
	@FindBy(id = "logoutBtn")
	public WebElement logoutBtn;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBtn;
	
	@FindBy(id = "heroImage")
	public WebElement homePagePicture;
	
	@FindBy(id = "categoryTitle")
	public WebElement shopByCategoryText;
	
	@FindBy(xpath = "//img[@class='image']")
	public List<WebElement> homePagecategories;
	
	@FindBy(xpath = "//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemonProduct;
	
	@FindBy(id = "signinLink")
	public WebElement signInBtn;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sidebarElements;
	
	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sidebarElementsChilds;
	
	@FindBy(id = "hamburgerBtn")
	public WebElement hamburgerBtn;
	
	@FindBy(id = "submenuBtn")
	public WebElement backBtnInAllDepartment;
	
	// belongs to cart
	@FindBy(id = "cartQuantity")
	public WebElement cartQuantityImg;
	
	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement productSelectQuantity;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBtn;
	
	@FindBy(xpath = "//p[@class='products__name']")
	public WebElement products;
	
	@FindBy(xpath = "//img[@alt='Smart Home Lightning']")
	public WebElement smartHome;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBtn;
	
	@FindBy(id = "proceedBtn")
	public WebElement proceedBtn;
	
	@FindBy(xpath = "//p[text()='Order Placed, Thanks']")
	public WebElement orderPlacedMessage;
	
	@FindBy(id = "addAddressBtn")
	public WebElement addANewAddressLink;
	
	@FindBy(id = "addPaymentBtn")
	public WebElement addACreditOrDebitCardLink;
	
	@FindBy(xpath = "//img[@alt='Apex Legends - 1,000 Apex Coins']")
	public WebElement apexLegends;
	
	@FindBy(xpath = "//span[@class='cart__item-delete']")
	public List<WebElement> deleteBtn;
	
	@FindBy(xpath = "//input[@type='number']")
	public WebElement qty;
	
	
	
	
	
	
	
	
}
