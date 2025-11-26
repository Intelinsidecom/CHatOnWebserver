package com.sec.chaton.trunk.p043c.p044a;

import android.os.Handler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.C0503j;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;
import org.apache.http.NameValuePair;

/* compiled from: RemoveCommentTask.java */
/* renamed from: com.sec.chaton.trunk.c.a.e */
/* loaded from: classes.dex */
public class C1157e extends AbstractRunnableC0153bb {

    /* renamed from: a */
    private static final String f4004a = C1157e.class.getSimpleName();

    public C1157e(Handler handler, C0503j c0503j) {
        super(handler, c0503j);
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public String mo670a() {
        return null;
    }

    @Override // com.sec.chaton.p013a.p014a.AbstractRunnableC0153bb
    /* renamed from: a */
    public void mo671a(C0259g c0259g) {
        String value;
        if (c0259g.m928b() == EnumC0518y.SUCCESS) {
            Iterator it = c0259g.m931c().m2531d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = "";
                    break;
                }
                NameValuePair nameValuePair = (NameValuePair) it.next();
                if (nameValuePair.getName().equals("commentid")) {
                    value = nameValuePair.getValue();
                    break;
                }
            }
            if (C1341p.f4578b) {
                C1341p.m4658b(String.format("Remove comment in database: ", value), f4004a);
            }
            C1173b.m4237a(GlobalApplication.m3100a(), C1173b.m4242e(value));
        }
    }
}
