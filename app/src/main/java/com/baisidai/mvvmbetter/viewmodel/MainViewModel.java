package com.baisidai.mvvmbetter.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.baisidai.mvvmbetter.base.BaseBean;
import com.baisidai.mvvmbetter.bean.PublicNumberBean;
import com.baisidai.mvvmbetter.data.MainRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MainRepository repository = new MainRepository();
    private MutableLiveData<BaseBean<List<PublicNumberBean>>> mutableLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<BaseBean<List<PublicNumberBean>>> getList() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.getList();//获取数据
        }
        return mutableLiveData;
    }


}
