package com.weaponzhi.imoocsmall;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * TinkerManager 对Tinker的所有api做一层封装
 * author:张冠之
 * time: 2017/8/13 上午10:25
 * e-mail: guanzhi.zhang@sojex.cn
 */

public class TinkerManager {
    private static boolean isInstalled = false;

    private static ApplicationLike mApplike;

    /**
     * 完成 Tinker 初始化
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike){
        mApplike = applicationLike;
        if (isInstalled){
            return;
        }
        //完成 tinker 初始化
        TinkerInstaller.install(mApplike);
        isInstalled = true;

    }
    //完成 patch 文件的加载
    public static void loadPatch(String path){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
        }
    }
    //通过ApplicationLike获取Context
    private static Context getApplicationContext(){
        if (mApplike != null){
            return mApplike.getApplication().getApplicationContext();
        }
        return null;
    }
}
