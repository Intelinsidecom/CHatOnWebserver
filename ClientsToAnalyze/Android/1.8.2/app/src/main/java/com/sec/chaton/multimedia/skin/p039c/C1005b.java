package com.sec.chaton.multimedia.skin.p039c;

import android.text.TextUtils;
import com.sec.chaton.multimedia.skin.entry.GetListSkinEntry;
import com.sec.chaton.multimedia.skin.entry.inner.Skin;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* compiled from: GetListSkinParser.java */
/* renamed from: com.sec.chaton.multimedia.skin.c.b */
/* loaded from: classes.dex */
public class C1005b extends AbstractC1578b {

    /* renamed from: a */
    private static final String f3706a = C1005b.class.getSimpleName();

    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) throws SAXException, IOException {
        GetListSkinEntry getListSkinEntry = new GetListSkinEntry();
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        getListSkinEntry.count = Long.parseLong(m5452a(document.getDocumentElement(), "count"));
        NodeList elementsByTagName = document.getElementsByTagName("skin");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            getListSkinEntry.skins.add(m3956a(elementsByTagName.item(i)));
        }
        return getListSkinEntry;
    }

    /* renamed from: a */
    protected Skin m3956a(Node node) {
        Skin skin = new Skin();
        node.normalize();
        m5454a(skin, node.getAttributes());
        String strA = m5452a(node, "special");
        if (!TextUtils.isEmpty(strA)) {
            try {
                skin.special = Integer.parseInt(strA);
            } catch (NumberFormatException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f3706a);
                }
            }
        }
        skin.thumbnailurl = m5452a(node, "thumbnailurl");
        skin.expirationdate = Long.parseLong(m5452a(node, "expirationdate"));
        skin.bgtype = m5452a(node, "bgtype");
        return skin;
    }
}
