package com.sec.chaton.multimedia.emoticon.p034c;

import android.text.TextUtils;
import com.sec.chaton.multimedia.emoticon.entry.inner.Anicon;
import com.sec.chaton.multimedia.emoticon.entry.inner.Package;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import com.sec.chaton.util.C1786r;
import org.w3c.dom.Node;

/* compiled from: AbstractEmoticonXmlParser.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0954a extends AbstractC1578b {

    /* renamed from: n */
    private static final String f3516n = AbstractC0954a.class.getSimpleName();

    /* renamed from: a */
    protected final String f3517a = "name";

    /* renamed from: b */
    protected final String f3518b = "description";

    /* renamed from: c */
    protected final String f3519c = "thumbnailurl";

    /* renamed from: d */
    protected final String f3520d = "totalcount";

    /* renamed from: e */
    protected final String f3521e = "package";

    /* renamed from: f */
    protected final String f3522f = "previewurl";

    /* renamed from: g */
    protected final String f3523g = "anicon";

    /* renamed from: h */
    protected final String f3524h = "aniconzipurl";

    /* renamed from: i */
    protected final String f3525i = "delegateimage";

    /* renamed from: j */
    protected final String f3526j = "volume";

    /* renamed from: k */
    protected final String f3527k = "aniconcount";

    /* renamed from: l */
    protected final String f3528l = "special";

    /* renamed from: m */
    protected final String f3529m = "newitem";

    /* renamed from: a */
    protected Package m3816a(Node node) {
        Package r1 = new Package();
        node.normalize();
        m5454a(r1, node.getAttributes());
        r1.name = m5452a(node, "name");
        if (r1.name == null || r1.name.equals("")) {
            r1.name = m5452a(node, "description");
        }
        r1.thumbnailurl = m5452a(node, "thumbnailurl");
        r1.previewurl = m5452a(node, "previewurl");
        String strA = m5452a(node, "volume");
        if (!TextUtils.isEmpty(strA)) {
            try {
                r1.volume = Long.parseLong(strA);
            } catch (NumberFormatException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f3516n);
                }
            }
        }
        String strA2 = m5452a(node, "aniconcount");
        if (!TextUtils.isEmpty(strA2)) {
            try {
                r1.aniconcount = Integer.parseInt(strA2);
            } catch (NumberFormatException e2) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e2, f3516n);
                }
            }
        }
        String strA3 = m5452a(node, "special");
        if (!TextUtils.isEmpty(strA3)) {
            try {
                r1.special = Integer.parseInt(strA3);
            } catch (NumberFormatException e3) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e3, f3516n);
                }
            }
        }
        String strA4 = m5452a(node, "newitem");
        if (!TextUtils.isEmpty(strA4)) {
            if (Boolean.parseBoolean(strA4)) {
                r1._new = 1;
            } else {
                r1._new = 0;
            }
        }
        return r1;
    }

    /* renamed from: b */
    protected Anicon m3817b(Node node) {
        Anicon anicon = new Anicon();
        node.normalize();
        m5454a(anicon, node.getAttributes());
        anicon.aniconzipurl = m5452a(node, "aniconzipurl");
        anicon.delegateimage = m5452a(node, "delegateimage");
        return anicon;
    }
}
