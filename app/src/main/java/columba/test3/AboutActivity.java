package columba.test3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Artur on 07.10.2016.
 */

public class AboutActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        Intent intent = getIntent();
        String url =  intent.getStringExtra("videoLink");

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String videoUrl=url;
        Uri video = Uri.parse(videoUrl);
        videoView.setVideoURI(video);

        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
