package com.zc.Test;

/**
 * Description:
 *
 * @author Corey Zhang
 * @create 2020-01-07 20:59
 */
public class TimeData {

    private String time;

    private double value;

    public TimeData(String time, double value) {
        this.time = time;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TimeData{" +
                "time='" + time + '\'' +
                ", value=" + value +
                '}';
    }
}
