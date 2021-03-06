package com.seniorzhai.alfred.log;

import com.seniorzhai.alfred.JobManager;

/**
 * You can provide your own logger implementation to {@link JobManager}
 * it is very similar to Roboguice's logger
 */
public interface CustomLogger {
    /**
     * JobManager may call this before logging something that is (relatively) expensive to calculate
     * @return True if debug logs are enabled
     */
    boolean isDebugEnabled();
    void d(String text, Object... args);
    void e(Throwable t, String text, Object... args);
    void e(String text, Object... args);
    void v(String text, Object... args);
}
