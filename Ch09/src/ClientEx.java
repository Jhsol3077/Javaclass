import java.io.*;
import java.net.*;
public class ClientEx {
public static void main(String[] args) {
try {
Socket sock = new Socket("localhost", 9999);
System.out.println("Client started ... \n");

BufferedReader in = new BufferedReader(new
InputStreamReader(sock.getInputStream()));
PrintWriter out = new PrintWriter(sock.getOutputStream());

String[] msgs = {"hello", "aloha", "bye"};//메세지를 여러 개 보낼 수 있도록 만든 String 배열
for (int i=0; i<msgs.length; i++) {//for문으로 메세지를 연속적으로 보냄, 배열 안에 있는 것이 각각이 메세지가 된다
	out.println(msgs[i]); // out.print("hello\n");
	out.flush(); // 출력 스트림 버퍼를 비움 ,서버로 전송
	String msg = in.readLine();
	System.out.println(msg);
}
sock.close();

System.out.println("Client stopped ... \n");


} catch (IOException ex) {
ex.printStackTrace();
}
}
}//cmd 실행할 때는 cd에서 한 칸 띄우고 내 workspace로 가서 bin파일을 끌어놓아서 path 지정, 그 후 java 한 칸 띄우고 클래스 이름만, 
//cmd는 Server부터 실행 하고 하나의 창을 더 띄워서 Client 실행
