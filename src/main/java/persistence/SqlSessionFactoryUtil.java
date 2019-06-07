package persistence;

import domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sf = null;
    private static String resource = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory() {
        if (sf == null) {
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sf = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sf;
    }

    public static void main(String args[]) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        Account account = new Account();
        account.setUsername("123");
        account.setPassword("123");

        AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);
        Account result = accountDAO.getAccountByUsernameAndPassword(account);
        accountDAO.insertAccount(account);
        System.out.print(result);
    }
}
