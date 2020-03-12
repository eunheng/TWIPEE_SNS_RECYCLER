package com.example.sns;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelLike;
import com.example.sns.DataModel.DataModelSNS;
import com.example.sns.DataModel.DataModelUser;
import com.example.sns.DataModel.DataModelUserSetting;
import com.example.sns.utill.SquareImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class SNSRecyclerAdapter extends RecyclerView.Adapter<SNSRecyclerAdapter.Holder> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private Intent intent;
    private String currentUsername = "";

    private ArrayList<DataModelSNS> list = new ArrayList<>();

    private int temp = 0;

    public SNSRecyclerAdapter(@NonNull Context context, ArrayList<DataModelSNS> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snsview, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;

        //데이터 불러와서 아이템 셋팅
        //유저 이름
        holder.username.setText(list.get(itemposition).getUser_id());
        //게시글 내용 불러오기
        holder.caption.setText(list.get(itemposition).getContent());
        //올린 시간
        holder.timeDetla.setText(list.get(itemposition).getData_created());
        //여행 타입
        holder.tripType.setText(list.get(itemposition).getType());
        //여행 기간
        holder.perioid.setText(list.get(itemposition).getPeriod());
        //여행 인원
        holder.people.setText(list.get(itemposition).getPeople());
        //교통 수단
        holder.traffic.setText(list.get(itemposition).getTraffic());
        //여행 비용
        holder.cost.setText(list.get(itemposition).getCost());

        //아이템 내의 component에 대한 클릭 리스너 정의
        holder.mprofileImage.setOnClickListener(this);
        holder.more.setOnClickListener(this);
        holder.tripticonEmpty.setOnClickListener(this);
        holder.comment.setOnClickListener(this);
        holder.likes.setOnClickListener(this);
        holder.moreContent.setOnClickListener(this);

    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_profile_photo:    //유저 페이지로 이동
                temp = 0;
                break;
            case R.id.iv_more:    //수정/삭제 등 다이얼로그 띄우기
                temp = 1;
                break;
            case R.id.iv_tripticon_empty:    //좋아요 누르기
                temp = 2;
                break;
            case R.id.speech_bubble:    //댓글창으로 이동
                intent = new Intent(view.getContext(), CommentActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.tv_likes:    //좋아요 누른 사람 목록창으로 이동
                temp = 4;
                break;
            case R.id.tv_moreContent:    //더보기 눌러서 내용 더보기
                temp = 5;
                break;
            default:
                break;
        }
    }


    public class Holder extends RecyclerView.ViewHolder {
        CircleImageView mprofileImage;
        TextView username, tripType, perioid, people, traffic, cost, caption, likes, moreContent, timeDetla;

        SquareImageView image;
        ImageView more, tripticonFill, tripticonEmpty, comment;
        boolean likeByCurrentUser;

        DataModelUserSetting DMuserSetting = new DataModelUserSetting();
        DataModelUser DMuser = new DataModelUser();
        DataModelLike DMLike = new DataModelLike();
        DataModelSNS DMSNS = new DataModelSNS();

        public Holder(View view){
            super(view);
            mprofileImage = (CircleImageView) view.findViewById(R.id.iv_profile_photo);
            username = (TextView) view.findViewById(R.id.tv_username);
            more = (ImageView) view.findViewById(R.id.iv_more);
            image = (SquareImageView) view.findViewById(R.id.iv_post);
            tripticonFill = (ImageView) view.findViewById(R.id.iv_tripticon_fill);
            tripticonEmpty = (ImageView) view.findViewById(R.id.iv_tripticon_empty);
            comment = (ImageView) view.findViewById(R.id.speech_bubble);
            likes = (TextView) view.findViewById(R.id.tv_likes);
            caption = (TextView) view.findViewById(R.id.tv_caption);
            tripType = (TextView) view.findViewById(R.id.tv_triptype);
            perioid = (TextView) view.findViewById(R.id.tv_period);
            people = (TextView) view.findViewById(R.id.tv_people);
            traffic = (TextView) view.findViewById(R.id.tv_traffic);
            cost = (TextView) view.findViewById(R.id.tv_cost);
            moreContent = (TextView) view.findViewById(R.id.tv_moreContent);
            timeDetla = (TextView) view.findViewById(R.id.tv_time_posted);
        }
    }
}
