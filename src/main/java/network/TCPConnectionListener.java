package network;

public interface TCPConnectionListener {
    void onConnected(TCPConnection tcpConnection);

    void onReceiveMessage(TCPConnection tcpConnection, String message);

    void onDisconnect(TCPConnection tcpConnection);

    void onException(TCPConnection tcpConnection, Exception e);
}
