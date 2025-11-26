package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChatOnACSLangRep extends MsgBody {
    private List<ChatOnACSLang> ChatOnACSLangList = new ArrayList();

    public List<ChatOnACSLang> getChatOnACSLangList() {
        return this.ChatOnACSLangList;
    }

    public void setChatONACSLangSet(List<ChatOnACSLang> chatOnACSLangList) {
        this.ChatOnACSLangList = chatOnACSLangList;
    }
}
