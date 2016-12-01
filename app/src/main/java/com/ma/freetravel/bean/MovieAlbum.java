package com.ma.freetravel.bean;

/**
 * Created by Administrator on 2016/11/28.
 */

public class MovieAlbum {
    /**
     * FilmAlbumID : 118
     * ManagerID : 19
     * Title : 陈乔恩演技差？呵！真是“见识短”
     * Description : 别以为人家演过“傻白甜”，就真当人家是傻白甜！我陈乔恩“偶像剧女王”的称号可不是说笑，那演技爆发起来，分分钟可是会炸掉你家房顶！不信？那你随意戳一部来看看咯！
     * AddTime : 2016-11-04T15:54:52
     * ThePhoto : upload/image/20161104/19_FFFE0C949136883.jpg
     * InfoIDS : 4965,4966,4963,4967,4964,
     * IsUsed : true
     * LabelIDS :
     */
    private int FilmAlbumID;
    private int ManagerID;
    private String Title;
    private String Description;
    private String AddTime;
    private String ThePhoto;
    private String InfoIDS;
    private boolean IsUsed;
    private String LabelIDS;

    public int getFilmAlbumID() {
        return FilmAlbumID;
    }

    public void setFilmAlbumID(int FilmAlbumID) {
        this.FilmAlbumID = FilmAlbumID;
    }

    public int getManagerID() {
        return ManagerID;
    }

    public void setManagerID(int ManagerID) {
        this.ManagerID = ManagerID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAddTime() {
        return AddTime;
    }

    public void setAddTime(String AddTime) {
        this.AddTime = AddTime;
    }

    public String getThePhoto() {
        return ThePhoto;
    }

    public void setThePhoto(String ThePhoto) {
        this.ThePhoto = ThePhoto;
    }

    public String getInfoIDS() {
        return InfoIDS;
    }

    public void setInfoIDS(String InfoIDS) {
        this.InfoIDS = InfoIDS;
    }

    public boolean isIsUsed() {
        return IsUsed;
    }

    public void setIsUsed(boolean IsUsed) {
        this.IsUsed = IsUsed;
    }

    public String getLabelIDS() {
        return LabelIDS;
    }

    public void setLabelIDS(String LabelIDS) {
        this.LabelIDS = LabelIDS;
    }
}
