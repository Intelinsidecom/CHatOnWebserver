package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NoticeRep extends MsgBody {
    private List<NoticeInfo> NoticeInfoList = new ArrayList();

    public List<NoticeInfo> getNoticeInfoList() {
        return this.NoticeInfoList;
    }

    public void setNoticeInfoList(List<NoticeInfo> noticeInfoList) {
        this.NoticeInfoList = noticeInfoList;
    }
}
