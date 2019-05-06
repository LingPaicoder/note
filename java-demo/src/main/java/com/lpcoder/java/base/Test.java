package com.lpcoder.java.base;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liurenpeng
 * @date Created in 19-4-12
 */
public class Test {

    private Logger logger = Logger.getLogger("abc");

    /**
     * 代码中存在的几个问题：
     *
     * 1. Execute方法名不规范，应为execute
     *    (类似的linked_list改为linkedList比较符合java命名规范)
     * 2. 入参list类型强转可能失败，建议copy
     * 3. 多个if else建议改为switch，
     *    而且源代码中缺少最后的else块 另外如果x->Ux为固定规律的话，应抽取出专门的映射方法处理
     * 4. catch块中的日志打印最好打出堆栈
     * 5. Arrays.asList得到的list尺寸固定，不能直接add
     */

    @SuppressWarnings("unchecked")
    public void execute(List<String> list, String type) {
        LinkedList<String> linkedList = new LinkedList<String>(list);
        try {
            switch (type) {
                case "0":
                    linkedList.addFirst("U0");
                    break;
                case "1":
                    linkedList.addFirst("U1");
                    break;
                case "2":
                    linkedList.addFirst("U2");
                    break;
                case "3":
                    linkedList.addFirst("U3");
                    break;
                case "4":
                    linkedList.addFirst("U4");
                    break;
                default:
                    logger.info("Unknown occurrence.");
            }
        } catch (Exception e) {
            logger.error("新增数据异常", e);
        }

        List arrayList = new ArrayList<>(Arrays.asList("U5", "U6", "U7"));
        arrayList.add("U8");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.execute(new LinkedList<>(), "3");
    }

}
