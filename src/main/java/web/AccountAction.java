package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Account;
import domain.Product;
import domain.VerifyCode;
import service.AccountService;
import service.CatalogService;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AccountAction extends ActionSupport {

    private static final long serialVersionUID = 5499663666155758178L;

    private static final List<String> LANGUAGE_LIST;
    private static final List<String> CATEGORY_LIST;

    private AccountService accountService;
    private CatalogService catalogService;

    private Account account;
    private List<Product> myList;
    private boolean authenticated;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    private ByteArrayInputStream imageStream;

    private String VerificationCode;

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        VerificationCode = verificationCode;
    }


    static {
        List<String> langList = new ArrayList<String>();
        langList.add("English");
        langList.add("Japanese");
        langList.add("Chinese");
        LANGUAGE_LIST = Collections.unmodifiableList(langList);

        List<String> catList = new ArrayList<String>();
        catList.add("FISH");
        catList.add("DOGS");
        catList.add("REPTILES");
        catList.add("CATS");
        catList.add("BIRDS");
        CATEGORY_LIST = Collections.unmodifiableList(catList);
    }

    public AccountAction() {
        account = new Account();
        accountService = new AccountService();
        catalogService = new CatalogService();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public String getUsername() {
        return account.getUsername();
    }


    public void setUsername(String username) {
        account.setUsername(username);
    }

    public String getPassword() {
        return account.getPassword();
    }

    public void setPassword(String password) {
        account.setPassword(password);
    }

    public List<Product> getMyList() {
        return myList;
    }

    public void setMyList(List<Product> myList) {
        this.myList = myList;
    }

    public List<String> getLanguages() {
        return LANGUAGE_LIST;
    }

    public List<String> getCategories() {
        return CATEGORY_LIST;
    }


    public String ToNewAccount() throws Exception {
        return "input";
    }

    public String NewAccount() {
        accountService.insertAccount(account);
        account = accountService.getAccount(account.getUsername());
        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
        authenticated = true;
        return "success";
    }

    public String toMyAccount() {
        return "input";
    }

    public String editAccount() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Account account1 = (Account) session.get("account");
        account.setUsername(account1.getUsername());
        accountService.updateAccount(account);
        account = accountService.getAccount(account.getUsername());
        myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
        session.put("account", account);
        return "success";
    }

    public String ToSignIn() {
        return "input";
    }

    /**
     * Structs2 的自动验证
     */
    public void validateSignIn() {
        this.clearFieldErrors();
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        account = accountService.getAccount(getUsername(), getPassword());
        String right_verifyCode;
        right_verifyCode = (String) session.get("SESSION_SECURITY_CODE");
        if (!right_verifyCode.equals(VerificationCode)) {
            String value = getText("signIn.message.code-error");
            this.addFieldError("error1", value);
        } else {
            if (account == null) {
//                String value = "Invalid username or password.  Signon failed.";
                String value = getText("signIn.message.fail");
                this.addFieldError("error1", value);

            } else {
                account.setPassword(null);
                myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
                authenticated = true;
                session.put("account", account);
                // this bean is already registered as /actions/Account.action
            }
        }
    }

    public String SignIn() {
        if (this.hasFieldErrors()) {
            return "input";
        } else {
//            System.out.print("aaa");
            // 日志记录登录成功
            return "success";
        }
    }

    public String signoff() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        session.put("account", null);
        return "success";
    }

    public String verifyCode() {
        String securityCode = VerifyCode.getSecurityCode();
        imageStream = VerifyCode.getImageAsInputStream(securityCode);
        Map session = WebUtils.getSession();
        session.put("SESSION_SECURITY_CODE", securityCode);
        return "success";
    }

    public boolean isAuthenticated() {
        return authenticated && account != null && account.getUsername() != null;
    }

    /**
     * message这类不应该放在session里面
     * @param message
     */
    public void setMessage(String message) {
//        ActionContext context = ActionContext.getContext();
//        Map session = context.getSession();
//        session.put("message", message);
        WebUtils.setMessage(message);
    }
}

