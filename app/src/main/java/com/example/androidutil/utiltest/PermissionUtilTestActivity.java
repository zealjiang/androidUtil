package com.example.androidutil.utiltest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidutil.util.PermissionUtil;

public class PermissionUtilTestActivity extends AppCompatActivity {

    private PermissionUtil permissionUtil;
    private String uriPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_editor);
        permissionUtil = new PermissionUtil();
        boolean boo = permissionUtil.checkPermission(this);

        Intent intent = getIntent();
        if(intent == null){
            return;
        }
        String action = intent.getAction();

        //将文件复制到制定目录中
        if(Intent.ACTION_VIEW.equals(action)) {
            String str = intent.getDataString();
            Log.e("uri", str);
            if (str != null) {
                uriPath = str;
                if(boo){
                    readFile(str);
                }
            }
        }
    }

    private void readFile(String uriPath){
        if(TextUtils.isEmpty(uriPath))return;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(permissionUtil == null)return;
        boolean boo = permissionUtil.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(boo){
            readFile(uriPath);
        }else{
            permissionUtil.checkPermission(this);
        }
    }

}
