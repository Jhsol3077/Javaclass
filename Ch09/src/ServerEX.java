//accept는 요청 올 때까지 기다렸다가 클라이언트 소켓 생성
//Socket sock = srcsock.accpet(); 대기 ~ 실제 요청에 의해 클라이언트 소켓 형성하는 것. 서버에는 서버 소켓 하나, 요청 올 때마다 클라이언트 소켓(=소켓) 생성
import java.io.*;
import java.net.*;
public class ServerEX {
public static void main(String[] args) {
try {
	ServerSocket srvsock = new ServerSocket(9999);
	System.out.println("Server started ... \n");
	Socket sock = srvsock.accept();
	// readLine() 함수 이용을 위해, BufferedReader 클래스 이용
	BufferedReader in = new BufferedReader(new
	InputStreamReader(sock.getInputStream()));
	PrintWriter out = new PrintWriter(sock.getOutputStream());
	
	while(true) {//오는 메세지한테 ok만 던진다
		String msg = in.readLine();
		System.out.println(msg);
		out.println("ok");
		out.flush();
	
	if (msg.equals("bye")) break;//서버가 여러 메세지 받을 수 있음, String은 ==사용 불가, equals 함수를 사용해야 한다
	}
	sock.close();//if문으로 while문 빠져나올 수 있게 만들어야 close 가능
	srvsock.close();
	System.out.println("Server stopped c... \n");
	
}catch(Exception ex) {
	ex.printStackTrace();
}
}
}
//서버가 대기. 포트가 일치해야 값을 받을 수 있음
//
//데이터 교환 위해 양쪽 동일한 코드
//Buffer ~ 임시 데이터 저장 장소
//burreredReader 글자를 주고 받을 때 사용
/*TCP/IP 데이터 주고받는 사이에 약속이 필요, 미리 정의된 약속
인터넷이 불안정, 데이터가 중간에 손실이 있으면 다시 보내달라고 요청 후 다 받은 후 보내주는 역할. 
IPv4. 0~255의 1Byte 이용, d클래스는 본인 컴퓨터  지역단위로 클래스 나눔
웹페이지 주고받으려면 http 필요, 동작시키려면 tcp, 컴퓨터 식별 위해 ip필요, 네트워크는 계층구조로 구성
포트 . 하나의 ip주소를 여러 프로그램이 공유하게 하는 가상 연결 채널. smtp는 이메일. 프로토콜 별로 자신의 포트가 결정됨
인터넷을 하기 위해서 프로그래밍 언어가 제공하는 것들 ~ 소켓
각각의 소켓은 고유한 포트 번호를 가짐. url은 프로토콜 먼저 지정, 이후 ip주소 지정, :80은 포트 번호, /login.html로 끝남
클라이언트 소켓이 생기면서 포트 자동 할당, 서버 찾아갈 때는 ip주소만 보고 찾아가고 그 다음 데이터를 80번인 웹 서버로 넘기고 서버는 받은 요청 처리 위한 소켓 별도로 생성
서버로부터 데이터 받기 위해 클라이언트 소켓을 또 사용, 서버 소켓은 채널 통로 역할만 수행
//실제 데이터 주고 받는 것은 클라이언트 소켓
실제 렌더링은 브라우저가 수행 멀티미디어 처리 브라우저, 웹 서버는 데이터 읽어서 던져주는 역할만 수행
*/