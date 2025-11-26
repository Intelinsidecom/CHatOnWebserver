package com.sec.chaton.buddy.p011b;

import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.w3c.dom.Node;

/* compiled from: AbstractSpecialBuddyXmlParser.java */
/* renamed from: com.sec.chaton.buddy.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC0286a extends AbstractC1578b {
    /* renamed from: a */
    protected SpecialUser m2368a(Node node) {
        SpecialUser specialUser = new SpecialUser();
        m5454a(specialUser, node.getAttributes());
        specialUser.specialuserid = m5452a(node, "specialuserid");
        specialUser.name = m5452a(node, "name");
        specialUser.photoloaded = m5452a(node, "photoloaded");
        specialUser.status = m5452a(node, "status");
        specialUser.description = m5452a(node, "description");
        specialUser.url = m5452a(node, RtspHeaders.Values.URL);
        specialUser.msgstatus = m5452a(node, "msgstatus");
        specialUser.followcount = m5452a(node, "followcount");
        specialUser.likecount = m5452a(node, "likecount");
        specialUser.weburl = m5452a(node, "weburl");
        return specialUser;
    }

    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        return null;
    }
}
