package recruitment;

	public static void main(String[] args) {
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		public class Dashboard {

		    private WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		        // Set the path to ChromeDriver executable
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Chromedriver_win32");

		        // Create a new instance of ChromeDriver
		        driver = new ChromeDriver();

		        // Maximize browser window
		        driver.manage().window().maximize();
		    }

		    @Test(priority = 1)
		    public void testDashboardTitle() {
		        // Navigate to the dashboard page
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		        // Verify the dashboard page title
		        String dashboardTitle = driver.getTitle();
		        Assert.assertTrue(dashboardTitle.contains("OrangeHRM"), "Dashboard title is incorrect.");
		    }

		    // Add more test methods to cover various scenarios on the dashboard page

		    @AfterClass
		    public void tearDown() {
		        // Close the browser after test execution
		        driver.quit();
		    }
		}
	}

}
