package org.common.enums;

public enum Enums {

	SUCCESS(1, "秒杀成功"), END(0, "秒杀结束"), REPEATKILL(-1, "重复秒杀"), INNERERROR(-2, "系统异常"), DATAREWRITE(-3, "数据篡改");

	private int index;
	private String info;

	Enums(int index, String info) {
		this.index = index;
		this.info = info;
	}

	public int getIndex() {
		return index;
	}

	public String getInfo() {
		return info;
	}

	public static Enums stateOf(int index) {
		for (Enums model : values()) {
			if (model.getIndex() == index) {
				return model;
			}
		}
		return null;
	}
}
