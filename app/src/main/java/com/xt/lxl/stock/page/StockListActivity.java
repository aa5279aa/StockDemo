package com.xt.lxl.stock.page;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xt.lxl.stock.R;
import com.xt.lxl.stock.list.StockAdapter;
import com.xt.lxl.stock.model.StockViewModel;
import com.xt.lxl.stock.sender.StockSender;
import com.xt.lxl.stock.util.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/8/2.
 */
public class StockListActivity extends Activity implements View.OnClickListener {

    RelativeLayout mStockListTitle;
    RelativeLayout mStockListTopView;
    ListView mStockListView;
    StockAdapter mAdapter;
    List<StockViewModel> mStockList = new ArrayList<>();
    Handler mHander = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list_layout);
        initData();
        initView();
        initListener();
        bindData();
    }

    private void initListener() {
        findViewById(R.id.stock_self_optional).setOnClickListener(this);
        findViewById(R.id.stock_self_quotation).setOnClickListener(this);
    }

    private void initData() {
//        DataSource.initStockList(mStockList);
//        mStockList.add(0, new StockViewModel());
//        mStockList.add(new StockViewModel());
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<StockViewModel> stockList = new ArrayList<>();
                List<String> saveStockCodeList = DataSource.getSaveStockCodeList(StockListActivity.this);
                for (String code : saveStockCodeList) {
                    StockViewModel stockViewModel = StockSender.requestStockModelByCode(code);
                    stockList.add(stockViewModel);
                }
                mStockList = stockList;
                mHander.post(new Runnable() {
                    @Override
                    public void run() {
                        mStockList.add(0, new StockViewModel());
                        mStockList.add(new StockViewModel());
                    }
                });
            }
        });
    }

    private void initView() {
        mStockListTitle = (RelativeLayout) findViewById(R.id.stock_detail_titlebar_container);
        mStockListTopView = (RelativeLayout) findViewById(R.id.stock_list_top_view);
        mStockListView = (ListView) findViewById(R.id.stock_list);
    }

    private void bindData() {
        mAdapter = new StockAdapter(this);
        mStockListView.setAdapter(mAdapter);
        mAdapter.setData(mStockList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }
}
