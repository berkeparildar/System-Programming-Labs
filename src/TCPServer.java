import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(9999);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			capitalizedSentence = "01-January.txt 02-February.txt" + '\n';
			outToClient.writeBytes(capitalizedSentence); // outToClient.writeBytes(capitalizedSentence);
			String result = inFromClient.readLine();
			System.out.println(result);
			String result2 = inFromClient.readLine();
			System.out.println(result2);
		}
	}
}