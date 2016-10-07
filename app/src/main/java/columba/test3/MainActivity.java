package columba.test3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private int x = 0;
    ImageView bdsm;

    String[] links;

    public MainActivity() throws MalformedURLException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyTask().execute();
        while (true) {
            if (links!=null) {
                Buttons();
                break;
            }
        }
    }



public void Buttons() {
    int fggg = 1;
    for (int i = 0; i <links.length/2 ; i++) {
        bdsm = new ImageView(this);
        Picasso.with(this).load(links[fggg]).into(bdsm);
        fggg +=2;
        LinearLayout layout = (LinearLayout) findViewById(R.id.main);
        layout.addView(bdsm);
        bdsm.setId(x);
        bdsm.setOnClickListener(this);
        x+=2;
    }

//    btn1 = new Button(this);
////   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
////        btn1.setBackground();
////    }
//    btn1.setText("");
//    btn1.setId(x);
//    btn1.setOnClickListener((View.OnClickListener) this);
//    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//    layoutParams.gravity = Gravity.CENTER;
//    layoutParams.setMargins(50, 30, 50, 0);
//    btn1.setLayoutParams(layoutParams);
//    LinearLayout layout = (LinearLayout) findViewById(R.id.main);
//    //layout.addView(btn1);
}



    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("videoLink", links[v.getId()]);
        startActivityForResult(intent, 1);
    }


    private class MyTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String title = "";
            org.jsoup.nodes.Document doc;
            try {
                doc = Jsoup.connect("http://artur789298.hopto.org/ID.html").get();
                Elements br = doc.select("p");
                //String title = doc.title();
                String link =  br.text();

                links = link.split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return title;
        }

    }

}