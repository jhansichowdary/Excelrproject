package recruitment;



	public static void main(String[] args) {
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.Test;

		public classVacantcies {

		    private WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\Chromedriver_win32");

		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		    }

		    @Test(priority = 1)
		    public void testViewJobVacancyPageTitle() {

		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");
		        String pageTitle = driver.getTitle();
		        Assert.assertTrue(pageTitle.contains("Job Vacancy"), "View Job Vacancy page title is incorrect.");
		    }

		    @Test(priority = 2)
		    public void testViewJobVacancyTable() {
		        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");

		        // Verify the presence of the job vacancy 
		        WebElement jobVacancyTable = driver.findElement(By.id("resultTable"));
		        Assert.assertTrue(jobVacancyTable.isDisplayed(), "Job Vacancy table is not displayed.");
		    }

		    @Test(priority = 3)
		    public void testJobVacancySearch() {
		        // Navigate to the "View Job Vacancy" page
		    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");

		        // Enter job title in the search box
		        String searchJobTitle = "Software Engineer";
		        driver.findElement(By.id("vacancySearch_jobTitle")).sendKeys(searchJobTitle);

		        // Click on the "Search" button
		        driver.findElement(By.id("btnSrch")).click();

		        // Verify the search results
		        WebElement searchResultsTable = driver.findElement(By.id("resultTable"));
		        WebElement searchResultRow = searchResultsTable.findElement(By.xpath("//td[contains(text(),'" + searchJobTitle + "')]"));
		        Assert.assertTrue(searchResultRow.isDisplayed(), "Job Vacancy search results are incorrect.");
		    }

		    @AfterClass
		    public void tearDown() {
		        // Close the browser after test execution
		        driver.quit();
		    }
		}
	}

}
