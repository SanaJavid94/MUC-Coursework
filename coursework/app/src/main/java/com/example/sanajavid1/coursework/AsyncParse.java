package com.example.sanajavid1.coursework;

import android.os.AsyncTask;

import java.util.ArrayList;

public class AsyncParse extends AsyncTask<Void, Void, Void> {

    public ArrayList<FeedData> GAData;
    public ParsingData GAParser;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        GAData = new ArrayList<FeedData>();
        GAParser = new ParsingData();
    }

    @Override
    protected Void doInBackground(Void...params) {
        while (true) {
            try {
                GAData = GAParser.retrieveData();
            } catch (Exception e) {

            }
            break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

}