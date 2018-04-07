package com.four.four;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	
	private String UN;
	private String PS;
	private String NAME;
	private int count;
	private String AM;
	private String PM;
	
		
	public Student() {}
	
	public Student(String uN, String pS , String N) {
		NAME = N;
		UN = uN;
		PS = pS;
	
	}


	
	
	public String getAM() {
		return AM;
	}

	public void setAM(String aM) {
		AM = aM;
	}

	public String getPM() {
		return PM;
	}

	public void setPM(String pM) {
		PM = pM;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getUN() {
		return UN;
	}

	public void setUN(String uN) {
		UN = uN;
	}

	public String getPS() {
		return PS;
	}

	public void setPS(String pS) {
		PS = pS;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	// 打卡方法
	public void studentCheckin() {
		SimpleDateFormat df = new SimpleDateFormat("HH");
		SimpleDateFormat mf = new SimpleDateFormat("m");
		String time = df.format(new Date());
		String min = mf.format(new Date());
		
		int m = Integer.parseInt(min);
		int t = Integer.parseInt(time);
		if(t > 8 && t <= 10 ) {
			count++;
			System.err.println(NAME+"上午打卡成功,以打卡"+count+"次！");
			this.AM = String.valueOf(new Date());
		}else if(t >= 16 && t <= 17) {
			count++;
			System.err.println(NAME+"下午打卡成功,以打卡"+count+"次！");
			this.AM = String.valueOf(new Date());
		}
		else if(m >= 30 && t == 8) {
			count++;
			System.err.println(NAME+"上午打卡成功,以打卡"+count+"次！");
			this.AM = String.valueOf(new Date());
		}else {
			System.err.println("非打卡时间！");
		}
		
	}
	
}
