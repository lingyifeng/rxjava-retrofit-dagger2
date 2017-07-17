package com.alipay.lyf.rxjavasample.net.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 01F on 2017/5/17.
 */

public abstract class RetrofitCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()) {
            onSuccess(call, response);
        } else {
            onFailure(call, new Throwable(response.message()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
    public abstract void onSuccess(Call<T> call, Response<T> response);

    public void onLoading(long total, long progress) {

    }
}
