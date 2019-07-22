package com.tl.job007.controller;

import com.tl.job007.manager.IPLocationManager;

/**
 * 系统的入口类，当引入或使用该项目时，均从入口类开始 解决的是项目的控制入口，直接面向用户提供其对应的需求功能
 * 
 * @author tianliang
 *
 * @date 2019年6月4日
 */
public class SystemController {
	public static void main(String[] args) {
//		String targetIp = "222.216.227";
		if(args.length==0){
			System.out.println("请检查IP地址的正确性!!!");
			System.exit(-1);
		}
		String targetIp=args[0];
		String location = IPLocationManager.getLocation(targetIp);
		System.out.println("location = " + location);
	}
}
