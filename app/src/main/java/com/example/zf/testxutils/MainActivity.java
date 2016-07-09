package com.example.zf.testxutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/***
 * 说明
 * 用注解方式绑定控件及其响应事件的步骤
 * 1）定义Application子类，在其中初始化xutils，并在manifiest文件中声明
 * 2）Activity的onCreate中用x.view().inject(this);来初始化
 * 3）参考下面的“省去了”注释下的写法
 */
public class MainActivity extends AppCompatActivity {

    //下面省去了findViewById
    @ViewInject(R.id.textView2)
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        label.setText("fdsf");

    }

    //下面省去了onClickListen接口的定义
    @Event(value = R.id.button2)//,            type = View.OnClickListener.class/*可选参数, 默认是View.OnClickListener.class*/)
    private void onButton2Click(View view) {
        Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
    }
}
