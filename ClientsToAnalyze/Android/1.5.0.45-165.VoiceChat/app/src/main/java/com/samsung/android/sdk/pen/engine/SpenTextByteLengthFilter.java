package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.samsung.android.sdk.pen.Spen;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;

/* loaded from: classes.dex */
class SpenTextByteLengthFilter implements InputFilter {
    private int mByte;
    private Context mContext;
    private Toast mToastMessage;

    public SpenTextByteLengthFilter(Context paramContext, int length) {
        this.mByte = length;
        this.mContext = paramContext;
    }

    public void setLimitLength(int length) {
        this.mByte = length;
    }

    public int getLimitLength() {
        return this.mByte;
    }

    public void close() {
        this.mContext = null;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) throws PackageManager.NameNotFoundException {
        if (this.mByte == -1) {
            return source.subSequence(start, end);
        }
        int i = this.mByte - (dest.length() - (dend - dstart));
        if (i <= 0) {
            String msg = getMultiLanguage("string_reached_maximum_input");
            if (msg != null) {
                String msg2 = String.format(msg, Integer.valueOf(this.mByte));
                if (this.mToastMessage == null) {
                    this.mToastMessage = Toast.makeText(this.mContext, msg2, 0);
                } else {
                    this.mToastMessage.setText(msg2);
                    this.mToastMessage.setDuration(0);
                }
                this.mToastMessage.setGravity(80, 0, ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                this.mToastMessage.show();
            }
            return "";
        }
        if (i >= end - start) {
            return null;
        }
        return source.subSequence(start, start + i);
    }

    private String getMultiLanguage(String strName) throws PackageManager.NameNotFoundException {
        try {
            PackageManager manager = this.mContext.getPackageManager();
            Resources sdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            int strID = sdkResources.getIdentifier(strName, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (strID == 0) {
                return null;
            }
            return sdkResources.getString(strID);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
