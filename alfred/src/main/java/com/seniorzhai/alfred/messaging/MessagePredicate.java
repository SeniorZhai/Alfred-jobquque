package com.seniorzhai.alfred.messaging;

public interface MessagePredicate {
    boolean onMessage(Message message);
}
