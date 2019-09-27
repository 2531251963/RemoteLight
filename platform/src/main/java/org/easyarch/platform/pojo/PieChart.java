package org.easyarch.platform.pojo;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName PieChart
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/25 上午9:29
 * @Version 1.0
 */
public class PieChart {
    private double _fast;
    private double _short;
    private double _normal;

    public double get_fast() {
        return _fast;
    }

    public void set_fast(double _fast) {
        this._fast = _fast;
    }

    public double get_short() {
        return _short;
    }

    public void set_short(double _short) {
        this._short = _short;
    }

    public double get_normal() {
        return _normal;
    }

    public void set_normal(double _normal) {
        this._normal = _normal;
    }

    @Override
    public String toString() {
        return "PieChart{" +
                "_fast=" + _fast +
                ", _short=" + _short +
                ", _normal=" + _normal +
                '}';
    }
}
