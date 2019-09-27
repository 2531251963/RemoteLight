package org.easyarch.platform.pojo;

/**
 * @ClassName RequestApi
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午9:31
 * @Version 1.0
 */
public class RequestApi {
    private String url;
    private String platformid;
    private String other;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlatformid() {
        return platformid;
    }

    public void setPlatformid(String platformid) {
        this.platformid = platformid;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "RequestApi{" +
                "url='" + url + '\'' +
                ", platformid='" + platformid + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
