package com.seniorzhai.alfred.messaging.message;

import com.seniorzhai.alfred.messaging.Message;
import com.seniorzhai.alfred.messaging.Type;

public class ConstraintChangeMessage extends Message {
    private boolean forNextJob;
    public ConstraintChangeMessage() {
        super(Type.CONSTRAINT_CHANGE);
    }

    @Override
    protected void onRecycled() {
        forNextJob = false;
    }

    public boolean isForNextJob() {
        return forNextJob;
    }

    public void setForNextJob(boolean forNextJob) {
        this.forNextJob = forNextJob;
    }
}
