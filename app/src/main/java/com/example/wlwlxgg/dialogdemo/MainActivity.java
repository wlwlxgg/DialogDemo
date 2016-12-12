package com.example.wlwlxgg.dialogdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn = null;
    private Context mContex = null;
    private MyDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mContex = this;
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mDialog = new MyDialog(mContex);
                mDialog.setOkListener(new MyDialog.onOkClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(mContex, "您点击了确定键", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                });
                mDialog.setCancelListener(new MyDialog.onCancelCickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(mContex, "您点击了取消键", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                });
                mDialog.show();
                break;
        }
    }
}
