package com.example.sns;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.Model_SNS_Post;
import com.example.sns.DataModel.DataModelUserSetting;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SNSView extends Fragment implements View.OnClickListener{

    private DatabaseReference mDatabase;
    private ArrayList<Model_SNS_Post> Postdata = new ArrayList<>();
    private ArrayList<String> Postkey = new ArrayList<>();
    private HashMap<String, Model_SNS_Post> SNS_Post_list = new HashMap<String, Model_SNS_Post>();
    private HashMap<String, String> category1 = new HashMap<>();
    private HashMap<String, String> category2 = new HashMap<>();
    private HashMap<String, String> category3 = new HashMap<>();
    private HashMap<String, String> category4 = new HashMap<>();
    private HashMap<String, String> listImage = new HashMap<>();


    //widget
    private EditText et_feedSearchBox;
    private Button btn_feedSearch;
    private TextView tv_favorite;
    private RecyclerView recyclerView;

    private SNSRecyclerAdapter adapter;
    private FragmentManager fm;
    private Intent intent;
    private int resultsCount = 0;
    private ArrayList<DataModelUserSetting> DMUserSetting;

    public SNSView() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snsview, container, false);
        btn_feedSearch = (Button) view.findViewById(R.id.btn_feedSearch);
        tv_favorite = (TextView) view.findViewById(R.id.tv_favorite);
        btn_feedSearch.setOnClickListener(this);
        tv_favorite.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.SNSListView);
        //postFirebaseDatabase(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int i = 0;
                for(DataSnapshot item : dataSnapshot.child("SNS").getChildren()){
                    Postkey.add(item.getKey());
                    Postdata.add(item.getValue(Model_SNS_Post.class));
                    SNS_Post_list.put(Postkey.get(i),Postdata.get(i));
                    i++;
                }
//                oldestPostId = oldlist_get.get(0);
                fm = getActivity().getSupportFragmentManager();
                recyclerView.setHasFixedSize(true);
                adapter = new SNSRecyclerAdapter(getActivity(), SNS_Post_list,fm );
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "예상치 못한 오류가 발생했습니다. 다시 실행해주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //마지막 체크
                if(!recyclerView.canScrollVertically(1)){
//                    if(list_get.size()==3){
////                        pd.setMessage("더 불러오는 중...");
////                        pd.show();
//                    }
//                    mDatabase.orderByKey().endAt(oldestPostId).limitToLast(3).addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            list_get.clear(); //임시저장 위치
//                            oldlist_get.clear();
//
//                            for (DataSnapshot item : dataSnapshot.getChildren()) {
//                                list_get.add(0,item.getValue(Model_SNS_Post.class));
//                                oldlist_get.add(item.getKey());
//                            }
//                            //불러오는 중인지, 전부 불러왔는지 if문
//                            if(list_get.size() > 1) {//1개라도 있으면 불러옴
//                                //마지막 중복되는 부분 삭제
//                                list_get.remove(0);
//                                //contents 뒤에 추가
//                                list.addAll(list_get);
//                                oldestPostId = oldlist_get.get(0);
//                                //메시지 갱신 위치
//                                adapter.notifyDataSetChanged();
//                            } else {
                    Toast.makeText(getActivity(), "마지막입니다", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//                        }
//                    });
                }
            }
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_feedSearch:
                intent = new Intent(getActivity(), SNSSearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_favorite:
                intent = new Intent(getActivity(), FavoriteActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void postFirebaseDatabase(boolean add){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key = mDatabase.child("SNS").push().getKey();
        addDumydata();

        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            Model_SNS_Post post = new Model_SNS_Post("PostType8", "CreatedData8", "PublisherID8", "Body8", "MapImage8", "Step8", "Period8", "MemberNumber8", "Cost8", "Traffic8", listImage, category4,0,0);
            postValues = post.SNStoMap();
        }
        childUpdates.put("/SNS/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }


    private void addDumydata(){
        category1.put("category1", "A");
        category1.put("category2", "B");
        category1.put("category3", "C");
        category2.put("category1", "B");
        category2.put("category2", "C");
        category2.put("category3", "D");
        category3.put("category1", "D");
        category3.put("category2", "E");
        category3.put("category3", "D");
        category4.put("category2", "F");
        category4.put("category3", "g");

        listImage.put("image1", String.valueOf(R.drawable.chico1));
        listImage.put("image2", String.valueOf(R.drawable.toystory));
        listImage.put("image3", String.valueOf(R.drawable.parking));
    }

}
