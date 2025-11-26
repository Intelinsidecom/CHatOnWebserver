package com.p137vk.sdk.api.httpClient;

import android.os.Handler;
import android.os.Looper;
import com.p137vk.sdk.api.VKError;

/* loaded from: classes.dex */
public abstract class VKAbstractOperation {
    private static Handler mMainThreadHandler;
    private VKOperationCompleteListener mCompleteListener;
    private VKOperationState mState = VKOperationState.Created;
    private boolean mCanceled = false;

    public abstract class VKAbstractCompleteListener<OperationType, ResponseType> {
        public abstract void onComplete(OperationType operationtype, ResponseType responsetype);

        public abstract void onError(OperationType operationtype, VKError vKError);
    }

    public interface VKOperationCompleteListener {
        void onComplete();
    }

    public enum VKOperationState {
        Created,
        Ready,
        Executing,
        Paused,
        Finished
    }

    public abstract void start();

    protected static Handler getMainThreadHandler() {
        if (mMainThreadHandler == null) {
            mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return mMainThreadHandler;
    }

    public VKAbstractOperation() {
        setState(VKOperationState.Ready);
    }

    public void cancel() {
        this.mCanceled = true;
        setState(VKOperationState.Finished);
    }

    public void finish() {
        if (this.mCompleteListener != null) {
            postInMainQueue(new Runnable() { // from class: com.vk.sdk.api.httpClient.VKAbstractOperation.1
                @Override // java.lang.Runnable
                public void run() {
                    VKAbstractOperation.this.mCompleteListener.onComplete();
                }
            });
        }
    }

    protected void setCompleteListener(VKOperationCompleteListener vKOperationCompleteListener) {
        this.mCompleteListener = vKOperationCompleteListener;
    }

    protected void setState(VKOperationState vKOperationState) {
        if (stateTransitionIsValid(this.mState, vKOperationState, this.mCanceled)) {
            this.mState = vKOperationState;
            if (this.mState == VKOperationState.Finished) {
                finish();
            }
        }
    }

    private boolean stateTransitionIsValid(VKOperationState vKOperationState, VKOperationState vKOperationState2, boolean z) {
        switch (vKOperationState) {
            case Paused:
                if (vKOperationState2 != VKOperationState.Ready) {
                    break;
                }
                break;
            case Executing:
                switch (vKOperationState2) {
                }
            case Ready:
                switch (vKOperationState2) {
                }
        }
        return true;
    }

    public static void postInMainQueue(Runnable runnable) {
        getMainThreadHandler().post(runnable);
    }

    public static void postInMainQueueDelayed(Runnable runnable) {
        getMainThreadHandler().postDelayed(runnable, 300L);
    }
}
