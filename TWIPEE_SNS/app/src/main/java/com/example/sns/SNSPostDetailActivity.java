package com.example.sns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sns.DataModel.Model_SNS_Post;
import com.example.sns.DataModel.Model_SNS_Post_Like;

import java.util.ArrayList;

public class SNSPostDetailActivity extends AppCompatActivity implements View.OnClickListener {

    //widget
    private ImageView iv_back;
    private TextView tv_title, tv_done;
    private TextView tv_triptype, tv_period, tv_people, tv_traffic, tv_cost;
    ArrayList<Model_SNS_Post> list;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns_detail);
        initView();
        Intent intent = getIntent();
        list = (ArrayList<Model_SNS_Post>)intent.getSerializableExtra("PostInfo");
        position = intent.getExtras().getInt("position");
        setText();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_title.setText(getString(R.string.sns_post_detail__activity));
        tv_done = (TextView) findViewById(R.id.tvDone);
        tv_done.setVisibility(View.GONE);

        iv_back.setOnClickListener(this);
    }

    private void setText(){
        tv_triptype = (TextView) findViewById(R.id.tv_triptype);
        tv_period = (TextView) findViewById(R.id.tv_period);
        tv_people = (TextView) findViewById(R.id.tv_people);
        tv_traffic = (TextView) findViewById(R.id.tv_traffic);
        tv_cost = (TextView) findViewById(R.id.tv_cost);

        tv_triptype.setText(list.get(position).getPostType());
        tv_period.setText(list.get(position).getPeriod());
        tv_people.setText(list.get(position).getMemberNumber());
        tv_traffic.setText(list.get(position).getTraffic());
        tv_cost.setText(list.get(position).getCost());
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
