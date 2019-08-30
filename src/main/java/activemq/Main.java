package activemq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Main
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/7/22 14:20
 */
public class Main {

    public static void main(String[] args){
        String hll = "[\"localVideoControl\",\"localUserVideo\",\"RecordForLocal\"]";
        String[] sss ={"111", "222", "3333"};
        OOO os = new OOO(sss);
        ArrayList<String> aa = new ArrayList<>();
        aa.add("localVideoControl");
        aa.add("localUserVideo");
        aa.add("RecordForLocal");
        System.out.println(Arrays.toString(os.operateList));
        System.out.println(JSON.toJSONString(sss));
        System.out.println(JSON.toJSONString(aa));

        JSONObject jsonObject = JSON.parseObject(hll);
        System.out.println(jsonObject.toJSONString());
    }

    static class OOO{
        public String[] operateList;
        public OOO(String[] a){
            operateList = a;
        }

    }
}
