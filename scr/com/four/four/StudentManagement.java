package com.four.four;

import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {
	/**
	 * 题目：实现学生管理和打卡 1.角色分为学生和管理员 2.管理员和学生有登录功能 3.学生对象列表保存在集合里 4.管理员登录后可以添加和删除学生对象
	 * 5.学生登录后可以打卡 6.打卡时间段为：8:30-10:00，16:00-17:00 7.浏览集合中学生的列表及每个学生信息和打卡情况
	 * 8.所有操作都在控制台里进行
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// 实例出学生集合
		LinkedList<Student> stu = new LinkedList<Student>();
		// Student s1, s2, s3;
		stu.add(new Student("kou", "123", "张三"));
		stu.add(new Student("kxy", "098", "李四"));
		stu.add(new Student("kzy", "918", "王五"));
		// 程序开始
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("欢迎登陆学生管理系统！输入账号登陆");
		System.out.println("请输入账号：");
		String un = sc.next();
		System.out.println("请输入密码：");
		String pw = sc.next();
		// 登陆验证功能下
		if (un.equals("admin") && pw.equals("ad")) { // 管理员分支
			while (true) {
				System.out.println("您好^管理员^_输入相应数字进行功能操作：");
				System.out.println("0. 浏览学生明细\n 1. 添加学生\n 2. 删除学生 \n 3. 退出程序");
				int f = sc.nextInt();

				switch (f) {// 管理员功能分支实现
				case 0:// 查询
					for (int i = 0; i < stu.size(); i++) {
						Student NU = stu.get(i);
						System.out.println("打卡次数：" + NU.getCount() + "姓名" + NU.getUN() + "密码" + NU.getPS());
					}
					break;
				case 1:// 添加
					System.out.println("输入所添加学生的账号");
					String n = sc.next();
					System.out.println("输入所添加学生的密码");
					String p = sc.next();
					System.out.println("输入所添加学生的真名");
					String N = sc.next();
					stu.addLast(Manager.creatNew(n, p, N));
					System.out.println("添加成功！");
					break;
				case 2:// 删除
					System.out.println("输入需要删除的学生的账号");
					String userName = sc.next();

					for (int i = 0; i < stu.size(); i++) {
						if (userName.equals(stu.get(i).getUN())) {
							stu.remove(i);
						}
					}
					System.out.println("删除成功！");
					break;
				case 3:// 退出
					System.exit(0);
					break;
				default:
					System.err.println("输入正确字符");
					break;
				}
			} // w-m
		} else {// 如非管理员账号进入以下循环↓
				boolean b = false;
				Student NU = null;
			for (int i = 0; i < stu.size(); i++) {// 匹配账户密码				
				if (un.equals(stu.get(i).getUN()) && 
					pw.equals(stu.get(i).getPS())) {
					b=true;	
					NU=stu.get(i);
					break;
				} 
				if(i==stu.size()-1) {
					System.err.println("账号或密码输入错误！程序退出！");
				}
			} // for
			
			if(b) {
				System.out.println("登陆成功！");
				while(true) {
				stuBranch(sc, un, NU);
				}
			}
			
		} // else 大

	}

	private static void stuBranch(Scanner sc, String un, Student NU) {
		System.out.println("你好^" + un + "^_输入相应数字进行功能操作：");
		System.out.println("1. 打卡\n 2. 查看个人信息\n 3. 退出程序");
		int f = sc.nextInt();

		switch (f) {// 学生功能分支实现
		case 1:// 打卡
			NU.studentCheckin();
			System.out.println("打卡成功！"+"本日打卡时间："+NU.getAM()+"AND"+NU.getPM());
			break;
		case 2:// 查询
			System.out.println("打卡次数：" + NU.getCount() + "账号:" + NU.getUN()+"姓名："+NU.getNAME());
			break;
		case 3:// 退出
			System.exit(0);
			break;
		default:
			System.err.println("输入正确字符");
			break;
		}
	}	

}
