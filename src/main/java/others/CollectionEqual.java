package others;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @ClassName: CollectionEqual
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/5/19 23:56
 */
public class CollectionEqual {

    public static void main(String[] args){
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        a.add("11");
        a.add("3");
        a.add("45");
        a.add("6");
        a.add("7");



        b.add("11");
        b.add("3");
        b.add("45");
        b.add("6");


        CompareResult result = compareListl(a, b);
        Print.println(String.valueOf(result.isEqual()));
        Print.println(String.valueOf(result.getWhichBig()));
        for(String s : result.getDiffElementsInLeft()){
            Print.print(s+"; ");
        }
        Print.println();
        for(String s : result.getDiffElementsInRight()){
            Print.print(s+"; ");
        }

    }

    /**
     * @Title: compareList
     * @Description: 比较两个list中的值是否相等 map可取值 ‘isEqual’ 'whichBig' 'diffElementsInLeft' 'diffElementsInRight'
     * @params: [left, right]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     * @author: caiwei
     * @date: 2019/5/20 0:02
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static private class CompareResult{
        private boolean isEqual;
        private String whichBig;
        private List<String> diffElementsInLeft;
        private List<String> diffElementsInRight;
    }
    public static CompareResult compareListl(List<String> left, List<String> right) {

        //判断是否指向同一个对象
        if (left == right){
            return new CompareResult(true, "equal", new ArrayList<>(), new ArrayList<>());
        }

        //判断其中一个是否为空
        if (left == null || right == null){
            return new CompareResult(false, left != null ? "left" : "right", left, right);
        }

        //两个列表均不为空的情况:
        CompareResult compareResult = new CompareResult();
        List<String> tempElementInLeft = new ArrayList<>();
        List<String> tempElementInRight = new ArrayList<>();
        //判断哪个列表尺寸大
        if (left.size() == right.size()) {
            //如果两个列表长度相等，先判断两个列表是否相等
            for(String leftElement : left){
                //左侧列表中与右侧列表中不同的元素，返回的为左侧中的元素
                if(!right.contains(leftElement)){
                    tempElementInLeft.add(leftElement);
                }
            }
            //如果两个列表内容相等，直接返回
            if(tempElementInLeft.size() == 0){
                return new CompareResult(true, "equal", new ArrayList<>(), new ArrayList<>());
            }
        }else {
            for(String leftElement : left){
                //左侧列表中与右侧列表中不同的元素，返回的为左侧中的元素
                if(!right.contains(leftElement)){
                    tempElementInLeft.add(leftElement);
                }
            }
            compareResult.setWhichBig(left.size() > right.size() ? "left" : "right");
        }
        compareResult.setEqual(false);
        for(String leftElement : right){
            //返回右侧中不同的元素
            if(!left.contains(leftElement)){
                tempElementInRight.add(leftElement);
            }
        }
        compareResult.setDiffElementsInLeft(tempElementInLeft);
        compareResult.setDiffElementsInRight(tempElementInRight);
        return compareResult;
    }
}
