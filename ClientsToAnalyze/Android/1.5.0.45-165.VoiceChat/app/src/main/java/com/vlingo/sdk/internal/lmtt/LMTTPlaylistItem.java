package com.vlingo.sdk.internal.lmtt;

import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.util.XmlUtils;

/* loaded from: classes.dex */
public class LMTTPlaylistItem extends LMTTItem {
    public String title;

    public LMTTPlaylistItem(String title, int uid, LMTTItem.ChangeType changeType) {
        super(LMTTItem.LmttItemType.TYPE_PLAYLIST, uid, changeType);
        this.title = title == null ? "" : title;
    }

    public LMTTPlaylistItem(int uid, LMTTItem.ChangeType changeType) {
        this(null, uid, changeType);
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getDelXML(StringBuilder sb) {
        sb.append("<PD");
        sb.append(" uid=\"");
        sb.append(this.uid);
        sb.append("\"/>");
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getInsXML(StringBuilder sb) {
        sb.append("<PU");
        sb.append(" uid=\"");
        sb.append(this.uid);
        sb.append("\"");
        sb.append(" ttl=\"");
        XmlUtils.xmlEncode(this.title, sb);
        sb.append("\"");
        sb.append("/>");
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getUpXML(StringBuilder sb) {
        getInsXML(sb);
    }

    public String toString() {
        return "LMTTPlaylistItem | uid: " + this.uid + " | changeType: " + this.changeType + " | title: " + this.title;
    }
}
