package cn.ljpc.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import cn.ljpc.databinding.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setIdol(new Idol("留洋", "五星"));
        binding.setHander(new EventHandler(this));
        //使用liveData时，需要
        binding.setLifecycleOwner(this);
    }
}