package com.seniorzhai.alfred.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.seniorzhai.alfred.Job;
import com.seniorzhai.alfred.Params;
import com.seniorzhai.alfred.RetryConstraint;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runJob(View view) {
        MyApplication.getInstance().getJobManager().addJobInBackground(new Job(new Params(1)) {
            @Override
            public void onAdded() {
                Log.d("---", "Add");
            }

            @Override
            public void onRun() throws Throwable {
                Thread.sleep(10000);
                Log.d("---", "Run");
            }

            @Override
            protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

            }

            @Override
            protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
                return null;
            }
        });
    }
}
