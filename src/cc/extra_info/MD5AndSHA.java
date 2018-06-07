package cc.extra_info;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.System.out;

/**
 * 一个消息摘要就是一个数据块的数字指纹。
 * 即对一个任意长度的一个数据块进行计算，产生一个唯一指印（对于SHA1是产生一个20字节的二进制数组）。
 * 消息摘要是一种与消息认证码结合使用以确保消息完整性的技术。
 * 主要使用单向散列函数算法，可用于检验消息的完整性，和通过散列密码直接以文本形式保存等，目前广泛使用的算法有MD4、MD5、SHA-1。
 * <p>
 * 消息摘要有两个基本属性：
 * 两个不同的报文难以生成相同的摘要
 * 难以对指定的摘要生成一个报文，而可以由该报文反推算出该指定的摘要
 * 代表：美国国家标准技术研究所的SHA1和麻省理工学院Ronald Rivest提出的MD5
 */
public class MD5AndSHA {
    public static void main(String[] args) {
        out.println(Integer.toHexString("Hello World!".hashCode()));
        out.println(Integer.toHexString(new String("Hello World!").hashCode()));
        out.println(Integer.toHexString(new StringBuffer("Hello World!").hashCode()));
        out.println(Integer.toHexString(new StringBuffer("Hello World!").toString().hashCode()));
        out.println(Integer.toHexString(new StringBuilder("Hello World!").hashCode()));
        out.println(Integer.toHexString(new StringBuilder("Hello World!").toString().hashCode()));
        out.println(encoderByMd5("Hello World!"));
    }

    /**
     * 利用MD5进行加密
     *
     * @param s 待加密的字符串
     * @return 加密后的字符串
     * NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * UnsupportedEncodingException
     */
    public static String encoderByMd5(String s) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(s.getBytes("utf-8"));
            for (byte b : digest) {
                out.print(digest.length + ":");
                out.println((char) b);
            }
            out.println();
            out.println(new String(digest, "utf-8"));
            BASE64Encoder base64 = new BASE64Encoder();
            String result = base64.encode(md5.digest(s.getBytes("utf-8")));
            return result;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return "exception";
        } finally {
//            return "finally";
        }
    }

    /**
     * 判断用户密码是否正确
     * <p>
     * 因为MD5是基于消息摘要原理的，消息摘要的基本特征就是很难根据摘要推算出消息报文，
     * 因此要验证密码是否正确，就必须对输入密码（消息报文）重新计算其摘要，和数据库中存储的摘要进行对比（即数据库中存储的其实为用户密码的摘要），
     * 若两个摘要相同，则说明密码正确，不同，则说明密码错误。
     *
     * @param newpasswd 用户输入的密码
     * @param oldpasswd 数据库中存储的密码－－用户密码的摘要
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (encoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}
