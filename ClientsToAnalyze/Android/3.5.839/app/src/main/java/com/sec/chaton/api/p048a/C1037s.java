package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityWebView;
import com.sec.chaton.settings.FragmentWebView;

/* compiled from: SupportLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.s */
/* loaded from: classes.dex */
public class C1037s extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) throws Resources.NotFoundException {
        intent.getExtras();
        Uri data = intent.getData();
        String action = intent.getAction();
        if (data != null && ("android.intent.action.VIEW".equals(action) || "android.intent.action.SEND".equals(action))) {
            String host = data.getHost();
            String path = data.getPath();
            if (host.equals("supports")) {
                if (path.equals("/notice")) {
                    if (!TextUtils.isEmpty(data.getQueryParameter("list_id"))) {
                        Toast.makeText(activity, R.string.toast_supported_format, 0);
                        return true;
                    }
                    Intent intent2 = new Intent(activity, (Class<?>) ActivityWebView.class);
                    intent2.putExtra(FragmentWebView.PARAM_MENU, "Noti");
                    intent2.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
                    activity.startActivity(intent2);
                    return true;
                }
                if (path.equals("/faq")) {
                    if (!TextUtils.isEmpty(data.getQueryParameter("list_id"))) {
                        Toast.makeText(activity, R.string.toast_supported_format, 0);
                        return true;
                    }
                    Intent intent3 = new Intent(activity, (Class<?>) ActivityWebView.class);
                    intent3.putExtra(FragmentWebView.PARAM_MENU, "Help");
                    intent3.putExtra(FragmentWebView.SHOW_BREADCRUMB, true);
                    activity.startActivity(intent3);
                    return true;
                }
                if (path.equals("/disclaimer")) {
                    Intent intent4 = new Intent(activity, (Class<?>) ActivityWebView.class);
                    intent4.putExtra(FragmentWebView.PARAM_MENU, "TERMS_AND_CONDITION");
                    intent4.putExtra(FragmentWebView.FROM_ABOUT_CHATON, true);
                    activity.startActivity(intent4);
                    return true;
                }
            }
        }
        return false;
    }
}
