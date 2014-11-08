package com.example.felipecv;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordActivity extends Activity {

	final String PASS="minion";
	EditText passBox;
	Button bot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.activity_password);
		
		passBox=(EditText) findViewById(R.id.passBox);
		bot=(Button) findViewById(R.id.botPass);
		
		SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String savedPassword = preferences.getString("password", "");
		
		if(PASS.equals(savedPassword)){
			startActivity();
		}
		
		bot.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String password=passBox.getText().toString();
				SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
				SharedPreferences.Editor editor = preferences.edit();
				editor.putString("password", password);
				editor.commit();
				testPassword(password);
			}
		});
		
	}
	
	public void startActivity(){
		Intent intent=new Intent(PasswordActivity.this,MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	startActivity(intent);
    	this.finish();
	}
	
	private void testPassword(String pass) {
		
		
		if(pass.equals(PASS)){
			startActivity();
		}else if(pass.equals("")){
			createToast(R.string.typePass);
			
		}else{
			createToast(R.string.wrongPass);
			passBox.setText("");
			}
	}

	private void createToast(int id) {
		Toast toast=new Toast(getApplicationContext());
		TextView text =  new TextView(this);
        text.setText(id);
        text.setTextColor(getResources().getColor(R.color.BACKBLUE));
        toast.setView(text);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
	}


}
