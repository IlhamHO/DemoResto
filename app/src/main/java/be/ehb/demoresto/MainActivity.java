package be.ehb.demoresto;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.IOException;

import be.ehb.demoresto.model.MockRestoDataSource;
import be.ehb.demoresto.util.RestoAdapter;
import be.ehb.demoresto.util.RestoHandler;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRestos;
    private RestoHandler mRestoHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRestos = findViewById(R.id.rv_resto);

        RestoAdapter mRestoAdapter = new RestoAdapter(MockRestoDataSource.getInstance().getRestos());
        rvRestos.setAdapter(mRestoAdapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvRestos.setLayoutManager(mLayoutManager);

        mRestoHandler = new RestoHandler(mRestoAdapter);

        downloadData();
    }

    private void downloadData() {
        Thread backThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://opendata.brussel.be/api/records/1.0/search/?dataset=eten-en-drinken&rows=80")
                            .get()
                            .build();

                    Response response = client.newCall(request).execute();

                    if (response.body() != null) {
                        String responseBodyText = response.body().string();

                        Message msg = new Message();
                        msg.obj = responseBodyText;
                        mRestoHandler.sendMessage(msg);


                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


        backThread.start();
    }
}
