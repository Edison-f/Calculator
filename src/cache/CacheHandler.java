package cache;

import echo.ProxyHandler;

public class CacheHandler extends ProxyHandler {

    private static Cache cache = new Cache();

    @Override
    protected String response(String msg) throws Exception {
        String search = cache.search(msg);
        if(search != null) {
            System.out.println("Found cached response");
            return search;
        }
        String response = super.response(msg);
        cache.update(msg, response);
        return response;
    }
}
