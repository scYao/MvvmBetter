package com.baisidai.mvvmbetter.base;

import com.baisidai.mvvmbetter.config.Url;
import com.baisidai.mvvmbetter.http.APIService;
import com.baisidai.mvvmbetter.http.HttpUtils;

public abstract class BaseRepository {
    protected APIService apiService;

    public BaseRepository() {
        if (apiService == null) {
            apiService = HttpUtils.getInstance().getAPIService(Url.BASE_URL);
        }
    }

}
