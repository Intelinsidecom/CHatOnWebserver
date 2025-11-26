package com.coolots.chaton.call.model;

import android.graphics.Bitmap;
import com.coolots.p2pmsg.model.SimpleUserInfo;

/* loaded from: classes.dex */
public class ChatOnUserInfo {
    public Bitmap userImage;
    public SimpleUserInfo userInfo;

    public ChatOnUserInfo(SimpleUserInfo info, Bitmap image) {
        this.userInfo = info;
        this.userImage = image;
    }

    public ChatOnUserInfo(String name, Bitmap image) {
        this.userInfo = new SimpleUserInfo("", name);
        this.userImage = image;
    }

    public ChatOnUserInfo(String userId, String name) {
        this.userInfo = new SimpleUserInfo(userId, name);
        this.userImage = null;
    }
}
