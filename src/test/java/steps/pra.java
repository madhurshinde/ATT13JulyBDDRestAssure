package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pra {

	
	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
				
		WebElement idfeatch= driver.findElement(By.xpath("(//p[@class=\"oxd-text oxd-text--p\"])[1]"));
		WebElement passfeatch= driver.findElement(By.xpath("(//p[@class=\"oxd-text oxd-text--p\"])[2]"));
		
		WebElement userTxtbox= driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement passTxtbox= driver.findElement(By.xpath("//input[@name=\"password\"]"));
		WebElement logintxt= driver.findElement(By.xpath("//button[@type=\"submit\"]"));
					
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String id =idfeatch.getText();
		String pw =passfeatch.getText();
		userTxtbox.sendKeys(id);
		passTxtbox.sendKeys(pw);
		logintxt.click();
}	

}
