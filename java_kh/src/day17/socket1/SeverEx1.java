package day17.socket1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SeverEx1 {

	public static void main(String[] args) {
		//1. 서버의 포트번호 정함
		int port = 5001;
		ArrayList<String>list = new ArrayList<String>();
		ServerSocket severSocket;
		String fileName="src/day17/socket1/caht.txt";
		list = load(fileName);
		System.out.println(list);
		System.out.println("불러오기 성공");
		try {
			severSocket = new ServerSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			severSocket =  new ServerSocket(port);
			Socket socket = severSocket.accept();
			System.out.println("연결 성공!");
			//읽어온 채팅 내역을 클라이언트로 전송
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(list);
			oos.flush();
			
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			while(true) {
			String str = ois.readUTF();
			if(str.equals("-1")) {
				break;
			}
			System.out.println(str);
			list.add(str);
			
			}
			ois.close();
			is.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		save(list,fileName);
		
	}
	private static void save(ArrayList<String>list,String fileName) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			list.stream().forEach(str->{
				try {
					oos.writeUTF(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static ArrayList<String>load(String fileName){
		ArrayList<String>list = new ArrayList<String>();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				list.add(ois.readUTF());
				
			}
			
		} catch (IOException e) {
			return list;
		}
	}
}
