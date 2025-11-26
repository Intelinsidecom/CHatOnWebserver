package com.sec.chaton.api;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.p126d.p127a.p129b.C4985b;
import com.sec.common.p126d.p127a.p129b.C4986c;
import com.sec.common.util.AbstractC5016a;
import java.util.Map;

/* compiled from: AuthorizeFragment.java */
/* renamed from: com.sec.chaton.api.a */
/* loaded from: classes.dex */
class C1018a extends AbstractC5016a<String, Void, C4986c> {

    /* renamed from: a */
    final /* synthetic */ AuthorizeFragment f3315a;

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a */
    protected void mo6107a() {
        super.mo6107a();
        this.f3315a.f3307g.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public C4986c mo6106a(String... strArr) {
        String str = strArr[0];
        C4985b c4985b = new C4985b();
        c4985b.m18930a(EnumC4988d.GET);
        c4985b.mo10630a(str);
        for (Map.Entry entry : this.f3315a.m6105c().entrySet()) {
            c4985b.m18931a((String) entry.getKey(), (String) entry.getValue());
        }
        try {
            return (C4986c) new C1042b(this.f3315a, c4985b).call();
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, AuthorizeFragment.f3301a);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo6108a(C4986c c4986c) {
        super.mo6108a((C1018a) c4986c);
        if (c4986c != null) {
            if (c4986c.m18953m() == 303) {
                String str = c4986c.m18952l().get("Location");
                if (!TextUtils.isEmpty(str)) {
                    if (this.f3315a.f3303c != null) {
                        this.f3315a.f3307g.dismiss();
                        Intent intent = new Intent();
                        intent.setData(Uri.parse(str));
                        this.f3315a.m6098a(-1, intent);
                        return;
                    }
                } else if (C4904y.f17875e) {
                    C4904y.m18634a("Server response doesn't have Location header.", AuthorizeFragment.f3301a);
                }
            } else if (C4904y.f17875e) {
                C4904y.m18634a("Server response code isn't 303. Response code: " + c4986c.m18953m(), AuthorizeFragment.f3301a);
            }
        }
        this.f3315a.f3307g.dismiss();
        this.f3315a.m6097a(0);
        if (this.f3315a.f3303c != null) {
            this.f3315a.f3303c.finish();
        }
    }

    @Override // com.sec.common.util.AbstractC5016a
    /* renamed from: b */
    protected void mo6109b() {
        super.mo6109b();
        this.f3315a.f3307g.dismiss();
    }
}
