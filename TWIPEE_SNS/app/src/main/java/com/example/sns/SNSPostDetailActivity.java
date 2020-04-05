package com.example.sns;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SNSPostDetailActivity extends AppCompatActivity implements View.OnClickListener {

    //widget
    private ImageView iv_back;
    private TextView tv_title, tv_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_detail);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_title.setText(getString(R.string.sns_post_detail__activity));
        tv_done = (TextView) findViewById(R.id.tvDone);
        tv_done.setVisibility(View.GONE);

        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backArrow:    //창 끄기
                finish();
                break;
            default:
                break;
        }
    }
}
