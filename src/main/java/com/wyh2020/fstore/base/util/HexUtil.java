package com.wyh2020.fstore.base.util;

/**
 * This class provides convenient functions to convert hex string to byte array
 * and vice versa.
 */
public class HexUtil {

	private HexUtil() {
	}

	/**
	 * Converts a byte array to hex string.
	 * 
	 * @param b -
	 *            the input byte array
	 * @return hex string representation of b.
	 */

	public static String toHexString(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(com.wyh2020.fstore.base.util.HexUtil.HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
			sb.append(com.wyh2020.fstore.base.util.HexUtil.HEX_CHARS.charAt(b[i] & 0x0F));
		}
		return sb.toString();
	}

	/**
	 * Converts a hex string into a byte array.
	 * 
	 * @param s -
	 *            string to be converted
	 * @return byte array converted from s
	 */
	public static byte[] toByteArray(String s) {
		byte[] buf = new byte[s.length() / 2];
		int j = 0;
		for (int i = 0; i < buf.length; i++) {
			buf[i] = (byte) ((Character.digit(s.charAt(j++), 16) << 4) | Character
					.digit(s.charAt(j++), 16));
		}
		return buf;
	}
	public static String byte2hex(byte[] b) { //二行制转字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1) {
				hs = hs;
			}
		}
		return hs;
	}
	private static final String HEX_CHARS = "0123456789abcdef";

}
