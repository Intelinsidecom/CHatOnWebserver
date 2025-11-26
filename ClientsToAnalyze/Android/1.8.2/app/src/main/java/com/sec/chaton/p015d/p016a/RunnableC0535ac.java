package com.sec.chaton.p015d.p016a;

import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.util.C1786r;

/* compiled from: FileUploadTask2.java */
/* renamed from: com.sec.chaton.d.a.ac */
/* loaded from: classes.dex */
class RunnableC0535ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC0534ab f2197a;

    RunnableC0535ac(AsyncTaskC0534ab asyncTaskC0534ab) {
        this.f2197a = asyncTaskC0534ab;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2197a.f2187k == EnumC0699n.CONTACT || this.f2197a.f2187k == EnumC0699n.CALENDAR || this.f2197a.f2187k == EnumC0699n.DOCUMENT) {
            C0665i.m3052a(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(this.f2197a.f2190n), this.f2197a.f2178b);
        } else {
            C0665i.m3049a(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(this.f2197a.f2190n));
        }
        if (C0639k.m2914b(this.f2197a.f2179c) != null && C0639k.m2914b(this.f2197a.f2179c).f2485c != null && ((AsyncTaskC0534ab) C0639k.m2914b(this.f2197a.f2179c).f2485c.remove(Long.valueOf(this.f2197a.f2190n))) != null) {
            C1786r.m6061b("Successfully removed from hashmap", getClass().getName());
        }
        Toast.makeText(GlobalApplication.m3260b(), R.string.toast_file_upload_fail, 0).show();
    }
}
