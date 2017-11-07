package main.java.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtils {
	
	public void launchMuseAssetAndExport(String museApp, String asset) throws IOException, InterruptedException, AWTException {
			
			File file = new File(asset);
			String absoultePath = file.getAbsolutePath();
			
			Runtime.getRuntime().exec(museApp + " " + absoultePath);
	
			TimeUnit.SECONDS.sleep(25);
			
			Robot r = new Robot();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			exportFullSiteToBrowser();
		}

	public void exportFullSiteToBrowser() throws AWTException, InterruptedException {
		Robot r = new Robot();
		Thread.sleep(500);
		r.mouseMove(10, 40);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_E);
		
		TimeUnit.SECONDS.sleep(10);
	}
	
	public void quitMuse() throws AWTException, InterruptedException {
		Robot r = new Robot();
		r.mouseMove(10, 50);
		Thread.sleep(2000);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_Q);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_Q);
		
		TimeUnit.SECONDS.sleep(5);
	}
	
	public void closeRunningProcess(String procName) throws IOException {
		
		Runtime rt = Runtime.getRuntime();
		rt.exec("taskkill /F /IM "+procName.toLowerCase()+".exe");
		
	}
	
	public String getRunTimeCss(WebElement we, WebDriver driver) {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  String script = "var s = '';" +
		                  "var o = getComputedStyle(arguments[0]);" +
		                  "for(var i = 0; i < o.length; i++){" +
		                  "s+=o[i] + ':' + o.getPropertyValue(o[i])+';'+'\\n';}" + 
		                  "return s;";
		  
		  return executor.executeScript(script, we).toString();
	}
	
	public Boolean compareFileContents(String pathFile1, String pathFile2) throws IOException {
		File file1 = new File(pathFile1);
		File file2 = new File(pathFile2);
		boolean areFilesEqual = FileUtils.contentEquals(file1, file2);
		
		return areFilesEqual;
	}
	
	public static Boolean compareFilesEqual(String pathFile1, String pathFile2) throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader(pathFile1));
        BufferedReader reader2 = new BufferedReader(new FileReader(pathFile2));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;    
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }

        if(!areEqual)
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);
            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
        }
        reader1.close();
        reader2.close();
		return areEqual;
    }
	
	public Boolean compareDirectories(String folderPath1, String folderPath2) throws IOException {
		boolean result = true;
		
	    File[] folder1 = new File(folderPath1).listFiles();
	    File[] folder2 = new File(folderPath2).listFiles();
	    
	    for(int i = 0; i<folder1.length; i++) {
	    	if(folder1[i].isFile() && folder2[i].isFile()) {
	    		result = compareFilesEqual(folder1[i].getPath(),folder2[i].getPath());
	    	}
	    }
		
		return result;
	}
	
	public void resizeBrowser(WebDriver driver, int width, int height) {
		Dimension dimension= new Dimension(width, height);
		  driver.manage().window().setSize(dimension);
	}
	
	public int convertWidthToNumber(String width) {
		width = width.substring(0, width.length() - 2);
		return Integer.parseInt(width);
	}

}
