package com.example.airwallet;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView tView;
    Button clickhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView = (TextView) findViewById(R.id.tv_top);
        clickhere = (Button) findViewById(R.id.bt_reg);
    }

    public void registerClick(View v) {
        new URLTask().execute();
    }

    public class URLTask extends AsyncTask<String, String, String> {
    String jsonData;
        protected String doInBackground(String... urlvalue) {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://gp4javanode.herokuapp.com/returnchain")
                        .build();
                Response responses = null;
                try {
                    responses = client.newCall(request).execute();
                    jsonData = responses.body().string();
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

        protected void onPostExecute(String st3) {
            updateTV(jsonData);
            return;
        }

        private void updateTV(String newval){
            tView.setText(newval);
        }

    }
}
