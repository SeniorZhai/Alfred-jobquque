package com.seniorzhai.alfred.messaging.message;

import com.seniorzhai.alfred.messaging.Message;
import com.seniorzhai.alfred.messaging.Type;
import com.seniorzhai.alfred.CancelResult;

public class CancelResultMessage extends Message {
    CancelResult.AsyncCancelCallback callback;
    CancelResult result;
    public CancelResultMessage() {
        super(Type.CANCEL_RESULT_CALLBACK);
    }

    @Override
    protected void onRecycled() {
        result = null;
        callback = null;
    }

    public void set(CancelResult.AsyncCancelCallback callback, CancelResult result) {
        this.callback = callback;
        this.result = result;
    }

    public CancelResult.AsyncCancelCallback getCallback() {
        return callback;
    }

    public CancelResult getResult() {
        return result;
    }
}
