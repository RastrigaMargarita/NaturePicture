package com.margretcraft.naturepicture;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPictureArray extends AsyncTask<Void, Void, ArrayList<String>> {

    MainActivity mainActivity;

    public GetPictureArray(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        SoftReference soft = new SoftReference(mainActivity);
    }


    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        ArrayList<String> ars = new ArrayList<>();
        URL url = null;
        HttpURLConnection urlConnection = null;
        StringBuilder sb = null;
        BufferedReader br = null;
        try{
            url = new URL(mainActivity.getResources().getString(R.string.pathToGoogle));
            urlConnection = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection!=null){

                urlConnection.disconnect();
            }
        }
        Pattern pattern = Pattern.compile("https://cdny(.*?)\"");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            ars.add(matcher.group().replace("\"",""));
        }
        return ars;
    }
}
