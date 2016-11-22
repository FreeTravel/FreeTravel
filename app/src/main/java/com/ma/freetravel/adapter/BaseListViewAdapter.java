package com.ma.freetravel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author :ZJF
 * @version : 2016-11-01 下午 7:01
 */

public abstract class BaseListViewAdapter<T> extends BaseAdapter {

    private LayoutInflater inflater;
    private List<T> data;
    private Context context;

    public BaseListViewAdapter(List<T> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);

    public LayoutInflater getInflater() {
        return inflater;
    }

    /**
     * 直接添加新数据
     * @param data
     */
    public void addData(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    //清空后，添加新数据
    public void refulshData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
