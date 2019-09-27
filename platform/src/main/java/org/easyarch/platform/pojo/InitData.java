package org.easyarch.platform.pojo;

import java.util.Set;

/**
 * @ClassName InitData
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/25 上午9:27
 * @Version 1.0
 */
public class InitData {
    private Set listjson;
    private PieChart pieChart;

    public Set getListjson() {
        return listjson;
    }

    public void setListjson(Set listjson) {
        this.listjson = listjson;
    }

    public PieChart getPieChart() {
        return pieChart;
    }

    public void setPieChart(PieChart pieChart) {
        this.pieChart = pieChart;
    }

    @Override
    public String toString() {
        return "InitData{" +
                "listjson=" + listjson +
                ", pieChart=" + pieChart +
                '}';
    }
}
