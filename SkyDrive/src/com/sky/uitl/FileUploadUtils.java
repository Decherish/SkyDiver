package com.sky.uitl;

import java.util.UUID;

public class FileUploadUtils {

	// 得到文件的真实民称
	public static String getRealName(String filename) {
		int index = filename.lastIndexOf("\\") + 1;
		return filename.substring(index);
	}

	// 得到文件的随机名称
	public static String getUUIDfileName(String filename) {
		int index = filename.lastIndexOf(".");
		if (index != -1) {
			return UUID.randomUUID() + filename.substring(index);
		}
		return UUID.randomUUID().toString();
	}
	//目录分离算法
	public static String getRandomDirectory(String filename) {
		int hashcode = filename.hashCode();
		int a = hashcode & 0xf;
		hashcode = hashcode >>> 4;
		int b = hashcode & 0xf;
		return "/" + a + "/" + b;
	}
}
