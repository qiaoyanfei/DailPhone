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
	
	
	// ���ı������������ԣ�����ÿ�δ�绰������
	EditText etInputNum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// ���ò���
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        // ��ȡ����绰����İ�ť����
        Button btnDailNum = (Button) findViewById(R.id.bt_dail_num);
       
		// ��ȡ�ı����������
		this.etInputNum = (EditText) Welcome.this.findViewById(R.id.et_input_phone_number);
        
        // ע�����¼�
        btnDailNum.setOnClickListener(new DailNumClickListener());
           
    }
    
    
    /**
     * ʵ�ֵ���¼��ӿ�
     * @author jixiaofeng
     *
     */
    private class DailNumClickListener implements OnClickListener{

		/**
		 * ��������¼�
		 */
		public void onClick(View v) {
			Log.i("chuan", "ahahh");

			// ��ȡ�绰����
			String phoneNum = etInputNum.getText().toString();
			
			// ��ӡ
			Log.i("chuan", phoneNum);
			
			// ����绰����
			Intent intent = new Intent();
			
			// ָ����������(����绰)
			intent.setAction(Intent.ACTION_CALL);
			
			// ָ���绰����(�����tel:110 ��ʽһ��Ҫ����,����ᱨactivitynotfound����)
			intent.setData(Uri.parse("tel:" + phoneNum));
			
			// ��ʼ����(�����л�����ͨ��intent)
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
