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

    public SlookWritingBuddy(ViewGroup viewGroup) {
        if (!isSupport(1)) {
            Log.e(TAG, "This is not supported in device");
        } else {
            this.mParentView = viewGroup;
            this.mWritingBuddyImpl = new WritingBuddyImpl(viewGroup);
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

    public void setEditorType(int i) {
        if (isSupport(1)) {
            this.mWritingBuddyImpl.setEditorType(i);
        }
    }

    public int getEditorType() {
        if (isSupport(1)) {
            return this.mWritingBuddyImpl.getEditorType();
        }
        return 0;
    }

    public void setTextWritingListener(TextWritingListener textWritingListener) {
        if (isSupport(1)) {
            this.mTextWritingListener = textWritingListener;
            this.mWritingBuddyImpl.setOnTextWritingListener(new WritingBuddyImpl.OnTextWritingListener() { // from class: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.1
                public void onTextReceived(CharSequence charSequence) {
                    SlookWritingBuddy.this.mTextWritingListener.onTextReceived(charSequence);
                }
            });
        }
    }

    public void setImageWritingListener(ImageWritingListener imageWritingListener) {
        if (isSupport(1)) {
            this.mImageWritingListener = imageWritingListener;
            this.mWritingBuddyImpl.setOnImageWritingListener(new WritingBuddyImpl.OnImageWritingListener() { // from class: com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.2
                public void onImageReceived(Bitmap bitmap) {
                    SlookWritingBuddy.this.mImageWritingListener.onImageReceived(bitmap);
                }
            });
        }
    }

    public void setEnabled(boolean z) {
        if (isSupport(1)) {
            if (this.mParentView == null) {
                throw new IllegalStateException("mParentView is null.");
            }
            if (this.mParentView instanceof EditText) {
                this.mParentView.setWritingBuddyEnabled(z);
            } else {
                if (this.mParentView.getWritingBuddy(false) != null) {
                    this.mParentView.setWritingBuddyEnabled(z);
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

    private boolean isSupport(int i) {
        return this.mSlook.getVersionCode() >= i;
    }
}
