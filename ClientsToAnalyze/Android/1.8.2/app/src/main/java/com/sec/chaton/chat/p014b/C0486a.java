package com.sec.chaton.chat.p014b;

import com.sec.chaton.p028io.entry.ChatMemberListEntry;
import com.sec.chaton.p028io.entry.inner.ChatMember;
import com.sec.chaton.p028io.entry.inner.ChatMembers;
import com.sec.chaton.trunk.p051d.AbstractC1578b;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: ChatMemberListParser.java */
/* renamed from: com.sec.chaton.chat.b.a */
/* loaded from: classes.dex */
public class C0486a extends AbstractC1578b {
    @Override // com.sec.chaton.trunk.p051d.AbstractC1578b
    /* renamed from: a */
    public Object mo2369a(InputStream inputStream) {
        ChatMemberListEntry chatMemberListEntry = new ChatMemberListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("members");
        if (elementsByTagName.getLength() > 0) {
            chatMemberListEntry.members = m2678a(elementsByTagName.item(0));
        }
        return chatMemberListEntry;
    }

    /* renamed from: a */
    protected ChatMembers m2678a(Node node) {
        ChatMembers chatMembers = new ChatMembers();
        m5454a(chatMembers, node.getAttributes());
        List list = chatMembers.members;
        NodeList elementsByTagName = node.getOwnerDocument().getElementsByTagName("member");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            list.add(m2679b(elementsByTagName.item(i)));
        }
        return chatMembers;
    }

    /* renamed from: b */
    protected ChatMember m2679b(Node node) {
        ChatMember chatMember = new ChatMember();
        m5454a(chatMember, node.getAttributes());
        chatMember.MSISDN = node.getTextContent();
        return chatMember;
    }
}
