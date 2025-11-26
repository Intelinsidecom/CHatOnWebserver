package com.sec.chaton.trunk.parser;

import com.sec.chaton.trunk.entry.inner.Comment;
import com.sec.chaton.trunk.entry.inner.File;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.trunk.entry.inner.User;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public abstract class AbstractTrunkXmlParser extends AbstractXmlParser {
    private static final String NODE_COMMENT = "comment";
    private static final String NODE_CONTENT = "content";
    private static final String NODE_DOWNURL = "downurl";
    private static final String NODE_FILE = "file";
    private static final String NODE_NAME = "name";
    private static final String NODE_ORGNAME = "orgname";
    private static final String NODE_ORGNUM = "orgnum";
    private static final String NODE_SENDER = "sender";
    private static final String NODE_THUMBURL = "thumburl";
    private static final String NODE_WRITER = "writer";

    protected Comment parsingCommentNode(Node node) {
        Comment comment = new Comment();
        setAttributeToObject(comment, node.getAttributes());
        comment.content = getValueOfNode(node, "content");
        comment.user = parsingUserNode(findNode(node, NODE_WRITER));
        return comment;
    }

    protected TrunkItem parsingTrunkItem(Node node) {
        TrunkItem trunkItem = new TrunkItem();
        setAttributeToObject(trunkItem, node.getAttributes());
        File file = trunkItem.file;
        Node nodeFindNode = findNode(node, NODE_FILE);
        setAttributeToObject(file, nodeFindNode.getAttributes());
        file.thumburl = getValueOfNode(nodeFindNode, NODE_THUMBURL);
        file.downurl = getValueOfNode(nodeFindNode, NODE_DOWNURL);
        trunkItem.user = parsingUserNode(findNode(node, NODE_SENDER));
        List list = trunkItem.comment;
        NodeList elementsByTagName = node.getOwnerDocument().getElementsByTagName(NODE_COMMENT);
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            list.add(parsingCommentNode(elementsByTagName.item(i)));
        }
        return trunkItem;
    }

    protected User parsingUserNode(Node node) {
        User user = new User();
        setAttributeToObject(user, node.getAttributes());
        user.orgname = getValueOfNode(node, NODE_ORGNAME);
        if (user.orgname == null) {
            user.orgname = getValueOfNode(node, NODE_NAME);
        }
        user.orgnum = getValueOfNode(node, NODE_ORGNUM);
        return user;
    }
}
