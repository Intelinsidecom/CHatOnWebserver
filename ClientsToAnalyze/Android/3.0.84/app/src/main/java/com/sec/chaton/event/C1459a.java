package com.sec.chaton.event;

import android.os.Handler;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: EventBannerImageTask.java */
/* renamed from: com.sec.chaton.event.a */
/* loaded from: classes.dex */
public class C1459a {

    /* renamed from: a */
    private static final String f5436a = C1459a.class.getSimpleName();

    /* renamed from: a */
    public static void m6382a(String str, Handler handler) {
        String strM11328b = C3223ck.m11328b();
        File file = null;
        if (str != null) {
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf > 0) {
                String strSubstring = str.substring(iLastIndexOf);
                if (strM11328b != null && strSubstring != null) {
                    file = new File(strM11328b, strSubstring);
                }
            } else {
                C1464f.m6389a(false);
                return;
            }
        }
        try {
            if (file == null) {
                C1464f.m6389a(false);
            } else {
                C3250y.m11450b("downloadImage: Url = " + str + "filename = " + file, f5436a);
                C3332a.m11750a().m11758b(handler, str, file, f5436a);
            }
        } catch (IOException e) {
            e.printStackTrace();
            C1464f.m6389a(false);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            C1464f.m6389a(false);
        }
    }
}
