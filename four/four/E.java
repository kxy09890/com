package com.four.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class E {
	public static void main(String[] args) {
		String names="lilei,sunjianong,wangzanru,daijiaxing,zhuangzheshen,";
		names+="zhugeshengjie,suyuelai,hanyufeng,likang,hanshijia,meixiaolin,zhangzhilin,";
		names+="xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,";
		names+="xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,";
		names+="xunzepeng,kouxingyuan,liuluoheng,lipeiyue,zengyihang,";
		names+="zhugeshengjie,suyuelai,hanyufeng,likang,hanshijia,meixiaolin,zhangzhilin,";
		names+="lilei,sunjianong,wangzanru,daijiaxing,zhuangzheshen";
		
		HashMap<String, Integer> hm = findCountByNames(names);
		
		
		Set<String> ks = hm.keySet();
		Iterator<String> it = ks.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key+"出现次数："+hm.get(key));			
		}
		
	}

	private static HashMap<String, Integer> findCountByNames(String names) {
		HashMap<String,Integer> hm =  new HashMap<String,Integer>();
		String[] n = names.split(",");
		ArrayList<String> al = new ArrayList<String>();
		for (String item : n) {
			//System.out.println(item);
			if(!al.contains(item)) {//如果姓名不在集合列表里
				al.add(item);
			}
		}
		
		for (String alItem : al) {//循环去重后的列表
			int count=0;//计数变量，记录去重列表里每个名字在未去重数组里出现的次数，并且必须定义在第一个循环里
			for (String nItem : n) {//循环未去重的列表
				if(alItem.equals(nItem)) {
					count++;
				}
			}
			hm.put(alItem, count);
			System.out.println(alItem+count);
		}
		return hm;
	}

}
