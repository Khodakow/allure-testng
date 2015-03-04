package roles;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 04.03.2015 13:07.
 */
public class Webmaster implements User {

    private String name;
    private String password;
    private String currency;
    private String remoteAuth;



    @Step(value = "get wm name")
    @Attachment
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRemoteAuth() {
        return remoteAuth;
    }

    public Webmaster() {
        this.name = System.getProperty("wmname");
        this.password = System.getProperty("wmpassword");
        this.remoteAuth = System.getProperty("wmRemoteAuth");
    }

    public Webmaster(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Webmaster{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remoteAuth='" + remoteAuth + '\'' +
                '}';
    }
}
