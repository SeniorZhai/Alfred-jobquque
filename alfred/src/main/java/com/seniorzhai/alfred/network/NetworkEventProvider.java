package com.seniorzhai.alfred.network;

import com.seniorzhai.alfred.JobManager;

/**
 * An interface that NetworkUtil can implement if it supports a callback method when network state is changed
 * This is not mandatory but highly suggested so that {@link JobManager} can avoid
 * busy loops when there is a job waiting for network and there is no network available
 */
public interface NetworkEventProvider {
    void setListener(Listener listener);
    interface Listener {
        /**
         * @param networkStatus {@link NetworkUtil.NetworkStatus}
         */
        void onNetworkChange(@NetworkUtil.NetworkStatus int networkStatus);
    }
}
