package com.four.four;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestStrSort {

	public static void main(String[] args) {
		// TODO 課堂作業

		StringBuffer sb1 = new StringBuffer();

		sb1.append("lilei,sunjianong,wangzanru,daijiaxing,zhuangzheshen,"
				+ "zhugeshengjie,suyuelai,hanyufeng,likang,hanshijia,meixiaolin,zhangzhilin,"
				+ "xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,"
				+ "xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,"
				+ "xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,"
				+ "zhugeshengjie,suyuelai,hanyufeng,likang,hanshijia,meixiaolin,zhangzhilin,"
				+ "lilei,sunjianong,wangzanru,daijiaxing,zhuangzheshen");
		
		Map<String,Integer> m =  new HashMap<String,Integer>();
		// 用于输出的图表实例
		String xs = sb1.toString();
		// 緩存轉字符
		Set<String> ss = new HashSet<String>();
		// 哈希表去重
		String[] ys = xs.split(",");
		// 拆分字符串
		for (int i = 0; i < ys.length; i++) {
			ss.add(ys[i]);// 數組填裝到ss哈希表
		}			
		Set<String> sx = m.keySet();
		// 得到键值key---sx
		for (String string1 : ss) {// 遍历去重后hash表
		//System.out.println(string1);
			int count = 0;
				
			for (String string2 : ys) {// 从拆分后大表里找次数
				if(string1.equals(string2)) {					
					count++;
				}				
			}	
			m.put(string1,count);
		}	
		
		
		Iterator<String> it = sx.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key+"|出现次数："+m.get(key));			
		}		
	}
}
