import com.zc.DAO.DAO;
import com.zc.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestShiro
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/7 10:14
 * @Version 1.0
 **/
public class TestShiro {
    public static void main(String[] args) {
        User zhang3 = new User();
        zhang3.setName("zhang3");
        zhang3.setPassword("12345");

        User li4 = new User();
        li4.setName("li4");
        li4.setPassword("abcde");

        User wang5 = new User();
        wang5.setName("wang5");
        wang5.setPassword("wrongpassword");

        //new DAO().createUser("zhouchao", "zc88869176");
        User zhouchao = new User("zhouchao", "zc88869176");

        List<User> users = new ArrayList<>();

        users.add(zhang3);
        users.add(li4);
        users.add(wang5);
        users.add(zhouchao);

        String roleAdmin = "admin";
        String roleProductManager = "productManager";
        String orderManager = "orderManager";

        List<String> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleProductManager);
        roles.add(orderManager);

        String permitAddProduct = "addProduct";
        String permitAddOrder = "addOrder";

        List<String> permits = new ArrayList<>();
        permits.add(permitAddOrder);
        permits.add(permitAddProduct);

        for (User user : users) {
            if (login(user))
                System.out.printf("%s \t成功登陆，用的密码是 %s\t%n", user.getName(), user.getPassword());
            else
                System.out.printf("%s \t登陆失败，用的密码是 %s\t%n", user.getName(), user.getPassword());

        }
        System.out.println("************************");

        for (User user : users) {
            if (login(user)) {
                for (String role : roles) {
                    if (hasRole(role))
                        System.out.printf("%s\t 拥有角色：%s\t%n", user.getName(), role);
                    else
                        System.out.printf("%s\t 不拥有角色：%s\t%n", user.getName(), role);
                }
            }
        }

        System.out.println("*******************************");

        for (User user : users) {
            if (login(user)) {
                for (String permit : permits) {
                    if (isPermitted(permit))
                        System.out.printf("%s\t 拥有权限：%s\t%n", user.getName(), permit);
                    else
                        System.out.printf("%s\t 不拥有权限：%s\t%n", user.getName(), permit);
                }
            }
        }

    }

    private static boolean hasRole(String role) {
        Subject subject = getSubject();
        return subject.hasRole(role);
    }

    private static boolean isPermitted(String permit) {
        Subject subject = getSubject();
        return subject.isPermitted(permit);
    }

    private static Subject getSubject() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager sm = factory.getInstance();
        SecurityUtils.setSecurityManager(sm);
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }

    private static boolean login(User user) {
        Subject subject = getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }
        return subject.isAuthenticated();
    }
}
