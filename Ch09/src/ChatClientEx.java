import java.io.*;
import java.util.*;
import java.net.*;
public class ChatClientEx {
public static void main(String[] args) {
try {
Socket sock = new Socket("localhost", 9999);
System.out.println("Client started ... \n");

BufferedReader in = new BufferedReader(new
InputStreamReader(sock.getInputStream()));
PrintWriter out = new
PrintWriter(sock.getOutputStream());
Scanner scan = new Scanner(System.in); // 사용자로부터 메시지를 입력받도록 Scanner 클래스 이용
while (true) {
System.out.print(">> ");
String mymsg = scan.next(); // 콘솔에서 메시지 입력
out.println(mymsg);
out.flush();
String msg = in.readLine();
System.out.println(msg);
if (mymsg.equals("bye")) break; // 사용자가 입력한 메시지가 bye일 경우 종료
}
scan.close();
sock.close();

System.out.println("Client stopped ... \n");


} catch (IOException ex) {
ex.printStackTrace();
}
}
}
