package string;

/**
 * @ClassName: CharLength
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/10/21 09:40
 */
public class CharLength {

    public static void main(String[] args) {
        String str1 = "测试";
        int byte_len = str1.getBytes().length;
        int len = str1.length();
        System.out.println("字节长度为：" + byte_len);
        System.out.println("字符长度为：" + len);

        String str= "a";
        char x ='a';
        byte[] byteStr=null;
        byte[] byteChar=null; 
        try {
            byteStr = str.getBytes("utf-8");
            byteChar = charToByte(x);
        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("byteStr ："+byteStr.length);
        System.out.println("byteChar："+byteChar.length);
    }
    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }
}
