package com.sec.chaton.p028io.p029a;

import com.sec.chaton.p028io.entry.inner.ContentCategory;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.w3c.dom.Node;

/* compiled from: AbstractContentCategoryXmlParser.java */
/* renamed from: com.sec.chaton.io.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0830a extends AbstractC1578b {
    /* renamed from: a */
    protected ContentCategory m3479a(Node node) {
        ContentCategory contentCategory = new ContentCategory();
        m5454a(contentCategory, node.getAttributes());
        contentCategory.ccid = m5452a(node, "ccid");
        contentCategory.name = m5452a(node, "name");
        contentCategory.selected = m5452a(node, "selected");
        contentCategory.description = m5452a(node, "description");
        contentCategory.url = m5452a(node, RtspHeaders.Values.URL);
        return contentCategory;
    }

    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        return null;
    }
}
