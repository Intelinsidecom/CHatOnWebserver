package com.coolots.chaton.common.util;

import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import com.sds.coolots.common.util.Log;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class EditTextByteLengthFilter implements InputFilter {
    private static final String CLASSNAME = "[EditTextByteLengthFilter]";
    public static final int HANDLER_WHAT_BYTE_INFO = 1000;
    private final String mCharset;
    private final Handler mHandler;
    protected int mMaxByte;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public EditTextByteLengthFilter(int maxbyte, String charset, Handler handler) {
        this.mMaxByte = maxbyte;
        this.mCharset = charset;
        this.mHandler = handler;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        StringBuilder expected = new StringBuilder();
        expected.append(dest.subSequence(0, dstart));
        expected.append(source.subSequence(start, end));
        expected.append(dest.subSequence(dend, dest.length()));
        logE("source: " + ((Object) source));
        logE("source start: " + start);
        logE("source end: " + end);
        logE("dest: " + ((Object) dest));
        logE("dest dstart: " + dstart);
        logE("dest dend: " + dend);
        logE("Expected string: " + ((Object) expected));
        int keep = calculateMaxLength(expected.toString()) - (dest.length() - (dend - dstart));
        logI("keep: " + keep);
        Message msg = new Message();
        msg.what = 1000;
        if (keep <= 0) {
            msg.arg1 = getByteLength(dest.toString());
            if (msg.arg1 >= this.mMaxByte) {
                msg.arg2 = 1;
            } else {
                msg.arg2 = 0;
            }
            logI("byte: " + msg.arg1);
            this.mHandler.sendMessage(msg);
            return "";
        }
        if (keep >= end - start) {
            msg.arg1 = getByteLength(expected.toString());
            msg.arg2 = 0;
            logI("byte: " + msg.arg1);
            this.mHandler.sendMessage(msg);
            return null;
        }
        msg.arg1 = getByteLength(String.valueOf(dest.toString()) + source.subSequence(start, start + keep).toString());
        msg.arg2 = 1;
        logI("byte: " + msg.arg1);
        this.mHandler.sendMessage(msg);
        return source.subSequence(start, start + keep);
    }

    protected int calculateMaxLength(String expected) {
        return this.mMaxByte - (getByteLength(expected) - expected.length());
    }

    private int getByteLength(String str) {
        return getByteLength(this.mCharset, str);
    }

    public static int getByteLength(String charset, String str) {
        try {
            return str.getBytes(charset).length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }
}
