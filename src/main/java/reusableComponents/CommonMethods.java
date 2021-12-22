package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;


public class CommonMethods {
	
	
	//Customized sendkeys method-> To log sendkeys message for every occ.
		public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
			try {
				element.sendKeys(valueToBeSent);
				//log success message in exgent report
			} catch (Exception e) {
				
			}
		}


		//custom click method to log evey click action in to extent report
		public void click_custom(WebElement element, String fieldName) {
			try {
				element.click();
				//log success message in exgent report
			} catch (Exception e) {
				//log failure in extent
			}
		}


		//clear data from field
		public void clear_custom(WebElement element,String fieldName) {
			try {
				element.clear();
				Thread.sleep(250);
			} catch (Exception e) {
				
			} 
		}

		


		//check if element is Present
		public boolean isElementPresent_custom(WebElement element,String fieldName){
			boolean flag = false;
			try {
				flag = element.isDisplayed();
				return flag;
			} catch (Exception e) {
				return flag;
			}
		}


		//Select dropdown value value by visibleText
		public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText) throws Throwable {
			try {
				Select s = new Select(element);
				s.selectByVisibleText(ddVisibleText);
			} catch (Exception e) {
			}
		}

		//Select dropdown value value by value
		public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
			try {
				Select s = new Select(element);
				s.selectByValue(ddValue);
			} catch (Exception e) {
			}
		}

		//String Asserts
		public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
			try {
				if(actualValue.equals(expvalue)) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			} catch (Exception e) {
				Assert.assertTrue(false, e.toString());
			}
		}

		//Get text from webelement
		public String getText_custom(WebElement element, String fieldName) {
			String text = "";
			try {
				text = element.getText();
				return text;
			} catch (Exception e) {		
				
			}
			return text;
		}

	

	
	
	//common method to select dd value
	public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception {
		Select os = new Select(element);
		try {
		os.selectByVisibleText(valueToBeSelected);
		} catch(Exception e) {
			throw new Exception("Value is not present in dropdown for WebElement: "+element + "Value to be selected is: "+valueToBeSelected);
		}
		}
	
	public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected) {
		for (WebElement ref : element) {
			if(ref.getText().equalsIgnoreCase(valueToBeSelected)) {
				ref.click();
				break;
			}
			
		}
	}
	
	//selecting check boxes
	public void selectCheckBoxes(List<WebElement> element, String checks) {
		String[] checksArray = checks.split(",");
		for (String str : checksArray) {   //speeding, Other
			for (WebElement ele : element) {
				if(ele.getText().equalsIgnoreCase(str)) {
					ele.click();
					break;
				}
			}
		}
		
	}
	
	
	//get dropdown options as list of string for compare
	public List<String> getDropDownOptionsAsList(WebElement element) {
		Select os = new Select(element);
		List<WebElement> list_webElement_model = os.getOptions();
		List<String> actualContents = new ArrayList<String>();
		
		for (WebElement ref : list_webElement_model) {
			actualContents.add(ref.getText());
		}
		return actualContents;
	}

}
