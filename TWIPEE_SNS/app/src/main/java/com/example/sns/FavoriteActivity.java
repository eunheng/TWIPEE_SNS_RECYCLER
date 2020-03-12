package com.example.sns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FavoriteActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        initView();
    }

    private void initView() {
        btn_done = (Button) findViewById(R.id.done);
        btn_done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.done:    //관심사 적용하기
                finish();
                break;
            default:
                break;
        }

    }

}
