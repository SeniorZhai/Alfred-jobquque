package com.seniorzhai.alfred.example;

import android.support.annotation.NonNull;
import com.seniorzhai.alfred.JobManager;
import com.seniorzhai.alfred.scheduling.FrameworkJobSchedulerService;

public class MyJobService extends FrameworkJobSchedulerService {
    @NonNull
    @Override
    protected JobManager getJobManager() {
        return MyApplication.getInstance().getJobManager();
    }
}