package com.baisidai.mvvmbetter.http;

import com.baisidai.mvvmbetter.base.BaseBean;
import com.baisidai.mvvmbetter.bean.PublicNumberBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("wxarticle/chapters/json")
    Observable<BaseBean<List<PublicNumberBean>>> getList();
}
