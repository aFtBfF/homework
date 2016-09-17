package 服务端;

import java.net.*;  
import java.util.Scanner;
import java.io.*;  

public class 客户端 {
	public static void main(String[] args) throws Exception{  
	    Socket s = new Socket("127.0.0.1",3333); //创建一个Socket对象，连接IP地址为127.0.0.1的服务器的3333端口  
	    DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //获取Socket对象的输出流，并且在外边包一层DataOutputStream管道，方便输出数据  
	    Thread.sleep((int)(Math.random()*3000)); //让客户端不定时向服务器发送消息  
	    System.out.println("输入一串字符：");
	    Scanner scanner=new Scanner(System.in);
	    String str=scanner.nextLine();
	    dos.writeUTF(str); //DataOutputStream对象的writeUTF()方法可以输出数据，并且支持中文  
	    dos.flush(); //确保所有数据都已经输出  
	    DataInputStream dis = new DataInputStream(s.getInputStream());  
	    System.out.println("服务端返回消息：" + dis.readUTF());  
	    dos.close(); //关闭输出流 
	    dis.close();  
	    s.close(); //关闭Socket连接  
	  }  
}
