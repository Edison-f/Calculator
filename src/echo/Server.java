package echo;

import java.util.*;
import java.io.*;
import java.net.*;

public class Server {

    protected ServerSocket mySocket;
    protected int myPort;
    public static boolean DEBUG = true;
    protected Class<?> handlerType;

    public Server(int port, String handlerType) {
        try {
            myPort = port;
            mySocket = new ServerSocket(myPort);
            this.handlerType = (Class.forName(handlerType));
        } catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } // catch
    }


    public void listen() {
        while(true) {
            try {
                RequestHandler handler = makeHandler(mySocket.accept());
                Thread newThread = new Thread(handler);
                newThread.start();
            }
            catch (Exception ignored) {}
            // accept a connection
            // make handler
            // start handler in its own thread
        } // while
    }

    public RequestHandler makeHandler(Socket s) {
        // handler = a new instance of handlerType
        //    use: try { handlerType.getDeclaredConstructor().newInstance() } catch ...
        // set handler's socket to s
        // return handler
        try {
            RequestHandler handler = (RequestHandler) handlerType.getDeclaredConstructor().newInstance();
            handler.sock = s;
            return handler;
        }
        catch (Exception ignored) {

        }
        return null;
    }



    public static void main(String[] args) {
        int port = 5555;
        String service = "echo.RequestHandler";
        if (1 <= args.length) {
            service = args[0];
        }
        if (2 <= args.length) {
            port = Integer.parseInt(args[1]);
        }
        Server server = new Server(port, service);
        server.listen();
    }
}