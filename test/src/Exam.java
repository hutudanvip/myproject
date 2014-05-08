import java.util.Vector;


public class Exam {
	//TODO
//	public static void main(String[] args) {
//		System.out.println("a".equals(new String("a")));
//
//		int  x =-3;
//				int  y =-10;
//					System.out.println(y%x);
//
//					System.out.println(Math.floor(-4.1));
//
//	}
	
	
    public static void main(String[] args) {
        // TODO: Add your code here
        class M {
            int a1; /* ����...���� */
        } ;
        M m1,m=new M();
        m.a1=100;
        Vector v = new Vector() ;
        v.add(0,m);
        /* ���»��ǲ��� 
        ...
        ���Խ���
        */
        m1=(M)v.elementAt(0);
        System.out.println(m1.a1);
    }    
}
