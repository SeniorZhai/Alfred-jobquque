package com.seniorzhai.alfred.messaging.message;

import com.seniorzhai.alfred.messaging.Message;
import com.seniorzhai.alfred.messaging.Type;
import com.seniorzhai.alfred.Job;

public class AddJobMessage extends Message {
    private Job job;
    public AddJobMessage() {
        super(Type.ADD_JOB);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    protected void onRecycled() {
        job = null;
    }
}
