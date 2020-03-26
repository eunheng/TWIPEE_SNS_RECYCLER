package com.example.sns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelLike;

import java.util.ArrayList;

public class LikeUserActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<DataModelLike> likes = new ArrayList<>();
    private DataModelLike dataModelLike = new DataModelLike("NSLB");

    //widget
    private ImageView iv_back;
    private TextView tv_title, tv_done;
    private RecyclerView LikeUserRecyclerView;

    private LikeUserRecyclerAdapter adapter;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likeuserlist);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_title.setText(getString(R.string.likeuser_activity));
        tv_done = (TextView) findViewById(R.id.tvDone);
        tv_done.setVisibility(View.GONE);
        LikeUserRecyclerView = (RecyclerView) findViewById(R.id.like_user_list);
        initRecyclerViewRefresh();

        iv_back.setOnClickListener(this);

    }

    private void initRecyclerViewRefresh() {
        likes.add(dataModelLike);
        likes.add(dataModelLike);
        likes.add(dataModelLike);
        likes.add(dataModelLike);
        LikeUserRecyclerView.setHasFixedSize(true);
        adapter = new LikeUserRecyclerAdapter(this,likes);
        LikeUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LikeUserRecyclerView.setAdapter(adapter);
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
