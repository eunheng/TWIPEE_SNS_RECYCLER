package com.example.sns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelComment;
import com.example.sns.DataModel.DataModelLike;
import com.example.sns.DataModel.DataModelSNS;
import com.example.sns.DataModel.DataModelUser;
import com.example.sns.DataModel.DataModelUserSetting;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.Holder> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private Intent intent;
    private String currentUsername = "";

    private ArrayList<DataModelComment> list = new ArrayList<>();

    private int temp = 0;

    public CommentRecyclerAdapter(@NonNull Context context, ArrayList<DataModelComment> list){
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commentview,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int itemposition = position;

        //유저 이름
        holder.username.setText(list.get(itemposition).getUser_id());
        //댓글 내용
        holder.comment.setText(list.get(itemposition).getComment());
        //올린 시간
        holder.timeDetla.setText(list.get(itemposition).getDate_created());

        //아이템 내의 component에 대한 클릭 리스너 정의
        holder.username.setOnClickListener(this);
        holder.like.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_username:    //유저 페이지로 이동
                Toast.makeText(mContext,"유저페이지로 이동", Toast.LENGTH_SHORT).show();;
                break;
            case R.id.iv_like:    //좋아요 누르기
                temp = 2;
                break;
            default:
                break;
        }
    }

    public class Holder extends RecyclerView.ViewHolder {

        CircleImageView mprofileImage;
        TextView username, comment, timeDetla;
        ImageView like;
        boolean likeByCurrentUser;

        DataModelUserSetting DMUserSetting = new DataModelUserSetting();
        DataModelUser DMUser = new DataModelUser();
        //DataModelLike DMLike = new DataModelLike();
        DataModelSNS DMSNS = new DataModelSNS();

        public Holder(View view) {
            super(view);
            mprofileImage = (CircleImageView) view.findViewById(R.id.iv_profile_photo);
            username = (TextView) view.findViewById(R.id.tv_username);
            comment = (TextView) view.findViewById(R.id.tv_comment);
            timeDetla = (TextView) view.findViewById(R.id.tv_commentCreated);
            like = (ImageView) view.findViewById(R.id.iv_like);


        }
    }
}
