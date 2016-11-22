package com.ma.freetravel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ma.freetravel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    private ViewPager viewPager;
    private RecyclerView rcLv;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        viewPager = ((ViewPager) view.findViewById(R.id.vp_movie));
         rcLv = (RecyclerView) view.findViewById(R.id.rclv_movie);
    }

}
