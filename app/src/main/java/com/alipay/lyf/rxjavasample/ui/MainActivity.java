package com.alipay.lyf.rxjavasample.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

import com.alipay.lyf.rxjavasample.R;
import com.alipay.lyf.rxjavasample.adapter.PlanAdapter;
import com.alipay.lyf.rxjavasample.base.MVPBaseActivity;
import com.alipay.lyf.rxjavasample.entity.PlanDetailEntity;
import com.alipay.lyf.rxjavasample.helper.recyclerview.RecyclerViewInit;
import com.alipay.lyf.rxjavasample.inject.components.DaggerMainComponents;
import com.alipay.lyf.rxjavasample.inject.modules.MainModules;
import com.alipay.lyf.rxjavasample.rx.RxSchedulers;
import com.alipay.lyf.rxjavasample.ui.presenter.MainPresenter;
import com.alipay.lyf.rxjavasample.util.AESUtil;
import com.jiang.common.base.irecyclerview.IRecyclerView;
import com.jiang.common.utils.LogUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

public class MainActivity extends MVPBaseActivity<MainPresenter> {

    public PlanAdapter mPlanAdapter;

    Button btGoToNext;
    @BindView(R.id.bt_gotonext)
    Button mBtGotonext;
    @BindView(R.id.progress_download)
    public ProgressBar proLoading;
    @BindView(R.id.irv_show)
    IRecyclerView mIrvShow;
    private ArrayList<PlanDetailEntity> details = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
//        String url="http://vodwbil74qz.nosdn.127.net/nPZyUPER_3485993_sd.mp4?download=%E6%B5%81%E7%95%85_%E7%AE%A1%E7%90%86%E5%91%98%E5%A1%AB%E5%86%99%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF.mp4.mp4";
//        int i = url.lastIndexOf("/");
//        System.out.println("22  "+url.substring(i+1));
        ButterKnife.setDebug(true);
        mPlanAdapter = new PlanAdapter(mContext, details);
        RecyclerViewInit.init(mContext, mIrvShow, mPlanAdapter, new LinearLayoutManager(this));
//        String masterPassword = "hfuewihfuewi";
        String originalText = "0123456789";
        try {
            byte[] keys = AESUtil.initKey(192);
            byte[] bytes = originalText.getBytes();
            byte[] encrypt = AESUtil.encrypt(bytes, keys);
            String s1 = new String(encrypt);
            System.out.println("加密后：" + s1);
            byte[] decrypt = AESUtil.decrypt(encrypt,
                    keys);

            String s = new String(decrypt);
            System.out.println("解密后： " + s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败");
        }

    }
/** -------------------------------------------------*/
//private static final String TAG = "MainActivity";
//
//    public static String encrypt(String seed, String cleartext)
//            throws Exception {
//        byte[] rawKey = getRawKey(seed.getBytes());
//        byte[] result = encrypt(rawKey, cleartext.getBytes());
//        return toHex(result);
//    }
//
//    public static String decrypt(String seed, String encrypted)
//            throws Exception {
//        byte[] rawKey = getRawKey(seed.getBytes());
//        byte[] enc = toByte(encrypted);
//        byte[] result = decrypt(rawKey, enc);
//        return new String(result);
//    }
//
//    private static byte[] getRawKey(byte[] seed) throws Exception {
//        KeyGenerator kgen = KeyGenerator.getInstance("AES");
//        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");
//        sr.setSeed(seed);
//        kgen.init(128, sr);
//        SecretKey skey = kgen.generateKey();
//        byte[] raw = skey.getEncoded();
//        return raw;
//    }
//
//    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(
//                new byte[cipher.getBlockSize()]));
//        byte[] encrypted = cipher.doFinal(clear);
//        return encrypted;
//    }
//
//    private static byte[] decrypt(byte[] raw, byte[] encrypted)
//            throws Exception {
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(
//                new byte[cipher.getBlockSize()]));
//        byte[] decrypted = cipher.doFinal(encrypted);
//        return decrypted;
//    }
//
//    private static String toHex(String txt) {
//        return toHex(txt.getBytes());
//    }
//
//    private static String fromHex(String hex) {
//        return new String(toByte(hex));
//    }
//
//    private static byte[] toByte(String hexString) {
//        int len = hexString.length() / 2;
//        byte[] result = new byte[len];
//        for (int i = 0; i < len; i++)
//            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
//                    16).byteValue();
//        return result;
//    }
//
//    private static String toHex(byte[] buf) {
//        if (buf == null)
//            return "";
//        StringBuffer result = new StringBuffer(2 * buf.length);
//        for (int i = 0; i < buf.length; i++) {
//            appendHex(result, buf[i]);
//        }
//        return result.toString();
//    }
//
//    private final static String HEX = "0123456789ABCDEF";
//
//    private static void appendHex(StringBuffer sb, byte b) {
//        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
//    }

    /**
     * -------------------------------------------------------------
     */

    @Override
    protected void initInjector() {

        DaggerMainComponents.builder()
                .mainModules(new MainModules(this, mIrvShow))
                .build().inject(this);

    }

    public void zipTest() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4);

        Observable<Integer> observable2 = Observable.just(4, 5, 6);


        Observable.zip(observable1, observable2, new Func2<Integer, Integer, String>() {
            @Override
            public String call(Integer item1, Integer item2) {
                return item1 + "and" + item2;
            }
        }).subscribe(item -> LogUtils.loge(item));
    }

    public void filterTest() {
        Observable.just(3, 4, 5, 6)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 4;
                    }
                })
                .subscribe(item -> LogUtils.loge(item.toString())); //5,6
    }

    public void ofTypeTest() {
        Observable.just(1, 2, "3")
                .ofType(Integer.class)
                .subscribe(item -> LogUtils.loge(item.toString()));//1,2
    }

    public void takeTest() {
        Observable.just(3, 4, 5, 6)
                .take(3)//发射前三个数据项
                .take(100, TimeUnit.MILLISECONDS);//100m后停止发射
    }

    public void firstOrDeafult() {
        Observable.just(3, 4, 5, 6).firstOrDefault(1, new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 3;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer.toString());
            }
        });
    }

    public void throttleFirst() {
        Observable.create(subscriber -> {
            subscriber.onNext(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }
            subscriber.onNext(2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }

            subscriber.onNext(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }
            subscriber.onNext(4);
            subscriber.onNext(5);//     500  500   1000
            subscriber.onCompleted();//1   2    3      4 5
            //1       .3    .4
            //   999   999
        }).throttleFirst(999, TimeUnit.MILLISECONDS)
                .subscribe(item -> System.out.println(item.toString())); //结果为1,3,4
    }

    public void throttleWithTimeout() {
        Observable.create(subscriber -> {
            subscriber.onNext(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }
            subscriber.onNext(2);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }

            subscriber.onNext(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw Exceptions.propagate(e);
            }
            subscriber.onNext(4);
            subscriber.onNext(5);
            subscriber.onCompleted();
//throttleLast 结果为2,3,5
        }).throttleWithTimeout(1000, TimeUnit.MILLISECONDS)
                .subscribe(item -> System.out.println(item.toString())); //结果为3,5
    }

    public void groupBy() {
        Observable.just(1, 2, 3, 4, 5)
                .groupBy(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer % 2 == 0 ? "偶数" : "奇数";
                    }
                }).subscribe(new Action1<GroupedObservable<String, Integer>>() {
            @Override
            public void call(GroupedObservable<String, Integer> observable) {
                observable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(observable.getKey() + integer);
                    }
                });
            }
        });
    }

    public void window() {
        Observable.interval(0, 1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Observable<Long>>() {
                    @Override
                    public void call(Observable<Long> longObservable) {
                        System.out.println("subdivide begin......");
                        longObservable.subscribe(aLong -> {
                            System.out.println("Next: " + aLong);
                        });
                    }
                });
    }

    public void collect() {
        Observable.just(3, 4, 5, 6)
                .collect(ArrayList::new,
                        (integers, integer) -> integers.add(integer))
                .subscribe(integers -> System.out.println(integers.size()));
    }

    public void amb() {
        Observable<Integer> observable1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.computation());

        Observable<Integer> observable2 = Observable.create(subscriber -> {
            subscriber.onNext(3);
            subscriber.onNext(4);
            subscriber.onCompleted();
        });

        Observable.amb(observable1, observable2)
                .subscribe(integer -> Log.d("JG", integer.toString())); //3,4
    }

    //按照时间顺序连接Observable
    public void mergeTest() {
        Observable.merge(getFromNet(), getFromLocal())
                .compose(RxSchedulers.io_main())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        LogUtils.loge("输出   " + s);
                    }
                });
    }

    private Observable<String> getFromNet() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("FromNet");
                subscriber.onCompleted();
            }
        }).delay(500, TimeUnit.MILLISECONDS);
    }

    private Observable<String> getFromLocal() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("FromLocal");
                subscriber.onCompleted();
            }
        });
    }


    //将一个被观察者转换成另一个被观察者发射出去
    public void flatMapTest() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            strings.add("flatMap " + i);
        }
        Observable.just(strings).flatMap(new Func1<ArrayList<String>, Observable<String>>() {
            @Override
            public Observable<String> call(ArrayList<String> strings) {
                return Observable.from(strings);
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }

    //Map操作符对Observable发射的每一项数据应用一个函数，
    // 执行变换操作，然后返回一个发射这些结果的Observable。
    public void mapText() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("the " + i + " num");
        }
        Observable.just(strings)
                .map(new Func1<ArrayList<String>, String>() {
                    @Override
                    public String call(ArrayList<String> strings) {
                        return strings.get(4);
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }

    //combineLatest 操作符用来将多个Observable发射的数据组装起来然后在发射.
    // 通过Func类来组装多个Observable发射的数据,
    // 等到最后一个Observable发射数据了, 然后把所有发射的数据交给Fun进行组合, 然后把组合后的数据发射出去.

    public void combineLatestTest() {
        Observable.combineLatest(Observable.just("a", "b", "c"), Observable.just("1", "2", "3", "4"), new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s.concat(s2);
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String b) {
                System.out.println(b);
            }
        });
    }


    @OnClick(R.id.bt_gotonext)
    public void onViewClicked() {
//        startActivity(DownLaodActivity.class);
        mPresenter.downLoad("vodwbil74qz.nosdn.127.net/nPZyUPER_3485993_sd.mp4?download=%E6%B5%81%E7%95%85_%E7%AE%A1%E7%90%86%E5%91%98%E5%A1%AB%E5%86%99%E4%BC%81%E4%B8%9A%E4%BF%A1%E6%81%AF.mp4.mp4&wsiphost=local");

    }



}
