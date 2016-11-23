package com.ma.freetravel.bean;

import java.io.Serializable;

/**
 * @author :ZJF
 * @version : 2016-11-23 下午 5:33
 */

public class Picture implements Serializable{

    private float oriWidth;
    private float oriHeight;
    private int realWidth;
    private int realHeight;
    private float x;
    private float y;
    private String url;

    public Picture() {
    }

    public Picture(int oriWidth, int oriHeight, int realWidth, int realHeight, int x, int y, String url) {
        this.oriWidth = oriWidth;
        this.oriHeight = oriHeight;
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.x = x;
        this.y = y;
        this.url = url;
    }

    public float getOriWidth() {
        return oriWidth;
    }

    public void setOriWidth(float oriWidth) {
        this.oriWidth = oriWidth;
    }

    public float getOriHeight() {
        return oriHeight;
    }

    public void setOriHeight(float oriHeight) {
        this.oriHeight = oriHeight;
    }

    public int getRealWidth() {
        return realWidth;
    }

    public void setRealWidth(int realWidth) {
        this.realWidth = realWidth;
    }

    public int getRealHeight() {
        return realHeight;
    }

    public void setRealHeight(int realHeight) {
        this.realHeight = realHeight;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
