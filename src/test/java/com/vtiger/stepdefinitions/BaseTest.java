package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.lib.Xls_Reader;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties setting;
	
	
	public static Map<String,Map<String,String>> ExcelData;
	
	
	
	public void SetupPreconditions() throws Exception
	{
		setting=readsettings();
		//createReport();
		ExcelData = MapExcelData();
		launchApp();
	}
	
   
	public void launchApp()
	{
		if(setting.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(setting.getProperty("browser").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(setting.getProperty("browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(setting.getProperty("url"));
		int time = Integer.parseInt(setting.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));		
	}
	
	public Properties readsettings() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/setting.properties");
		prop.load(fis);
		return prop;
	}
	
	/*
	public void createReport() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}
	*/
	public Map<String,List<String>> readExcelData()
	{
		Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerData.xlsx");
		int rowcount = xr.getRowCount("Sheet1");
		int colmcount = xr.getColumnCount("Sheet1");
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		
		for(int i=1;i<=rowcount;i++)
		{
			List<String> ls = new ArrayList<String>();
			String tcname=xr.getCellData("Sheet1", "TCName", i).trim();
			for(int j=1;j<=colmcount;j++)
			{
				String clmval = xr.getCellData("Sheet1", j, i).trim();
				ls.add(clmval);
			}
			map.put(tcname, ls);
		}
		
		return map;
	}

	
	public Map<String,Map<String,String>> MapExcelData()
	{
		Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerData.xlsx");
		int rowcount = xr.getRowCount("Sheet1");
		int colmcount = xr.getColumnCount("Sheet1");
		
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		
		for(int i=2;i<=rowcount;i++)
		{
			Map<String,String> ls = new HashMap<String,String>();
			String tcname=xr.getCellData("Sheet1", "TCName", i).trim();
			for(int j=1;j<=colmcount;j++)
			{
				String clmName = xr.getCellData("Sheet1", j, 1).trim();
				String clmval = xr.getCellData("Sheet1", j, i).trim();
				ls.put(clmName, clmval);
			}
			map.put(tcname, ls);
		}
		
		return map;
	}

}
