package com.samsung.android.sdk.pen.objectruntime.preload;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class VideoIntentFragment extends Fragment {
    private static OnVideoIntentFragmentListener mBackupListener;
    private OnVideoIntentFragmentListener mListener;

    public interface OnVideoIntentFragmentListener {
        void onDestroy();

        void onResult(Intent intent);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mListener != null) {
            this.mListener.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.mListener != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("video/*");
            startActivityForResult(intent, 0);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (this.mListener == null) {
                if (mBackupListener != null) {
                    mBackupListener.onResult(data);
                    return;
                }
                return;
            }
            this.mListener.onResult(data);
            return;
        }
        if (this.mListener != null) {
            this.mListener.onResult(data);
        }
    }

    public void setVideoIntentFragmentListener(OnVideoIntentFragmentListener listener) {
        if (listener == null && this.mListener != null) {
            mBackupListener = this.mListener;
        }
        this.mListener = listener;
    }
}
