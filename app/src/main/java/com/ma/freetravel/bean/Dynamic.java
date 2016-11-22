package com.ma.freetravel.bean;

import java.util.List;

/**
 * @author :ZJF
 * @version : 2016-11-22 下午 4:14
 */

public class Dynamic {


    private String message;

    private DataBean data;

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


        private List<TrendsListBean> trends_list;

        public List<TrendsListBean> getTrends_list() {
            return trends_list;
        }

        public void setTrends_list(List<TrendsListBean> trends_list) {
            this.trends_list = trends_list;
        }

        public static class TrendsListBean {
            private String id;
            private String content;
            private String image_count;
            private String fav_count;
            private String geoinfo;
            private String lon;
            private String lat;

            private AuthorBean author;
            private String human_ctime;

            private List<ImageListBean> image_list;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }


            public String getImage_count() {
                return image_count;
            }

            public void setImage_count(String image_count) {
                this.image_count = image_count;
            }

            public String getFav_count() {
                return fav_count;
            }

            public void setFav_count(String fav_count) {
                this.fav_count = fav_count;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public String getHuman_ctime() {
                return human_ctime;
            }

            public void setHuman_ctime(String human_ctime) {
                this.human_ctime = human_ctime;
            }

            public List<ImageListBean> getImage_list() {
                return image_list;
            }

            public void setImage_list(List<ImageListBean> image_list) {
                this.image_list = image_list;
            }

            public String getGeoinfo() {
                return geoinfo;
            }

            public void setGeoinfo(String geoinfo) {
                this.geoinfo = geoinfo;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public static class AuthorBean {
                private String user_name;
                private String avatar;

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }

            public static class ImageListBean {
                private String image_url;
                private String image_thumbnail_url;
                private int image_width;
                private int image_height;

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public String getImage_thumbnail_url() {
                    return image_thumbnail_url;
                }

                public void setImage_thumbnail_url(String image_thumbnail_url) {
                    this.image_thumbnail_url = image_thumbnail_url;
                }

                public int getImage_width() {
                    return image_width;
                }

                public void setImage_width(int image_width) {
                    this.image_width = image_width;
                }

                public int getImage_height() {
                    return image_height;
                }

                public void setImage_height(int image_height) {
                    this.image_height = image_height;
                }
            }
        }
    }
}
