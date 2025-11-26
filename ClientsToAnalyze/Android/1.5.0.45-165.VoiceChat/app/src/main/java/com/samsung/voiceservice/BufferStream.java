package com.samsung.voiceservice;

import android.util.Log;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class BufferStream extends InputStream {
    private boolean mIsClosed = false;
    private static final String TAG = BufferStream.class.getName();
    public static AudioSourceInfo.SourceFormat mSourceForamt = AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT;
    private static LinkedList mLinkedList = new LinkedList();
    private static boolean mIsLastBuf = false;
    private static Object mWaitingObject = null;

    public static synchronized BufferStream request(AudioSourceInfo.SourceFormat format) {
        Log.i(TAG, "BufferStream requested ");
        return new BufferStream(format);
    }

    private BufferStream(AudioSourceInfo.SourceFormat format) {
        mSourceForamt = format;
        mIsLastBuf = false;
    }

    public boolean is16KHz() {
        return mSourceForamt == AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT;
    }

    public boolean is8KHz() {
        return mSourceForamt == AudioSourceInfo.SourceFormat.PCM_8KHZ_16BIT;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] ba;
        int bytesRead;
        ba = new byte[1];
        bytesRead = read(ba, 0, 1);
        return bytesRead > 0 ? ba[0] : (byte) -1;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] buffer, int offset, int length) throws IOException {
        int bytesRead;
        bytesRead = length;
        if (mLinkedList.isEmpty()) {
            if (mIsLastBuf) {
                bytesRead = -1;
            } else {
                try {
                    mWaitingObject = this;
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        if (bytesRead > 0) {
            byte[] tmp_buf = (byte[]) mLinkedList.get(0);
            bytesRead = tmp_buf.length;
            for (int i = 0; i < bytesRead; i++) {
                buffer[i] = tmp_buf[i];
            }
            mLinkedList.remove(0);
        }
        return bytesRead;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Log.i(TAG, "close() ");
        if (this.mIsClosed) {
            Log.i(TAG, "ignoring close()");
        } else {
            mLinkedList.clear();
            super.close();
            this.mIsClosed = true;
        }
    }

    public synchronized boolean isRecording() {
        return true;
    }

    public static synchronized boolean addAudioBuf(byte[] buffer, long len, boolean isLastBuf) {
        mLinkedList.add(buffer);
        mIsLastBuf = isLastBuf;
        if (mWaitingObject != null) {
            synchronized (mWaitingObject) {
                try {
                    mWaitingObject.notify();
                    mWaitingObject = null;
                } catch (Exception e) {
                }
            }
        }
        return true;
    }
}
