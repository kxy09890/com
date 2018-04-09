package com.four.nine;

import java.io.File;

public class RecursionFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("C:\\Java\\jdk-9.0.4\\bin");	
		System.err.println(f);
		pp(f);						
	}
	
	public static void pp(File ff){
		if(ff.isDirectory()){// 如果文件是一个目录
			System.out.println(ff);// 打印出文件
			File fs[] = ff.listFiles();// 生成文夹下的文件
			for (int i = 0; i < fs.length; i++) {// 循环出文件
				pp(fs[i]);
			}
		}else{
			System.out.println(ff);
		}
	}
	
}
