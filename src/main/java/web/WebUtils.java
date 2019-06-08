package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @author: sun
 * @date: 2019/6/1
 */
public class WebUtils {


    public static Map getSession() {
        ActionContext context = ActionContext.getContext();
        return context.getSession();
    }

    public static Map getRequest() {
        ActionContext context = ActionContext.getContext();
        return (Map) context.get("request");
    }

    public static void setMessage(String message) {
        Map request = getRequest();
        request.put("message", message);
    }
}
