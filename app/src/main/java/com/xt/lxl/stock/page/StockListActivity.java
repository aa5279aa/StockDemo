package com.xt.lxl.stock.page;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.xt.lxl.stock.R;
import com.xt.lxl.stock.list.StockAdapter;
import com.xt.lxl.stock.model.StockViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangleiliu on 2017/8/2.
 */
public class StockListActivity extends Activity {

    RelativeLayout mStockListTitle;
    RelativeLayout mStockListTopView;
    ListView mStockListView;
    StockAdapter mAdapter;
    List<StockViewModel> mStockList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list_layout);
        initData();
        initView();
        bindData();
    }

    private void initData() {
        StockViewModel viewModel1 = new StockViewModel();
        StockViewModel viewModel2 = new StockViewModel();
        mStockList.add(viewModel1);
        mStockList.add(viewModel2);

        viewModel1.mStockName = "汉得信息";
        viewModel1.mPirce = "10.26";
        viewModel1.mStockCode = "300170";
        viewModel1.mStockChange = -0.0182;

        viewModel2.mStockName = "朗新科技";
        viewModel2.mPirce = "10.55";
        viewModel2.mStockCode = "300682";
        viewModel2.mStockChange = 0.1001;

        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());
        mStockList.add((StockViewModel) viewModel1.clone());

        mStockList.add(0, new StockViewModel());
        mStockList.add(new StockViewModel());
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
}
