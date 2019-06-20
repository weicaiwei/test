package extend;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName: Son1
 * @Description: TODO
 * @auther: caiwei
 * @date: 2019/6/12 20:10
 */
@Data
@ToString(callSuper = true)
public class Son1 extends Father {
    private String sonName;
}
