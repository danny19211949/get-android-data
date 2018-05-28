package com.example.wangguoqing01.get_data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tombstonePath = Environment.getExternalStorageDirectory().getPath() + "/save_tombstone";

        if (!new File(tombstonePath).exists()) { //创建目标目录
            new File(tombstonePath).mkdirs();
        }

        try {
            String cmd = "cp -rf /data/tombstones/ " + tombstonePath;
            Runtime.getRuntime().exec(cmd);
        } catch(Exception e) {
            Log.e("get_data", e.getMessage());
        }
    }
}
