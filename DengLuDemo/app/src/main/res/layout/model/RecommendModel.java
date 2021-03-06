package net.anumbrella.lkshop.model;

import android.content.Context;

import net.anumbrella.lkshop.db.DBManager;
import net.anumbrella.lkshop.http.RetrofitHttp;

import java.util.List;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author：Anumbrella
 * Date：16/5/31 下午12:40
 */
public class RecommendModel {

    public static void getProductsDataFromNet(Subscriber<List<net.anumbrella.lkshop.model.bean.ProductDataModel>> subscriber) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        RetrofitHttp.getRetrofit(builder.build()).getProducts("getProducts")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


    /**
     * 返回一个被观察者对象
     *
     * @param context
     * @return
     */
    public static Observable<List<net.anumbrella.lkshop.model.bean.RecommendContentModel>> getProductsFromDB(final Context context) {
        return Observable.create(new Observable.OnSubscribe<List<net.anumbrella.lkshop.model.bean.RecommendContentModel>>() {
            @Override
            public void call(Subscriber<? super List<net.anumbrella.lkshop.model.bean.RecommendContentModel>> subscriber) {
                //订阅者回调行为
                subscriber.onNext(DBManager.getManager(context).getRecommendContentsFromDB());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    public static void getRecommendBanners(Subscriber<List<net.anumbrella.lkshop.model.bean.BannerDataModel>> subscriber) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        RetrofitHttp.getRetrofit(builder.build()).getBanners("getBanners")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
