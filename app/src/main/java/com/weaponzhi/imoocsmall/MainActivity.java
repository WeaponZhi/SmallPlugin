package com.weaponzhi.imoocsmall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.wequick.small.Small;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final String FILE_END = ".apk";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        File file = new File(mPatchDir);
        if (file == null || file.exists()) {
            file.mkdir();
        }
    }

    public void fixBug(View view) {
        TinkerManager.loadPatch(getPatchName());
    }

    //构造patch文件名
    private String getPatchName() {
        return mPatchDir.concat("imooc").concat(FILE_END);
    }


    public void startToSmall(View view) {
        Small.setUp(this, new Small.OnCompleteListener() {

            @Override
            public void onComplete() {
                Small.openUri("main", MainActivity.this);
            }
        });
    }
}
