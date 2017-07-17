package com.alipay.lyf.rxjavasample.rx;

import android.content.Context;

import com.alipay.lyf.rxjavasample.inject.components.DaggerContextComponents;
import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo;
import com.jiang.common.utils.NetWorkUtils;

import rx.Observable;

/**
 * Created by 01F on 2017/6/9.
 */

public class HttpUtil  {
    private Context mContext;
    private HttpUtil() {
        mContext = DaggerContextComponents.builder().build().inject();

    }

    private static class SingleHolder {
        private static final HttpUtil INSTANCE = new HttpUtil();
    }

    public static HttpUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public <T> void loadDatasForMsg(Observable<ResponseInfo<T>> observable, final RxDataSubscriber<String> subscriber) {
        observable.compose(RxHelper.handleResultMsg())
                .doOnSubscribe(() -> {
                    if (!NetWorkUtils.isNetConnected(mContext)) {
                        subscriber._onError("当前网络不可用");
                        subscriber.unsubscribe();
                    } else
                        subscriber.showDialogLoading();
                }).doOnTerminate(subscriber::dismissLoadingDialog)
                .subscribe(subscriber);
        //  doOnSubscribe():
//  在 subscribe() 调用后而且在事件发送前执行，但区别在于它可以指定线程。默认情况下，
//  doOnSubscribe() 执行在 subscribe() 发生的线程；而如果在 doOnSubscribe() 之后有 subscribeOn() 的话，
//  它将执行在离它最近的 subscribeOn() 所指定的线程。

//  onStart 可以用作流程开始前的初始化。然而  onStart() 由于在 subscribe() 发生时就被调用了，
//  因此不能指定线程，而是只能执行在  subscribe() 被调用时的线程。
//  所以 onStart 并不能保证永远在主线程运行。
    }

    public <T> void loadDatasForBody(final Observable<ResponseInfo<T>> observable, final RxDataSubscriber<T> subscriber) {
        observable.compose(RxHelper.handleResultBody())
                .doOnSubscribe(() -> {
                    if (!NetWorkUtils.isNetConnected(mContext)) {
                        subscriber._onError("当前网络不可用");
                        subscriber.unsubscribe();
                    } else
                        subscriber.showDialogLoading();
                }).doOnTerminate(subscriber::dismissLoadingDialog)
                .subscribe(subscriber);
    }
}
