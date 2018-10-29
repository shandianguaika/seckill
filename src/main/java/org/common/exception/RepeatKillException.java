package org.common.exception;
/**
 * 重复秒杀异常
 * @author 小宇宙
 * @date 2018年10月28日
 */
public class RepeatKillException extends SeckillException{

	private static final long serialVersionUID = 1L;

	public RepeatKillException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RepeatKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


}
