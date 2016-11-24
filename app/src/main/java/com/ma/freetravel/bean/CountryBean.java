package com.ma.freetravel.bean;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/22.
 */
public class CountryBean {

    /**
     * code : 200
     * message :
     * data : {"country_info":{"place_id":"4003","place_name":"法国","place_name_en":"France","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/d8ab73a0baea0cf718c8a635868a2788_big.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false},"other_info":{"footer":{"img_url":"http://qimages.b0.upaiyun.com/24784a5a414c873891d2feeaf81999e5","download_url":"http://a.app.qq.com/o/simple.jsp?pkgname=com.qiugonglue.qgl_tourismguide"},"shejieyou_mall":{"coupon_url":"http://m.shijieyou.com/mobile/couponLanding","mall_url":"http://www.qiugonglue.com/api/v3/client/shijieyou_mall?place_id=4003"}},"city_list":[{"place_id":"4003001","place_name":"巴黎","place_name_en":"Paris","open":"1","board_id":"525","cover_image":"http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c_medium.jpg","booking_count":"3326","is_country":false,"is_city":true,"has_booking":true,"has_board":true,"national_cover_image":"http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c"},{"place_id":"4003010","place_name":"阿维尼翁","place_name_en":"Avignon","open":"1","board_id":"528","cover_image":"http://qimages.b0.upaiyun.com/7a63f214b1df8c71c99092f08426a748_medium.jpg","booking_count":"131","is_country":false,"is_city":true,"has_booking":true,"has_board":true},{"place_id":"4003002","place_name":"马赛","place_name_en":"Marseille","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/da053169798b72e32fddf729691e0dbb_medium.jpg","booking_count":"239","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"2995468"},{"place_id":"4003003","place_name":"波尔多","place_name_en":"Bordeaux","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/676991bb5e4b35d05d523c6a21071c8c_medium.jpg","booking_count":"202","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"3031580"},{"place_id":"4003004","place_name":"尼斯","place_name_en":"Nice","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/7f0590f02ec92c5380aa1dee1c982b9c_medium.jpg","booking_count":"756","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"2990440"},{"place_id":"4003005","place_name":"里昂","place_name_en":"Lyon","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/03f83d8baf00a09f19c39fe805f4bce8_medium.jpg","booking_count":"299","is_country":false,"is_city":true,"has_booking":true,"has_board":false}]}
     */

    private int code;
    private String message;
    /**
     * country_info : {"place_id":"4003","place_name":"法国","place_name_en":"France","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/d8ab73a0baea0cf718c8a635868a2788_big.jpg","booking_count":"0","is_country":true,"is_city":false,"has_booking":false,"has_board":false}
     * other_info : {"footer":{"img_url":"http://qimages.b0.upaiyun.com/24784a5a414c873891d2feeaf81999e5","download_url":"http://a.app.qq.com/o/simple.jsp?pkgname=com.qiugonglue.qgl_tourismguide"},"shejieyou_mall":{"coupon_url":"http://m.shijieyou.com/mobile/couponLanding","mall_url":"http://www.qiugonglue.com/api/v3/client/shijieyou_mall?place_id=4003"}}
     * city_list : [{"place_id":"4003001","place_name":"巴黎","place_name_en":"Paris","open":"1","board_id":"525","cover_image":"http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c_medium.jpg","booking_count":"3326","is_country":false,"is_city":true,"has_booking":true,"has_board":true,"national_cover_image":"http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c"},{"place_id":"4003010","place_name":"阿维尼翁","place_name_en":"Avignon","open":"1","board_id":"528","cover_image":"http://qimages.b0.upaiyun.com/7a63f214b1df8c71c99092f08426a748_medium.jpg","booking_count":"131","is_country":false,"is_city":true,"has_booking":true,"has_board":true},{"place_id":"4003002","place_name":"马赛","place_name_en":"Marseille","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/da053169798b72e32fddf729691e0dbb_medium.jpg","booking_count":"239","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"2995468"},{"place_id":"4003003","place_name":"波尔多","place_name_en":"Bordeaux","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/676991bb5e4b35d05d523c6a21071c8c_medium.jpg","booking_count":"202","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"3031580"},{"place_id":"4003004","place_name":"尼斯","place_name_en":"Nice","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/7f0590f02ec92c5380aa1dee1c982b9c_medium.jpg","booking_count":"756","is_country":false,"is_city":true,"has_booking":true,"has_board":false,"weather_id":"2990440"},{"place_id":"4003005","place_name":"里昂","place_name_en":"Lyon","open":"1","board_id":"0","cover_image":"http://qimages.b0.upaiyun.com/03f83d8baf00a09f19c39fe805f4bce8_medium.jpg","booking_count":"299","is_country":false,"is_city":true,"has_booking":true,"has_board":false}]
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * place_id : 4003
         * place_name : 法国
         * place_name_en : France
         * open : 1
         * board_id : 0
         * cover_image : http://qimages.b0.upaiyun.com/d8ab73a0baea0cf718c8a635868a2788_big.jpg
         * booking_count : 0
         * is_country : true
         * is_city : false
         * has_booking : false
         * has_board : false
         */

        private CountryInfoBean country_info;
        /**
         * footer : {"img_url":"http://qimages.b0.upaiyun.com/24784a5a414c873891d2feeaf81999e5","download_url":"http://a.app.qq.com/o/simple.jsp?pkgname=com.qiugonglue.qgl_tourismguide"}
         * shejieyou_mall : {"coupon_url":"http://m.shijieyou.com/mobile/couponLanding","mall_url":"http://www.qiugonglue.com/api/v3/client/shijieyou_mall?place_id=4003"}
         */

        private OtherInfoBean other_info;
        /**
         * place_id : 4003001
         * place_name : 巴黎
         * place_name_en : Paris
         * open : 1
         * board_id : 525
         * cover_image : http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c_medium.jpg
         * booking_count : 3326
         * is_country : false
         * is_city : true
         * has_booking : true
         * has_board : true
         * national_cover_image : http://qimages.b0.upaiyun.com/d4e8773d3e4b952cc374d6cb493a6c6c
         */

        private List<CityListBean> city_list;

        public CountryInfoBean getCountry_info() {
            return country_info;
        }

        public void setCountry_info(CountryInfoBean country_info) {
            this.country_info = country_info;
        }

        public OtherInfoBean getOther_info() {
            return other_info;
        }

        public void setOther_info(OtherInfoBean other_info) {
            this.other_info = other_info;
        }

        public List<CityListBean> getCity_list() {
            return city_list;
        }

        public void setCity_list(List<CityListBean> city_list) {
            this.city_list = city_list;
        }

        public static class CountryInfoBean {
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

        public static class OtherInfoBean {
            /**
             * img_url : http://qimages.b0.upaiyun.com/24784a5a414c873891d2feeaf81999e5
             * download_url : http://a.app.qq.com/o/simple.jsp?pkgname=com.qiugonglue.qgl_tourismguide
             */

            private FooterBean footer;
            /**
             * coupon_url : http://m.shijieyou.com/mobile/couponLanding
             * mall_url : http://www.qiugonglue.com/api/v3/client/shijieyou_mall?place_id=4003
             */

            private ShejieyouMallBean shejieyou_mall;

            public FooterBean getFooter() {
                return footer;
            }

            public void setFooter(FooterBean footer) {
                this.footer = footer;
            }

            public ShejieyouMallBean getShejieyou_mall() {
                return shejieyou_mall;
            }

            public void setShejieyou_mall(ShejieyouMallBean shejieyou_mall) {
                this.shejieyou_mall = shejieyou_mall;
            }

            public static class FooterBean {
                private String img_url;
                private String download_url;

                public String getImg_url() {
                    return img_url;
                }

                public void setImg_url(String img_url) {
                    this.img_url = img_url;
                }

                public String getDownload_url() {
                    return download_url;
                }

                public void setDownload_url(String download_url) {
                    this.download_url = download_url;
                }
            }

            public static class ShejieyouMallBean {
                private String coupon_url;
                private String mall_url;

                public String getCoupon_url() {
                    return coupon_url;
                }

                public void setCoupon_url(String coupon_url) {
                    this.coupon_url = coupon_url;
                }

                public String getMall_url() {
                    return mall_url;
                }

                public void setMall_url(String mall_url) {
                    this.mall_url = mall_url;
                }
            }
        }

        public static class CityListBean {
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
            private String national_cover_image;

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

            public String getNational_cover_image() {
                return national_cover_image;
            }

            public void setNational_cover_image(String national_cover_image) {
                this.national_cover_image = national_cover_image;
            }
        }
    }
}
