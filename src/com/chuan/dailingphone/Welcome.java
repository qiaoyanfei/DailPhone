package com.chuan.dailingphone;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Welcome extends ActionBarActivity {
	
	
	// 把文本框做成类属性，不用每次打电话都查找
	EditText etInputNum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// 设置布局
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        // 获取拨打电话号码的按钮引用
        Button btnDailNum = (Button) findViewById(R.id.bt_dail_num);
       
		// 获取文本输入框引用
		this.etInputNum = (EditText) Welcome.this.findViewById(R.id.et_input_phone_number);
        
        // 注册点击事件
        btnDailNum.setOnClickListener(new DailNumClickListener());
           
    }
    
    
    /**
     * 实现点击事件接口
     * @author jixiaofeng
     *
     */
    private class DailNumClickListener implements OnClickListener{

		/**
		 * 监听点击事件
		 */
		public void onClick(View v) {
			Log.i("chuan", "ahahh");

			// 获取电话号码
			String phoneNum = etInputNum.getText().toString();
			
			// 打印
			Log.i("chuan", phoneNum);
			
			// 拨打电话号码
			Intent intent = new Intent();
			
			// 指定动作类型(拨打电话)
			intent.setAction(Intent.ACTION_CALL);
			
			// 指定电话号码(这里的tel:110 格式一定要遵守,否则会报activitynotfound错误)
			intent.setData(Uri.parse("tel:" + phoneNum));
			
			// 开始拨打(动作切换都是通过intent)
			startActivity(intent);
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
