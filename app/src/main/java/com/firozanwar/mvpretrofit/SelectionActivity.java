package com.firozanwar.mvpretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.firozanwar.mvpretrofit.basicmvp.view.BasicMVPActivity;
import com.firozanwar.mvpretrofit.mvpwithretrofit.MVPwithRetrofitActivity;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Button btn = findViewById(R.id.btn_basic_mvp);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(SelectionActivity.this, BasicMVPActivity.class));
        });
        btn = findViewById(R.id.btn_mvp_retrofit);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(SelectionActivity.this, MVPwithRetrofitActivity.class));
        });
    }
}
