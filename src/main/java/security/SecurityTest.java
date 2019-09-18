package security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @ClassName: SecurityTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/27 16:00
 */
public class SecurityTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        double a = Double.valueOf("3.79");
        System.out.println(a);

        String data = "caiweiweiwei";




        System.out.println(encrypt(data));

        System.out.println(encrypt("精彩的母猪餐后护理"));


    }

    public static String encrypt(String data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
   }
}
