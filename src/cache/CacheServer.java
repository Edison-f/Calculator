package cache;

import echo.ProxyServer;
import echo.RequestHandler;

import java.net.Socket;

public class CacheServer extends ProxyServer {


    public CacheServer(int myPort, String service, int peerPort, String peerHost) {
        super(myPort, service, peerPort, peerHost);
    }

    @Override
    public RequestHandler makeHandler(Socket s) {
        CacheHandler handler = (CacheHandler) super.makeHandler(s);
        return handler;
    }
}
