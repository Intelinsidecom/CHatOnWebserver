package com.renren.android.feed;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.p137vk.sdk.api.VKApiConst;
import com.renren.android.C0724f;
import com.renren.android.p040a.AbstractC0708a;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* loaded from: classes.dex */
public class FeedPublishRequestParam extends AbstractC0708a implements Parcelable {
    private static final int ACTION_NAME_MAX_LENGTH = 10;
    public static final int ACTION_NAME_TOO_LONG = 65536;
    private static final int CAPTION_MAX_LENGTH = 20;
    public static final int CAPTION_TOO_LONG = 4096;
    public static final Parcelable.Creator<FeedPublishRequestParam> CREATOR = new C0725a();
    private static final int DESCRIPTION_MAX_LENGTH = 200;
    public static final int DESCRIPTION_TOO_LONG = 256;
    private static final int MESSAGE_MAX_LENGTH = 200;
    public static final int MESSAGE_TOO_LONG = 1048576;
    private static final String METHOD = "feed.publishFeed";
    private static final int NAME_MAX_LENGTH = 30;
    public static final int NAME_TOO_LONG = 16;
    public static final int NORMAL_LENGTH = 0;
    private static final int WIDGET_DESCRIPTION_MAX_LENGTH = 120;
    private static final int WIDGET_MESSAGE_MAX_LENGTH = 140;
    private String actionLink;
    private String actionName;
    private String caption;
    private String description;
    private String imageUrl;
    private String message;
    private String name;
    private String url;

    public FeedPublishRequestParam(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        this.name = bundle.getString("name");
        this.description = bundle.getString("description");
        this.url = bundle.getString("url");
        this.imageUrl = bundle.getString("image_url");
        this.caption = bundle.getString("caption");
        this.actionName = bundle.getString("action_name");
        this.actionLink = bundle.getString("action_link");
        this.message = bundle.getString(VKApiConst.MESSAGE);
    }

    public FeedPublishRequestParam(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.name = str;
        this.description = str2;
        this.url = str3;
        this.imageUrl = str4;
        this.caption = str5;
        this.actionName = str6;
        this.actionLink = str7;
        this.message = str8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.name != null) {
            bundle.putString("name", this.name);
        }
        if (this.description != null) {
            bundle.putString("description", this.description);
        }
        if (this.url != null) {
            bundle.putString("url", this.url);
        }
        if (this.imageUrl != null) {
            bundle.putString("image_url", this.imageUrl);
        }
        if (this.caption != null) {
            bundle.putString("caption", this.caption);
        }
        if (this.actionName != null) {
            bundle.putString("action_name", this.actionName);
        }
        if (this.actionLink != null) {
            bundle.putString("action_link", this.actionLink);
        }
        if (this.message != null) {
            bundle.putString(VKApiConst.MESSAGE, this.message);
        }
        parcel.writeBundle(bundle);
    }

    /* renamed from: b */
    private int m2294b() {
        int i = 0;
        if (this.name != null && this.name.length() > 30) {
            i = 16;
        }
        if (this.description != null && this.description.length() > 200) {
            i |= 256;
        }
        if (this.caption != null && this.caption.length() > 20) {
            i |= 4096;
        }
        if (this.actionName != null && this.actionName.length() > 10) {
            i |= 65536;
        }
        if (this.message != null && this.message.length() > 200) {
            return i | MESSAGE_TOO_LONG;
        }
        return i;
    }

    /* renamed from: a */
    public Bundle m2295a() throws C0724f {
        if (this.name == null || this.name.length() == 0 || this.description == null || this.description.length() == 0 || this.url == null || this.url.length() == 0) {
            throw new C0724f(-1, "Required parameter could not be null.", "Required parameter could not be null.");
        }
        if (m2294b() != 0) {
            throw new C0724f(-3, "Some parameter is illegal for feed.", "Some parameter is illegal for feed.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("method", METHOD);
        bundle.putString("name", this.name);
        bundle.putString("description", this.description);
        bundle.putString("url", this.url);
        if (this.imageUrl != null) {
            bundle.putString(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, this.imageUrl);
        }
        if (this.caption != null) {
            bundle.putString("caption", this.caption);
        }
        if (this.actionName != null) {
            bundle.putString("action_name", this.actionName);
        }
        if (this.actionLink != null) {
            bundle.putString("action_link", this.actionLink);
        }
        if (this.message != null) {
            bundle.putString(VKApiConst.MESSAGE, this.message);
        }
        return bundle;
    }
}
