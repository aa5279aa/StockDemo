package com.xt.lxl.stock.page;

import android.app.Activity;
import android.os.Bundle;

import com.xt.lxl.stock.R;

/**
 * Created by xiangleiliu on 2017/8/2.
 */
public class StockListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list_layout);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
