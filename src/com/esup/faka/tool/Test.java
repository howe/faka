package com.esup.faka.tool;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String test = "Hellow Word!";
			DESPlus des = new DESPlus();
			System.out.println("加密前的字符：" + test);
			System.out.println("加密后的字符：" + des.encrypt(test));
			System.out.println("解密后的字符：" + des.decrypt("adfcd06c6f0ca4f7f614c91c98cbd772"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
