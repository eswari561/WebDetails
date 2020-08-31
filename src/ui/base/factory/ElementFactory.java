package ui.base.factory;


public class ElementFactory {


	public static void webBrowser(String browseType) {
		
		if(browseType.contains("chrome")) {
			
             System.setProperty("webdriver.chrome.driver", "F:\\WorkSpace_new\\Assignment\\WebDrivers\\chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();
             
		}
	}
}
