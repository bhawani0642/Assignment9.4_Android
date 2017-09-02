package com.acadgild.contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Access to the texview
        TextView tvw = (TextView) findViewById(R.id.texview);
        this.registerForContextMenu(tvw);
    }
  //overriding the onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.texview) {
            this.getMenuInflater().inflate(R.menu.color_context_menu, menu);
            super.onCreateContextMenu(menu, v, menuInfo);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int selectedItemId=item.getItemId();
        //Access to the Main layout
        RelativeLayout mainLayout= (RelativeLayout) findViewById(R.id.mainLayout);
        //using the swith case to display the appropriate buttton selected in action
        switch (selectedItemId){

            case R.id.itemRed:
                mainLayout.setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(),"Red color selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemGreen:
                mainLayout.setBackgroundColor(Color.GREEN);
                Toast.makeText(getApplicationContext(),"Green color selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.itemBlue:
                mainLayout.setBackgroundColor(Color.BLUE);
                Toast.makeText(getApplicationContext(),"Blue color selected",Toast.LENGTH_LONG).show();
                break;

        }

        return super.onContextItemSelected(item);
    }
}
