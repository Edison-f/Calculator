package security;

import echo.ProxyHandler;

public class SecurityHandler extends ProxyHandler {
    public static PassTable passTable = new PassTable();
    private boolean loggedIn = false;

    @Override
    protected String response(String msg) throws Exception {
        if (!loggedIn) {
            String[] split = msg.split(" ");
            if (split.length == 3) {
                String operation = split[0];
                String user = split[1];
                String pass = split[2];
                if (operation.equals("new")) {
                    if (!passTable.containsKey(user)) {
                        passTable.add(user, pass);
                        return "New user/pass combination added";
                    } else {
                        return "User already exists";
                    }
                } else if (operation.equals("login")) {
                    if (passTable.verify(user, pass)) {
                        loggedIn = true;
                        return "Valid user/pass combination, logged in";
                    } else {
                        shutDown();
                        throw new Exception("Wrong user/pass combination, no further messages will be processed");
                    }
                } else {
                    return "Invalid operation \"" + operation + "\"";
                }
            } else {
                return "Invalid parameter count";
            }
        }
        return super.response(msg);
    }

}
