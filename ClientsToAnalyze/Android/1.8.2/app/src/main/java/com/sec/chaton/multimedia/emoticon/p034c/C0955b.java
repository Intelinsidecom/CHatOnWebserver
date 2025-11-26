package com.sec.chaton.multimedia.emoticon.p034c;

import com.sec.chaton.multimedia.emoticon.entry.DownloadEmoticonEntry;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/* compiled from: DownloadEmoticonParser.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.c.b */
/* loaded from: classes.dex */
public class C0955b extends AbstractC0954a {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        DownloadEmoticonEntry downloadEmoticonEntry = new DownloadEmoticonEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getElementsByTagName("anicon");
        if (elementsByTagName.getLength() == 1) {
            downloadEmoticonEntry.emoticon = m3817b(elementsByTagName.item(0));
        }
        return downloadEmoticonEntry;
    }
}
