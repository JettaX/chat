package server;

import network.TCPConnection;
import network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {
    public static void main(String[] args) {
        new ChatServer();
    }

    /*private final Map<String, TCPConnection> connections = new HashMap<>();*/
    private final ArrayList<TCPConnection> connections = new ArrayList<>();

    private ChatServer() {
        System.out.println("ServerRunning...");
        try (ServerSocket serverSocket = new ServerSocket(8188)) {
            while (true) {
                try {
                    new TCPConnection(serverSocket.accept(), this);
                } catch (IOException e) {
                    System.out.println("tcp.TCPConnection exception: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void onConnected(TCPConnection tcpConnection) {
        /*connections.put(userNameForAndTo, tcpConnection);*/
        connections.add(tcpConnection);
        System.out.println(connections);
    }

    @Override
    public synchronized void onReceiveMessage(TCPConnection tcpConnection, String message) {
        sendToAllConnections(message);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        System.out.println("Clients disconnected:  " + tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("tcp.TCPConnection exception: " + e.getMessage());
    }

    /*private void sendToAllConnections(String message) {
        System.out.println("SERVER: " + message);
        for (Map.Entry<String, TCPConnection> connection : connections.entrySet()) {
            connection.getValue().sendMessage(message);
        }
    }*/

    private void sendToAllConnections(String message) {
        for (TCPConnection connection : connections) {
            connection.sendMessage(message);
        }
    }
}
