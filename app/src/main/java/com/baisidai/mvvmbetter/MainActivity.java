package com.baisidai.mvvmbetter;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.baisidai.mvvmbetter.adapter.MainAdapter;
import com.baisidai.mvvmbetter.base.BaseActivity;
import com.baisidai.mvvmbetter.base.BaseBean;
import com.baisidai.mvvmbetter.bean.PublicNumberBean;
import com.baisidai.mvvmbetter.databinding.ActivityMainBinding;
import com.baisidai.mvvmbetter.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    private LinearLayoutManager layoutManager;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dataBinding.recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this);
        dataBinding.recyclerView.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        showWaitDialog();//显示加载动画
        viewModel.getList().observe(this, new Observer<BaseBean<List<PublicNumberBean>>>() {
            @Override
            public void onChanged(@Nullable BaseBean<List<PublicNumberBean>> listBaseBean) {
                if (listBaseBean.getErrorCode() == 0) {
                    dismissWaitDialog();//关闭加载图
                    adapter.setData(listBaseBean.getData());
                }

            }
        });
    }

}
