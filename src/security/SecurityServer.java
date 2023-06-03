package security;

import echo.ProxyServer;

public class SecurityServer extends ProxyServer {
    public SecurityServer(int myPort, String service, int peerPort, String peerHost) {
        super(myPort, service, peerPort, peerHost);
    }


}
