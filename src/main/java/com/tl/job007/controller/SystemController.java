package com.tl.job007.controller;

import com.tl.job007.manager.IPLocationManager;

/**
 * ϵͳ������࣬�������ʹ�ø���Ŀʱ����������࿪ʼ ���������Ŀ�Ŀ�����ڣ�ֱ�������û��ṩ���Ӧ��������
 * 
 * @author tianliang
 *
 * @date 2019��6��4��
 */
public class SystemController {
	public static void main(String[] args) {
//		String targetIp = "222.216.227";
		if(args.length==0){
			System.out.println("����IP��ַ����ȷ��!!!");
			System.exit(-1);
		}
		String targetIp=args[0];
		String location = IPLocationManager.getLocation(targetIp);
		System.out.println("location = " + location);
	}
}
