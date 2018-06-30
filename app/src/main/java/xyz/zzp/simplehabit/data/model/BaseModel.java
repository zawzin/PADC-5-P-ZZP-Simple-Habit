package xyz.zzp.simplehabit.data.model;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.zzp.simplehabit.network.SampleHabitApi;
import xyz.zzp.simplehabit.persistence.SimpleHabitDB;

public class BaseModel {

    protected SampleHabitApi mSeriesApi;
    protected SimpleHabitDB mTheDB;

    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mSeriesApi = retrofit.create(SampleHabitApi.class);
        mTheDB = SimpleHabitDB.getDatabase(context);
    }

}
