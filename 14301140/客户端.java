package �����;

import java.net.*;  
import java.util.Scanner;
import java.io.*;  

public class �ͻ��� {
	public static void main(String[] args) throws Exception{  
	    Socket s = new Socket("127.0.0.1",3333); //����һ��Socket��������IP��ַΪ127.0.0.1�ķ�������3333�˿�  
	    DataOutputStream dos = new DataOutputStream(s.getOutputStream()); //��ȡSocket��������������������߰�һ��DataOutputStream�ܵ��������������  
	    Thread.sleep((int)(Math.random()*3000)); //�ÿͻ��˲���ʱ�������������Ϣ  
	    System.out.println("����һ���ַ���");
	    Scanner scanner=new Scanner(System.in);
	    String str=scanner.nextLine();
	    dos.writeUTF(str); //DataOutputStream�����writeUTF()��������������ݣ�����֧������  
	    dos.flush(); //ȷ���������ݶ��Ѿ����  
	    DataInputStream dis = new DataInputStream(s.getInputStream());  
	    System.out.println("����˷�����Ϣ��" + dis.readUTF());  
	    dos.close(); //�ر������ 
	    dis.close();  
	    s.close(); //�ر�Socket����  
	  }  
}
