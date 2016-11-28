package com.ma.freetravel.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.ma.freetravel.R;
import com.ma.freetravel.adapter.CountryAdapter;
import com.ma.freetravel.bean.PlaceBean;
import com.ma.freetravel.ui.CountryActivity;
import com.ma.freetravel.ui.QueryActivity;
import com.ma.freetravel.url.Url;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BournFragment extends Fragment {

    private View view;
    private ListView listView_place;
    private String[] adapterData=new String[]{"去哪玩","亚洲","欧洲","北美洲","非洲","南美洲","大洋洲"};
    private ArrayAdapter <String> lvAdapter;
    private String urlPath=Url.PlayPath;
    private RecyclerView recyclerView_place;
    private List<PlaceBean.DataBean> datas=new ArrayList<>();
    private CountryAdapter countryAdapter;
    private EditText et_input;
    private Button btn_click;

    public BournFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_bourn, container, false);
        initView();
        initButtonTurn();
        httpRequest(urlPath);
        initAdapter();
        initListener();
        return view;
    }

    private void initButtonTurn() {

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QueryActivity.class);
                String city = et_input.getText().toString().trim();
                intent.putExtra("city",city);
                getActivity().startActivity(intent);
            }
        });
    }

    private void initTurn() {
        countryAdapter.setOnItemClickCallBack(new CountryAdapter.OnItemClickCallBack() {
            @Override
            public void OnItemClickLister(View view, int pos) {
                Intent intent=new Intent(getActivity(), CountryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        lvAdapter =new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,adapterData);
        listView_place.setAdapter(lvAdapter);
    }

    private void initView() {
        listView_place = ((ListView) view.findViewById(R.id.lv_place));
        recyclerView_place = ((RecyclerView) view.findViewById(R.id.rv_place));
        et_input = ((EditText) view.findViewById(R.id.et_input));
        btn_click = ((Button) view.findViewById(R.id.btn_click));
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
                        urlPath=Url.NorthUSAPath;
                        break;
                    case 6:
                        urlPath=Url.OceaniaPath;
                        break;
                }
                httpRequest(urlPath);
            }
        });


    }

    private void httpRequest(String urlPath) {
        RequestParams params=new RequestParams(urlPath);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson=new Gson();
                PlaceBean placeBean=gson.fromJson(result, PlaceBean.class);
                datas.addAll(placeBean.getData());
                countryAdapter=new CountryAdapter(getContext(),placeBean);
                recyclerView_place.setAdapter(countryAdapter);
                GridLayoutManager gridlayoutManager = new GridLayoutManager(getActivity(), 3);
                gridlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView_place.setLayoutManager(gridlayoutManager);
                initTurn();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("ssss","err");
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
