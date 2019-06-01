package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Account;
import service.AccountService;

import java.util.Map;

public class AccountAction extends ActionSupport {
    private Account account;
    private boolean isBannerOption;
    private String[] bannerOption;
    private String favouriteCategoryId;
    private String languagePreference;
    private boolean authenticated;
    private AccountService accountService;

    public AccountAction() {
        account = new Account();
        isBannerOption = false;
        accountService = new AccountService();
    }

    public void setBannerOption(String[] bannerOption) {
        this.bannerOption = bannerOption;
    }

    public String[] getBannerOption() {
        return bannerOption;
    }

    public String getFavouriteCategoryId() {
        return favouriteCategoryId;
    }

    public void setFavouriteCategoryId(String favouriteCategoryId) {
        this.favouriteCategoryId = favouriteCategoryId;
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    @Override
    public String execute() {
        return null;
    }

    public String ToNewAccount() throws Exception {
        return "input";
    }

    public String NewAccount() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();

        String[] items = getBannerOption();
        if (items != null) {
            isBannerOption = true;
        }

        account.setBannerOption(isBannerOption);

        favouriteCategoryId = getFavouriteCategoryId();
        account.setFavouriteCategoryId(favouriteCategoryId);

        session.put("account", account);
        accountService.insertAccount(account);
        return "success";
    }

    public String ToSignIn() {
        return "input";
    }

    public String SignIn() {
        account = accountService.getAccount(account.getUsername(), account.getPassword());
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        if (account == null) {
            String value = "Invalid username or password.  Signon failed.";
            session.put("message", value);
            return "input";
        } else {
            session.put("account", account);
            return "success";
        }
    }

    public String toMyAccount() {
        return "input";
    }

    public String editAccount() {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        Account account = (Account) session.get("account");


        String[] items = getBannerOption();
        if (items != null) {
            isBannerOption = true;
        }

        account.setBannerOption(isBannerOption);

        favouriteCategoryId = getFavouriteCategoryId();
        account.setFavouriteCategoryId(favouriteCategoryId);

        session.put("account", account);
        accountService.updateAccount(account);
        return "success";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isAuthenticated() {
        return authenticated && account != null && account.getUsername() != null;
    }
}
