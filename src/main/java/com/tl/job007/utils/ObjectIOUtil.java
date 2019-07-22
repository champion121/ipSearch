package com.tl.job007.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOUtil {
	public static void writeObjectToFile(Object obj, String filePath)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}

	public static void writeObjectToFile(Object obj, int byteBufferSize,
			String filePath) throws IOException {
		// FileOutputStream fos = new FileOutputStream(filePath);
		// ObjectOutputStream oos = new ObjectOutputStream(fos);
		// oos.writeObject(obj);
		// oos.flush();
		// oos.close();
		byte[] byteArray = convertObjectToByteArray(obj, byteBufferSize);
		FileOperatorUtil.writeByteArrayToFile(byteArray, filePath);
	}

	public static byte[] convertObjectToByteArray(Object obj)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(obj);
		oos.flush();
		oos.close();

		return baos.toByteArray();
	}

	public static byte[] convertObjectToByteArray(Object obj, int byteBufferSize)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(byteBufferSize);
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(obj);
		oos.flush();
		oos.close();

		return baos.toByteArray();
	}

	public static Object convertByteArrayToObject(byte[] byteArray)
			throws ClassNotFoundException, IOException {
		// 读取该文件对应的对象数据
		ByteArrayInputStream bios = new ByteArrayInputStream(byteArray);
		ObjectInputStream ois = new ObjectInputStream(bios);
		try {
			return ois.readObject();
		} finally {
			ois.close();
		}
	}

	public static Object readObjectFromFile(String filePath)
			throws ClassNotFoundException, IOException {
		// 读取该文件对应的对象数据
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			return ois.readObject();
		} finally {
			ois.close();
		}
	}

	public static Object readObjectFromFile(String filePath, int byteBufferSize)
			throws ClassNotFoundException, IOException {
		// 读取该文件对应的对象数据
		FileInputStream fis = new FileInputStream(filePath);
		byte[] byteArray = new byte[byteBufferSize];
		fis.read(byteArray);
		return convertByteArrayToObject(byteArray);
		// ObjectInputStream ois = new ObjectInputStream(fis);
		// try {
		// return ois.readObject();
		// } finally {
		// ois.close();
		// }
	}
}
