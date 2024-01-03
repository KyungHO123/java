package socket2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx2 {

	public static void main(String[] args) {
		
		//서버의 ip, port번호 생성
		String ip = "192.168.30.213";
		int port = 5001;
		
		
		//1. ip와 port를 이용해 소켓 생성 및 대기
		Socket socket;
		try{
			socket = new Socket(ip,port);
			Thread receiveThread = new Thread(()->{
				try {
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					while(true) {
						String str = ois.readUTF();
						if(str.equals("-1")) {
							break;
						}
						System.out.println(str);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트 : 받는 기능 종료");
			});
			receiveThread.start();
			
			//문자열을 입력받아 클라이언트에 전송하는 쓰레드
			Thread sendTread = new Thread(()->{
				try{
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Scanner sc = new Scanner(System.in);
					while(true) {
						String str =sc.nextLine();
						oos.writeUTF(str);
						oos.flush();
						if(str.equals("-1")) {
							break;
						}
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("클라이언트 : 보내는 기능 종료");
			});
			sendTread.start();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("클라이언트 :메인 기능 종료");
	}
	
	
}
