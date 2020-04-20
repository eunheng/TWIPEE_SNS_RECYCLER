package com.example.sns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.sns.utill.SquareImageView;

public class SNSPostViewPager extends Fragment {

    private SquareImageView iv_post;

    public SNSPostViewPager() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_snspost_viewpager , container , false);
        iv_post = (SquareImageView) view.findViewById(R.id.iv_post);

        if (getArguments() != null) {
            Bundle args = getArguments();
            //받아온 Resource를 ImageView로
            Glide.with(this).load(args.getString("imgRes")).into(iv_post);
            //iv_post.setImageResource(args.getString("imgRes"));
        }

        return view;
    }
}
