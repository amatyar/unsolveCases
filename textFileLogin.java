package UnsolveCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class textFileLogin {

	public static void main(String[] args) throws IOException {
		String line;
		int lineCount =0 ;
		int iteration = 0;
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Rabindra\\OneDrive\\Desktop\\chromedriver\\chromedriver.exe");		
		WebDriver dr = new ChromeDriver();	
		dr.manage().window().maximize();
		
		FileReader f_obj= new FileReader("C:\\Users\\Rabindra\\OneDrive\\Desktop\\input.txt");
		BufferedReader bf = new BufferedReader(f_obj);

		while ((line = bf.readLine()) !=null) {
			String inputData[] = line.split(",", 2);
			lineCount = lineCount +1;
			if(lineCount > 1) {
				iteration = iteration +1;
				dr.get("https://login.yahoo.com/");
				dr.findElement(By.name("username")).sendKeys(inputData[0]);
				dr.findElement(By.id("login-signin")).click();
				dr.findElement(By.name("password")).sendKeys(inputData[1]);
				dr.findElement(By.id("login-signin")).click();
				String url= dr.getCurrentUrl();
				if (url.equals("https://mail.yahoo.com/d/folders/1")) {
					System.out.println(iteration + "Login is Successful – Passed");
					}
					else 
					{
					System.out.println(iteration+"Login is Unsuccessful – Failed");
					}
					dr.close();
					}
					}
		bf.close();
		f_obj.close();
	}		
		
	

}
