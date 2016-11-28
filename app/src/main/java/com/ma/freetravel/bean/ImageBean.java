package com.ma.freetravel.bean;

import java.util.List;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/23.
 */
public class ImageBean {

    /**
     * item_recommend : [{"id":3605625,"title":"Mia带你将足迹留遍巴黎","url":"http://m.shijieyou.com/mdetail-3605625-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3605625/1435127443485.jpg!w300","lprice":888,"lon":null,"lat":null,"saleCount":35,"evaluateCount":16,"originPrice":900},{"id":4088089,"title":"大卫带你游览他熟悉的巴黎","url":"http://m.shijieyou.com/mdetail-4088089-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_4088089/1437391128297.jpg!w300","lprice":750,"lon":null,"lat":null,"saleCount":18,"evaluateCount":8,"originPrice":null},{"id":3240259,"title":"来巴黎,给你不一样的旅行照","url":"http://m.shijieyou.com/mdetail-3240259-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3240259/1433518573966.jpg!w300","lprice":3500,"lon":null,"lat":null,"saleCount":9,"evaluateCount":4,"originPrice":null},{"id":3218236,"title":"法国巴黎婚纱，旅拍","url":"http://m.shijieyou.com/mdetail-3218236-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3218236/1437949613912.jpg!w300","lprice":5000,"lon":null,"lat":null,"saleCount":5,"evaluateCount":3,"originPrice":null},{"id":4449469,"title":"巴黎私人订制导游导购","url":"http://m.shijieyou.com/mdetail-4449469-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_4449469/1439172515274.jpg!w300","lprice":480,"lon":null,"lat":null,"saleCount":2,"evaluateCount":0,"originPrice":null},{"id":5568574,"title":"巴黎一日游","url":"http://m.shijieyou.com/mdetail-5568574-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_5568574/1445851881054.jpg!w300","lprice":700,"lon":null,"lat":null,"saleCount":1,"evaluateCount":1,"originPrice":null}]
     * mall_url : http://m.shijieyou.com/mobile/getItemListByClientName?client_name=Paris&from=Paris_index
     */

    private DataBean data;
    /**
     * data : {"item_recommend":[{"id":3605625,"title":"Mia带你将足迹留遍巴黎","url":"http://m.shijieyou.com/mdetail-3605625-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3605625/1435127443485.jpg!w300","lprice":888,"lon":null,"lat":null,"saleCount":35,"evaluateCount":16,"originPrice":900},{"id":4088089,"title":"大卫带你游览他熟悉的巴黎","url":"http://m.shijieyou.com/mdetail-4088089-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_4088089/1437391128297.jpg!w300","lprice":750,"lon":null,"lat":null,"saleCount":18,"evaluateCount":8,"originPrice":null},{"id":3240259,"title":"来巴黎,给你不一样的旅行照","url":"http://m.shijieyou.com/mdetail-3240259-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3240259/1433518573966.jpg!w300","lprice":3500,"lon":null,"lat":null,"saleCount":9,"evaluateCount":4,"originPrice":null},{"id":3218236,"title":"法国巴黎婚纱，旅拍","url":"http://m.shijieyou.com/mdetail-3218236-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_3218236/1437949613912.jpg!w300","lprice":5000,"lon":null,"lat":null,"saleCount":5,"evaluateCount":3,"originPrice":null},{"id":4449469,"title":"巴黎私人订制导游导购","url":"http://m.shijieyou.com/mdetail-4449469-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_4449469/1439172515274.jpg!w300","lprice":480,"lon":null,"lat":null,"saleCount":2,"evaluateCount":0,"originPrice":null},{"id":5568574,"title":"巴黎一日游","url":"http://m.shijieyou.com/mdetail-5568574-Paris_index-Paris","mainImage":"http://img.shijieyou.cn/item_5568574/1445851881054.jpg!w300","lprice":700,"lon":null,"lat":null,"saleCount":1,"evaluateCount":1,"originPrice":null}],"mall_url":"http://m.shijieyou.com/mobile/getItemListByClientName?client_name=Paris&from=Paris_index"}
     * msg : 请求成功
     * success : true
     */

    private String msg;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        private String mall_url;
        /**
         * id : 3605625
         * title : Mia带你将足迹留遍巴黎
         * url : http://m.shijieyou.com/mdetail-3605625-Paris_index-Paris
         * mainImage : http://img.shijieyou.cn/item_3605625/1435127443485.jpg!w300
         * lprice : 888
         * lon : null
         * lat : null
         * saleCount : 35
         * evaluateCount : 16
         * originPrice : 900
         */

        private List<ItemRecommendBean> item_recommend;

        public String getMall_url() {
            return mall_url;
        }

        public void setMall_url(String mall_url) {
            this.mall_url = mall_url;
        }

        public List<ItemRecommendBean> getItem_recommend() {
            return item_recommend;
        }

        public void setItem_recommend(List<ItemRecommendBean> item_recommend) {
            this.item_recommend = item_recommend;
        }

        public static class ItemRecommendBean {
            private int id;
            private String title;
            private String url;
            private String mainImage;
            private int lprice;
            private Object lon;
            private Object lat;
            private int saleCount;
            private int evaluateCount;
            private int originPrice;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getMainImage() {
                return mainImage;
            }

            public void setMainImage(String mainImage) {
                this.mainImage = mainImage;
            }

            public int getLprice() {
                return lprice;
            }

            public void setLprice(int lprice) {
                this.lprice = lprice;
            }

            public Object getLon() {
                return lon;
            }

            public void setLon(Object lon) {
                this.lon = lon;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public int getSaleCount() {
                return saleCount;
            }

            public void setSaleCount(int saleCount) {
                this.saleCount = saleCount;
            }

            public int getEvaluateCount() {
                return evaluateCount;
            }

            public void setEvaluateCount(int evaluateCount) {
                this.evaluateCount = evaluateCount;
            }

            public int getOriginPrice() {
                return originPrice;
            }

            public void setOriginPrice(int originPrice) {
                this.originPrice = originPrice;
            }
        }
    }
}
