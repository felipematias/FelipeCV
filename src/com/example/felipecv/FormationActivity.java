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

public class FormationActivity extends Activity {
	
	List<String> groupList;
	List<String> childList;
	Map<String, List<String>> titleCollection;
	ExpandableListView expListView;
	
	String date1;
	String date2;
	String form1;
	String form2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_formation);
		
		date1=getResources().getString(R.string.date1);
		date2=getResources().getString(R.string.date2);
		form1=getResources().getString(R.string.formation1);
		form2=getResources().getString(R.string.formation2);
		
		createGroupList();
		 
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.expandableListView1);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, groupList, titleCollection);
        expListView.setAdapter(expListAdapter);
        
        expandAll();
 
        //setGroupIndicatorToRight();
	}

	private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add(date1);
        groupList.add(date2);
    }
 
    private void createCollection() {
        // preparing the collection(child)
    	
    	String[] colegio = { form1 };
        String[] fac = { form2 };
       
  
 
        titleCollection = new LinkedHashMap<String, List<String>>();
 
        for (String title : groupList) {
            if (title.equals(date1)) {
                loadChild(colegio);
            } else if (title.equals(date2)){
                loadChild(fac);
            }
            titleCollection.put(title, childList);
        }
    }
 
    private void loadChild(String[] titleModels) {
        childList = new ArrayList<String>();
        for (String model : titleModels)
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
