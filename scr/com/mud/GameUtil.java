package com.mud;

import java.util.Random;

public class GameUtil {
	
	// 在攻击范围中随机生成伤害值
	public static int getRandomNumber(int min, int max){
		Random r = new Random();
		int num = r.nextInt(max-min+1)+min;
		return num;	
	}

}