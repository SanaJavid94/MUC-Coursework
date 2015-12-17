package com.example.sanajavid1.coursework;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ParsingData {

    public String RSSFeedURL = "https://twitrss.me/twitter_user_to_rss/?user=xercise4less";

    private String result;

    private ArrayList<FeedData> myData;

    public ParsingData() {
        myData = new ArrayList<FeedData>();
    }

    public ArrayList<FeedData> retrieveData() {
        try {
            //Retrieves the data from the RSS feed
            result = RSSFeedString(RSSFeedURL);
            //Parses the data into the array
            parsedTwitterData();
            return myData;
        } catch (Exception ae) {
            return myData;
        }
    }

    private static String RSSFeedString(String urlString) throws IOException {
        String result = "";
        InputStream anInStream = null;
        int response = -1;
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        //Checks the connection to the stream
        if (!(conn instanceof HttpURLConnection))
            throw new IOException("Not as an HTTP Connection");
        try {
            //Opens the connection to the stream
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            response = httpConn.getResponseCode();
            //Checks that the connection is OK
            if(response == HttpURLConnection.HTTP_OK) {
                //If the connection is okay, open the stream
                anInStream = httpConn.getInputStream();
                InputStreamReader in = new InputStreamReader(anInStream);
                BufferedReader bin = new BufferedReader(in);
                //Reads the data from the stream
                bin.readLine(); //Throws away the header
                String line = new String();
                while (( (line = bin.readLine())) !=null) {
                    result = result + "\n" + line;
                }
            }
        } catch (Exception ex){
            throw new IOException("Error connecting");
        }
        //Returns the result from the stream as a string value
        return result;
    }


    private void parsedTwitterData() throws IOException {
        try {
            String title = "", pubDate = "";
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(result));
            int eventType = xpp.getEventType();
            Boolean hasCaughtItem = false;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equalsIgnoreCase("item")) {
                        hasCaughtItem = true;
                    } else {
                        if (xpp.getName().equalsIgnoreCase("title")) {
                            title = xpp.nextText();
                            Log.i("XML", "Found the title: " + title);
                        } else {
                            if (xpp.getName().equalsIgnoreCase("pubDate")) {
                                String[] temp = xpp.nextText().split(" ");
                                pubDate = temp[0] + " " + temp[1] + " "  + temp[2] + " "  + temp[3] + ", "  + temp[4];
                                Log.i("XML", "Found the publication date as: " + pubDate);
                            }
                        }
                    }
                }
                if (eventType == XmlPullParser.END_TAG) {
                    if (xpp.getName().equalsIgnoreCase("item")) {
                        myData.add(new FeedData(title, pubDate));
                        hasCaughtItem = false;
                    }
                }
                eventType = xpp.next();
            }
        } catch (Exception ae) {
            throw new IOException("Error parsing");
        }
    }
}