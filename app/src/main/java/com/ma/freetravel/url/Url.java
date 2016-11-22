package com.ma.freetravel.url;

/**
 * Created by 哈士奇爱吃苹果 on 2016/11/21.
 */
public class Url {
    //首页

    public static String HomePath="http://m.shijieyou.com/mobileJson/recommendItemList?client_name=QGLMain&place_id=&offset=10&_=1479728842996&callback=jsonp1";

    //动态
    public static  String DynamicPath="http://www.qiugonglue.com/api/v3/trends/new_trends_list?client_name=QGLMain&client_version=6.0.1&limit=20&order_by=desc&os_version=17&p=1&platform=android&screen_size=720x1280&uuid=133524328529283&sign=b7b76d8ff653eaa12aed6a0ad698d0af";   //轻松一刻

    //边走边看
    //轮播
    public  static String Vp_Path="http://apk.zdomo.com/api/ApiFilmAlbum?pagenum=0&pagesize=4&tmp=0.5617492643658829";
    //轮播点击跳转
    public static String turnPath="http://apk.zdomo.com/api/ApiFilmAlbum?pagenum=0&pagesize=20&tmp=0.6233542039472624";
    //二次跳转     tmp=0.33767933309475884?
    public static String secondTurnPath="http://apk.zdomo.com/api/ApiFilmAlbum/?pageSize=20&pageNum=0&id=110&tmp=0.33767933309475884" ;
                                        //http://apk.zdomo.com/api/ApiFilmAlbum/?pageSize=20&pageNum=0&id=114&tmp=0.11219674811926295

    //listview的网址
    public static String lvPath="http://apk.zdomo.com/api/ApiBasic?pageSize=20&pageNum=0&tmp=0.06086050612584448";
    //listvie点击跳转 第二页的内容需要xml解析listview的Content属性

    //目的地
    //十一必玩
    public static String PlayPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727833223&type=hot&type_value=1&uuid=133524328529283&sign=a6fe988a3137dd395d0e16f6d2506df2";

            //特惠推荐
    public static String RecommendPath="http://m.shijieyou.com/mobileJson/recommendByClientName?client_name=Seoul";

        //发现新奇
    public  static String DiscoverPath="http://www.qiugonglue.com/api/v3/place/place_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=2012011&platform=android&screen_size=720x1280&tm=1479727935926&uuid=133524328529283&sign=c9525b087e0136f902fc6d5e2b3d53c2";

    //点击图片后跳转的网址是url  http://www.qiugonglue.com/cms/1001660

    //亚洲
    public static String AsiaPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727194077&type=continent&type_value=2&uuid=133524328529283&sign=458f721ed77280e54b3dee4ff8cf4930";
    //欧洲
    public static String EuropePath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727365562&type=continent&type_value=4&uuid=133524328529283&sign=aced5404d951609b6c9d7ffcc3739eaa";
    //第一次点击跳转               //http://www.qiugonglue.com/api/v3/place/country_index?client_name=QGLMain&client_version=6.0.1&country_id=4003&os_version=17&platform=android&screen_size=720x1280&tm=1479731903164&uuid=133524328529283&sign=b0434bae85c76bebb565cd082f9262a3
                                    //http://www.qiugonglue.com/api/v3/place/country_index?client_name=QGLMain&client_version=6.0.1&country_id=4010&os_version=17&platform=android&screen_size=720x1280&tm=1479730500282&uuid=133524328529283&sign=2b472a0fb5f87b3df09cad95fba9e6e6
                                    //http://www.qiugonglue.com/api/v3/place/country_index?client_name=QGLMain&client_version=6.0.1&country_id=4002&os_version=17&platform=android&screen_size=720x1280&tm=1479730782946&uuid=133524328529283&sign=12f0e54e53d8a8b991a5a3cdec1028cf
    //北美洲：
    public static String NorthUSAPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727522155&type=continent&type_value=9&uuid=133524328529283&sign=c45db5b6ac747a1dbb3bf0e8e6d22cbc";
    //非洲
    public static String AfricaPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727598633&type=continent&type_value=6&uuid=133524328529283&sign=2dbd602e1d78bab492242c10161ba062";

    //南美洲
    public static String SouthAmericaPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727665247&type=continent&type_value=7&uuid=133524328529283&sign=a21494c56b11146547fe25e21020ae18";
    //跳转country
    public static String CountryPath="http://www.qiugonglue.com/api/v3/place/country_index?client_name=QGLMain&client_version=6.0.1&country_id=7002&os_version=17&platform=android&screen_size=720x1280&tm=1479729739730&uuid=133524328529283&sign=5afe88b1339b9e63c29862816985acf4";
    //跳转的城市
    //public  static String PlacePath="http://www.qiugonglue.com/api/v3/place/place_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=7002001&platform=android&screen_size=720x1280&tm=1479729967614&uuid=133524328529283&sign=b1c542556a2ad364ed4530ffe64095ac";
    String aaa="http://www.qiugonglue.com/api/v3/place/place_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id="+"place_id"+"&platform=android&screen_size=720x1280&tm=1479729599429&uuid=133524328529283&sign=8cc67adb1841eaaa26519e692cedb7dc";
//http://www.qiugonglue.com/api/v3/place/place_index?client_name=QGLMain&client_version=6.0.1&os_version=17&place_id=6003001&platform=android&screen_size=720x1280&tm=1479729599429&uuid=133524328529283&sign=8cc67adb1841eaaa26519e692cedb7dc";

    //大洋洲
    public static String OceaniaPath="http://www.qiugonglue.com/api/v3/place/nav_place_list?client_name=QGLMain&client_version=6.0.1&os_version=17&platform=android&screen_size=720x1280&tm=1479727811894&type=continent&type_value=8&uuid=133524328529283&sign=6644240b0607721ee176e4f32451f17a";

}
