package com.example.user.threadprogressbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends Activity {

     ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1=(ProgressBar) findViewById(R.id.progressBar1);
        Button btnStart=(Button) findViewById(R.id.btnStart) ;

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressBar1.setProgress(0);
                new Thread(new Task()).start();
            }
        });
    }

    class Task implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                final int value=i;
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {e.printStackTrace();
                }
                progressBar1.setProgress(value);

            }

        }
    }

}


