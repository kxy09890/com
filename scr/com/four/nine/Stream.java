package com.four.nine;
// → Source Folder
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Stream {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Administrator\\Desktop/全国身份证前六位.txt");
		FileReader fr;
		BufferedReader br = null;
		String name = "110116";// 查询的数
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			ArrayList<String> ars = new ArrayList<String>();// 查询集
			ArrayList<String> ars2 = new ArrayList<String>();// 映射集

			String rr = null;
			while ((rr = br.readLine()) != null)
				ars.add(rr);

			for (int i = 0; i < ars.size(); i++) {// 截前六位
				ars2.add(ars.get(i).substring(0, 6));// 填入库组
			}

			for (int j = 0; j < ars.size(); j++) {// 查询组比配后打映射组内容
				if (ars2.get(j).equals(name)) {
					System.out.println(ars.get(j));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}
}
