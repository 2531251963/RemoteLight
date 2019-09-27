package org.easyarch.user.pojo;

/**
 * @ClassName UserMessage
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/21 上午12:09
 * @Version 1.0
 */
public class UserMessage {
    private String userid;
    private String message;
    private String type;

    @Override
    public String toString() {
        return "UserMessage{" +
                "userid='" + userid + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
