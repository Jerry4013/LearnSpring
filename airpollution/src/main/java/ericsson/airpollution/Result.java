package ericsson.airpollution;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/01
 **/
public class Result {

    private double pm25 = 170;
    private int aqi = 49;

    private double hour1 = 54.0;
    private double hour2 = 123.0;
    private double hour3 = 245.0;
    private double hour4 = 321.0;
    private double hour5 = 56.0;

    public double getHour1() {
        return hour1;
    }

    public void setHour1(double hour1) {
        this.hour1 = hour1;
    }

    public double getHour2() {
        return hour2;
    }

    public void setHour2(double hour2) {
        this.hour2 = hour2;
    }

    public double getHour3() {
        return hour3;
    }

    public void setHour3(double hour3) {
        this.hour3 = hour3;
    }

    public double getHour4() {
        return hour4;
    }

    public void setHour4(double hour4) {
        this.hour4 = hour4;
    }

    public double getHour5() {
        return hour5;
    }

    public void setHour5(double hour5) {
        this.hour5 = hour5;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }
}
