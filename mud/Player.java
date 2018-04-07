package com.mud;

public class Player implements Runnable {

	private String name;// 名字
	private int maxHP; // 生命值上限
	private int nowHP; // 当期生命值
	private int minAP; // 最小攻击力
	private int maxAP; // 最大攻击力
	private int speed; // 攻击间隔
	private double percent;// 暴击几率

	public Player target; // 当前玩家的目标

	public Player() {
	}

	public Player(Player target) {
	
		this.target = target;
	}

	public void attack() {
		if(target.nowHP == 0) {
			System.out.println("*战斗结束*");
			System.err.println("提示：下回开始第一章时偷偷按2试试，有惊喜！");
			System.exit(0);
		}else if (nowHP == 0) {
			System.err.println("恭喜通关新手试炼关--后面还有赵四，刘能，王大拿等boss~~~静等更新！");
			System.exit(0);
		}
		
		int a = GameUtil.getRandomNumber(minAP, maxAP);// 随机出本次的伤害值
		if (Math.random() < percent) {// 随机小数小于角色暴击率时，暴击
			System.out.print("[暴击]");
			a *= 2;// 暴击攻击翻倍
		}
		if (a >= target.nowHP) {// 最后一击只能把生命之打成0
			target.nowHP = 0;
			System.out.println(
					name + " 对" + target.name + "造成了" + a + "点伤害," + target.name + "剩余生命值为0," + target.name + "被干掉了");
			
			return;
		} else {
			target.nowHP -= a;
			System.out.println(name + "对" + target.name + "造成了" + a + "点伤害," + target.name + "剩余生命值为" + target.nowHP);
		}
	}

	public void run() {
		while (nowHP > 0 || target.nowHP > 0) {// 有人没死就继续打
			attack();
			try {
				Thread.sleep(speed);// 攻击速度为线程休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getNowHP() {
		return nowHP;
	}

	public void setNowHP(int nowHP) {
		this.nowHP = nowHP;
	}

	public int getMinAP() {
		return minAP;
	}

	public void setMinAP(int minAP) {
		this.minAP = minAP;
	}

	public int getMaxAP() {
		return maxAP;
	}

	public void setMaxAP(int maxAP) {
		this.maxAP = maxAP;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	
}
