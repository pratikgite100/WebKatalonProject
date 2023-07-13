import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))




/*

ProductTitle=WebUI.getText(findTestObject('Object Repository/txt_product_title',["ProductTitle" : productTitle]))

WebUI.scrollToElement(findTestObject('Object Repository/btn_add_to_cart',["ProductTitle" : productTitle]), 10)

expectedPrice=WebUI.getText(findTestObject('Object Repository/cartPage/txt_product_price', ["ProductTitle" : productTitle]))
WebUI.click(findTestObject('Object Repository/btn_add_to_cart',["ProductTitle" : productTitle]))

WebUI.scrollToElement(findTestObject('Object Repository/icon_add_to_cart'), 10)
WebUI.click(findTestObject('Object Repository/icon_add_to_cart'))

WebUI.verifyElementPresent(findTestObject('Object Repository/cartPage/txt_Product_title',["ProductTitle" : productTitle]), 10)

actualPrice = WebUI.getText(findTestObject('Object Repository/cartPage/txt_product_price', ["ProductTitle" : productTitle]))

*/

int rowCount=findTestData('ProductData').getRowNumbers()
ArrayList<String> arr= new ArrayList<String>();

for(int i=1;i<=rowCount;i++) {
  arr.add(findTestData('ProductData').getValue("ProductTitle", i))

}

for(String pp:arr) {
	ProductTitle=WebUI.getText(findTestObject('Object Repository/txt_product_title',["ProductTitle" : pp]))
	
	WebUI.scrollToElement(findTestObject('Object Repository/btn_add_to_cart',["ProductTitle" : pp]), 10)
	
	expectedPrice=WebUI.getText(findTestObject('Object Repository/cartPage/txt_product_price', ["ProductTitle" : pp]))
	WebUI.click(findTestObject('Object Repository/btn_add_to_cart',["ProductTitle" : pp]))
	
	WebUI.scrollToElement(findTestObject('Object Repository/icon_add_to_cart'), 10)
	WebUI.click(findTestObject('Object Repository/icon_add_to_cart'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/cartPage/txt_Product_title',["ProductTitle" : pp]), 10)
	
	actualPrice = WebUI.getText(findTestObject('Object Repository/cartPage/txt_product_price', ["ProductTitle" : pp]))
	//actualPrice="90"
	
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/cartPage/btn_continue_shopping'))
}



  

