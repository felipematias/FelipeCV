package com.example.felipecv;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;

public class LanguageActivity extends Activity {
	
	  List<String> groupList;
	  List<String> childList;
	  Map<String, List<String>> titleCollection;
	  ExpandableListView expListView;
	  
	  String pt;
      String fr;
      String en;
      String spa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_language);
		
		pt=getResources().getString(R.string.portuguese);
	    fr=getResources().getString(R.string.french);
	    en=getResources().getString(R.string.english);
	    spa=getResources().getString(R.string.spanish);
		
		createGroupList();
		 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.expandableListView1);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, titleCollection);
        expListView.setAdapter(expListAdapter);
        
        expandAll();
 
        setGroupIndicatorToRight();
	}

	private void createGroupList() {
        groupList = new ArrayList<String>();
        
        groupList.add(pt);
        groupList.add(fr);
        groupList.add(en);
        groupList.add(spa);
    }
 
    private void createCollection() {
        // preparing laptops collection(child)
        String[] portuguese = { getResources().getString(R.string.natLang) };
        String[] french = { getResources().getString(R.string.fluent) };
        String[] english = { getResources().getString(R.string.GAL)};
        String[] spanish = { getResources().getString(R.string.BAL)};
        
 
        titleCollection = new LinkedHashMap<String, List<String>>();
 
        for (String title : groupList) {
            if (title.equals(pt)) {
                loadChild(portuguese);
            } else if (title.equals(fr))
                loadChild(french);
            else if (title.equals(en))
                loadChild(english);
            else if (title.equals(spa))
                loadChild(spanish);
           
 
            titleCollection.put(title, childList);
        }
    }
 
    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }
 
    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
 
        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }
 
    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
    
    public void expandAll(){
    	android.widget.ExpandableListAdapter adapter = expListView.getExpandableListAdapter();
    	for(int i=0; i < adapter.getGroupCount(); i++)
    		expListView.expandGroup(i);
    }
}
