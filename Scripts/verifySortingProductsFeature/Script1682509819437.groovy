import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'open url'
WebUI.openBrowser('https://www.saucedemo.com/')

'maximize window'
WebUI.maximizeWindow()

'send username'
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), 'standard_user')

'send password'
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), 'secret_sauce')

'click on login Button'
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

'find out count of product count present in PLP'
eleCount = WebUI.findWebElements(findTestObject('Object Repository/PLP/count_products'),10).size()

'verify all products are sorted as per selected option in dropdown'
String flag=CustomKeywords.'com.PLP.CommonKeywords.validateListIsInDescendingOrderOrNot'(eleCount)
WebUI.verifyMatch(flag, "true", false, FailureHandling.CONTINUE_ON_FAILURE)

String flag1=CustomKeywords.'com.PLP.CommonKeywords.validateListIsInAscendingOrderOrNot'(eleCount)
WebUI.verifyMatch(flag1, "true", false, FailureHandling.CONTINUE_ON_FAILURE)

String flag2=CustomKeywords.'com.PLP.CommonKeywords.isPriceAscending'(eleCount)
WebUI.verifyMatch(flag2, "true", false, FailureHandling.CONTINUE_ON_FAILURE)

String flag3=CustomKeywords.'com.PLP.CommonKeywords.isPriceDescending'(eleCount)
WebUI.verifyMatch(flag3, "true", false, FailureHandling.CONTINUE_ON_FAILURE)


