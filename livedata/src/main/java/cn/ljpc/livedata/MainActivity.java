package cn.ljpc.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;

    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeView = findViewById(R.id.time);

        viewModel = new ViewModelProvider(
                this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        viewModel.getTime().observe(this, time -> {
            timeView.setText(String.valueOf(time));
        });

        setTimer();
    }

    private void setTimer() {
        new Timer("我是一个定时器").schedule(new TimerTask() {
            @Override
            public void run() {
                viewModel.getTime().postValue(viewModel.getTime().getValue() + 1);
            }
        }, 0, 1000);
    }

    public void doAdd(View view){
        viewModel.getTime().postValue(viewModel.getTime().getValue() + 1);
    }
}