import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TCPClient {
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 9999);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println("Give signal to the server");
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		String[] inputArray = modifiedSentence.split(" ");
		Data data = new Data();
		List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
		sharedDataStructure = data.getSharedDataStructure();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < inputArray.length; i++) {
			String path = "http://homes.ieu.edu.tr/culudagli/files/SE375/datasets/" + inputArray[i];
			Runnable worker = new Thread(new myRunnable(path, sharedDataStructure));
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		Scanner scan = new Scanner(System.in);
		int storeSum = sharedDataStructure.get(7).get(Integer.toString(inputArray.length));
		int onlineSum = sharedDataStructure.get(8).get(Integer.toString(inputArray.length));
		System.out.println("Choose a specific month for the product information");
		String monthInput = scan.nextLine();
		int monthStore = sharedDataStructure.get(3).get(monthInput.toUpperCase());
		int monthOnline = sharedDataStructure.get(4).get(monthInput.toUpperCase());
		scan.close();
		int total = storeSum + onlineSum;
		String name = "There are, " + "In-store: $" + storeSum + " Online: $" + onlineSum + " Total $" + total + " worth of sales for all products";
		outToServer.writeBytes(name + '\n');
		String bababo = "For the month " + monthInput.substring(0, 1).toUpperCase() + monthInput.substring(1) + " In-store sales: $" + monthStore + " Online sales: $" + monthOnline ;
		outToServer.writeBytes(bababo + '\n');
		clientSocket.close();
	}
}