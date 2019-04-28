package others;

import lombok.extern.java.Log;

@Log
public class SystemProperty {

    public static void main(String[] args) {
        String jvmName = System.getProperty("java.vm.name");
        System.out.println(jvmName);
        Short b = (short) 10;
        String bs = Integer.toBinaryString((int) b);
        log.info(bs);
        char[] chars = bs.toCharArray();
        for (char c : chars) {
            System.out.print(c);
        }

    }
}
