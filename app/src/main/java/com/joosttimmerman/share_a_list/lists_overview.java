package com.joosttimmerman.share_a_list;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class lists_overview extends Activity {

    //declare globals;
    TextView listTitle;
    Animation animSlideDown, animSlideUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_overview);

        // load the animation
        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);

        //get the textview
        listTitle = (TextView)findViewById(R.id.listTitle);

        //set font
        //Typeface roboto_thin = Typeface.createFromAsset(getAssets(),"Roboto-Thin.ttf");
        //listTitle.setTypeface(roboto_thin);

        //overridePendingTransition(R.anim.slide_right2left,R.anim.scale_down_darken);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //animate title slide
        listTitle.startAnimation(animSlideDown);
    }

    @Override
    public void onPause() {

        //animate title slide
        listTitle.startAnimation(animSlideUp);

        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lists_overview, menu);
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
