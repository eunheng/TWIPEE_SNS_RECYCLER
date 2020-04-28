package com.example.sns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelComment;
import com.example.sns.DataModel.DataModelLike;
import com.example.sns.DataModel.Model_SNS_Post;
import com.example.sns.DataModel.Model_SNS_Post_Comment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<DataModelComment> list = new ArrayList<>();
    private ArrayList<DataModelLike> likes = new ArrayList<>();
    private DataModelComment dataModelComment = new DataModelComment("comment","user_id",likes,"date_created");
    private DatabaseReference mDatabase;

    //widget
    private CircleImageView iv_profile_photo;
    private ImageView iv_back;
    private EditText et_addComment;
    private Button btn_addComment;
    private TextView tv_title, tv_done;
    private RecyclerView CommentRecyclerView;
    private String Key;
    private CommentRecyclerAdapter adapter;
    private ArrayList<Model_SNS_Post_Comment> Postcommentdata = new ArrayList<>();
    private Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        Intent intent = getIntent();
        Key = intent.getExtras().getString("Key");
        loadFirebaseDatabase();
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
//        initRecyclerViewRefresh();

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
//        adapter = new CommentRecyclerAdapter(this, list);
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
                postFirebaseDatabase(true);
                loadFirebaseDatabase();
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/SNS/" + Key + "/CommentCount", Postcommentdata.size()+1);
                mDatabase.updateChildren(childUpdates);
                break;
            default:
                break;
        }
    }

    public void postFirebaseDatabase(boolean add){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String commentkey = mDatabase.child("SNS_POST_COMMENT").child(Key).push().getKey();

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = sdfNow.format(date);

        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            Model_SNS_Post_Comment post_comment = new Model_SNS_Post_Comment(et_addComment.getText().toString(),"종우",formatDate);
            postValues = post_comment.SNS_Post_CommenttoMap();
        }
        childUpdates.put("/SNS_POST_COMMENT/" + Key + "/"+commentkey, postValues);

        mDatabase.updateChildren(childUpdates);
    }

    public void loadFirebaseDatabase(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Postcommentdata = new ArrayList<>();
//                int i = 0;
                for(DataSnapshot item : dataSnapshot.child("SNS_POST_COMMENT").child(Key).getChildren()){
                    Postcommentdata.add(item.getValue(Model_SNS_Post_Comment.class));
                }
                CommentRecyclerView.setHasFixedSize(true);
                CommentRecyclerView.setLayoutManager(new LinearLayoutManager(context));
                adapter = new CommentRecyclerAdapter(context, Postcommentdata);
                CommentRecyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "예상치 못한 오류가 발생했습니다. 다시 실행해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
