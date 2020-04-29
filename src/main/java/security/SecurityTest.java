package security;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

/**
 * @ClassName: SecurityTest
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/27 16:00
 */
public class SecurityTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {


        String data = "caiweiweiwei";




        encrypt(data);



    }

    public static void encrypt(String data) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data.getBytes());
            System.out.println(new BigInteger(digest.digest()).toString(16));
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

   }
}
