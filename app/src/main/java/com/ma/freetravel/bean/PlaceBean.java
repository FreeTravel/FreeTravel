package com.ma.freetravel.bean;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/22.
 */
public class PlaceBean {

    /**
     * code : 200
     * message :
     * data : [{"place_id":"2012","place_name":"韩国","place_name_en":"South Korea","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/84229d9d95fc2b1d4a4638d506932aa5_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2007","place_name":"泰国","place_name_en":"Thailand","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/92f1f99bef251810582d9a22a5081591_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2005","place_name":"日本","place_name_en":"Japan","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/2010f77d08b15bde06d550f5b52fe548_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2013","place_name":"新加坡","place_name_en":"Singapore","open":"1","board_id":"96","cover_image":"http://qimages.b0.upaiyun.com/717b9c4cc82d17ce3cc40d62a6410d25_medium.jpg","booking_count":"120","is_country":false,"is_city":true,"has_booking":true,"has_board":true},{"place_id":"2011","place_name":"马来西亚","place_name_en":"Malaysia","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/d4ad68d18ddba9e30b5bfa63e15c6a07_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2014","place_name":"柬埔寨","place_name_en":"Cambodia","open":"1","board_id":"126","cover_image":"http://qimages.b0.upaiyun.com/f03ba3b60f26de2d4e8714749962cd78_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":true},{"place_id":"2016","place_name":"斯里兰卡","place_name_en":"Sri Lanka","open":"1","board_id":"520","cover_image":"http://qimages.b0.upaiyun.com/71f0948de434a90c9b4b79d08523e659_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":true},{"place_id":"2003","place_name":"阿联酋","place_name_en":"United Arab Emirates","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/a3d70ae6d1c0ba531f0ca2f3db70434a_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2010","place_name":"越南","place_name_en":"Vietnam","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/7d5f63f0b9410c7ecfa66b5f627984e8_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2008","place_name":"菲律宾","place_name_en":"Philippines","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/7db996c7e86e0e69487713f6fc703f06_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2001","place_name":"塞班岛","place_name_en":"Saipan","open":"1","board_id":"116","cover_image":"http://qimages.b0.upaiyun.com/139f3ab3b3f92c653260aeedd1cf6b5f_medium.jpg","booking_count":"18","is_country":false,"is_city":true,"has_booking":true,"has_board":true},{"place_id":"2002","place_name":"马尔代夫","place_name_en":"Maldives","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/4b26c6e3bc5488941161117adf6d42a7_medium.jpg","booking_count":"207","is_country":false,"is_city":true,"has_booking":true,"has_board":false},{"place_id":"2006","place_name":"印度","place_name_en":"India","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/74282447c1ebb5de1eada92e58f4a336_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},{"place_id":"2009","place_name":"印度尼西亚","place_name_en":"Indonesia","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/717fd0a5d3c5f268ababddf82d6a8dde_medium.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false}]
     */

    private int code;
    private String message;
    /**
     * place_id : 2012
     * place_name : 韩国
     * place_name_en : South Korea
     * open : 1
     * board_id : 0
     * cover_image : http://qimages.b0.upaiyun.com/84229d9d95fc2b1d4a4638d506932aa5_medium.jpg
     * booking_count : 0
     * is_country : true
     * is_city : false
     * has_booking : false
     * has_board : false
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String place_id;
        private String place_name;
        private String place_name_en;
        private String open;
        private String board_id;
        private String cover_image;
        private String booking_count;
        private boolean is_country;
        private boolean is_city;
        private boolean has_booking;
        private boolean has_board;

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public String getPlace_name() {
            return place_name;
        }

        public void setPlace_name(String place_name) {
            this.place_name = place_name;
        }

        public String getPlace_name_en() {
            return place_name_en;
        }

        public void setPlace_name_en(String place_name_en) {
            this.place_name_en = place_name_en;
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getBoard_id() {
            return board_id;
        }

        public void setBoard_id(String board_id) {
            this.board_id = board_id;
        }

        public String getCover_image() {
            return cover_image;
        }

        public void setCover_image(String cover_image) {
            this.cover_image = cover_image;
        }

        public String getBooking_count() {
            return booking_count;
        }

        public void setBooking_count(String booking_count) {
            this.booking_count = booking_count;
        }

        public boolean isIs_country() {
            return is_country;
        }

        public void setIs_country(boolean is_country) {
            this.is_country = is_country;
        }

        public boolean isIs_city() {
            return is_city;
        }

        public void setIs_city(boolean is_city) {
            this.is_city = is_city;
        }

        public boolean isHas_booking() {
            return has_booking;
        }

        public void setHas_booking(boolean has_booking) {
            this.has_booking = has_booking;
        }

        public boolean isHas_board() {
            return has_board;
        }

        public void setHas_board(boolean has_board) {
            this.has_board = has_board;
        }
    }
}
