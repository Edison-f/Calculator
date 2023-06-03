package security;

import cache.Cache;

import java.util.HashMap;

public class PassTable extends Cache {


    public synchronized boolean add(String user, String pass) {
        if(containsKey(user)) {
            return false;
        }
        put(user, pass);
        return true;
    }

    public synchronized boolean verify(String user, String pass) {
        if(containsKey(user)) {
            return get(user).equals(pass);
        }
        return false;
    }
}
