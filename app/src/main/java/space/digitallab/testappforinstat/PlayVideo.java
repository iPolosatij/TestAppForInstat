package space.digitallab.testappforinstat;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import space.digitallab.testappforinstat.dto.VideoUrls;
import space.digitallab.testappforinstat.net.Adapter;
import space.digitallab.testappforinstat.net.BodyUrlResponse;
import space.digitallab.testappforinstat.net.DataCall;

public class PlayVideo extends AppCompatActivity {

    private  TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        textView = findViewById(R.id.textUrl);
        textView.setText(getIntent().getStringExtra("url"));

    }
}
