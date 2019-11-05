import java.security.NoSuchAlgorithmException;

import urlshotner.Base62;
import urlshotner.URLShortnerHashTechniques;

public class MainClass {

	public static void main(String[] args) {
		URLShortnerHashTechniques url = new URLShortnerHashTechniques();
		Base62 base62 = new Base62();
		try {
			//System.out.println(url.urlshortnerMD5Hash("www.google.com/?hwjkh=hekjh=ehgke", 7));
			//System.out.println(url.urlShortnerSH1Hash("www.google.com/?hwjkh=hekjh=ehgke", 7));
			System.out.println(url.urlShortnerSH256Hash("www.google.com/?hwjkh=hekjh=ehgke", 7));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}	

}
