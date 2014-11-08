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

public class ProgramActivity extends Activity {
	List<String> groupList;
	List<String> childList;
	Map<String, List<String>> titleCollection;
	ExpandableListView expListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);   
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    
		setContentView(R.layout.activity_program);
		
		createGroupList();
		 
		createCollection();

		expListView = (ExpandableListView) findViewById(R.id.expandableListView1);
		final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
				this, groupList, titleCollection);
		expListView.setAdapter(expListAdapter);
      
		//expandAll();
		expListView.expandGroup(3);
		//setGroupIndicatorToRight();
	}

	private void createGroupList() {
      groupList = new ArrayList<String>();
      groupList.add(getString(R.string.information_systems) );
      groupList.add( getString(R.string.hardware_architecture));
      groupList.add(getString(R.string.general_training));
      groupList.add(getString(R.string.software_development));
      groupList.add(getString(R.string.system_and_network) );
      groupList.add( getString(R.string.models_and_mathematical_tools));
      groupList.add(getString(R.string.work_experience));
      groupList.add(getString(R.string.foreign_languages));
      groupList.add(getString(R.string.spo));
  }

  private void createCollection() {
      // preparing collection(child)
      String[] is = { getString(R.string.is1),getString(R.string.is2),getString(R.string.is3),
    		  getString(R.string.is4),getString(R.string.is5),getString(R.string.is6)};
      String[] ha = { getString(R.string.ha1),getString(R.string.ha2)};
      String[] gt = { getString(R.string.gt1), getString(R.string.gt2), getString(R.string.gt3), getString(R.string.gt4)};
      String[] sd = { getString(R.string.sd1), getString(R.string.sd2),getString(R.string.sd3),getString(R.string.sd4)};
      String[] sn = { getString(R.string.sn1),getString(R.string.sn2),getString(R.string.sn3)};
      String[] mmt = { getString(R.string.mmt1),getString(R.string.mmt2),getString(R.string.mmt3),
    		  getString(R.string.mmt4),getString(R.string.mmt5),getString(R.string.mmt6),getString(R.string.mmt7)};
      String[] we = { getString(R.string.we1)};
      String[] fl = { getString(R.string.fl1)};
      String[] s = { ""};
      
      

      titleCollection = new LinkedHashMap<String, List<String>>();

      for (String title : groupList) {
          if (title.equals(getString(R.string.information_systems))) {
              loadChild(is);
          } else if (title.equals(getString(R.string.hardware_architecture)))
              loadChild(ha);
          else if (title.equals(getString(R.string.general_training)))
              loadChild(gt);
          else if (title.equals(getString(R.string.software_development)))
              loadChild(sd);
          else if (title.equals(getString(R.string.system_and_network)))
              loadChild(sn);
          else if (title.equals(getString(R.string.models_and_mathematical_tools)))
              loadChild(mmt);
          else if (title.equals(getString(R.string.work_experience)))
              loadChild(we);
          else if (title.equals(getString(R.string.foreign_languages)))
              loadChild(fl);
          else if (title.equals(getString(R.string.spo)))
              loadChild(s);

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
