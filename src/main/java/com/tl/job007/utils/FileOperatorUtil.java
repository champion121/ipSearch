package com.tl.job007.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileOperatorUtil {
	/**
	 * ����filepath��charset���������ļ���Ӧ���ݵ�list������ʽ
	 * 
	 * @param filePath
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFileToList(String filePath, String charset)
			throws IOException {
		// ��������·���������صĽ������
		List<String> lineList = new ArrayList<String>();

		// ���ļ�IO����
		FileInputStream fis = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String tempLine = null;
		while ((tempLine = br.readLine()) != null) {
			lineList.add(tempLine);
		}
		br.close();
		return lineList;
	}
	
	public static void writeByteArrayToFile(byte[] byteArray,
			String outputFilePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		fos.write(byteArray);
		fos.close();
	}

}
