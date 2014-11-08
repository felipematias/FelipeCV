package com.example.felipecv;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class LinksActivity extends Activity {

	TextView linkFr, linkEn, progFr, progEn, pdfText;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		setContentView(R.layout.activity_links);
		
		linkFr = (TextView) findViewById(R.id.linkFr);
		linkEn = (TextView) findViewById(R.id.linkEn);
		progFr = (TextView) findViewById(R.id.progFr);
		progEn = (TextView) findViewById(R.id.progEn);
		pdfText = (TextView) findViewById(R.id.pdfsText);
		
		linkFr.setText("http://www.insa-lyon.fr/");
		linkEn.setText("http://www.insa-lyon.fr/en");
		progFr.setText("http://www.insa-lyon.fr/fr/formation/offre-de-formation2/g/d/m?y=3&s=2&p=726");
		progEn.setText("http://www.insa-lyon.fr/en/formation/offre-de-formation2/g/d/m?y=3&s=2&p=726");
		pdfText.setText("https://drive.google.com/folderview?id=0B6aQj1_a59oFdUNDZTBfTFFlUEE&usp=sharing");
		
	}
}
