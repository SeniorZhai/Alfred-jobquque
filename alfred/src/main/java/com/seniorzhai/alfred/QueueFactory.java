package com.seniorzhai.alfred;


import com.seniorzhai.alfred.config.Configuration;

public interface QueueFactory {
    JobQueue createPersistentQueue(Configuration configuration, long sessionId);
    JobQueue createNonPersistent(Configuration configuration, long sessionId);
}