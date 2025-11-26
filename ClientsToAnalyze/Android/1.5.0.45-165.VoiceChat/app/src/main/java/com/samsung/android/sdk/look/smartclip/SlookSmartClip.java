package com.samsung.android.sdk.look.smartclip;

import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;
import com.samsung.android.smartclip.SmartClipMetaUtils;

/* loaded from: classes.dex */
public final class SlookSmartClip {
    private static final String TAG = "SmartClip";
    private View mView;
    private Slook mSlook = new Slook();
    private DataExtractionListener mDataExtractionListener = null;

    public interface DataExtractionListener {
        public static final int EXTRACTION_DEFAULT = 1;
        public static final int EXTRACTION_DISCARD = 0;

        int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea);
    }

    public SlookSmartClip(View view) {
        this.mView = null;
        this.mView = view;
    }

    public void addMetaTag(SlookSmartClipMetaTag metaTag) {
        if (isSupport(1)) {
            SmartClipMetaUtils.addMetaTag(this.mView, metaTag);
        }
    }

    public void removeMetaTag(String tagType) {
        if (isSupport(1)) {
            SmartClipMetaUtils.removeMetaTag(this.mView, tagType);
        }
    }

    public void clearAllMetaTag() {
        if (isSupport(1)) {
            SmartClipMetaUtils.clearAllMetaTag(this.mView);
        }
    }

    public void setDataExtractionListener(DataExtractionListener listener) {
        if (isSupport(1)) {
            this.mDataExtractionListener = listener;
            SmartClipMetaUtils.setDataExtractionListener(this.mView, new SmartClipDataExtractionListener() { // from class: com.samsung.android.sdk.look.smartclip.SlookSmartClip.1
                public int onExtractSmartClipData(View view, SlookSmartClipDataElement resultElement, SlookSmartClipCroppedArea croppedArea) {
                    return SlookSmartClip.this.mDataExtractionListener.onExtractSmartClipData(view, resultElement, croppedArea);
                }
            });
        }
    }

    public int extractDefaultSmartClipData(SlookSmartClipDataElement resultElement, SlookSmartClipCroppedArea croppedArea) {
        if (isSupport(1)) {
            return SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, resultElement, croppedArea);
        }
        return 0;
    }

    private boolean isSupport(int ver) {
        if (this.mSlook.getVersionCode() >= ver) {
            return true;
        }
        Log.e(TAG, "This is not supported in device");
        return false;
    }
}
