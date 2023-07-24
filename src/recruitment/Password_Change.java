package recruitment;

public class Password_Change {

	public static void main(String[] args) {
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		
		public class Password_Change {
		    private WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Chromedriver_win32");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		    }

		    @Test(priority = 1)
		    public void testUpdatePassword() {
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/updatePassword");

		        String currentPassword = "current_password";
		        String newPassword = "new_password";
		        String confirmNewPassword = "new_password";
		        
		        driver.findElement(By.id("currentPassword")).sendKeys(currentPassword);
		        driver.findElement(By.id("newPassword")).sendKeys(newPassword);
		        driver.findElement(By.id("confirmNewPassword")).sendKeys(confirmNewPassword);

		        driver.findElement(By.id("btnSave")).click();

		        String successMessage = driver.findElement(By.cssSelector(".message.success")).getText();
		        Assert.assertTrue(successMessage.contains("Successfully Updated"), "Password update not successful.");
		    }

		    @AfterClass
		    public void tearDown() {
		        driver.quit();
		    }
		}

	}

}
