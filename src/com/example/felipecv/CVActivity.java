package com.example.felipecv;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CVActivity extends Activity implements OnItemClickListener{

	
	private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ListViewCV> itens;
    
    String fe;
    String ct;
    String lang;
    String ul;
    String typ,co,we;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);   

	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_contact);
	    this.setTitle("Felipe's CV");
		setContentView(R.layout.activity_cv);	
		listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        
        fe=getResources().getString(R.string.FE);
        ct=getResources().getString(R.string.CT);
        lang=getResources().getString(R.string.LANG);
        ul=getResources().getString(R.string.UL);
        typ=getResources().getString(R.string.TYP);
        co=getResources().getString(R.string.CONTACT);
        we=getString(R.string.WORK_EXP);
        
  
        createListView();
      
		
	}
	
	private void createListView() {
        //The list that will fill the ListView
        itens = new ArrayList<ListViewCV>();
        
        ListViewCV item1 = new ListViewCV(fe, R.drawable.school_ic);
        ListViewCV item2 = new ListViewCV(ct, R.drawable.computer_ic);
        ListViewCV item3 = new ListViewCV(lang, R.drawable.languages_ic);
        ListViewCV item4 = new ListViewCV(ul, R.drawable.link_ic);
        ListViewCV item5 = new ListViewCV(typ, R.drawable.insa_ic);
        ListViewCV item6 = new ListViewCV(we, R.drawable.work_ic);
        ListViewCV item7 = new ListViewCV(co, R.drawable.contact_ic);
        
        
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);

 
        //Create adapter
        adapterListView = new AdapterListView(this, itens);
        listView.setOnItemClickListener(this);
        //Define adapter
        listView.setAdapter(adapterListView);
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
	
	

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
 
		 Intent myintent2 = null;
		 if(arg2==0){	 
			 myintent2 = new Intent(CVActivity.this,FormationActivity.class);
		 }else if(arg2==1){	 
			 myintent2 = new Intent(CVActivity.this,ComputerActivity.class);
		 }else if(arg2==2){	 
			 myintent2 = new Intent(CVActivity.this,LanguageActivity.class);
		 }else if(arg2==3){	 
			 myintent2 = new Intent(CVActivity.this,LinksActivity.class);
		 }else if(arg2==4){	 
			 myintent2 = new Intent(CVActivity.this,ProgramActivity.class);
		 }else if(arg2==5){	 
			 myintent2 = new Intent(CVActivity.this,WEActivity.class);
		 }else if(arg2==6){	 
			 myintent2 = new Intent(CVActivity.this,ContactActivity.class);
		 }
		 startActivity(myintent2);
	}

}
