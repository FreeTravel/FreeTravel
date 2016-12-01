package com.ma.freetravel.bean;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/29.
 */

public class AlumDetail implements Serializable{
    /**
     * ColumnID : 1
     * InfoID : 4977
     * PicURL : /ueditor/net/upload/image/20161121/c119_45BB5997626.jpg
     * Title : 火锅英雄
     * LinkUrl : http://www.iqiyi.com/v_19rrlon744.html??zjmoviezdomo=1
     * Introduction : 《火锅英雄》：钱和美女，你选哪样？
     * SpecilLabelIDS : 14,
     * Content : <p style="text-align: center;"><img title="6.jpg" src="/ueditor/net/upload/image/20161121/c119_FFFF1B525960113.jpg"/></p><p style="text-align: center;"><img title="7.jpg" src="/ueditor/net/upload/image/20161121/c119_FFFF1B527432695.jpg"/></p><p style="text-align: center;"><img title="8.jpg" src="/ueditor/net/upload/image/20161121/c119_FFFF1C4C1975738.jpg"/></p><p>在布满防空洞的重庆，三个从初中就“厮混”在一起的好兄弟刘波（陈坤 饰）、许东（秦昊 饰）和王平川（喻恩泰 饰）合伙开着一家火锅店，名为“老同学洞子火锅”。由于经营不善，几人落得只能转让店铺还债。为了店铺能“卖个好价钱”，三人打起了“扩充门面”的主意，自行往洞里开挖。</p><p>没想到，在扩充工程中却凿开了银行的金库！就这样，濒临倒闭的火锅店和银行金库仅有“一洞之隔”；看着眼前随手可得的成堆现金，在“拿钱还是报案”的思想拉锯战中，三兄弟偶遇上另一个女同学——初中时给老大写过情书、现在在银行上班的于小惠（白百何 饰）。四个老同学因为这个“洞”而打开重聚之门。由此，这个略显尴尬的洞，引发了一个令人意想不到的故事。</p>
     * AddTime : 2016-11-21T16:30:40
     * GoodTimes : 0
     * LabelIDS :
     */
    /**
     * ColumnID : 1
     * InfoID : 4942
     * PicURL : /ueditor/net/upload/image/20160927/c17_FFFD99481158215.jpg
     * Title : 马男波杰克
     * LinkUrl : http://www.iqiyi.com/v_19rrl2306o.html?zjmoviezdomo=1
     * Introduction : 《马男波杰克》：时下最流行的“毒鸡汤”
     * SpecilLabelIDS : 15,
     * Content : <p style="text-align: center;"><img src="/ueditor/net/upload/image/20160927/c17_32CAB6794554.jpg" title="马男1.jpg" alt="马男1.jpg"/></p><p style="text-align: center;"><img src="/ueditor/net/upload/image/20160927/c17_FFFCC46D5458375.jpg" title="马男2.jpg" alt="马男2.jpg"/></p><p style="text-align: center;"><img src="/ueditor/net/upload/image/20160927/c17_FFFCD7801134920.jpg" title="马男3.jpg" alt="马男3.jpg"/></p><p>本剧的世界设定是普通人类和拟人化的动物共同生活在一起，除了外形，这些动物跟人类没什么不同。马男波杰克（威尔·阿奈特 Will Arnett 配音）就是一匹中年过气明星马，他年轻时主演的电视剧《胡闹的小马》风靡一时，而今他已是无人问津的过气明星，与人类废柴陶德（亚伦·保尔 Aaron Paul 配音）一同生活在LA的一所别墅里。为了重整旗鼓，波杰克在经纪人兼前女友卡罗琳公主（艾米·塞德丽丝 Amy Sedaris 配音）催促下决定出版一部自传，希望回到大众视野里。但是由于波杰克过分拖延迟迟不肯下笔，出版社介绍了一位枪手作者戴安（爱丽森·布里 Alison Brie 配音）给他。波杰克多番拒绝，终于，在一个派对上，他与戴安相遇了，却发现她竟是自己的死对头花生酱先生的女朋友。</p>
     * AddTime : 2016-09-30T17:41:41
     * LabelIDS : 动画
     * GoodTimes : 4
     */
    private int ColumnID;
    private int InfoID;
    private String PicURL;
    private String Title;
    private String LinkUrl;
    private String Introduction;
    private String SpecilLabelIDS;
    private String Content;
    private String AddTime;
    private String LabelIDS;
    private int GoodTimes;

    public int getColumnID() {
        return ColumnID;
    }

    public void setColumnID(int ColumnID) {
        this.ColumnID = ColumnID;
    }

    public int getInfoID() {
        return InfoID;
    }

    public void setInfoID(int InfoID) {
        this.InfoID = InfoID;
    }

    public String getPicURL() {
        return PicURL;
    }

    public void setPicURL(String PicURL) {
        this.PicURL = PicURL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getLinkUrl() {
        return LinkUrl;
    }

    public void setLinkUrl(String LinkUrl) {
        this.LinkUrl = LinkUrl;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public String getSpecilLabelIDS() {
        return SpecilLabelIDS;
    }

    public void setSpecilLabelIDS(String SpecilLabelIDS) {
        this.SpecilLabelIDS = SpecilLabelIDS;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public String getLabelIDS() {
        return LabelIDS;
    }

    public void setLabelIDS(String LabelIDS) {
        this.LabelIDS = LabelIDS;
    }

    public int getGoodTimes() {
        return GoodTimes;
    }

    public void setGoodTimes(int GoodTimes) {
        this.GoodTimes = GoodTimes;
    }
}
