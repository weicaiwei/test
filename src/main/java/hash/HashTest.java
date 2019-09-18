package hash;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @ClassName: HashTest
 * @Description:
 * <li>{@code MD5}</li>
 * <li>{@code SHA-1}</li>
 * <li>{@code SHA-256}</li>
 * @auther: caiwei
 * @date: 2019/9/10 21:27
 */
public class HashTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        //总体来看，nio是快一些
        System.out.println("bio:");
        bio();
        System.out.println("nio:");
        nio();
    }

    static void bio() throws NoSuchAlgorithmException, IOException {

        File file = new File("D:\\temp\\mysql-5.6.34-winx64.zip");
        if (file.exists()) {
            MessageDigest MD5MessageDigest = MessageDigest.getInstance("MD5");
            MessageDigest SHA_1MessageDigest = MessageDigest.getInstance("SHA-1");
            MessageDigest SHA_256MessageDigest = MessageDigest.getInstance("SHA-256");

            long fileTime = System.currentTimeMillis();
            byte[] fileByte = FileUtils.readFileToByteArray(file);
            System.out.println("将文件全部读到内存耗时:" + (System.currentTimeMillis() - fileTime)+"毫秒");

            long md5StartTime = System.currentTimeMillis();
            MD5MessageDigest.update(fileByte);
            byte[] MD5Digest = MD5MessageDigest.digest();
            System.out.println("MD5Digest耗时:" + (System.currentTimeMillis() - md5StartTime)+"毫秒");
            System.out.println("hash的位数："+MD5Digest.length*8+"；hash值："+Base64.getEncoder().encodeToString(MD5Digest));

            long sha15StartTime = System.currentTimeMillis();
            SHA_1MessageDigest.update(fileByte);
            byte[] SHA_1Digest = SHA_1MessageDigest.digest();
            System.out.println("SHA_1MessageDigest耗时:" + (System.currentTimeMillis() - sha15StartTime)+"毫秒");
            System.out.println("hash的位数："+SHA_1Digest.length*8+"；hash值："+Base64.getEncoder().encodeToString(SHA_1Digest));

            long sha256StartTime = System.currentTimeMillis();
            SHA_256MessageDigest.update(fileByte);
            byte[] SHA_256Digest = SHA_256MessageDigest.digest();
            System.out.println("SHA_256MessageDigest耗时:" + (System.currentTimeMillis() - sha256StartTime)+"毫秒");
            System.out.println("hash的位数："+SHA_256Digest.length*8+"；hash值："+Base64.getEncoder().encodeToString(SHA_256Digest));

        }else {
            System.out.println("file is not exists");
        }
    }

    static void nio() throws NoSuchAlgorithmException, IOException {

        MessageDigest MD5MessageDigest = MessageDigest.getInstance("MD5");
        MessageDigest SHA_1MessageDigest = MessageDigest.getInstance("SHA-1");
        MessageDigest SHA_256MessageDigest = MessageDigest.getInstance("SHA-256");

        RandomAccessFile file = new RandomAccessFile("D:\\temp\\mysql-5.6.34-winx64-temp.zip", "r");

        File biofile = new File("D:\\temp\\mysql-5.6.34-winx64-temp.zip");

        FileChannel fileChannel = file.getChannel();
        FileChannel fileChannel2 = file.getChannel();
        FileChannel fileChannel3 = file.getChannel();


        ByteBuffer directBuffer = ByteBuffer.allocate(1024*1024);
        ByteBuffer directBuffer2 = ByteBuffer.allocate(1024*1024);
        ByteBuffer directBuffer3 = ByteBuffer.allocate(1024*1024);

        FileInputStream biofileInputStream = new FileInputStream(biofile);
        FileChannel fileChannel4 = biofileInputStream.getChannel();

        long sha256StartTime = System.currentTimeMillis();
        int readByteLen3;
        while((readByteLen3=fileChannel4.read(directBuffer3))!=-1){
            directBuffer3.flip();//将Buffer从写模式切换到读模式
            byte[] bytes = directBuffer3.array();
            SHA_256MessageDigest.update(bytes);
            directBuffer3.clear();
        }
        byte[] SHA_256Digest = SHA_256MessageDigest.digest();
        System.out.println("SHA_256MessageDigest耗时:" + (System.currentTimeMillis() - sha256StartTime) + "毫秒");
        System.out.println("hash的位数：" + SHA_256Digest.length * 8 + "；hash值：" + Base64.getEncoder().encodeToString(SHA_256Digest));



        long sha15StartTime = System.currentTimeMillis();
        int readByteLen2;
        while((readByteLen2=fileChannel2.read(directBuffer2))!=-1){
            directBuffer2.flip();//将Buffer从写模式切换到读模式
            byte[] bytes = directBuffer2.array();
            SHA_1MessageDigest.update(bytes);
            directBuffer2.clear();
        }
        byte[] SHA_1Digest = SHA_1MessageDigest.digest();
        System.out.println("SHA_1MessageDigest耗时:" + (System.currentTimeMillis() - sha15StartTime) + "毫秒");
        System.out.println("hash的位数：" + SHA_1Digest.length * 8 + "；hash值：" + Base64.getEncoder().encodeToString(SHA_1Digest));



        long md5StartTime = System.currentTimeMillis();
        int readByteLen;
        while((readByteLen=fileChannel.read(directBuffer))!=-1){
            directBuffer.flip();//将Buffer从写模式切换到读模式
            byte[] bytes = directBuffer.array();
            MD5MessageDigest.update(bytes);
            directBuffer.clear();
        }
        byte[] MD5Digest = MD5MessageDigest.digest();
        System.out.println("MD5Digest耗时:" + (System.currentTimeMillis() - md5StartTime) + "毫秒");
        System.out.println("hash的位数：" + MD5Digest.length * 8 + "；hash值：" + Base64.getEncoder().encodeToString(MD5Digest));





    }


}
