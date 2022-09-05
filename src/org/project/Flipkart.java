package org.project;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
	public static void main(String[] args) throws AWTException{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium pro\\Anesh-s-Project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement btn = driver.findElement(By.xpath("//button[@CLASS='_2KpZ6l _2doB4z']"));
		btn.click();
		WebElement txt = driver.findElement(By.xpath("//input[@type='text']"));
		txt.sendKeys("Laptops");
		WebElement srch = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		srch.click();
		Map<String,Integer> m=new TreeMap<>();
		for(int i=1;i<=24;i++) {
		String v="(//div[@class='_4rR01T'])["+i+"]";
		WebElement name = driver.findElement(By.xpath(v));
		String a=name.getText();
		a=a.substring(0, a.indexOf('-'));
		String w="(//div[@class='_30jeq3 _1_WHN1'])["+i+"]";
		WebElement price = driver.findElement(By.xpath(w));
		String str=price.getText();
		str = str.replaceAll("[^\\d.]","");
		int b=Integer.parseInt(str);
		m.put(a, b);
		}
		//Prints Key and Value
		System.out.println("\nPrinting product and its Price");
        Set<Entry<String,Integer>> e=m.entrySet();
		for(Entry<String,Integer> x:e) {
		System.out.println(x);
		}
		//Printing Key
		System.out.println("\nPrinting product Name");
		for(Entry<String,Integer> x:e) {
			System.out.println(x.getKey());
			}
		//Printing Values
		System.out.println("\nPrinting Price");
		List<Integer> l=new LinkedList<>();
		for(Entry<String,Integer> x:e) {
			System.out.println(x.getValue());
			l.add(x.getValue());
			}
		//Printing Ascending order
		Collections.sort(l);
		System.out.println("\nAscending order");
		System.out.println(l);
		//Printing Highest price
		int y=l.size()-1;
		System.out.println("\nHighest Price\n"+l.get(y));
		}}