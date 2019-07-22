package com.tl.job007.test;

import com.tl.job007.manager.IPLocationManager;
import com.tl.job007.pojos.IPLocationPojo;

/**
 * IP-location管理器
 * 
 * @author tianliang
 *
 * @date 2019年6月3日
 */
public class IPLocationManagerTest {
	public static void main(String[] args) throws Exception {
		String filePath = "ip_location_relation.txt";
		String charset = "utf-8";
		
		IPLocationPojo[] pojoArray = IPLocationManager.getSortPojoArray(
				filePath, charset);

		String targetIp = "222.216.224.223";
		int startIndex = 0;
		int endIndex = pojoArray.length - 1;
		
		int targetIndex = IPLocationManager.binarySearch4Object(pojoArray,
				targetIp, startIndex, endIndex);
			
		System.out.println("all done!!!");
	}
}
