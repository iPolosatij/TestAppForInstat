package space.digitallab.testappforinstat;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;



public class PlayVideo extends AppCompatActivity {

    private  VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        videoView = findViewById(R.id.myVideo);

        String vidAddress = getIntent().getStringExtra("url");
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);
        videoView.start();

    }
}
