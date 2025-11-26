package com.vlingo.sdk.internal.lmtt;

import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.util.XmlUtils;

/* loaded from: classes.dex */
public class LMTTContactItem extends LMTTItem {
    public String companyName;
    public String firstName;
    public String lastName;

    public LMTTContactItem(String firstName, String lastName, String companyName, int uid, LMTTItem.ChangeType changeType) {
        super(LMTTItem.LmttItemType.TYPE_CONTACT, uid, changeType);
        firstName = firstName == null ? "" : firstName;
        lastName = lastName == null ? "" : lastName;
        companyName = companyName == null ? "" : companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
    }

    public LMTTContactItem(int uid, LMTTItem.ChangeType changeType) {
        this(null, null, null, uid, changeType);
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getDelXML(StringBuilder sb) {
        sb.append("<e uid=\"");
        sb.append(this.uid);
        sb.append("\"");
        sb.append(" t=\"d\">");
        sb.append("</e>");
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getInsXML(StringBuilder sb) {
        sb.append("<e uid=\"");
        sb.append(this.uid);
        sb.append("\"");
        sb.append("><fn>");
        XmlUtils.xmlEncode(this.firstName, sb);
        sb.append("</fn><ln>");
        XmlUtils.xmlEncode(this.lastName, sb);
        sb.append("</ln><c>");
        XmlUtils.xmlEncode(this.companyName, sb);
        sb.append("</c>");
        sb.append("</e>");
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getUpXML(StringBuilder sb) {
        getInsXML(sb);
    }

    public String toString() {
        return "LMTTContact: " + this.firstName + " " + this.lastName + " | " + this.companyName + " | uid: " + this.uid + " changeType: " + this.changeType;
    }
}
