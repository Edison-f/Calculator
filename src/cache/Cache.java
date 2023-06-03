package cache;

import java.util.HashMap;
import java.util.Map;

public class Cache extends HashMap<String, String> {

    public synchronized String search(String request) {
        return super.get(request);
    }

    public synchronized void update(String request, String response) {
        super.put(request, response);
    }

}
