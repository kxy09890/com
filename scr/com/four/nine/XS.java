package com.four.nine;

import java.util.*;
import java.io.*;

public class XS {

	String content="";
	
	public static void main(String[] args) throws IOException {
		XS xs= new XS();
		String temp = xs.getListFile("C:\\Users\\Administrator\\Desktop\\20180409练习/base");
		Map<String, Integer> result = xs.findEnglishNum(temp);
		// 输出到控制台
		System.out.println("各个单词出现的频率为：");
		Iterator<String> iter = result.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer num = (Integer)result.get(key);
			System.out.println(key + "\t\t" + num + "次\n-------------------");
		}

	}

	
	/**
	 * 递归获取文件下所有的文件信息
	 * 
	 * @param path
	 *            文件路径
	 * @return 文件实体集合
	 * @throws IOException
	 */
	public String getListFile(String path) throws IOException {

		// 若是目录, 采用递归的方法遍历子目录
		File file = new File(path);
		if (file.isDirectory()) {// 如果是文件夹，则取出其中的文件
			File[] files = file.listFiles();
			for (File file2 : files) {
				String pathDemo = file2.getPath();
				getListFile(pathDemo);
			}
		} else {// 如果是文件则读取文件
			String filePath = file.getParent() + "/";
			String fileName = file.getName();
			System.out.println("当前文件的文件路径为：" + filePath + ",文件名为：" + fileName);
			// System.out.println("file.getTotalSpace():" +
			// file.getTotalSpace());

			FileInputStream fis = new FileInputStream(file);
			int length;
			String s="";
			byte[] bytes = new byte[1024];
			while ((length = fis.read(bytes)) != -1) {
				s+=new String(bytes, 0, length);// 将数据变为字符串输出
			}
			//System.out.println(content);
			content+=s;
			fis.close();// 关闭流

		}
		return content;
	}

	/**
	 * 统计各个单词出现的次数
	 * 
	 * @param text
	 */
	public Map<String, Integer> findEnglishNum(String text) {

		// 找出所有的单词
		String[] array = {"\r\n","…","’","‘",".", " ", "?", "!" ,"'",":","&","-",";","(",")","\"","`","“","”","—","]","["};
		for (int i = 0; i < array.length; i++) {
			text = text.replace(array[i], ",");
		}
		String[] textArray = text.split(",");

		// 遍历 记录
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < textArray.length; i++) {
			String key = textArray[i];
			key = key.trim();
			// 转为小写
			String key_l = key.toLowerCase();
			if (!"".equals(key_l)) {
				Integer num = map.get(key_l);
				if (num == null || num == 0) {
					map.put(key_l, 1);
				} else if (num > 0) {
					map.put(key_l, num + 1);
				}
			}
		}
		
		
		List<Map.Entry<String, Integer>> list =  
	            new LinkedList<Map.Entry<String, Integer>>( map.entrySet() );  
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()  
	        {  
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )  
	            {  
	                return (o1.getValue()).compareTo( o2.getValue() );  
	            }  
	        } );  
	  
	        Map<String, Integer> result = new LinkedHashMap<String, Integer>();  
	        for (Map.Entry<String, Integer> entry : list)  
	        {  
	            result.put( entry.getKey(), entry.getValue() );  
	        }
	        
	        return result;
		
		
	}
	
}
