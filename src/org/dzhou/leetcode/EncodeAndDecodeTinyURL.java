package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 535. Encode and Decode TinyURL
 * 
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * @author zhoudong
 *
 */
public class EncodeAndDecodeTinyURL {

	public class Codec {

		List<String> urls = new ArrayList<String>();

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			urls.add(longUrl);
			return String.valueOf(urls.size() - 1);
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			int index = Integer.valueOf(shortUrl);
			return (index < urls.size()) ? urls.get(index) : "";
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(url));

}
