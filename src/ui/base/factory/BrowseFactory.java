package ui.base.factory;

public class BrowseFactory {

	private static WebDriver driver=null;
	
	public static  <WebDriver> String createdChromeBrowser(String browseType) {
		
		if(browseType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			 
		}
		
		return driver;
	}
}
