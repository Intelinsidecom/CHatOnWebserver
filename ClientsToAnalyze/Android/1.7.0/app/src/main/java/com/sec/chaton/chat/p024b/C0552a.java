package com.sec.chaton.chat.p024b;

import com.sec.chaton.p033io.entry.ChatMemberListEntry;
import com.sec.chaton.p033io.entry.inner.ChatMember;
import com.sec.chaton.p033io.entry.inner.ChatMembers;
import com.sec.chaton.trunk.p041a.AbstractC1098b;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: ChatMemberListParser.java */
/* renamed from: com.sec.chaton.chat.b.a */
/* loaded from: classes.dex */
public class C0552a extends AbstractC1098b {
    @Override // com.sec.chaton.trunk.p041a.AbstractC1098b
    /* renamed from: a */
    public Object mo2725a(InputStream inputStream) {
        ChatMemberListEntry chatMemberListEntry = new ChatMemberListEntry();
        NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("members");
        if (elementsByTagName.getLength() > 0) {
            chatMemberListEntry.members = m2724a(elementsByTagName.item(0));
        }
        return chatMemberListEntry;
    }

    /* renamed from: a */
    protected ChatMembers m2724a(Node node) {
        ChatMembers chatMembers = new ChatMembers();
        m4090a(chatMembers, node.getAttributes());
        List list = chatMembers.members;
        NodeList elementsByTagName = node.getOwnerDocument().getElementsByTagName("member");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            list.add(m2726b(elementsByTagName.item(i)));
        }
        return chatMembers;
    }

    /* renamed from: b */
    protected ChatMember m2726b(Node node) {
        ChatMember chatMember = new ChatMember();
        m4090a(chatMember, node.getAttributes());
        chatMember.MSISDN = node.getTextContent();
        return chatMember;
    }
}
