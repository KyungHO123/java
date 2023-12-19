package day08;

import java.sql.PseudoColumnUsage;

public class ConstructorEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A a = new A();//기본 생성자를 호출 => A클래스에 성성자가 있어서 본 서앙자가 자동으로 추가가 안딤 =>여러 에러 발생
		A a= new A(2);
		
	}

}

class A{
	int num;
	
	public A(int num2 ) {
		num = num2;
	}
	public A(double num2) {
		num = (int)num2;

	}public A(A a){
		num =a.num;
	}
	
}