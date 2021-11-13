package rob.myappcompany.circledeterminateprogressbartextandbackgrounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button clickme_btn;
    TextView statusTextView;

    int progressStatus = 0;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarId);
        clickme_btn = findViewById(R.id.Progress_btn);
        statusTextView = findViewById(R.id.text_status);

        clickme_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100){
                            progressStatus++;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    statusTextView.setText(progressStatus + " %");
                                }
                            });
                            try {
                                Thread.sleep(200);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}