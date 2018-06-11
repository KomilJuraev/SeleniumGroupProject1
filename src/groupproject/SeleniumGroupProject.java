package groupproject;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumGroupProject {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Maftuna\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
		Thread.sleep(1000);
		Random rand = new Random();
		Thread.sleep(1000);
		int i = rand.nextInt(100);
		String str = "" + i;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(str);
		Thread.sleep(1000);

		Random ran = new Random();
		String[] middleNames = { "Andre", "Johnson", "Kevin", "Adam" };
		String middleName = middleNames[ran.nextInt(middleNames.length)];

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + middleName + " Smith");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Any city");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("10000");
		Thread.sleep(1000);

		Random r = new Random();
		String[] arr = { "ctl00_MainContent_fmwOrder_cardList_0", "ctl00_MainContent_fmwOrder_cardList_1",
				"ctl00_MainContent_fmwOrder_cardList_2" };
		String name = arr[r.nextInt(arr.length)];
		driver.findElement(By.cssSelector("input[id=" + name + "]")).click();

		if (name.equals("ctl00_MainContent_fmwOrder_cardList_0")) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("444565489");

		} else if (name.equals("ctl00_MainContent_fmwOrder_cardList_1")) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("553565979");

		} else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("346378965");
		}

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("05/20");
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("a[id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

		String expected = "New order has been successfully added";
		String pageSource = driver.getPageSource();
		///////////////////////////////////////////////////////////////////////////////////////////////////
		if (pageSource.contains("New order has been successfully added")) {
			System.out.println("1) Expected text \"" + expected + "\" present in the web page.");
		} else {
			System.out.println("2) Expected text '" + expected + "' is not present in the web page.");
		}

	}
}
