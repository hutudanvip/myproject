import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WhatHappens {
		public static void main (String[] args) {
//			WhatHappens w = new WhatHappens();
//			Thread t = new Thread(new WhatHappens());
//			t.start();
//			
			List<String> list = new ArrayList<String>();
//			list.add(null);
//			list.add(null);
//			list.add("");
			System.out.println(list.size());
			if(list != null && list.size() > 0) {
				System.out.println("2222222222222222222");
			}
		}
		public void run(){
			System.out.println("hi");
		}
}

