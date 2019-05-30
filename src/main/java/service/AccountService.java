package service;


import domain.Account;
import org.apache.ibatis.session.SqlSession;
import persistence.AccountDAO;
import persistence.SqlSessionFactoryUtil;

public class AccountService {
    private AccountDAO accountDAO;
    private SqlSession session;

    public AccountService() {
        this.session = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
        this.accountDAO = session.getMapper(AccountDAO.class);
    }

    public Account getAccount(String username) {
        Account account = null;
        return accountDAO.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDAO.getAccountByUsernameAndPassword(account);
    }

    public void insertAccount(Account account) {
        accountDAO.insertAccount(account);
        accountDAO.insertProfile(account);
        accountDAO.insertSignon(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        accountDAO.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountDAO.updateSignon(account);
        }
    }
}
