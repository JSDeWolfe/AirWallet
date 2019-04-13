package com.example.airwallet;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

public class URLTask extends AsyncTask<String, String, String> {

    protected String doInBackground(String... urlvalue) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://gp4javanode.herokuapp.com/returnchain")
                    .build();
            Response responses = null;
            try {
                responses = client.newCall(request).execute();
                String jsonData = responses.body().string();
                String jreturn = jsonData.toString();
                //JSONObject Jobject = new JSONObject(jsonData);
                //error: A JSONObject text must begin with '{' at 1 [character 2 line 1]
                System.out.println(jsonData);
                return jsonData;
            } catch (IOException ioe) {
                StringWriter sw = new StringWriter();
                ioe.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                return exceptionAsString;
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                return exceptionAsString;
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
            return exceptionAsString;
        } finally {
            System.out.println("stuff not workin");
            return "no work";
        }
    }

        protected void onProgressUpdate(String... st2) {
            return;
        }

        protected void onPostExecute(String... st3) {

            return;
        }

}