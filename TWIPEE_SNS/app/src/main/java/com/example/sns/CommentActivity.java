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

import com.example.sns.DataModel.DataModelComment;
import com.example.sns.DataModel.DataModelLike;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<DataModelComment> list = new ArrayList<>();
    private ArrayList<DataModelLike> likes = new ArrayList<>();
    private DataModelComment dataModelComment = new DataModelComment("comment","user_id",likes,"date_created");

    //widget
    private CircleImageView iv_profile_photo;
    private ImageView iv_back;
    private EditText et_addComment;
    private Button btn_addComment;
    private TextView tv_title, tv_done;
    private RecyclerView CommentRecyclerView;

    private CommentRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.backArrow);
        tv_title = (TextView) findViewById(R.id.setTitle);
        tv_title.setText(getString(R.string.comment_activity));
        tv_done = (TextView) findViewById(R.id.tvDone);
        tv_done.setVisibility(View.GONE);
        CommentRecyclerView = (RecyclerView) findViewById(R.id.CommentRecyclerView);
        iv_profile_photo = (CircleImageView) findViewById(R.id.iv_profile_photo);
        et_addComment = (EditText) findViewById(R.id.et_addComment);
        btn_addComment = (Button) findViewById(R.id.btn_addComment);
        initRecyclerViewRefresh();

        iv_back.setOnClickListener(this);
        iv_profile_photo.setOnClickListener(this);
        btn_addComment.setOnClickListener(this);
    }

    private void initRecyclerViewRefresh() {
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        list.add(dataModelComment);
        CommentRecyclerView.setHasFixedSize(true);
        adapter = new CommentRecyclerAdapter(this, list);
        CommentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommentRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backArrow:    //댓글창 끄기
                finish();
                break;
            case R.id.iv_profile_photo:    //유저 페이지로 이동
                Toast.makeText(this,"유저페이지로 이동", Toast.LENGTH_SHORT).show();;
                break;
            case R.id.btn_addComment:    //댓글 달기
                break;
            default:
                break;
        }

    }
}
