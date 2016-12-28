package com.minibank;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.minibank.utils.AppPreferences;
import com.minibank.utils.Config;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
    }

    private void startTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AppPreferences preferences = AppPreferences.getAppPreferences(getApplicationContext());
                String userId = preferences.getStringValue(AppPreferences.USER_ID);
                Log.v(TAG, "userId=" + userId);
                if (userId.isEmpty()) {
                    startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                    finishAffinity();
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finishAffinity();
                }
            }
        }, Config.SPLASH_TIME);
    }
}
