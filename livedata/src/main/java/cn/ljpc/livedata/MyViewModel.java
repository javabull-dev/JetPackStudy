package cn.ljpc.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> time;

    public MutableLiveData<Integer> getTime() {
        if (time == null) {
            time = new MutableLiveData<>();
            time.setValue(0);
        }
        return time;
    }
}
