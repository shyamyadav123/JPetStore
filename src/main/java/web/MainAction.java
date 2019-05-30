package web;

import com.opensymphony.xwork2.Action;

public class MainAction implements Action {
    @Override
    public String execute() {
        return "success";
    }
}
