package com.example.sanajavid1.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    //Starts "main_activity.xml" which contains all the buttons for the main pages of the app.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    //Starts the "main_menu.xml"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //All buttons in the Main Activity are linked to their classes when user clicks on them
    public void gymLoc (View view) {
        Intent loc = new Intent(MainActivity.this, GymLocator.class);
        startActivity(loc);
    }

    public void twit (View view) {
        Intent twit = new Intent(MainActivity.this, TwitterFeed.class);
        startActivity(twit);
    }

    public void gClass (View view) {
        Intent classes = new Intent(MainActivity.this, GymClasses.class);
        startActivity(classes);
    }

    public void abo (View view) {
        startActivity(new Intent(MainActivity.this, AboutGym.class));
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
