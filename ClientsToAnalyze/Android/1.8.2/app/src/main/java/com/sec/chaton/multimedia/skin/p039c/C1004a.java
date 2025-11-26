package com.sec.chaton.multimedia.skin.p039c;

import com.sec.chaton.multimedia.skin.entry.DownloadSkinEntry;
import com.sec.chaton.multimedia.skin.entry.inner.SkinView;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

/* compiled from: DownloadSkinParser.java */
/* renamed from: com.sec.chaton.multimedia.skin.c.a */
/* loaded from: classes.dex */
public class C1004a extends AbstractC1578b {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        DownloadSkinEntry downloadSkinEntry = new DownloadSkinEntry();
        downloadSkinEntry.skinview = m3955a(m5455b(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement(), "skinview"));
        return downloadSkinEntry;
    }

    /* renamed from: a */
    protected SkinView m3955a(Node node) {
        SkinView skinView = new SkinView();
        node.normalize();
        m5454a(skinView, node.getAttributes());
        Node nodeB = m5455b(node, "settingview");
        if (nodeB != null) {
            skinView.settingviewzipurl = m5452a(nodeB, "zipfileurl");
        }
        Node nodeB2 = m5455b(node, "chatview");
        if (nodeB2 != null) {
            skinView.chatviewzipurl = m5452a(nodeB2, "zipfileurl");
        }
        return skinView;
    }
}
