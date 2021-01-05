package space.digitallab.testappforinstat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.digitallab.testappforinstat.dto.MatchInfo;
import space.digitallab.testappforinstat.dto.VideoUrls;
import space.digitallab.testappforinstat.net.Adapter;
import space.digitallab.testappforinstat.net.BodyDataResponse;
import space.digitallab.testappforinstat.net.BodyUrlResponse;
import space.digitallab.testappforinstat.net.DataCall;
import space.digitallab.testappforinstat.net.MatchInfoCall;
import space.digitallab.testappforinstat.net.Params;

public class MainActivity extends AppCompatActivity {

    private MatchInfo matchInfo;
    //private VideoUrls videoUrls;
    private TextView tournament, date, team1, team2;
    private ListView videoList;
    private List<VideoUrls> videoUrlsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        tournament = findViewById(R.id.tournament);
        date = findViewById(R.id.date);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        videoList = findViewById(R.id.video_list);
/*
        videoUrls = new VideoUrls();
        videoUrls.setName("загрузка");
        videoUrls.setPeriod(0);
        videoUrls.setQuality("загрузка");
        videoUrls.setSize(0);
        videoUrlsList.add(videoUrls);



 */

    dataNetworkRequest(new BodyUrlResponse(1724836, 1));
    matchInfoRequest(new BodyDataResponse("get_match_info", new Params(1, 1724836)));

    }

    private  void dataNetworkRequest(BodyUrlResponse bodyUrlResponse){

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        okHttpClientBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.instat.tv")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build() );

        Retrofit retrofit = builder.build();

        DataCall dataCall = retrofit.create(DataCall.class);

        Call<List<VideoUrls>> call = dataCall.videoUrls("application/json", bodyUrlResponse);
        call.enqueue(new Callback<List<VideoUrls>>() {
            @Override
            public void onResponse(Call<List<VideoUrls>> call, Response<List<VideoUrls>> response) {

                videoUrlsList = response.body();
                videoList.setAdapter(new Adapter(MainActivity.this, videoUrlsList));
            }

            @Override
            public void onFailure(Call<List<VideoUrls>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void matchInfoRequest (BodyDataResponse bodyDataResponse) {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        okHttpClientBuilder.addInterceptor(logging);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.instat.tv")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build() );

        Retrofit retrofit = builder.build();

        MatchInfoCall matchInfoCall = retrofit.create(MatchInfoCall.class);

        Call<MatchInfo> call = matchInfoCall.matchInfo("application/json", bodyDataResponse);
        call.enqueue(new Callback<MatchInfo>() {
            @Override
            public void onResponse(Call<MatchInfo> call, Response<MatchInfo> response) {
                matchInfo = response.body();
                String[] subStr;
                String delimeter = "T";
                subStr = matchInfo.getDate().split(delimeter);
                tournament.setText("" + matchInfo.getTournament().getNameEng());
                date.setText("" + subStr[0] + "\n" + subStr[1]);
                team1.setText("" + matchInfo.getTeam1().getNameEng() + " - " + matchInfo.getTeam1().getScore());
                team2.setText("" + matchInfo.getTeam2().getNameEng() + " - " + matchInfo.getTeam2().getScore());
            }

            @Override
            public void onFailure(Call<MatchInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, PlayVideo.class);
        intent.putExtra("url", ((TextView)v).getText().toString());
        startActivity(intent);

    }
}