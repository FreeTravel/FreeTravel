package com.ma.freetravel.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ma.freetravel.R;
import com.ma.freetravel.url.Url;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * A simple {@link Fragment} subclass.
 */
public class BournFragment extends Fragment {

    private View view;
    private ListView listView_place;
    private String[] adapterData=new String[]{"去哪玩","亚洲","欧洲","北美洲","非洲","南美洲","大洋洲"};
    private ArrayAdapter <String> lvAdapter;

    private String urlPath;


    public BournFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_bourn, container, false);
        initView();
        initAdapter();
        initListener();

        return view;
    }

    private void initAdapter() {
        lvAdapter =new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,adapterData);
        listView_place.setAdapter(lvAdapter);
    }

    private void initView() {
        listView_place = ((ListView) view.findViewById(R.id.lv_place));
    }


    private void initListener() {

        listView_place.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        urlPath= Url.PlayPath;
                        break;
                    case 1:
                        urlPath=Url.AsiaPath;
                        break;
                    case 2:
                        urlPath=Url.EuropePath;
                        break;
                    case 3:
                        urlPath=Url.NorthUSAPath;
                        break;
                    case 4:
                        urlPath=Url.AfricaPath;
                        break;
                    case 5:
                        urlPath=Url.EuropePath;
                        break;
                    case 6:
                        urlPath=Url.OceaniaPath;
                        break;
                }
            }
        });

        httpRequest();
    }

    private void httpRequest() {
        RequestParams params=new RequestParams(urlPath);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
