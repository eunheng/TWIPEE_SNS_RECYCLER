package com.example.sns;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.sns.DataModel.Model_SNS_Post;
import com.example.sns.DataModel.DataModelUser;
import com.example.sns.DataModel.DataModelUserSetting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class SNSRecyclerAdapter extends RecyclerView.Adapter<SNSRecyclerAdapter.Holder> /*implements View.OnClickListener*/ {
    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutResource;
    private Intent intent;
    private String currentUsername = "";
    private FragmentManager fm;

    // 임시로 Fragment로 넘길 Image Resource
    ArrayList<Integer> listImage;
    ArrayList<String> listImage2;
    private int intViewpager;
    private String strViewpager;

    private ArrayList<Model_SNS_Post> list = new ArrayList<>();

    private int temp = 0;

    public SNSRecyclerAdapter(@NonNull Context context, ArrayList<Model_SNS_Post> list, FragmentManager fragmentManager) {
        this.mContext = context;
        this.list = list;
        this.fm = fragmentManager;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snsview, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;

        //데이터 불러와서 아이템 셋팅
        //유저 이름
        holder.PublisherID.setText(list.get(itemposition).getPublisherID());
        //게시글 내용 불러오기
        holder.Body.setText(list.get(itemposition).getBody());
        //올린 시간
        holder.timeDetla.setText(list.get(itemposition).getCreatedData());
//        //여행 타입
//        holder.tripType.setText(list.get(itemposition).getType());
//        //여행 기간
//        holder.perioid.setText(list.get(itemposition).getPeriod());
//        //여행 인원
//        holder.people.setText(list.get(itemposition).getPeople());
//        //교통 수단
//        holder.traffic.setText(list.get(itemposition).getTraffic());
//        //여행 비용
//        holder.cost.setText(list.get(itemposition).getCost());

//        //image viewpager 임시 데이터
//        listImage = new ArrayList<>();
//        listImage.add(R.drawable.chico1);
//        listImage.add(R.drawable.toystory);
//        listImage.add(R.drawable.parking);
        //ImageView pager
//        holder.vp_post.setAdapter(holder.pagerAdapter);
//        if(listImage.size()!=0)
//        {
//            holder.vp_post.setVisibility(View.VISIBLE);
//            for (int i = 0; i < listImage.size(); i++) {
//                SNSPostViewPager postViewPager = new SNSPostViewPager();
//                Bundle bundle = new Bundle();
//                bundle.putInt("imgRes", listImage.get(i));
//                postViewPager.setArguments(bundle);
//                holder.pagerAdapter.addImage(postViewPager);
//            }
//            holder.pagerAdapter.notifyDataSetChanged();
//        }
//        else
//        {
//            holder.vp_post.setVisibility(View.GONE);
//        }

        //이미지 배열
        listImage = new ArrayList<>();
        listImage2 = new ArrayList<>();

        //torageReference storageReference = FirebaseStorage.getInstance().getReference();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl("gs://snsview-75df8.appspot.com/");

        //다운로드할 파일을 가르키는 참조 만들기
        StorageReference pathReference = storageReference.child("/");

        //Url을 다운받기
        pathReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Toast.makeText(mContext.getApplicationContext(), "다운로드 성공 : "+ uri, Toast.LENGTH_SHORT).show();
                listImage2.add(uri.toString());

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(mContext.getApplicationContext(), "다운로드 실패", Toast.LENGTH_SHORT).show();
            }
        });


        //image viewpager 임시 데이터(파이어베이스에 저장된 사진 갯수를 어떻게 알 수 있지)
        //저장소 주소는 알아냈는데 그 아래 복수의 이미지를 어케 가지고 올 것인가....

        //strViewpager = Glide.with(mContext).load(storageReference).toString();
        //인트형으로 변환
//        intViewpager = Integer.parseInt(strViewpager);
//        //
        //ImageView pager
        holder.vp_post.setAdapter(holder.pagerAdapter);
        if(listImage2.size()!=0)
        {
            holder.vp_post.setVisibility(View.VISIBLE);
            for (int i = 0; i < listImage2.size(); i++) {
                SNSPostViewPager postViewPager = new SNSPostViewPager();
                Bundle bundle = new Bundle();
                bundle.putString("imgRes", listImage2.get(i));
                postViewPager.setArguments(bundle);
                holder.pagerAdapter.addImage(postViewPager);
            }
            holder.pagerAdapter.notifyDataSetChanged();
        }
        else
        {
            holder.vp_post.setVisibility(View.GONE);
        }






        //아이템 내의 component에 대한 클릭 리스너 정의
//        holder.PublisherID.setOnClickListener(this);
//        holder.more.setOnClickListener(this);
//        holder.tripticonEmpty.setOnClickListener(this);
//        holder.comment.setOnClickListener(this);
//        holder.likes.setOnClickListener(this);
//        holder.moreContent.setOnClickListener(this);

        holder.PublisherID.setOnClickListener(new View.OnClickListener() {//유저 페이지로 이동
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "유저페이지로 이동" + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.more.setOnClickListener(new View.OnClickListener() {//수정/삭제 등 다이얼로그 띄우기
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"게시물 옵션 더보기", Toast.LENGTH_SHORT).show();
            }
        });
        holder.tripticonEmpty.setOnClickListener(new View.OnClickListener() {//좋아요 누르기
            @Override
            public void onClick(View v) {
                temp = 2;
            }
        });
        holder.comment.setOnClickListener(new View.OnClickListener() {//댓글창으로 이동
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), CommentActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.likes.setOnClickListener(new View.OnClickListener() {//좋아요 누른 사람 목록창으로 이동
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(),LikeUserActivity.class);
                mContext.startActivity(intent);
            }
        });
        holder.moreContent.setOnClickListener(new View.OnClickListener() {//게시물 상세 보기
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(),SNSPostDetailActivity.class);
                intent.putExtra("PostInfo",list);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    public class Holder extends RecyclerView.ViewHolder {
        CircleImageView mprofileImage;
        //TextView username, tripType, perioid, people, traffic, cost, caption, likes, moreContent, timeDetla;
        TextView PublisherID, Body, likes, moreContent, timeDetla;

        //SquareImageView image;
        ViewPager vp_post;
        SNSPostViewPagerAdapter pagerAdapter;
        ImageView more, tripticonFill, tripticonEmpty, comment;
        boolean likeByCurrentUser;

        DataModelUserSetting DMuserSetting = new DataModelUserSetting();
        DataModelUser DMuser = new DataModelUser();
        //DataModelLike DMLike = new DataModelLike();
        Model_SNS_Post DMSNS = new Model_SNS_Post();


        public Holder(View view){
            super(view);
            mprofileImage = (CircleImageView) view.findViewById(R.id.iv_profile_photo);
            PublisherID = (TextView) view.findViewById(R.id.tv_username);
            more = (ImageView) view.findViewById(R.id.iv_more);
            //image = (SquareImageView) view.findViewById(R.id.iv_post);
            vp_post = (ViewPager) view.findViewById(R.id.vp_post);
            pagerAdapter = new SNSPostViewPagerAdapter(fm);
            tripticonFill = (ImageView) view.findViewById(R.id.iv_tripticon_fill);
            tripticonEmpty = (ImageView) view.findViewById(R.id.iv_tripticon_empty);
            comment = (ImageView) view.findViewById(R.id.speech_bubble);
            likes = (TextView) view.findViewById(R.id.tv_likes);
            Body = (TextView) view.findViewById(R.id.tv_caption);
            moreContent = (TextView) view.findViewById(R.id.tv_moreContent);
            timeDetla = (TextView) view.findViewById(R.id.tv_time_posted);
        }


    }
}
