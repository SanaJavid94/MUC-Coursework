package com.example.sanajavid1.coursework;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GymClasses extends ActionBarActivity {

    //Starts the "classes_activity" which displays the gym classes
    //and the times the classes run at
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classes_activity);
    }

    //Starts the "main_menu.xml"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Displays the "main_menu.xml" and links all the possible options within
    //the menu to the associated classes
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                Intent gaMain = new Intent(this, MainActivity.class);
                this.startActivity(gaMain);
                return true;
            case R.id.twitter:
                Intent gaTwitter = new Intent(this, TwitterFeed.class);
                this.startActivity(gaTwitter);
                return true;
            case R.id.classes:
                Intent gaClasses = new Intent(this, GymClasses.class);
                this.startActivity(gaClasses);
                return true;
            case R.id.locator:
                Intent gaLocator = new Intent(this, GymLocator.class);
                this.startActivity(gaLocator);
                return true;
            case R.id.About:
                Intent gaAbout = new Intent(this, AboutGym.class);
                this.startActivity(gaAbout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
