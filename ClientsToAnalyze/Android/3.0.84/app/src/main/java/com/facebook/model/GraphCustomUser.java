package com.facebook.model;

/* loaded from: classes.dex */
public interface GraphCustomUser extends GraphObject {
    String getEmail();

    String getId();

    Boolean getInstalled();

    String getName();

    void setId(String str);

    void setInstalled(boolean z);

    void setName(String str);
}
