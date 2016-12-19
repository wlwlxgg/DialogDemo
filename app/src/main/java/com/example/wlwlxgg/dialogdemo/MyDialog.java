package com.example.wlwlxgg.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by wlwlxgg on 2016/12/12.
 */

public class MyDialog extends Dialog {

    private onOkClickListener okListener = null;
    private onCancelCickListener cancelListener = null;
    private Button ok, cancel;
    private int tag;
    private LinearLayout ll1, ll2;
    /**
     * 构造函数
     * 第二个参数为自定义样式
     * 在styles.xml设置
     */
    public MyDialog(Context context, int tag) {
        super(context,R.style.MyDialog);
        this.tag = tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
    }

    private void initView() {
        ll1 = (LinearLayout) findViewById(R.id.dialog);
        ll2 = (LinearLayout) findViewById(R.id.dialog_2);
        if (tag == 1) {
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.GONE);
        }else {
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.VISIBLE);
        }
        ok = (Button)findViewById(R.id.dialog_pos);
        cancel = (Button)findViewById(R.id.dialog_nav);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(okListener != null) {
                    okListener.onClick();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cancelListener != null) {
                    cancelListener.onClick();
                }
            }
        });
    }


    /**
     * 设置确定按钮和取消被点击的接口
     * 可以设置很多接口去回调的，根据自己的爱好，也可以没有
     * 主要根据需要
     */
    public interface onOkClickListener {
        void onClick();
    }

    public interface onCancelCickListener {
        void onClick();
    }

    /**
     * 设置取消按钮的显示内容和监听
     */
    public void setCancelListener(onCancelCickListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     */
    public void setOkListener(onOkClickListener okListener) {
        this.okListener = okListener;
    }
}
