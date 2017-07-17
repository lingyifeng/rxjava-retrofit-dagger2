package com.alipay.lyf.rxjavasample.rx

import com.alipay.lyf.rxjavasample.net.bean.ResponseInfo
import com.jiang.common.utils.NetWorkUtils
import rx.Observable

/**
 * Created by 01F on 2017/6/11.
 */
class HttpUtils private constructor() {
    private val context = null

    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpUtils()
        }

    }

    init {
//        context != DaggerContextComponents.builder().build().inject()
    }

    fun <T> loadDatasForMsg(observable: Observable<ResponseInfo<T>>, subscriber: RxDataSubscriber<String>) {
        observable.compose(RxHelper.handleResultMsg())
                .doOnSubscribe {
                    if (!NetWorkUtils.isNetConnected(context)) {
                        subscriber._onError("当前网络不可用")
                        subscriber.unsubscribe()
                    } else
                        subscriber.showDialogLoading()
                }.doOnTerminate {
            subscriber.dismissLoadingDialog()
        }
                .subscribe(subscriber)
    }

    fun <T> loadDatasForBody(observable: Observable<ResponseInfo<T>>, subscriber: RxDataSubscriber<T>) {
        observable.compose(RxHelper.handleResultBody())
                .doOnSubscribe {
                    if (!NetWorkUtils.isNetConnected(context)) {
                        subscriber._onError("当前网络不可用")
                        subscriber.unsubscribe()
                    } else
                        subscriber.showDialogLoading()
                }.doOnTerminate {
            subscriber.dismissLoadingDialog()
        }.subscribe(subscriber)
    }
}