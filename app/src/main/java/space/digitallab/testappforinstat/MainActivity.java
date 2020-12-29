package space.digitallab.testappforinstat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import space.digitallab.testappforinstat.dto.MatchInfo;
import space.digitallab.testappforinstat.dto.Tournament;
import space.digitallab.testappforinstat.dto.VideoUrls;

public class MainActivity extends AppCompatActivity {

    private MatchInfo matchInfo;
    private VideoUrls videoUrls;
    private TextView tournament, date, team1, team2;
    private ListView videoList;
    private ArrayList<VideoUrls> videoUrlsList;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tournament = findViewById(R.id.tournament);
        date = findViewById(R.id.date);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        videoList = findViewById(R.id.video_list);

        videoUrls = new VideoUrls();
        videoUrls.setName("загрузка");
        videoUrls.setPeriod(0);
        videoUrls.setQuality("загрузка");
        videoUrls.setSize(0);
        videoUrlsList.add(videoUrls);

        tournament.setText("загрузка");
        date.setText("загрузка");
        team1.setText("загрузка");
        team2.setText("загрузка");

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }
}