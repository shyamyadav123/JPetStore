package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Locale;

/**
 * @author: sun
 * @date: 2019/6/9
 */
public class ChangeLanAction extends ActionSupport {

    public String execute() {
        // 获得本地的默认语言环境
        Locale locale = Locale.getDefault();
        // 存入到一个session变量中
        ActionContext.getContext().getSession().put("WW-TRANS-I18N-LOCALE", locale);
        return SUCCESS;
    }

}
