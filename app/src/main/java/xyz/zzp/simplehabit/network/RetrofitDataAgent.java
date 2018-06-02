package xyz.zzp.simplehabit.network;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.zzp.simplehabit.events.LoadedCategoryProgramEvent;
import xyz.zzp.simplehabit.events.LoadedCurrentProgramEvent;
import xyz.zzp.simplehabit.events.LoadedTopicEvent;
import xyz.zzp.simplehabit.events.NetworkErrorEvent;
import xyz.zzp.simplehabit.network.responses.GetCategoryProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetCurrentProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetTopicResponse;

public class RetrofitDataAgent implements SimpleHabitDataAgent {

    private static RetrofitDataAgent sObjectInstance;
    private SampleHabitApi mSampleHabitApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mSampleHabitApi = retrofit.create(SampleHabitApi.class);

    }

    public static RetrofitDataAgent getsObjectInstance() {
        if (sObjectInstance == null)
            sObjectInstance = new RetrofitDataAgent();
        return sObjectInstance;
    }

    @Override
    public void loadCurrentProgram() {
        Call<GetCurrentProgramResponse> currentProgramResponseCall = mSampleHabitApi.loadCurrentProgram("b002c7e1a528b7cb460933fc2875e916", 1);
        currentProgramResponseCall.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse getCurrentProgramResponse = response.body();

                if (getCurrentProgramResponse != null) {
                    LoadedCurrentProgramEvent event = new LoadedCurrentProgramEvent(getCurrentProgramResponse.getCurrentProgram());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                Log.i("Error-Current",t.getMessage());
                NetworkErrorEvent networkErrorEvent = new NetworkErrorEvent();
                EventBus.getDefault().post(networkErrorEvent);
            }
        });
    }

    @Override
    public void loadTopic() {
        Call<GetTopicResponse> getTopicResponseCall = mSampleHabitApi.loadTopic("b002c7e1a528b7cb460933fc2875e916", 1);
        getTopicResponseCall.enqueue(new Callback<GetTopicResponse>() {
            @Override
            public void onResponse(Call<GetTopicResponse> call, Response<GetTopicResponse> response) {
                GetTopicResponse getTopicResponse = response.body();

                if (getTopicResponse != null) {
                    LoadedTopicEvent event = new LoadedTopicEvent(getTopicResponse.getTopics());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetTopicResponse> call, Throwable t) {
                NetworkErrorEvent networkErrorEvent = new NetworkErrorEvent();
                EventBus.getDefault().post(networkErrorEvent);
            }
        });
    }

    @Override
    public void loadCategories() {
        Call<GetCategoryProgramResponse> getCategoryProgramResponseCall = mSampleHabitApi.loadCategoryProgram("b002c7e1a528b7cb460933fc2875e916",1);
        getCategoryProgramResponseCall.enqueue(new Callback<GetCategoryProgramResponse>() {
            @Override
            public void onResponse(Call<GetCategoryProgramResponse> call, Response<GetCategoryProgramResponse> response) {
                GetCategoryProgramResponse getCategoryProgramResponse =response.body();

                if (getCategoryProgramResponse != null){
                    LoadedCategoryProgramEvent event = new LoadedCategoryProgramEvent(getCategoryProgramResponse.getCategoryProgramList());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetCategoryProgramResponse> call, Throwable t) {
                NetworkErrorEvent networkErrorEvent = new NetworkErrorEvent();
                EventBus.getDefault().post(networkErrorEvent);
            }
        });
    }
}