import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String args[]) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        byte data[] = new byte[1500];
        DatagramPacket packet = new DatagramPacket(data, data.length);

        while (true) {
            String url = "01-January.txt";
            socket.receive(packet);
            byte packetData[] = url.getBytes();
            DatagramPacket pac = new DatagramPacket(packetData, packetData.length, packet.getAddress(),
                    packet.getPort());
            socket.send(pac);
        }
    }
}
