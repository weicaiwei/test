package others;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @ClassName: Base64Test
 * @Description: base64的3中编解码方法test
 * @auther: caiwei
 * @date: 2019/6/19 23:58
 */
public class Base64Test {

    public static void main(String[] args) {

        String test = "i am 采薇";


        Base64.Decoder baseDecoder = Base64.getDecoder();
        Base64.Encoder baseEncoder = Base64.getEncoder();

        byte[] baseTest = baseEncoder.encode(test.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(baseDecoder.decode(baseTest), StandardCharsets.UTF_8));


        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        String urlTest = urlEncoder.encodeToString(test.getBytes(StandardCharsets.UTF_8));
        System.out.println(urlTest);
        System.out.println(new String(urlDecoder.decode(urlTest), StandardCharsets.UTF_8));

        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        String mimeTest = mimeEncoder.encodeToString(test.getBytes(StandardCharsets.UTF_8));
        System.out.println(urlTest);
        System.out.println(new String(mimeDecoder.decode(urlTest), StandardCharsets.UTF_8));


    }

}
