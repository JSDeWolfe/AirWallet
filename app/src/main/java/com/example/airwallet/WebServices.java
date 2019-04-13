package com.example.airwallet;

import android.os.AsyncTask;

import okhttp3.Response;
import okhttp3.Connection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

public class WebServices {
    public static String getJson() {
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
            }
            catch(IOException ioe) {
                StringWriter sw = new StringWriter();
                ioe.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                return exceptionAsString;
            }

            catch(Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();
                return exceptionAsString;
            }
        }
        catch(Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
            return exceptionAsString;
        }
        finally {
            System.out.println("stuff not workin");
            return "no work";
        }
    }

    public static String getJsonV2(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://gp4javanode.herokuapp.com/returnchain")
                    .build();
            Response responses = null;
            responses = client.newCall(request).execute();
            String jsonData = responses.body().string();
            //JSONObject Jobject = new JSONObject(jsonData);
            //error: A JSONObject text must begin with '{' at 1 [character 2 line 1]
            return jsonData;
        }
        catch(Exception ioe) {
            StringWriter sw = new StringWriter();
            ioe.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString+" 11111111111111");
            return exceptionAsString;
        }

        finally {
            System.out.println("stuff not workin 444444444");
            return "pinetree";
        }
    }


}
