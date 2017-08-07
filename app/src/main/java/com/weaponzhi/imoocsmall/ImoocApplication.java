package com.weaponzhi.imoocsmall;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by pc on 2017/8/7.
 */

public class ImoocApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Small.preSetUp(this);//small框架的初始化
    }
}
