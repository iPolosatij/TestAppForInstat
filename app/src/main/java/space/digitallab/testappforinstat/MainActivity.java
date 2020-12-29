package space.digitallab.testappforinstat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import space.digitallab.testappforinstat.dto.MatchInfo;
import space.digitallab.testappforinstat.dto.VideoUrls;

public class MainActivity extends AppCompatActivity {

    private MatchInfo matchInfo;
    private VideoUrls videoUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}