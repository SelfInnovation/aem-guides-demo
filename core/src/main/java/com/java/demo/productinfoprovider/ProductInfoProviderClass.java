package com.java.demo.productinfoprovider;

import org.osgi.service.component.annotations.Reference;

import com.adobe.granite.license.ProductInfo;
import com.adobe.granite.license.ProductInfoProvider;

public class ProductInfoProviderClass implements Runnable {

	@Reference 
	private ProductInfoProvider productInfo;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			ProductInfo vers = productInfo.getProductInfo();
			//vers.getVersion();
			 String aemVersion = vers.toString();
		
	}
	
	

}
