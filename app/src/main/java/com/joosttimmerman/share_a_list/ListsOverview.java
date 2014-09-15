package com.joosttimmerman.share_a_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import database.DatabaseManager;
import database.ListName;


public class ListsOverview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_overview);

        //get all groceries from the database
        DatabaseManager.init(this);
        DatabaseManager db = DatabaseManager.getInstance();

        List<ListName> listNames = db.getAllListNames();

        //Add two recipes when database is completely empty
        if(listNames.isEmpty()) {
            ListName item = new ListName();
            item.setListName("Boodschappen","in de moeder");
            DatabaseManager.getInstance().addListName(item);
            item.setListName("ToDo", "voor alles wat je vergeet");
            DatabaseManager.getInstance().addListName(item);
        }

        //fill the listview with listnames
        ListView list = (ListView)findViewById(R.id.listNames);
        ListsOverview_adapter adapter = new ListsOverview_adapter(this,R.layout.listitem_lists_overview, db.getAllListNames());
        if(list == null){
            System.out.println("list is null :(");
        } else {
            System.out.println("list is niet null! :)");
        }
        list.setAdapter(adapter);

        TextView titel = (TextView)findViewById(R.id.listTitle);
        ImageButton addButton = (ImageButton) findViewById(R.id.addList);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        Animation fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        titel.startAnimation(slide_down);
        list.startAnimation(fade_in);
        addButton.startAnimation(fade_in);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListsOverview.this, ListDetails.class);
                startActivity(intent);
            }
        });
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
