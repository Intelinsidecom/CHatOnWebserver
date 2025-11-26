package com.sec.chaton.for3rd;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.sds.coolots.common.util.Log;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class ChatONAPI {
    private static final String DATA_PREFIX = "chaton://";
    private static final String EXTRA_KEY_RECEIVER = "receiver";
    private static Paint mPaintRoundedCorner1;
    private static Paint mPaintRoundedCorner2;

    public static Intent getActivityIntent(Context context, String receiver) {
        return getActivityIntent(context, null, null, null, receiver, null);
    }

    public static Intent getActivityIntent(Context context, String receiver, String command) {
        return getActivityIntent(context, null, null, null, receiver, command);
    }

    public static Intent getActivityIntent(Context context, String mimeType, String text, Uri stream) {
        return getActivityIntent(context, mimeType, text, stream, null, null);
    }

    public static Intent getActivityIntent(Context context, String mimeType, String text, Uri stream, String receiver) {
        return getActivityIntent(context, mimeType, text, stream, receiver, null);
    }

    private static Intent getActivityIntent(Context context, String mimeType, String extraText, Uri extraStream, String receiver, String command) {
        Uri data;
        Intent i = new Intent("android.intent.action.SEND");
        if (command == null) {
            data = Uri.parse(DATA_PREFIX);
        } else {
            data = Uri.parse(DATA_PREFIX + command);
        }
        if (mimeType != null && (!TextUtils.isEmpty(extraText) || extraStream != null)) {
            i.setDataAndType(data, mimeType);
        } else {
            i.setData(data);
        }
        if (!TextUtils.isEmpty(extraText)) {
            i.putExtra("android.intent.extra.TEXT", extraText);
        }
        if (extraStream != null) {
            i.putExtra("android.intent.extra.STREAM", extraStream);
        }
        if (!TextUtils.isEmpty(receiver)) {
            i.putExtra(EXTRA_KEY_RECEIVER, receiver);
        }
        if (receiver != null && (!TextUtils.isEmpty(extraText) || extraStream != null)) {
            addPassword(context, i);
        }
        i.setFlags(268435456);
        return i;
    }

    private static void addPassword(Context context, Intent intent) {
        Uri returnUri = context.getContentResolver().insert(Uri.parse("content://com.sec.chaton.access_token.provider"), new ContentValues());
        Log.m2963i("nora getPassword returnUri=" + returnUri);
        intent.putExtra("password", returnUri.getLastPathSegment());
    }

    public static Bitmap getProfileImageFromProvider(Context context, String buddyNo) throws IOException {
        Bitmap bitmap = null;
        ParcelFileDescriptor pfdInput = null;
        try {
            try {
                pfdInput = context.getContentResolver().openFileDescriptor(Uri.parse("content://com.sec.chaton.provider/buddy/buddy_no/" + buddyNo), "r");
                Log.m2963i("nora pfdInput=" + pfdInput);
                if (pfdInput != null) {
                    bitmap = getRoundedCornerBitmap(BitmapFactory.decodeFileDescriptor(pfdInput.getFileDescriptor(), null, null));
                }
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                if (pfdInput != null) {
                    try {
                        pfdInput.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return bitmap;
        } catch (Throwable th) {
            if (pfdInput != null) {
                try {
                    pfdInput.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        RectF rectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, bitmap.getWidth(), bitmap.getHeight());
        float roundPx = (float) (bitmap.getWidth() * 0.06d);
        if (mPaintRoundedCorner1 == null) {
            mPaintRoundedCorner1 = new Paint();
            mPaintRoundedCorner1.setAntiAlias(true);
            mPaintRoundedCorner1.setColor(-12434878);
            mPaintRoundedCorner2 = new Paint(mPaintRoundedCorner1);
            mPaintRoundedCorner2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, roundPx, roundPx, mPaintRoundedCorner1);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, mPaintRoundedCorner2);
        bitmap.recycle();
        return output;
    }
}
