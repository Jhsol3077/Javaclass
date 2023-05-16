import java.io.*;
import java.net.*;
public class ClientEx {
public static void main(String[] args) {
try {
Socket sock = new Socket("localhost", 9999);
System.out.println("Client started ... \n");

BufferedReader in = new BufferedReader(new
InputStreamReader(sock.getInputStream()));
PrintWriter out = new
PrintWriter(sock.getOutputStream());

String[] msgs = {"hello", "aloha", "bye"};
for (int i=0; i<msgs.length; i++) {
out.println(msgs[i]); // out.print("hello\n");
out.flush(); // 출력 스트림 버퍼를 비움  서버로 전송
String msg = in.readLine();
System.out.println(msg);
}
sock.close();

System.out.println("Client stopped ... \n");


} catch (IOException ex) {
ex.printStackTrace();
}
}
}
