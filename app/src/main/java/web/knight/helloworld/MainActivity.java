package web.knight.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    private int lineCounter = 0;
    private String[] lyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lyrics = getResources().getStringArray(R.array.song_lyrics);
        Log.i(TAG, "onCreate");
    }

    public void changeWidth (View view) {
        Button mainButton = findViewById(R.id.button);
        int currentWidth = mainButton.getWidth();
        int maxWidth = mainButton.getMaxWidth();

        currentWidth += 50;
        mainButton.setWidth(currentWidth);

        if (currentWidth == maxWidth) {
            mainButton.setText("Ты дошёл до конца!");
        }
    }

    public void showTextLyrics(View v) {
        if (lyrics == null || lyrics.length == 0) return;

        FancyToast.makeText(this, lyrics[lineCounter],FancyToast.LENGTH_LONG,FancyToast.INFO,false).show();
        lineCounter = (lineCounter + 1) % lyrics.length;
    }

    String TAG = "life";

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.i(TAG, "onCreate");
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

}