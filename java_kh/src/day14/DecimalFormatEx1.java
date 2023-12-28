package day14;

import java.text.DecimalFormat;

public class DecimalFormatEx1 {

	public static void main(String[] args) {
		int num = 100000000;
		
		DecimalFormat df = new DecimalFormat("###,###");
		System.out.println(df.format(num)+"원");
		
		int num2 = 5;
		DecimalFormat df2 = new DecimalFormat("00000");
		System.out.println(df2.format(num2));

	}

}