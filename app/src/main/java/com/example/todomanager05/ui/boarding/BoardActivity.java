package com.example.todomanager05.ui.boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.todomanager05.MainActivity;
import com.example.todomanager05.R;
import com.example.todomanager05.databinding.ActivityBoardBinding;
import com.example.todomanager05.utils.Constants;

public class BoardActivity extends AppCompatActivity {

    private ActivityBoardBinding binding;
    boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkShow();
        initViewPager();
    }

    private void checkShow() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.IS_SHOW_FILE, MODE_PRIVATE);
        isShow= sharedPreferences.getBoolean(Constants.IS_SHOW,false);
        if (isShow) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void initViewPager() {
        binding.viewPagerBoard.setAdapter(new BoardAdapter(getSupportFragmentManager()));
    }
}