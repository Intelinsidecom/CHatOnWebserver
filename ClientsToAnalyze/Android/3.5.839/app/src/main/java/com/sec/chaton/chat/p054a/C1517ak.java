package com.sec.chaton.chat.p054a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ak */
/* loaded from: classes.dex */
public class C1517ak extends AbstractC1506a {
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0231  */
    @Override // com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo8357a() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p054a.C1517ak.mo8357a():void");
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        super.mo8361a(z);
        this.f5861h.f6389G.setVisibility(8);
    }

    /* renamed from: e */
    public void m8409e() {
        Intent intent = new Intent();
        try {
            if (TextUtils.isEmpty(this.f5847H)) {
                intent.setAction("android.intent.action.SEND").setType("text/plain");
            } else {
                intent.setAction("android.intent.action.SENDTO").setData(Uri.parse("smsto:" + this.f5847H));
            }
            this.f5856c.startActivity(intent);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "SystemBubbleDrawer");
            }
        }
    }

    /* renamed from: f */
    public void m8410f() {
        try {
            if (m8408g() && C3847e.m14654aE() && C4904y.f17873c) {
                C4904y.m18641c("Free SMS Enabled", getClass().getSimpleName());
            }
            if (C4904y.f17873c) {
                C4904y.m18641c("Free SMS Disabled", getClass().getSimpleName());
            }
            Intent intent = new Intent(this.f5856c, (Class<?>) PluginComposeMessageActivity.class);
            if (C4822an.m18203M()) {
                C4904y.m18641c("Mixed ChatRoom", getClass().getSimpleName());
                intent.putExtra("sms_mix_room", true);
                if (TextUtils.isEmpty(this.f5847H)) {
                    intent.setAction("android.intent.action.SEND").setType("text/plain");
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f5847H);
                    intent.putExtra("receiver_array", (String[]) arrayList.toArray(new String[0]));
                }
            } else {
                C4904y.m18641c("Normal ChatRoom", getClass().getSimpleName());
                if (TextUtils.isEmpty(this.f5847H)) {
                    intent.setAction("android.intent.action.SEND").setType("text/plain");
                } else {
                    intent.setAction("android.intent.action.SENDTO").setData(Uri.parse("smsto:" + this.f5847H));
                }
            }
            this.f5856c.startActivity(intent);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, "SystemBubbleDrawer");
            }
        }
    }

    /* renamed from: g */
    private boolean m8408g() {
        int iM10677a = C2471v.m10677a(this.f5856c);
        if (-3 != iM10677a && -2 != iM10677a) {
            return true;
        }
        return false;
    }
}
