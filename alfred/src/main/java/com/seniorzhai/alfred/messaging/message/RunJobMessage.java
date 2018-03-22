package com.seniorzhai.alfred.messaging.message;

import com.seniorzhai.alfred.messaging.Message;
import com.seniorzhai.alfred.messaging.Type;
import com.seniorzhai.alfred.JobHolder;

public class RunJobMessage extends Message {
    private JobHolder jobHolder;
    public RunJobMessage() {
        super(Type.RUN_JOB);
    }

    public JobHolder getJobHolder() {
        return jobHolder;
    }

    public void setJobHolder(JobHolder jobHolder) {
        this.jobHolder = jobHolder;
    }

    @Override
    protected void onRecycled() {
        jobHolder = null;
    }
}
