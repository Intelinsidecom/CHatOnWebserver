package com.vlingo.sdk.internal;

import android.os.Handler;
import com.vlingo.sdk.VLComponent;
import com.vlingo.sdk.internal.logging.Logger;

/* loaded from: classes.dex */
abstract class VLComponentImpl implements VLComponent {
    private static Logger log = Logger.getLogger(VLComponentImpl.class);
    private Handler mHandler;
    private boolean mIsBusy;
    private VLComponentManager mManager;
    private boolean mIsValid = true;
    private Object mDestroyLock = new Object();

    abstract void onDestroy();

    VLComponentImpl(VLComponentManager manager, Handler handler) {
        this.mManager = manager;
        this.mHandler = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vlingo.sdk.VLComponent
    public synchronized void destroy() {
        synchronized (this.mDestroyLock) {
            log.debug("destroy()");
            if (this.mIsValid) {
                this.mIsValid = false;
                this.mHandler = null;
                this.mManager.removeComponent(getClass());
                this.mManager = null;
                onDestroy();
            }
        }
    }

    @Override // com.vlingo.sdk.VLComponent
    public boolean isValid() {
        return this.mIsValid;
    }

    Object getDestroyLock() {
        return this.mDestroyLock;
    }

    void validateInstance() {
        if (!this.mIsValid) {
            log.debug("  invalid instance");
            throw new IllegalStateException(String.valueOf(getClass().getName()) + " instance is no longer valid!");
        }
    }

    void setBusy(boolean isBusy) {
        this.mIsBusy = isBusy;
    }

    boolean isBusy() {
        return this.mIsBusy;
    }

    Handler getHandler() {
        return this.mHandler;
    }
}
