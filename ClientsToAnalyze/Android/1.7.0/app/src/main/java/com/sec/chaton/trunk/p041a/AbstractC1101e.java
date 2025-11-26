package com.sec.chaton.trunk.p041a;

import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.File;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.entry.inner.User;
import com.sec.spp.push.Config;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: AbstractTrunkXmlParser.java */
/* renamed from: com.sec.chaton.trunk.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC1101e extends AbstractC1098b {
    /* renamed from: a */
    protected TrunkItem m4092a(Node node) {
        TrunkItem trunkItem = new TrunkItem();
        m4090a(trunkItem, node.getAttributes());
        File file = trunkItem.file;
        Node nodeB = m4091b(node, "file");
        m4090a(file, nodeB.getAttributes());
        file.thumburl = m4088a(nodeB, "thumburl");
        file.downurl = m4088a(nodeB, "downurl");
        trunkItem.user = m4093b(m4091b(node, Config.NOTIFICATION_INTENT_SENDER));
        List list = trunkItem.comment;
        NodeList elementsByTagName = node.getOwnerDocument().getElementsByTagName("comment");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            list.add(m4094c(elementsByTagName.item(i)));
        }
        return trunkItem;
    }

    /* renamed from: b */
    protected User m4093b(Node node) {
        User user = new User();
        m4090a(user, node.getAttributes());
        user.orgname = m4088a(node, "orgname");
        if (user.orgname == null) {
            user.orgname = m4088a(node, "name");
        }
        user.orgnum = m4088a(node, "orgnum");
        return user;
    }

    /* renamed from: c */
    protected Comment m4094c(Node node) {
        Comment comment = new Comment();
        m4090a(comment, node.getAttributes());
        comment.content = m4088a(node, "content");
        comment.user = m4093b(m4091b(node, "writer"));
        return comment;
    }
}
