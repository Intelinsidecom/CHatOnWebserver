package com.sec.chaton.buddy;

import android.content.Context;
import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.sns.p115ui.facebook.FacebookSubMenuActivity;
import com.sec.chaton.sns.p115ui.odnoklassniki.OdnokSubMenuActivity;
import com.sec.chaton.sns.p115ui.renren.RenrenSubMenuActivity;
import com.sec.chaton.sns.p115ui.twitter.TwitterSubMenuActivity;
import com.sec.chaton.sns.p115ui.vkontakte.VKontakteSubMenuActivity;
import com.sec.chaton.sns.p115ui.weibo.WeiboSubMenuActivity;

/* compiled from: TellFriendsSnsListFragment.java */
/* renamed from: com.sec.chaton.buddy.iy */
/* loaded from: classes.dex */
public class C1399iy {

    /* renamed from: a */
    private String f5026a;

    /* renamed from: b */
    private Intent f5027b;

    public C1399iy(String str) {
        this.f5026a = str;
    }

    /* renamed from: a */
    public void m7515a(Context context) {
        this.f5027b = new Intent(context, m7513a(context, this.f5026a));
    }

    /* renamed from: a */
    public String m7514a() {
        return this.f5026a;
    }

    /* renamed from: b */
    public Intent m7516b() {
        return this.f5027b;
    }

    /* renamed from: a */
    private Class<?> m7513a(Context context, String str) {
        if (str.equals(context.getString(R.string.tellfriends_via_facebook))) {
            return FacebookSubMenuActivity.class;
        }
        if (str.equals(context.getString(R.string.tellfriends_via_twitter))) {
            return TwitterSubMenuActivity.class;
        }
        if (str.equals(context.getString(R.string.tellfriends_via_weibo))) {
            return WeiboSubMenuActivity.class;
        }
        if (str.equals(context.getString(R.string.tellfriends_via_renren))) {
            return RenrenSubMenuActivity.class;
        }
        if (str.equals(context.getString(R.string.tellfriends_via_odnoklassniki))) {
            return OdnokSubMenuActivity.class;
        }
        if (str.equals(context.getString(R.string.tellfriends_via_vkontakte))) {
            return VKontakteSubMenuActivity.class;
        }
        return FacebookSubMenuActivity.class;
    }
}
