package TestCases;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Resources.BaseClass;

public class AddToCartTestCases  {

	@Test
	public void VerifyProductPriceBeforeAndAfter() throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		//initializeDriver(); // This driver have scope

		driver.get("https://naveenautomationlabs.com/opencart/");

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iphone");

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String iphoneCost = driver.findElement(By.xpath("//p[@class='price']")).getText();

		//System.out.println(iphoneCost);

		String iphoneArray[] = iphoneCost.split(" ");

		//System.out.println(Arrays.toString(iphoneArray));

		String iphoneArrayFE = iphoneArray[0];

		//System.out.println(iphoneArrayFE);

		String iphoneCostWithNumber = iphoneArrayFE.replaceAll("[^\\d.]", "");

		//System.out.println(iphoneCostWithNumber);

		double finalIphoneCost = Double.parseDouble(iphoneCostWithNumber);

		System.out.println(finalIphoneCost);

		// System.out.println(finalIphoneCost);)

		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[3]")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("samsung");

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String SamsungCost = driver.findElement(By.xpath("(//p[@class='price'])[2]")).getText();

		//System.out.println(SamsungCost);

		String SamsungArray[] = SamsungCost.split(" ");

		//System.out.println(Arrays.toString(SamsungArray));

		String SamsungArrayFE = SamsungArray[0];

		//System.out.println(SamsungArrayFE);

		String SamsungCostWithNumber = SamsungArrayFE.replaceAll("[^\\d.]", "");

		//System.out.println(SamsungCostWithNumber);

		double finalSamsungCost = Double.parseDouble(SamsungCostWithNumber);

		System.out.println(finalSamsungCost);

		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[5]")).click();

		double d = finalIphoneCost + finalSamsungCost;

		//System.out.println(d);

		String t = "$" + d;

		System.out.println(t);

		//WebElement p = driver.findElement(By.xpath("//span[@id='cart-total']"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[2]")).click();
		
		Thread.sleep(2000);

		WebElement p = driver.findElement(By.xpath("(//td[@class='text-right'])[12]"));
		
		String TotalText = p.getText();

		System.out.println(TotalText);

		if (t.equals(TotalText)) {

			System.out.println("The Amount is matching successfully");

		} else {

			System.out.println("The Amount is not matching");

		} 

	}

}
