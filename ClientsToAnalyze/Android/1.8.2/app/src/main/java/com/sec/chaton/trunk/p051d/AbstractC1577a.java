package com.sec.chaton.trunk.p051d;

import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.File;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.entry.inner.User;
import com.sec.spp.push.Config;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: AbstractTrunkXmlParser.java */
/* renamed from: com.sec.chaton.trunk.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC1577a extends AbstractC1578b {
    /* renamed from: a */
    protected TrunkItem m5449a(Node node) {
        TrunkItem trunkItem = new TrunkItem();
        m5454a(trunkItem, node.getAttributes());
        File file = trunkItem.file;
        Node nodeB = m5455b(node, "file");
        m5454a(file, nodeB.getAttributes());
        file.thumburl = m5452a(nodeB, "thumburl");
        file.downurl = m5452a(nodeB, "downurl");
        trunkItem.user = m5450b(m5455b(node, Config.NOTIFICATION_INTENT_SENDER));
        List list = trunkItem.comment;
        NodeList elementsByTagName = node.getOwnerDocument().getElementsByTagName("comment");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            list.add(m5451c(elementsByTagName.item(i)));
        }
        return trunkItem;
    }

    /* renamed from: b */
    protected User m5450b(Node node) {
        User user = new User();
        m5454a(user, node.getAttributes());
        user.orgname = m5452a(node, "orgname");
        if (user.orgname == null) {
            user.orgname = m5452a(node, "name");
        }
        user.orgnum = m5452a(node, "orgnum");
        return user;
    }

    /* renamed from: c */
    protected Comment m5451c(Node node) {
        Comment comment = new Comment();
        m5454a(comment, node.getAttributes());
        comment.content = m5452a(node, "content");
        comment.user = m5450b(m5455b(node, "writer"));
        return comment;
    }
}
