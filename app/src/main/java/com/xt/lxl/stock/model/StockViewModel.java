package com.xt.lxl.stock.model;

/**
 * Created by xiangleiliu on 2017/8/5.
 */
public class StockViewModel implements Cloneable {

    public static final String STOCK_TYPE_CHINA = "China";
    public static final String STOCK_TYPE_US = "US";


    public String mStockName = "";
    public String mPirce = "";
    public String mPriceUS = "";//当前价格，美元
    public String mStockCode = "";//股票代码
    public String mStockType = "";//股票类型 美股orA股
    public String mStockSubType = "";//股票类型， 沪主板/深主板/创业板/中小板
    public double mStockChange = 0;//当前股票涨跌幅


    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new StockViewModel();
    }
}
