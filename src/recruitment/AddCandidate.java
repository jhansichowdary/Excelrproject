package recruitment;


		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		public class AddCandidate {

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
		    public void testAddCandidate() {
		        // Navigate to the "Add Candidate" page
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");

		        // Fill out candidate information
		        driver.findElement(By.id("addCandidate_firstName")).sendKeys("John");
		        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Doe");
		        driver.findElement(By.id("addCandidate_email")).sendKeys("john.doe@example.com");
		        driver.findElement(By.id("addCandidate_contactNo")).sendKeys("1234567890");
		        driver.findElement(By.id("addCandidate_vacancy")).sendKeys("Software Engineer");

		        // Upload resume (you can customize this based on your test data)
		        // driver.findElement(By.id("addCandidate_resume")).sendKeys("path/to/resume.pdf");

		        // Click on the "Save" button to submit the form
		        driver.findElement(By.id("btnSave")).click();

		        // Verify successful candidate addition (you can customize this based on your application behavior)
		        String successMessage = driver.findElement(By.cssSelector(".message.success")).getText();
		        Assert.assertTrue(successMessage.contains("Successfully Saved"), "Candidate addition not successful.");
		    }

		    @AfterClass
		    public void tearDown() {
		        // Close the browser after test execution
		        driver.quit();
		    }
		}
	}

}
