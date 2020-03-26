package com.example.sns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelComment;
import com.example.sns.DataModel.DataModelLike;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

class LikeUserRecyclerAdapter extends RecyclerView.Adapter<LikeUserRecyclerAdapter.Holder> implements View.OnClickListener {

    private Context mContext;
    private  ArrayList<DataModelLike> likes = new ArrayList<>();

    public LikeUserRecyclerAdapter(@NonNull Context context, ArrayList<DataModelLike> likes) {
        this.mContext = context;
        this.likes = likes;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_likeuser,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LikeUserRecyclerAdapter.Holder holder, int position) {
        int itemposition = position;

        //유저 이름
        holder.username.setText(likes.get(itemposition).getUser_id());

        holder.username.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return likes.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_username:    //유저 페이지로 이동
                Toast.makeText(mContext,"유저페이지로 이동", Toast.LENGTH_SHORT).show();;
                break;
            default:
                break;
        }

    }
    public class Holder extends RecyclerView.ViewHolder {

        CircleImageView mprofileImage;
        TextView username;


        public Holder(@NonNull View itemView) {
            super(itemView);
            mprofileImage = (CircleImageView) itemView.findViewById(R.id.iv_profile_photo);
            username = (TextView) itemView.findViewById(R.id.tv_username);
        }
    }
}
