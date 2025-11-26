package com.sec.chaton.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.CheckBox;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.ch */
/* loaded from: classes.dex */
public class C3220ch {
    /* renamed from: a */
    public static Intent m11316a(Context context, String str, Bitmap bitmap, String str2, String str3, boolean z) {
        return m11318a(context, str, m11323a(context, bitmap), str2, str3, z);
    }

    /* renamed from: a */
    public static Intent m11320a(Context context, String str, String str2, String str3, String str4) {
        return m11317a(context, str, m11324a(context, str2), str3, str4);
    }

    /* renamed from: a */
    public static Intent m11322a(Context context, String str, String str2, String str3, String str4, boolean z) {
        return m11318a(context, str, m11324a(context, str2), str3, str4, z);
    }

    /* renamed from: b */
    public static Intent m11326b(Context context, String str, String str2, String str3, String str4) {
        Uri uriM11324a = m11324a(context, str2);
        if (uriM11324a == null) {
            return null;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("video/*").putExtra("android.intent.extra.STREAM", uriM11324a);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str3);
        }
        if (str4 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str4);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: a */
    private static Intent m11319a(Context context, String str, String str2, String str3) {
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: a */
    private static Intent m11317a(Context context, String str, Uri uri, String str2, String str3) {
        return m11318a(context, str, uri, str2, str3, true);
    }

    /* renamed from: a */
    private static Intent m11318a(Context context, String str, Uri uri, String str2, String str3, boolean z) {
        if (uri == null) {
            return null;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.decode(uri.toString())));
        Intent intent = new Intent("android.intent.action.SEND");
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            intent.setType("image/*");
        } else if (mimeTypeFromExtension.startsWith(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            intent.setType(mimeTypeFromExtension);
        } else {
            intent.setType("image/" + mimeTypeFromExtension);
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        if (z) {
            if (str2 == null) {
                str2 = "www.chaton.com";
            } else {
                str2 = str2 + " www.chaton.com";
            }
        }
        if (str2 != null) {
            intent.putExtra("android.intent.extra.TEXT", str2);
        }
        if (str3 != null) {
            intent.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intent.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intent, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent m11321a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, com.sec.chaton.p027e.EnumC1455w r11) {
        /*
            r1 = 0
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.TEXT
            if (r11 == r0) goto L11
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.LIVERECOMMEND
            if (r11 == r0) goto L11
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.LIVESHARE
            if (r11 == r0) goto L11
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.LIVECONTENTS
            if (r11 != r0) goto L16
        L11:
            android.content.Intent r1 = m11319a(r6, r7, r8, r10)
        L15:
            return r1
        L16:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L15
            java.lang.String r0 = "file:"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L2c
            android.net.Uri r0 = android.net.Uri.parse(r8)
            java.lang.String r8 = r0.getPath()
        L2c:
            android.net.Uri r2 = m11324a(r6, r8)
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.IMAGE
            if (r11 == r0) goto L38
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.AMS
            if (r11 != r0) goto L46
        L38:
            android.net.Uri r2 = m11324a(r6, r8)
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r9
            r4 = r10
            android.content.Intent r1 = m11318a(r0, r1, r2, r3, r4, r5)
            goto L15
        L46:
            com.sec.chaton.e.w r0 = com.sec.chaton.p027e.EnumC1455w.VIDEO
            if (r11 != r0) goto L4f
            android.content.Intent r1 = m11326b(r6, r7, r8, r9, r10)
            goto L15
        L4f:
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.SEND"
            r3.<init>(r0)
            int[] r0 = com.sec.chaton.util.C3222cj.f11659a
            int r4 = r11.ordinal()
            r0 = r0[r4]
            switch(r0) {
                case 1: goto L89;
                case 2: goto L8c;
                case 3: goto L8f;
                case 4: goto L8f;
                case 5: goto La6;
                default: goto L61;
            }
        L61:
            r0 = r1
        L62:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L15
            r3.setType(r0)
            java.lang.String r0 = "android.intent.extra.STREAM"
            r3.putExtra(r0, r2)
            if (r9 == 0) goto L77
            java.lang.String r0 = "android.intent.extra.TEXT"
            r3.putExtra(r0, r9)
        L77:
            if (r10 == 0) goto L7e
            java.lang.String r0 = "android.intent.extra.SUBJECT"
            r3.putExtra(r0, r10)
        L7e:
            java.lang.String r0 = "extra_from_chaton"
            r1 = 1
            r3.putExtra(r0, r1)
            android.content.Intent r1 = android.content.Intent.createChooser(r3, r7)
            goto L15
        L89:
            java.lang.String r0 = "text/x-vCalendar"
            goto L62
        L8c:
            java.lang.String r0 = "text/x-vcard"
            goto L62
        L8f:
            java.lang.String r0 = "."
            int r0 = r8.lastIndexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r8.substring(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L61
            java.lang.String r0 = com.sec.chaton.multimedia.doc.FileExplorerActivity.m7383a(r0)
            goto L62
        La6:
            java.lang.String r0 = "."
            int r0 = r8.lastIndexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r8.substring(r0)
            java.lang.String r4 = "3GP"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto Lca
            java.lang.String r4 = "3GA"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto Lca
            java.lang.String r4 = "M4A"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 == 0) goto Lcd
        Lca:
            java.lang.String r0 = "audio/mp4"
            goto L62
        Lcd:
            java.lang.String r4 = "AMR"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L61
            java.lang.String r0 = "audio/amr"
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3220ch.m11321a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sec.chaton.e.w):android.content.Intent");
    }

    /* renamed from: a */
    private static Uri m11323a(Context context, Bitmap bitmap) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput;
        File fileStreamPath;
        File externalFilesDir;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                fileOutputStreamOpenFileOutput = null;
                fileStreamPath = null;
            } else {
                fileStreamPath = new File(externalFilesDir.getAbsolutePath() + "/temp_for_share.jpg");
                fileOutputStreamOpenFileOutput = new FileOutputStream(fileStreamPath);
            }
            if (fileStreamPath == null) {
                fileStreamPath = context.getFileStreamPath("temp_for_share.jpg");
                if (fileStreamPath == null) {
                    return null;
                }
                fileOutputStreamOpenFileOutput = context.openFileOutput("temp_for_share.jpg", 1);
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
            try {
                fileOutputStreamOpenFileOutput.close();
                return Uri.fromFile(fileStreamPath);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static Uri m11324a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: a */
    public static AbstractC3271a m11325a(Context context, DialogInterface.OnClickListener onClickListener) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_share_noti, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_never_show_again);
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(context);
        abstractC3271aM11494a.mo11502a(true);
        abstractC3271aM11494a.mo11508b(viewInflate);
        abstractC3271aM11494a.mo11495a(R.string.share);
        abstractC3271aM11494a.mo11515d(R.string.dialog_ok, onClickListener);
        checkBox.setOnClickListener(new ViewOnClickListenerC3221ci());
        return abstractC3271aM11494a;
    }
}
