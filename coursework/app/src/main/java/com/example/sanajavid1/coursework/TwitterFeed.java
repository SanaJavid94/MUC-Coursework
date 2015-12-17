package com.example.sanajavid1.coursework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TwitterFeed extends ActionBarActivity {

    public static AsyncParse parseAsync;

    public TextView firstTweet, firstDate;
    public TextView secondTweet, secondDate;
    public TextView thirdTweet, thirdDate;
    public TextView fourthTweet, fourthDate;
    public TextView fifthTweet, fifthDate;
    public TextView sixthTweet, sixthDate;
    public TextView seventhTweet, seventhDate;
    public TextView eighthTweet, eighthDate;
    public TextView ninthTweet, ninthDate;
    public TextView tenthTweet, tenthDate;
    public TextView eleventhTweet, eleventhDate;
    public TextView twelfthTweet, twelfthDate;
    public TextView thirteenthTweet, thirteenthDate;
    public TextView fourteenthTweet, fourteenthDate;
    public TextView fifteenthTweet, fifteenthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_activity);

        parseAsync = new AsyncParse();
        parseAsync.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

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

    public void viewContent(View view) {
        firstTweet = (TextView) findViewById(R.id.titleText);
        firstTweet.setText(parseAsync.GAData.get(0).TitleString);
        firstDate = (TextView) findViewById(R.id.pubDateText);
        firstDate.setText(parseAsync.GAData.get(0).PubDateString);

        secondTweet = (TextView) findViewById(R.id.titleText2);
        secondTweet.setText(parseAsync.GAData.get(1).TitleString);
        secondDate = (TextView) findViewById(R.id.pubDateText2);
        secondDate.setText(parseAsync.GAData.get(1).PubDateString);

        thirdTweet = (TextView) findViewById(R.id.titleText3);
        thirdTweet.setText(parseAsync.GAData.get(2).TitleString);
        thirdDate = (TextView) findViewById(R.id.pubDateText3);
        thirdDate.setText(parseAsync.GAData.get(2).PubDateString);

        fourthTweet = (TextView) findViewById(R.id.titleText4);
        fourthTweet.setText(parseAsync.GAData.get(3).TitleString);
        fourthDate = (TextView) findViewById(R.id.pubDateText4);
        fourthDate.setText(parseAsync.GAData.get(3).PubDateString);

        fifthTweet = (TextView) findViewById(R.id.titleText5);
        fifthTweet.setText(parseAsync.GAData.get(4).TitleString);
        fifthDate = (TextView) findViewById(R.id.pubDateText5);
        fifthDate.setText(parseAsync.GAData.get(4).PubDateString);

        sixthTweet = (TextView) findViewById(R.id.titleText6);
        sixthTweet.setText(parseAsync.GAData.get(5).TitleString);
        sixthDate = (TextView) findViewById(R.id.pubDateText6);
        sixthDate.setText(parseAsync.GAData.get(5).PubDateString);

        seventhTweet = (TextView) findViewById(R.id.titleText7);
        seventhTweet.setText(parseAsync.GAData.get(6).TitleString);
        seventhDate = (TextView) findViewById(R.id.pubDateText7);
        seventhDate.setText(parseAsync.GAData.get(6).PubDateString);

        eighthTweet = (TextView) findViewById(R.id.titleText8);
        eighthTweet.setText(parseAsync.GAData.get(7).TitleString);
        eighthDate = (TextView) findViewById(R.id.pubDateText8);
        eighthDate.setText(parseAsync.GAData.get(7).PubDateString);

        ninthTweet = (TextView) findViewById(R.id.titleText9);
        ninthTweet.setText(parseAsync.GAData.get(8).TitleString);
        ninthDate = (TextView) findViewById(R.id.pubDateText9);
        ninthDate.setText(parseAsync.GAData.get(8).PubDateString);

        tenthTweet = (TextView) findViewById(R.id.titleText10);
        tenthTweet.setText(parseAsync.GAData.get(9).TitleString);
        tenthDate = (TextView) findViewById(R.id.pubDateText10);
        tenthDate.setText(parseAsync.GAData.get(9).PubDateString);

        eleventhTweet = (TextView) findViewById(R.id.titleText11);
        eleventhTweet.setText(parseAsync.GAData.get(10).TitleString);
        eleventhDate = (TextView) findViewById(R.id.pubDateText11);
        eleventhDate.setText(parseAsync.GAData.get(10).PubDateString);

        twelfthTweet = (TextView) findViewById(R.id.titleText12);
        twelfthTweet.setText(parseAsync.GAData.get(11).TitleString);
        twelfthDate = (TextView) findViewById(R.id.pubDateText12);
        twelfthDate.setText(parseAsync.GAData.get(11).PubDateString);

        thirteenthTweet = (TextView) findViewById(R.id.titleText13);
        thirteenthTweet.setText(parseAsync.GAData.get(12).TitleString);
        thirteenthDate = (TextView) findViewById(R.id.pubDateText13);
        thirteenthDate.setText(parseAsync.GAData.get(12).PubDateString);

        fourteenthTweet = (TextView) findViewById(R.id.titleText14);
        fourteenthTweet.setText(parseAsync.GAData.get(13).TitleString);
        fourteenthDate = (TextView) findViewById(R.id.pubDateText14);
        fourteenthDate.setText(parseAsync.GAData.get(13).PubDateString);

        fifteenthTweet = (TextView) findViewById(R.id.titleText15);
        fifteenthTweet.setText(parseAsync.GAData.get(14).TitleString);
        fifteenthDate = (TextView) findViewById(R.id.pubDateText15);
        fifteenthDate.setText(parseAsync.GAData.get(14).PubDateString);
    }

    public void view1st(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(0).TitleString + "\n" + "\n" + parseAsync.GAData.get(0).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view2nd(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(1).TitleString + "\n" + "\n" + parseAsync.GAData.get(1).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view3rd(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(2).TitleString + "\n" + "\n" + parseAsync.GAData.get(2).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view4th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(3).TitleString + "\n" + "\n" + parseAsync.GAData.get(3).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view5th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(4).TitleString + "\n" + "\n" + parseAsync.GAData.get(4).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view6th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(5).TitleString + "\n" + "\n" + parseAsync.GAData.get(5).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view7th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(6).TitleString + "\n" + "\n" + parseAsync.GAData.get(6).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view8th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(7).TitleString + "\n" + "\n" + parseAsync.GAData.get(7).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view9th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(8).TitleString + "\n" + "\n" + parseAsync.GAData.get(8).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view10th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(9).TitleString + "\n" + "\n" + parseAsync.GAData.get(9).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view11th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(10).TitleString + "\n" + "\n" + parseAsync.GAData.get(10).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view12th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(11).TitleString + "\n" + "\n" + parseAsync.GAData.get(11).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view13th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(12).TitleString + "\n" + "\n" + parseAsync.GAData.get(12).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view14th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(13).TitleString + "\n" + "\n" + parseAsync.GAData.get(13).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void view15th(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(parseAsync.GAData.get(14).TitleString + "\n" + "\n" + parseAsync.GAData.get(14).PubDateString);
        builder.setCancelable(false);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}