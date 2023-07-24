package recruitment;

public class Login_Page {

	public static void main(String[] args) {
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		public class Loginpage {

		    private WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		      
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Chromedriver_win32");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		    }

		    @Test(priority = 1)
		    public void testValidLogin() {
		    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		        driver.findElement(By.id("btnLogin")).click();
		        String welcomeMessage = driver.findElement(By.id("welcome")).getText();
		        Assert.assertTrue(welcomeMessage.contains("Welcome"), "Login not successful.");
		    }

		    @Test(priority = 2)
		    public void testInvalidLogin() {
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		        // Enter invalid credentials
		        driver.findElement(By.id("txtUsername")).sendKeys("InvalidUser");
		        driver.findElement(By.id("txtPassword")).sendKeys("invalidPassword");
		        driver.findElement(By.id("btnLogin")).click();
		        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		        Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch for invalid login.");
		    }

		    @AfterClass
		    public void tearDown() {
		        driver.quit();
		    }
		}
	}

}
