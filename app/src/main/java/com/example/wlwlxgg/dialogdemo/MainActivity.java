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
                mDialog = new MyDialog(mContex, 1);
                mDialog.setOkListener(new MyDialog.onOkClickListener() {
                    @Override
                    public void onClick() {
                        final MyDialog dialog = new MyDialog(mContex, 2);
                        dialog.show();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                    dialog.dismiss();
                                    mDialog.dismiss();
                                    MainActivity.this.finish();
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

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
