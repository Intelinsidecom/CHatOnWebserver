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
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.sharedialog.ShareActivity;
import com.sec.common.p123a.AbstractC4932a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.cg */
/* loaded from: classes.dex */
public class C4869cg {
    /* renamed from: a */
    public static Intent m18489a(Context context, String str, Bitmap bitmap, String str2, String str3, boolean z) {
        return m18490a(context, str, m18495a(context, bitmap), str2, str3, z);
    }

    /* renamed from: a */
    public static Intent m18494a(Context context, String str, String str2, String str3, String str4, boolean z) {
        return m18490a(context, str, m18496a(context, str2), str3, str4, z);
    }

    /* renamed from: a */
    public static Intent m18492a(Context context, String str, String str2, String str3, String str4) {
        Uri uriM18496a = m18496a(context, str2);
        if (uriM18496a == null) {
            return null;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("video/*").putExtra("android.intent.extra.STREAM", uriM18496a);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str3);
        }
        if (str4 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str4);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return ShareActivity.m13949a(context, intentPutExtra);
    }

    /* renamed from: a */
    private static Intent m18491a(Context context, String str, String str2, String str3) {
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return ShareActivity.m13949a(context, intentPutExtra);
    }

    /* renamed from: a */
    private static Intent m18490a(Context context, String str, Uri uri, String str2, String str3, boolean z) {
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
        return ShareActivity.m13949a(context, intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent m18493a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, com.sec.chaton.p057e.EnumC2214ab r11) {
        /*
            r1 = 0
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.TEXT
            if (r11 == r0) goto L19
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.LIVERECOMMEND
            if (r11 == r0) goto L19
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.LIVESHARE
            if (r11 == r0) goto L19
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.LIVECONTENTS
            if (r11 == r0) goto L19
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.GLYMPSE
            if (r11 == r0) goto L19
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.HUGEFILE
            if (r11 != r0) goto L1e
        L19:
            android.content.Intent r1 = m18491a(r6, r7, r8, r10)
        L1d:
            return r1
        L1e:
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L1d
            java.lang.String r0 = "file:"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L35
            android.net.Uri r0 = android.net.Uri.parse(r8)
            java.lang.String r8 = r0.getPath()
        L35:
            android.net.Uri r2 = m18496a(r6, r8)
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.IMAGE
            if (r11 == r0) goto L41
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.AMS
            if (r11 != r0) goto L4f
        L41:
            android.net.Uri r2 = m18496a(r6, r8)
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r9
            r4 = r10
            android.content.Intent r1 = m18490a(r0, r1, r2, r3, r4, r5)
            goto L1d
        L4f:
            com.sec.chaton.e.ab r0 = com.sec.chaton.p057e.EnumC2214ab.VIDEO
            if (r11 != r0) goto L58
            android.content.Intent r1 = m18492a(r6, r7, r8, r9, r10)
            goto L1d
        L58:
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.SEND"
            r3.<init>(r0)
            int[] r0 = com.sec.chaton.util.C4871ci.f17779a
            int r4 = r11.ordinal()
            r0 = r0[r4]
            switch(r0) {
                case 1: goto L97;
                case 2: goto L9b;
                case 3: goto L9f;
                case 4: goto L9f;
                case 5: goto Lb7;
                default: goto L6b;
            }
        L6b:
            r0 = r1
        L6c:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L1d
            r3.setType(r0)
            java.lang.String r0 = "android.intent.extra.STREAM"
            r3.putExtra(r0, r2)
            if (r9 == 0) goto L83
            java.lang.String r0 = "android.intent.extra.TEXT"
            r3.putExtra(r0, r9)
        L83:
            if (r10 == 0) goto L8b
            java.lang.String r0 = "android.intent.extra.SUBJECT"
            r3.putExtra(r0, r10)
        L8b:
            java.lang.String r0 = "extra_from_chaton"
            r1 = 1
            r3.putExtra(r0, r1)
            android.content.Intent r1 = com.sec.chaton.sharedialog.ShareActivity.m13949a(r6, r3)
            goto L1d
        L97:
            java.lang.String r0 = "text/x-vCalendar"
            goto L6c
        L9b:
            java.lang.String r0 = "text/x-vcard"
            goto L6c
        L9f:
            java.lang.String r0 = "."
            int r0 = r8.lastIndexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r8.substring(r0)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L6b
            java.lang.String r0 = com.sec.chaton.multimedia.doc.FileExplorerActivity.m11579b(r0)
            goto L6c
        Lb7:
            java.lang.String r0 = "."
            int r0 = r8.lastIndexOf(r0)
            int r0 = r0 + 1
            java.lang.String r0 = r8.substring(r0)
            java.lang.String r4 = "3GP"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto Ldf
            java.lang.String r4 = "3GA"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 != 0) goto Ldf
            java.lang.String r4 = "M4A"
            boolean r4 = r4.equalsIgnoreCase(r0)
            if (r4 == 0) goto Le3
        Ldf:
            java.lang.String r0 = "audio/mp4"
            goto L6c
        Le3:
            java.lang.String r4 = "AMR"
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L6b
            java.lang.String r0 = "audio/amr"
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4869cg.m18493a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.sec.chaton.e.ab):android.content.Intent");
    }

    /* renamed from: a */
    private static Uri m18495a(Context context, Bitmap bitmap) throws IOException {
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
    private static Uri m18496a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: a */
    public static AbstractC4932a m18497a(Context context, DialogInterface.OnClickListener onClickListener) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_share_noti, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.checkbox_never_show_again);
        checkBox.setChecked(true);
        C4809aa.m18105a("TrunkShareCheckPopup", (Boolean) true);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18742a(true);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18734a(R.string.share);
        abstractC4932aM18733a.mo18756d(R.string.dialog_ok, onClickListener);
        checkBox.setOnClickListener(new ViewOnClickListenerC4870ch());
        return abstractC4932aM18733a;
    }

    /* renamed from: a */
    public static Intent m18488a(Context context, Class<?> cls, String str, String str2, EnumC2214ab enumC2214ab) {
        String strM18612b = C4894o.m18612b(enumC2214ab, str);
        if (strM18612b == null) {
            return null;
        }
        Intent intent = new Intent(context, cls);
        intent.setAction("android.intent.action.SEND");
        intent.setType(strM18612b);
        if (str != null) {
            if (str.startsWith("file")) {
                str = Uri.parse(str).getPath();
            }
            intent.putExtra("android.intent.extra.STREAM", m18496a(context, str));
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("android.intent.extra.TEXT", str2);
            return intent;
        }
        return intent;
    }
}
