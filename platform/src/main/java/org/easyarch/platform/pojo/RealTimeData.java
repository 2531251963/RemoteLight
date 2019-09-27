package org.easyarch.platform.pojo;

/**
 * @ClassName RealTimeData
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/26 下午6:25
 * @Version 1.0
 */
public class RealTimeData {
    private String _fast;
    private String _short;
    private int color;//0绿 1黄  2红

    public String get_fast() {
        return _fast;
    }

    public void set_fast(String _fast) {
        this._fast = _fast;
    }

    public String get_short() {
        return _short;
    }

    public void set_short(String _short) {
        this._short = _short;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
