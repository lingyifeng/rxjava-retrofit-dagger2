package com.alipay.lyf.rxjavasample.net.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 01F on 2017/6/27.
 */

public interface DownLoadService {
    //http://vodwbil74qz.vod.126.net/vodwbil74qz/d4471102-0c90-4b27-8bb1-2d0904f3c601.mp4
    //http://vodwbil74qz.nosdn.127.net/nPZyUPER_3485993_sd.mp4?download=%E6%B5%81%E7%95%85_%E7%AE%A1%E7%90%86%E5%91%98%E5%A1%AB%E5%86%99%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF.mp4.mp4
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url);

}
