package org.easyarch.user.pojo;

/**
 * @ClassName RequestApi
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午10:38
 * @Version 1.0
 */
public class RequestApi {
    private String url;
    private UserMessage data;
    private String other;

    @Override
    public String toString() {
        return "RequestApi{" +
                "url='" + url + '\'' +
                ", data=" + data +
                ", other='" + other + '\'' +
                '}';
    }

    public UserMessage getData() {
        return data;
    }

    public void setData(UserMessage data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
