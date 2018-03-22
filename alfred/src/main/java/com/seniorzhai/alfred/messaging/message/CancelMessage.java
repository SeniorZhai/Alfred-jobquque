package com.seniorzhai.alfred.messaging.message;

import com.seniorzhai.alfred.messaging.Message;
import com.seniorzhai.alfred.messaging.Type;
import com.seniorzhai.alfred.CancelResult;
import com.seniorzhai.alfred.TagConstraint;

public class CancelMessage extends Message {
    private TagConstraint constraint;
    private String[] tags;
    private CancelResult.AsyncCancelCallback callback;

    public CancelMessage() {
        super(Type.CANCEL);
    }

    @Override
    protected void onRecycled() {

    }

    public TagConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(TagConstraint constraint) {
        this.constraint = constraint;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public CancelResult.AsyncCancelCallback getCallback() {
        return callback;
    }

    public void setCallback(CancelResult.AsyncCancelCallback callback) {
        this.callback = callback;
    }
}
