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

public class ComputerActivity extends Activity {
	
	 List<String> groupList;
	 List<String> childList;
	 Map<String, List<String>> titleCollection;
	 ExpandableListView expListView;

	 String web;
	 String desktop;
	 String phone;
	 String compEnv;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_computer);
		
		web=getResources().getString(R.string.web);
		desktop=getResources().getString(R.string.desktop);
		phone=getResources().getString(R.string.phone);
		compEnv=getResources().getString(R.string.compEnv);
		
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
       groupList.add(desktop);
       groupList.add(phone);
       groupList.add(compEnv);
       groupList.add(web);
   }

   private void createCollection() {
       // preparing collection(child)
       String[] webList = {getResources().getString(R.string.webDesc)};
       String[] desktopList = {getResources().getString(R.string.desktopDesc)};
       String[] phoneList = {getResources().getString(R.string.phoneDesc)};
       String[] compEnvList = {getResources().getString(R.string.compEnvDesc1),getResources().getString(R.string.compEnvDesc2)};
       

       titleCollection = new LinkedHashMap<String, List<String>>();

       for (String title : groupList) {
           if (title.equals(web)) {
               loadChild(webList);
           } else if (title.equals(desktop))
               loadChild(desktopList);
           else if (title.equals(phone))
               loadChild(phoneList);
           else if (title.equals(compEnv))
               loadChild(compEnvList);
          

           titleCollection.put(title, childList);
       }
   }

   private void loadChild(String[] models) {
       childList = new ArrayList<String>();
       for (String model : models)
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
