package com.samsung.android.sdk.pen.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class SpenScreenCodecDecoder {
    public static native Bitmap decode_file(String str);

    public static native Bitmap decode_stream(byte[] bArr, int i);

    public static Drawable getDrawable(Resources res, int id) throws Resources.NotFoundException, IOException {
        BitmapDrawable bitmapDrawable = null;
        try {
            Drawable drawable = res.getDrawable(id);
            if (drawable != null) {
                return drawable;
            }
        } catch (Resources.NotFoundException e) {
        }
        InputStream stream = res.openRawResource(id);
        if (stream == null) {
            Log.e("SpenScreenCodecDecoder", "Can't open raw resource. id = " + id);
            return null;
        }
        try {
            int length = stream.available();
            byte[] buffer = new byte[length];
            if (stream.read(buffer) != length) {
                Log.e("SpenScreenCodecDecoder", "Failed to read stream. length = " + length);
                stream.close();
            } else {
                stream.close();
                Bitmap bitmap = decode_stream(buffer, buffer.length);
                if (bitmap == null) {
                    Log.e("SpenScreenCodecDecoder", "Failed to create the bitmap");
                } else {
                    bitmapDrawable = new BitmapDrawable(res, bitmap);
                }
            }
            return bitmapDrawable;
        } catch (IOException e2) {
            try {
                stream.close();
                return bitmapDrawable;
            } catch (IOException e3) {
                return bitmapDrawable;
            }
        }
    }

    public static Bitmap decodeFile(String filepath) {
        Bitmap resultBitmap = decode_file(filepath);
        return resultBitmap;
    }

    public static Bitmap decodeStream(InputStream stream) throws IOException {
        Bitmap resultBitmap;
        if (stream == null) {
            Log.e("SpenScreenCodecDecoder", "stream is null");
            return null;
        }
        try {
            int length = stream.available();
            byte[] buffer = new byte[length];
            if (stream.read(buffer) != length) {
                stream.close();
                throw new IOException("Failed to read stream");
            }
            try {
                stream.close();
                if (buffer[4] == -86 && buffer[5] == 1) {
                    resultBitmap = decode_stream(buffer, buffer.length);
                } else {
                    resultBitmap = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
                }
                return resultBitmap;
            } catch (IOException e) {
                return null;
            }
        } catch (IOException e2) {
            try {
                stream.close();
                return null;
            } catch (IOException e3) {
                return null;
            }
        }
    }
}
