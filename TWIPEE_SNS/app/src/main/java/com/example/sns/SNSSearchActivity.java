package com.example.sns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.DataModel.Model_SNS_Post;

import java.util.ArrayList;

public class SNSSearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title, tv_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snssearch);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_title.setText(getText(R.string.search_activity));
        tv_done = (TextView) findViewById(R.id.tvDone);
        iv_back.setOnClickListener(this);
        tv_done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backArrow:    //검색창 끄기
                finish();
                break;
            case R.id.btn_addComment:    //검색 적용하기
                break;
            default:
                break;
        }

    }
}
