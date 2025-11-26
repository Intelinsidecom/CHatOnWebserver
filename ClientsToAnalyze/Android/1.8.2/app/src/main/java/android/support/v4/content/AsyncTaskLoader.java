package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader extends Loader {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile LoadTask mCancellingTask;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTask mTask;
    long mUpdateThrottle;

    public abstract Object loadInBackground();

    final class LoadTask extends ModernAsyncTask implements Runnable {
        private CountDownLatch done = new CountDownLatch(1);
        Object result;
        boolean waiting;

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.content.ModernAsyncTask
        public Object doInBackground(Void... voidArr) {
            this.result = AsyncTaskLoader.this.onLoadInBackground();
            return this.result;
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void onPostExecute(Object obj) {
            try {
                AsyncTaskLoader.this.dispatchOnLoadComplete(this, obj);
            } finally {
                this.done.countDown();
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void onCancelled() {
            try {
                AsyncTaskLoader.this.dispatchOnCancelled(this, this.result);
            } finally {
                this.done.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.waiting = AsyncTaskLoader.DEBUG;
            AsyncTaskLoader.this.executePendingTask();
        }
    }

    public AsyncTaskLoader(Context context) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    @Override // android.support.v4.content.Loader
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask();
        executePendingTask();
    }

    public boolean cancelLoad() {
        boolean zCancel = DEBUG;
        if (this.mTask != null) {
            if (this.mCancellingTask != null) {
                if (this.mTask.waiting) {
                    this.mTask.waiting = DEBUG;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
            } else if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
            } else {
                zCancel = this.mTask.cancel(DEBUG);
                if (zCancel) {
                    this.mCancellingTask = this.mTask;
                }
                this.mTask = null;
            }
        }
        return zCancel;
    }

    public void onCanceled(Object obj) {
    }

    void executePendingTask() {
        if (this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = DEBUG;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.waiting = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
            } else {
                this.mTask.executeOnExecutor(ModernAsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
            }
        }
    }

    void dispatchOnCancelled(LoadTask loadTask, Object obj) {
        onCanceled(obj);
        if (this.mCancellingTask == loadTask) {
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(LoadTask loadTask, Object obj) {
        if (this.mTask != loadTask) {
            dispatchOnCancelled(loadTask, obj);
        } else {
            if (isAbandoned()) {
                onCanceled(obj);
                return;
            }
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mTask = null;
            deliverResult(obj);
        }
    }

    protected Object onLoadInBackground() {
        return loadInBackground();
    }

    public void waitForLoader() throws InterruptedException {
        LoadTask loadTask = this.mTask;
        if (loadTask != null) {
            try {
                loadTask.done.await();
            } catch (InterruptedException e) {
            }
        }
    }

    @Override // android.support.v4.content.Loader
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.waiting);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.waiting);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
