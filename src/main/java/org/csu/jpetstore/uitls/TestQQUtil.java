package org.csu.jpetstore.uitls;

import org.csu.jpetstore.common.utils.HttpRequest;

/**
 * Created by sun on 2019/12/2
 */
public class TestQQUtil {

    public static final String API_ADDRESS = "http://japi.juhe.cn/qqevaluate/qq";
    public static final String APP_KEY = "59928fe1fb22e969d6a6eeec058f9dc8";

    public static Object testQQ(String qq) {
        String param = "key=" + APP_KEY + "&qq=" + qq;
        Object result = HttpRequest.sendGet(API_ADDRESS, param);
        // 这里不对它的返回结果进行二次封装了，反正本来也就是Json数据嘛
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        testQQ("1090726895");
    }

}
