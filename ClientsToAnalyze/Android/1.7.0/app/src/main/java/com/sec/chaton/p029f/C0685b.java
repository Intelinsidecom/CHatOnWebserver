package com.sec.chaton.p029f;

import android.content.Context;
import com.sec.chaton.p013a.C0192ae;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.util.C1296as;
import com.sec.chaton.util.EnumC1289al;

/* compiled from: NetworkConstant.java */
/* renamed from: com.sec.chaton.f.b */
/* loaded from: classes.dex */
public class C0685b {

    /* renamed from: a */
    public static final String[] f2343a = {"https://gld1.samsungchaton.com", "https://stg.gld1.samsungchaton.com", "https://stg.gld2.samsungchaton.com", "http://ec2-50-17-226-248.compute-1.amazonaws.com"};

    /* renamed from: b */
    public static final String[] f2344b = {"Production\n" + f2343a[0], "Staging\n" + f2343a[1], "Development\n" + f2343a[2], "SNS dev server\n" + f2343a[3]};

    /* renamed from: a */
    public static String m3053a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(C1296as.m4521b(EnumC1289al.PRIMARY)).append(" : ").append(C1296as.m4522c(EnumC1289al.PRIMARY)).append("\n");
        sb.append(C1296as.m4521b(EnumC1289al.SECONDARY)).append(" : ").append(C1296as.m4522c(EnumC1289al.SECONDARY)).append("\n");
        sb.append(C0904h.m3552c((String) null)).append(" : ").append(C0904h.m3537a(-1)).append("\n");
        sb.append(C0904h.m3556d((String) null)).append(" : ").append(C0904h.m3545b(-1)).append("\n");
        sb.append((HeartBeat.m3568a() + 1) * 4).append(" / ").append(HeartBeat.m3573b() != 0).append("\n");
        if (C0192ae.m740b()) {
            sb.append("Push Type : ").append("Public push");
        } else {
            sb.append("Push Type : ").append("non Public push");
        }
        return sb.toString();
    }
}
