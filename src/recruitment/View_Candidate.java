package recruitment;

	public static void main(String[] args) {
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		public class ViewCandidates {

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
		    public void testViewCandidatesPageTitle() {
		        // Navigate to the "View Candidates" page
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");

		        // Verify the page title
		        String pageTitle = driver.getTitle();
		        Assert.assertTrue(pageTitle.contains("Candidates"), "View Candidates page title is incorrect.");
		    }

		    @Test(priority = 2)
		    public void testViewCandidatesTable() {
		        // Navigate to the "View Candidates" page
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");

		        // Verify the presence of the candidates table
		        boolean candidatesTableDisplayed = driver.findElement(By.id("resultTable")).isDisplayed();
		        Assert.assertTrue(candidatesTableDisplayed, "Candidates table is not displayed.");
		    }

		    @Test(priority = 3)
		    public void testSearchCandidate() {
		        // Navigate to the "View Candidates" page
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");

		        // Enter candidate name in the search box
		        driver.findElement(By.id("candidateName")).sendKeys("John Doe");

		        // Click on the "Search" button
		        driver.findElement(By.id("btnSrch")).click();

		        // Verify the search results
		        String searchResultsMessage = driver.findElement(By.id("recordsReturned")).getText();
		        Assert.assertTrue(searchResultsMessage.contains("candidates found"), "Search results are incorrect.");
		    }
		    @AfterClass
		    public void tearDown() {
		        // Close the browser after test execution
		        driver.quit();
		    }
	}

}
