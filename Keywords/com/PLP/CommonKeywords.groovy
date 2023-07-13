package com.PLP

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class CommonKeywords {


	@Keyword
	public String validateListIsInAscendingOrderOrNot(int eleCount) {
		WebUI.click(findTestObject('Object Repository/PLP/select_sort_products'))
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PLP/select_sort_products'), "Name (A to Z)", false)

		ArrayList<String> arr1=new ArrayList<String>()

		for(int i=1;i<=eleCount;i++) {
			arr1.add(WebUI.getText(findTestObject('Object Repository/PLP/txt_product_title_each',["ProductNumber" :i])))
		}

		String flag="true"
		for(int j=0;j<arr1.size()-1;j++) {
			if((arr1.get(j).compareTo(arr1.get(j+1)))>0){
				flag="false"
			}
		}
		return flag
	}


	@Keyword
	public  String validateListIsInDescendingOrderOrNot(int eleCount) {
		WebUI.click(findTestObject('Object Repository/PLP/select_sort_products'))
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PLP/select_sort_products'), "Name (Z to A)", false)

		ArrayList<String> arr=new ArrayList<String>()

		for(int i=1;i<=eleCount;i++) {
			arr.add(WebUI.getText(findTestObject('Object Repository/PLP/txt_product_title_each',["ProductNumber" :i])))
		}

		String flag="true"
		for(int j=0;j<arr.size()-1;j++) {
			if((arr.get(j).compareTo(arr.get(j+1)))<0){
				flag="false"
			}
		}

		return flag
	}

	@Keyword
	public String isPriceAscending(int eleCount) {
		WebUI.click(findTestObject('Object Repository/PLP/select_sort_products'))
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PLP/select_sort_products'), "Price (low to high)", false)

		ArrayList<Double> arr=new ArrayList<Double>()

		for(int i=1;i<=eleCount;i++) {
			String priceText=WebUI.getText(findTestObject('Object Repository/PLP/txt_product_price_each',["ProductNumber" :i]))
			String priceText1=priceText.replace('$', '').trim()
			Double act_price=Double.parseDouble(priceText1)
			arr.add(act_price)
		}

		String flag="true"
		for(int j=0;j<arr.size()-1;j++) {
			if(arr.get(j)>(arr.get(j+1))){
				flag="false"
			}
		}

		return flag
	}

	@Keyword
	public String isPriceDescending(int eleCount) {
		WebUI.click(findTestObject('Object Repository/PLP/select_sort_products'))
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PLP/select_sort_products'), "Price (high to low)", false)

		ArrayList<Double> arr1=new ArrayList<Double>()

		for(int i=1;i<=eleCount;i++) {
			String priceText=WebUI.getText(findTestObject('Object Repository/PLP/txt_product_price_each',["ProductNumber" :i]))
			String priceText1=priceText.replace('$', '').trim()
			arr1.add(Double.parseDouble(priceText1))
		}

		String flag="true"
		for(int j=0;j<arr1.size()-1;j++) {
			if(arr1.get(j)<(arr1.get(j+1))){
				flag="false"
			}
		}
		return flag
	}
}
