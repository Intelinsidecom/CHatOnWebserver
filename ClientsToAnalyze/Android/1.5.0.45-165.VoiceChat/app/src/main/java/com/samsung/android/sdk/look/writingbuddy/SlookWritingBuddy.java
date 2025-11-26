package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.writingbuddy.WritingBuddyImpl;

/* loaded from: classes.dex */
public final class SlookWritingBuddy {
    private static final String TAG = "WritingBuddy";
    public static final int TYPE_EDITOR_NUMBER = 1;
    public static final int TYPE_EDITOR_TEXT = 2;
    private ImageWritingListener mImageWritingListener;
    private View mParentView;
    private Slook mSlook = new Slook();
    private TextWritingListener mTextWritingListener;
    private WritingBuddyImpl mWritingBuddyImpl;

    public interface ImageWritingListener {
        void onImageReceived(Bitmap bitmap);
    }

    public interface TextWritingListener {
        void onTextReceived(CharSequence charSequence);
    }

    public SlookWritingBuddy(ViewGroup parentView) {
        if (!isSupport(1)) {
            Log.e(TAG, "This is not supported in device");
        } else {
            this.mParentView = parentView;
            this.mWritingBuddyImpl = new WritingBuddyImpl(parentView);
        }
    }

    public SlookWritingBuddy(EditText editText) {
        if (!isSupport(1)) {
            Log.e(TAG, "This is not supported in device");
        } else {
            this.mParentView = editText;
            this.mWritingBuddyImpl = new WritingBuddyImpl(editText);
        }
    }

    public void setEditorType(int type) {
        if (isSupport(1)) {
            this.mWritingBuddyImpl.setEditorType(type);
        }
    }

    public int getEditorType() {
        if (isSupport(1)) {
            return this.mWritingBuddyImpl.getEditorType();
        }
        return 0;
    }

    public void setTextWritingListener(TextWritingListener l) {
        if (isSupport(1)) {
            this.mTextWritingListener = l;
            this.mWritingBuddyImpl.setOnTextWritingListener(new WritingBuddyImpl.OnTextWritingListener() { // from class: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.1
                public void onTextReceived(CharSequence text) {
                    SlookWritingBuddy.this.mTextWritingListener.onTextReceived(text);
                }
            });
        }
    }

    public void setImageWritingListener(ImageWritingListener l) {
        if (isSupport(1)) {
            this.mImageWritingListener = l;
            this.mWritingBuddyImpl.setOnImageWritingListener(new WritingBuddyImpl.OnImageWritingListener() { // from class: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.2
                public void onImageReceived(Bitmap image) {
                    SlookWritingBuddy.this.mImageWritingListener.onImageReceived(image);
                }
            });
        }
    }

    public void setEnabled(boolean enabled) {
        if (isSupport(1)) {
            if (this.mParentView == null) {
                throw new IllegalStateException("mParentView is null.");
            }
            if (this.mParentView instanceof EditText) {
                this.mParentView.setWritingBuddyEnabled(enabled);
            } else {
                if (this.mParentView.getWritingBuddy(false) != null) {
                    this.mParentView.setWritingBuddyEnabled(enabled);
                    return;
                }
                throw new IllegalStateException("WritingBuddy was not enabled.");
            }
        }
    }

    public boolean isEnabled() {
        if (!isSupport(1)) {
            return false;
        }
        if (this.mParentView == null) {
            throw new IllegalStateException("mParentView is null.");
        }
        return this.mParentView.isWritingBuddyEnabled();
    }

    private boolean isSupport(int ver) {
        return this.mSlook.getVersionCode() >= ver;
    }
}
