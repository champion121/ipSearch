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
	 * 给定filepath和charset，返回其文件对应内容的list集合形式
	 * 
	 * @param filePath
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static List<String> readFileToList(String filePath, String charset)
			throws IOException {
		// 定义输入路径，及返回的结果集合
		List<String> lineList = new ArrayList<String>();

		// 做文件IO操作
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
