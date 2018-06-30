package xyz.zzp.simplehabit.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import xyz.zzp.simplehabit.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> extends ViewModel{

    protected T mView;

    protected MutableLiveData<String> mErrorLD;

    public void initPresenter(T mView){
        this.mView = mView;
        mErrorLD = new MutableLiveData<>();
    }

    public MutableLiveData<String> getmErrorLD() {
        return mErrorLD;
    }

}
