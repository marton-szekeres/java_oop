import java.io.Serializable;
import java.util.Map;

public class Profile implements Serializable {
    private Map<String, Object> userInfo;

    public Map<String, Object> getUserinfo() {
        return userInfo;
    }

    public void setUserinfo(Map<String, Object> infos) {
        this.userInfo = infos;
    }
}
