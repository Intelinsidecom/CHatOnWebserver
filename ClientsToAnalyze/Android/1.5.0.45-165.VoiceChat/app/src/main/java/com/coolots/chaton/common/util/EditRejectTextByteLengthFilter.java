package com.coolots.chaton.common.util;

import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import com.sds.coolots.common.util.Log;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class EditRejectTextByteLengthFilter implements InputFilter {
    private static final String CLASSNAME = "[EditTextByteLengthFilter]";
    public static final int HANDLER_WHAT_BYTE_INFO = 1000;
    private final String mCharset;
    private final Handler mHandler;
    protected int mMaxByte;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public EditRejectTextByteLengthFilter(int maxbyte, String charset, Handler handler) {
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
        int sourcelength = getByteLength(source.toString());
        logI("Text sourcelength: " + sourcelength);
        logI("Text source: " + ((Object) source));
        logI("Text source start: " + start);
        logI("Text source end: " + end);
        logI("Text dest: " + ((Object) dest));
        logI("Text dest dstart: " + dstart);
        logI("Text dest dend: " + dend);
        logI("Text Expected string: " + ((Object) expected));
        int keep = calculateMaxLength(expected.toString());
        logI("Text keep: " + keep);
        Message msg = new Message();
        msg.what = 1000;
        if (keep < 0) {
            msg.arg2 = 1;
            if (getByteLength(dest.toString()) >= this.mMaxByte - 1) {
                msg.arg1 = getByteLength(dest.toString());
                msg.obj = dest.toString();
            } else {
                StringBuilder expected2 = new StringBuilder();
                expected2.append(dest.subSequence(0, dstart));
                String trimStr = trimWantSize(sourcelength - Math.abs(keep), source.toString());
                if (trimStr != null) {
                    logI("Text trimStr = " + trimStr);
                    expected2.append(trimStr);
                }
                expected2.append(dest.subSequence(dend, dest.length()));
                msg.arg1 = getByteLength(expected2.toString());
                msg.obj = expected2.toString();
            }
            logI("Text 1 byte: " + msg.arg1);
            this.mHandler.sendMessage(msg);
            return "";
        }
        if (keep < 0) {
            return null;
        }
        msg.arg1 = getByteLength(expected.toString());
        msg.arg2 = 0;
        logI("Text 2 byte: " + msg.arg1);
        this.mHandler.sendMessage(msg);
        return null;
    }

    private String trimWantSize(int size, String Str) {
        String trimStr = new String();
        for (int i = 1; i < Str.length(); i++) {
            if (getByteLength(Str.substring(0, i)) > size) {
                String trimStr2 = Str.substring(0, i - 1);
                return trimStr2;
            }
            if (getByteLength(Str.substring(0, i)) == size) {
                String trimStr3 = Str.substring(0, i);
                return trimStr3;
            }
            trimStr = Str.substring(0, 1);
        }
        return trimStr;
    }

    protected int calculateMaxLength(String expected) {
        return this.mMaxByte - getByteLength(expected);
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
