package com.ma.freetravel.jiekou;

/**
 * Created by tian on 2016/11/24.
 */

public interface ICustom {
//    //请求动作开始调用
//    public void handleActionStart(String actionName,Object object);
//    //请求动作结束调用
//    public void handleActionFinish(String actionName,Object object);
//    //请求动作错误调用
    public void handleActionError(String result, Object object);
    //请求动作成功时调用
    public void handleActionSuccess(String result,Object object);
}
