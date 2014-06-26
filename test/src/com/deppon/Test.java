package com.deppon;

public class Test {
	public static void main(String[] args) {
		
		boolean b = true;String s = String.valueOf(b);System.out.println(s);
		
		 System.out.println("������ "+Thread.currentThread().getStackTrace()[1].getMethodName());
	        System.out.println("���� "+Thread.currentThread().getStackTrace()[1].getClassName());
	        System.out.println("�ļ��� " + Thread.currentThread().getStackTrace()[1].getFileName());
	        System.out.println("���ڵ����� "+Thread.currentThread().getStackTrace());
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
