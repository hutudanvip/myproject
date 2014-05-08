package com.deppon;

public class Test {
	public static void main(String[] args) {
		 System.out.println("方法名 "+Thread.currentThread().getStackTrace()[1].getMethodName());
	        System.out.println("类名 "+Thread.currentThread().getStackTrace()[1].getClassName());
	        System.out.println("文件名 " + Thread.currentThread().getStackTrace()[1].getFileName());
	        System.out.println("所在的行数 "+Thread.currentThread().getStackTrace());
		getPath();
//		System.out.println(Class);
	}

	static String[] s;

	private static void getPath() {
		Package[] p = Package.getPackages();
		s = new String[p.length];
		for (int i = 0; i < p.length; i++) {
			s[i] = p[i].getName();
			System.out.println(s[i]);
		}
	}
	
}
