package com.example.felipecv;



import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView emailText1;
	TextView emailText2;
	TextView textEtc;
	Button bot;
	Button btnOpenPopup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_main);
		
		
		emailText1=(TextView) findViewById(R.id.emailText1);
		emailText2=(TextView) findViewById(R.id.emailText2);
		textEtc=(TextView) findViewById(R.id.etc);
		
		bot=(Button) findViewById(R.id.buttonFormation);
		btnOpenPopup=(Button) findViewById(R.id.botLan);
		
		
		emailText1.setText("felipe.matias-camargo@insa-lyon.fr");
		emailText2.setText("felipe.matias371@gmail.com");
		String aniv = ""+calcAniv(21, 1, 1993);
		String etc = String.format(getResources().getString(R.string.etc), aniv);
		textEtc.setText(etc);
		
		bot.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
        
                Intent myintent2 = new Intent(MainActivity.this,CVActivity.class);
                startActivity(myintent2);

            }
        });
		
		btnOpenPopup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
        
            	popupWindow();
            }
        });
	}
	
	@SuppressWarnings("deprecation")
	public void popupWindow(){
	    LayoutInflater layoutInflater 
	     = (LayoutInflater)getBaseContext()
	      .getSystemService(LAYOUT_INFLATER_SERVICE);  
	    View popupView = layoutInflater.inflate(R.layout.popup, null);  
	    final PopupWindow popupWindow = new PopupWindow(
	           popupView, 
	           LayoutParams.WRAP_CONTENT,  
	                  LayoutParams.WRAP_CONTENT);  
	    
	    popupWindow.setBackgroundDrawable(new BitmapDrawable());
	    popupWindow.setOutsideTouchable(true);
	             
	    ImageButton fr = (ImageButton)popupView.findViewById(R.id.botFr);
	    ImageButton pt=(ImageButton)popupView.findViewById(R.id.botPt);
	    ImageButton en=(ImageButton)popupView.findViewById(R.id.botEn);
	    
	    pt.setOnClickListener(new Button.OnClickListener(){
	            	 
	     @Override
	     public void onClick(View v) {
		    changeLang("pt", "O idioma foi mudado para português");
		    final Intent intent = new Intent(getBaseContext(), MainActivity.class);
        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(intent);
		    popupWindow.dismiss();
	     }});
	             
	    en.setOnClickListener(new Button.OnClickListener(){
       	 
		     @Override
		     public void onClick(View v) {
			    changeLang("en", "The language has been changed to English");
			    final Intent intent = new Intent(getBaseContext(), MainActivity.class);
	        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	startActivity(intent);
			    popupWindow.dismiss();
		     }});
	    fr.setOnClickListener(new Button.OnClickListener(){
	            	 
	    	  @Override
			     public void onClick(View v) {
				    changeLang("fr", "La langue est maintenant le français");
				    final Intent intent = new Intent(getBaseContext(), MainActivity.class);
		        	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        	startActivity(intent);
				    popupWindow.dismiss();
			     }});
	               
	             popupWindow.showAtLocation(btnOpenPopup, Gravity.CENTER, 0, 0);
	    }

	
	public void changeLang(String abrev, String toast){
		
            Locale locale = new Locale(abrev);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources()
                    .updateConfiguration(
                            config,
                            getBaseContext().getResources()
                                    .getDisplayMetrics());
            Toast.makeText(getApplicationContext(), toast,
                    Toast.LENGTH_SHORT).show();
	}
	
	public void onBackPressed() {
		//super.onBackPressed();
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);

	    builder.setMessage(getResources().getString(R.string.backBot))
	            .setCancelable(false)
	            .setPositiveButton(getResources().getString(R.string.yesQuestion), new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                	finish();
	                }
	            })
	            .setNegativeButton(getResources().getString(R.string.noQuestion), new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	                }
	            });
	    AlertDialog alert = builder.create();
	    alert.show();
	}
	
	private int calcAniv(int d, int m, int y){
		
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		
		if(month>m || (month==m && day>d)){
			return year-y;
		}else{
			return year-y-1;
		}
		
	}

}
