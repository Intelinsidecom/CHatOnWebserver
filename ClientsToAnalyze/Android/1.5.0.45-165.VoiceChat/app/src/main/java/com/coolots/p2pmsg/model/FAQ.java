package com.coolots.p2pmsg.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("faq")
/* loaded from: classes.dex */
public class FAQ {
    private String content;

    /* renamed from: id */
    private String f13id;
    private String title;

    public FAQ() {
    }

    public FAQ(String id, String title) {
        this.f13id = id;
        this.title = title;
    }

    public FAQ(String id, String title, String content) {
        this.f13id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return this.f13id;
    }

    public void setId(String id) {
        this.f13id = id;
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
}
