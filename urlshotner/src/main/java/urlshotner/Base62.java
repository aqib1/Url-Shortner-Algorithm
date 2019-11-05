package urlshotner;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Base62 {
	private static String BASE62_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static int BASE62 = 62;
	private AtomicInteger atomicInteger = new AtomicInteger(1);
	private HashMap<String, String> map = new HashMap<String, String>();

	public String getShortnerUrl(String url, int limit) {
		if(map.containsKey(url)) {
			return map.get(url);
		} else {
			String shortUrl = getBase62(url, limit);
			map.put(url, shortUrl);
			return shortUrl;
		}
	}
	
	
	private String getBase62(String value, int limit) {
		StringBuffer sb = new StringBuffer();
		int hashcode = atomicInteger.getAndIncrement();
		while (hashcode / BASE62 > 0) {
			sb.append(BASE62_STR.charAt(hashcode % BASE62));
			hashcode /= BASE62;
			if(sb.length() >= limit) break;
		}
		sb.append(BASE62_STR.charAt(hashcode));
		while(sb.length() < limit) {
			sb.append(BASE62_STR.charAt(0));
		}
		return sb.reverse().toString();
	}
}
