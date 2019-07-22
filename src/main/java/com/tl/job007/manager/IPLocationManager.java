package com.tl.job007.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tl.job007.pojos.IPLocationPojo;
import com.tl.job007.utils.FileOperatorUtil;
import com.tl.job007.utils.IPUtil;
import com.tl.job007.utils.ObjectIOUtil;

public class IPLocationManager {
	public static IPLocationPojo[] pojoArray = null;

	static {
		long startTime = 0;
		long endTime = 0;
		String objFilePath = "pojoArray.dat";
		File objFilePathObj = new File(objFilePath);
		// pojoArray�������л��洢
		if (!objFilePathObj.exists()) {
			String filePath = "ip_location_relation.txt";
			String charset = "utf-8";

			startTime = System.currentTimeMillis();
			try {
				pojoArray = IPLocationManager.getSortPojoArray(filePath,
						charset);
				 ObjectIOUtil.writeObjectToFile(pojoArray, 50 * 1024 * 1024,
				 objFilePath);
//				ObjectIOUtil.writeObjectToFile(pojoArray, objFilePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			endTime = System.currentTimeMillis();
		} else {
			try {
				startTime = System.currentTimeMillis();
//				pojoArray = (IPLocationPojo[]) ObjectIOUtil
//						.readObjectFromFile(objFilePath);
				pojoArray = (IPLocationPojo[]) ObjectIOUtil.readObjectFromFile(
						objFilePath, 50 * 1024 * 1024);
				endTime = System.currentTimeMillis();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ϵͳ��ʼ��ʱ��=" + (endTime - startTime));
	}

	// public static void init() {
	// String filePath = "ip_location_relation.txt";
	// String charset = "utf-8";
	// long startTime = System.currentTimeMillis();
	// try {
	// pojoArray = IPLocationManager.getSortPojoArray(filePath, charset);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// long endTime = System.currentTimeMillis();
	// System.out.println("ϵͳ��ʼ��ʱ��=" + (endTime - startTime));
	// }

	public static IPLocationPojo[] getSortPojoArray(String filePath,
			String charset) throws Exception {
		List<String> lineList = FileOperatorUtil.readFileToList(filePath,
				charset);
		List<IPLocationPojo> pojoList = IPLocationManager
				.convertLineToPojoList(lineList);
		IPLocationPojo[] pojoArray = IPLocationManager
				.convertListToSortArray(pojoList);
		return pojoArray;
	}

	/**
	 * ���IP�ַ�����ʽ�Ķ��ֲ���ʵ��
	 * 
	 * @param pojoArray
	 * @param targetIP
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static int binarySearch4Object(IPLocationPojo[] pojoArray,
			String targetIP, int startIndex, int endIndex) {
		// �߽���
		if (pojoArray == null || pojoArray.length == 0 || startIndex > endIndex) {
			return -1;
		}
		int middle = (startIndex + endIndex) / 2;
		if (IPUtil.ipToLong(targetIP) > pojoArray[middle].getEndIPLong()) {
			startIndex = middle + 1;
		} else if (IPUtil.ipToLong(targetIP) < pojoArray[middle]
				.getStartIPLong()) {
			endIndex = middle - 1;
		} else {
			return middle;
		}
		return binarySearch4Object(pojoArray, targetIP, startIndex, endIndex);
	}

	public static List<IPLocationPojo> convertLineToPojoList(
			List<String> lineList) throws Exception {
		List<IPLocationPojo> pojoList = new ArrayList<IPLocationPojo>();

		for (String line : lineList) {
			if (line == null || line.trim().length() == 0) {
				continue;
			}
			String[] columnArray = line.split("\\t");
			if (columnArray.length == 3) {
				IPLocationPojo pojo = new IPLocationPojo(columnArray[0],
						columnArray[1], columnArray[2]);
				pojoList.add(pojo);
			} else {
				System.out.println("error line=" + line);
				throw new Exception("��������֯��ʽ���ԣ�����!");
			}
		}
		return pojoList;
	}

	public static IPLocationPojo[] convertListToSortArray(
			List<IPLocationPojo> pojoList) {
		Collections.sort(pojoList);
		IPLocationPojo[] pojoArray = new IPLocationPojo[pojoList.size()];
		pojoList.toArray(pojoArray);
		return pojoArray;
	}

	// ��װ�ռ���������������Ϸ�IP���õ�λ����Ϣ(������)
	public static String getLocation(String targetIp) {
		if (IPUtil.isIP(targetIp)) {
			int targetIndex = binarySearch4Object(pojoArray, targetIp, 0,
					pojoArray.length - 1);
			if (targetIndex > -1) {
				return pojoArray[targetIndex].getLocation();
			}
		}
		return "��Ҫ�ҵ�IPȥ̫����!!!";
	}
}
