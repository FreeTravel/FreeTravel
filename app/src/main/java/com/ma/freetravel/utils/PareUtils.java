package com.ma.freetravel.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.ma.freetravel.bean.MovieAlbum;
import com.ma.freetravel.bean.MovieBanner;
import com.ma.freetravel.bean.MovieLv;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tian on 2016/11/24.
 */

public class PareUtils {
    public static List<MovieBanner> getMoiveBanner(String jsonString){
        List<MovieBanner> movieBanners=new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                MovieBanner movieBanner = new MovieBanner();
                movieBanner.parseData(jsonArray.getJSONObject(i));
                movieBanners.add(movieBanner);
            }
            return movieBanners;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Object> getBean(String jsonString,Object object) {
        List<Object> objects = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                if (object.equals(MovieBanner.class))
                    object=new MovieBanner();
                    ((MovieBanner) object).parseData(jsonArray.getJSONObject(i));
                objects.add(object);
            }
            return objects;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //Gson解析[]
    public static List getData1(String jsonString, Object object){
        Gson gson = new Gson();
        if (object.equals(FlagData.FLAG_MOVIEBANNER)){
            List<MovieBanner>  movieBanners = gson.fromJson(jsonString, new TypeToken<List<MovieBanner>>() {}.getType());
            return movieBanners;
        }else if (object.equals(FlagData.FLAG_MOVIELV)){
            List<MovieLv>  movieLvs=gson.fromJson(jsonString, new TypeToken<List<MovieLv>>() {
            }.getType());
            return movieLvs;
        }else if (object.equals(FlagData.FLAG_MOVIEALBUM)){
            List<MovieAlbum> movieAlba=gson.fromJson(jsonString,new TypeToken<List<MovieAlbum>>(){}.getType());
            return movieAlba;
        }else if (object.equals(FlagData.FLAG_MOVIEALBUMDETAIL)){
            List<MovieLv> alumDetails=gson.fromJson(jsonString,new TypeToken<List<MovieLv>>(){}.getType());
            return alumDetails;
        }
       return null;
    }
    //Gson解析{}
    public static Object getData2(String jsonString, Object object) {
        Gson gson = new Gson();
         object = gson.fromJson(jsonString, Object.class);
        return object;
    }
}
