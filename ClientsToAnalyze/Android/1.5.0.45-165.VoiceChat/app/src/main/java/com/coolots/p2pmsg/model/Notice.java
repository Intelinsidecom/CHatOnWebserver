package com.coolots.p2pmsg.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("notice")
/* loaded from: classes.dex */
public class Notice {
    private String content;
    private String created;

    /* renamed from: id */
    private String f15id;
    private String title;

    public Notice() {
    }

    public Notice(String id, String title) {
        this.f15id = id;
        this.title = title;
    }

    public Notice(String id, String title, String content) {
        this.f15id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return this.f15id;
    }

    public void setId(String id) {
        this.f15id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
