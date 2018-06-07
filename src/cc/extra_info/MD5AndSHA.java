package cc.extra_info;

import static java.lang.System.out;


public class MD5AndSHA {
	public static void main(String[] args) {
		out.println(Integer.toHexString("Hello World!".hashCode()));
		out.println(Integer.toHexString(new String("Hello World!").hashCode()));
		out.println(Integer.toHexString(new StringBuffer("Hello World!").hashCode()));
		out.println(Integer.toHexString(new StringBuffer("Hello World!").toString().hashCode()));
		out.println(Integer.toHexString(new StringBuilder("Hello World!").hashCode()));
		out.println(Integer.toHexString(new StringBuilder("Hello World!").toString().hashCode()));

	}

}
