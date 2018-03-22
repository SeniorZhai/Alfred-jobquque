package com.seniorzhai.alfred.example;

import android.app.Application;
import android.util.Log;
import com.seniorzhai.alfred.JobManager;
import com.seniorzhai.alfred.config.Configuration;
import com.seniorzhai.alfred.log.CustomLogger;
import com.seniorzhai.alfred.scheduling.FrameworkJobSchedulerService;

public class MyApplication extends Application {
    private static MyApplication instance;
    private JobManager jobManager;

    public MyApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getJobManager();// ensure it is created
    }

    private void configureJobManager() {
        Configuration.Builder builder = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";

                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }

                    @Override
                    public void v(String text, Object... args) {

                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120);//wait 2 minute
        builder.scheduler(FrameworkJobSchedulerService.createSchedulerFor(this,
                MyJobService.class), true);
        jobManager = new JobManager(builder.build());
    }

    public synchronized JobManager getJobManager() {
        if (jobManager == null) {
            configureJobManager();
        }
        return jobManager;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}