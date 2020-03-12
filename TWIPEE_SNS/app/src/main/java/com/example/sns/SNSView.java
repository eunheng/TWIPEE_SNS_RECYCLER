package com.example.sns;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sns.DataModel.DataModelComment;
import com.example.sns.DataModel.DataModelLike;
import com.example.sns.DataModel.DataModelSNS;
import com.example.sns.DataModel.DataModelUserSetting;

import java.util.ArrayList;

public class SNSView extends Fragment implements View.OnClickListener{


    private ArrayList<DataModelSNS> list = new ArrayList<>();
    private ArrayList<String> category = new ArrayList<>();
    private ArrayList<DataModelLike> likes = new ArrayList<>();
    private ArrayList<DataModelComment> comments = new ArrayList<>();

    private DataModelSNS dataModelSNS = new DataModelSNS("type","data_created", "user_id", "10", "content", "image_path", "photo_id", "step", "cost", "period", "traffic", category, likes, comments);

    //widget
    private EditText et_feedSearchBox;
    private Button btn_feedSearch;
    private TextView tv_favorite;
    private RecyclerView recyclerView;

    private SNSRecyclerAdapter adapter;
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

        initRecyclerViewRefresh();


        return view;
    }

    private void initRecyclerViewRefresh() {
        list.add(dataModelSNS);
        list.add(dataModelSNS);
        recyclerView.setHasFixedSize(true);
        adapter = new SNSRecyclerAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
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


}
