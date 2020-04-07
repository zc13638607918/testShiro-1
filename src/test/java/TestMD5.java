import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName TestMD5
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/7 21:50
 * @Version 1.0
 **/
public class TestMD5 {
    public static void main(String[] args) {
        String password = "zc88869176";
        String salt=new SecureRandomNumberGenerator().nextBytes().toString();
        int times=2;
        String algorithmName="md5";
        String encodedPassword=new SimpleHash(algorithmName,password,salt,times).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ",password,salt,times,encodedPassword);

    }

}

