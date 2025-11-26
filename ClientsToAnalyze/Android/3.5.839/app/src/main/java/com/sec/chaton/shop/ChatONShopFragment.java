package com.sec.chaton.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.shop.entrys.PurchaseRequestEntry;
import com.sec.chaton.shop.items.ItemMarket;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ChatONShopFragment extends AbstractChatONShopFragment {

    /* renamed from: a */
    private static final String f13331a = ChatONShopFragment.class.getSimpleName();

    /* renamed from: b */
    private EnumC3762k f13332b;

    /* renamed from: c */
    private C3733f f13333c;

    /* renamed from: d */
    private Activity f13334d;

    /* renamed from: e */
    private PurchaseRequestEntry f13335e;

    /* renamed from: f */
    private long f13336f;

    /* renamed from: g */
    private String f13337g;

    /* renamed from: h */
    private String f13338h;

    /* renamed from: i */
    private AsyncTaskC3731d f13339i;

    /* renamed from: j */
    private boolean f13340j;

    /* renamed from: k */
    private Handler f13341k;

    /* renamed from: l */
    private Handler f13342l;

    public ChatONShopFragment() {
        super(f13331a, EnumC2599m.SHOP_MAIN);
        this.f13332b = EnumC3762k.MAIN;
        this.f13341k = new HandlerC3735h(this);
        this.f13342l = new HandlerC3736i(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("page_name")) {
            int i = arguments.getInt("page_name");
            if (i == 0) {
                this.f13332b = EnumC3762k.MAIN;
            } else if (i == 1) {
                this.f13332b = EnumC3762k.DETAIL;
                this.f13336f = arguments.getLong("category_id");
                this.f13337g = arguments.getString("item_id");
                this.f13338h = arguments.getString("anicon_id");
            } else if (i == 2) {
                this.f13332b = EnumC3762k.CATEGORY;
                this.f13336f = arguments.getLong("category_id");
            }
        }
        if (bundle != null) {
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f13341k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m13980a(ItemMarket itemMarket) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(itemMarket.data1) && !TextUtils.isEmpty(itemMarket.data2) && !TextUtils.isEmpty(itemMarket.data3) && !TextUtils.isEmpty(itemMarket.data4)) {
            try {
                sb.append(itemMarket.data1.substring(2)).append(itemMarket.data2).append(itemMarket.data3.substring(0, itemMarket.data3.length() - 1)).append(itemMarket.data4.substring(0, itemMarket.data4.length() - 3));
            } catch (IndexOutOfBoundsException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f13331a);
                }
            }
        } else if (C4904y.f17875e) {
            C4904y.m18634a("data is null(empty) from server", f13331a);
        }
        return sb.toString();
    }

    /* renamed from: e */
    private void m13995e() {
        if (C4904y.f17872b) {
            C4904y.m18639b("refreshBadgeCount", f13331a);
        }
        C4809aa.m18104a().m18126b("new_anicon_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_skin_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_font_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_sound_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_ams_item_background_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_ams_item_stamp_count", (Integer) 0);
        C4809aa.m18104a().m18126b("new_ams_item_template_count", (Integer) 0);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Log.d(f13331a, "success to get purchase data");
            switch (i) {
                case 10:
                    if (this.f13335e != null) {
                        this.f13333c.m14075a(this.f13335e, this.f13342l, this.f13334d, intent, this.f13335e.success);
                        break;
                    } else {
                        C5179v.m19810a(this.f13334d, R.string.purchase_failed, 1).show();
                        break;
                    }
            }
            return;
        }
        Log.d(f13331a, "fail to get purchase data");
        if (this.f13335e != null) {
            this.f13333c.m14075a(this.f13335e, this.f13342l, this.f13334d, intent, this.f13335e.error);
        } else {
            C5179v.m19810a(this.f13334d, R.string.purchase_failed, 1).show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!C5034k.m19106k()) {
            m13971a();
            return;
        }
        if (!m13972b()) {
            if (!this.f13340j) {
                m13995e();
                this.f13340j = true;
            }
            boolean zIsRequestedLoadingWeb = isRequestedLoadingWeb();
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("onResume(), requestedLoadingWeb(%s), isActivityStarted(%s)", Boolean.valueOf(zIsRequestedLoadingWeb), Boolean.valueOf(this.mIsActivityStarted)), f13331a);
            }
            if (zIsRequestedLoadingWeb) {
                refreshWebContents();
            } else {
                startWebContents(m13996f());
            }
        }
    }

    /* renamed from: f */
    private String m13996f() {
        getApiUsageType();
        String str = "";
        if (this.f13332b == EnumC3762k.MAIN) {
            str = "/shop/getMain?" + (("myid=" + C4809aa.m18104a().m18121a("chaton_id", "")) + "&" + ("countryCd=" + C4822an.m18257y()));
        } else if (this.f13332b == EnumC3762k.CATEGORY) {
            str = "/shop/getMain?" + ("cParam=" + C4822an.m18257y() + "&categoryId=" + this.f13336f);
        } else if (this.f13332b == EnumC3762k.DETAIL) {
            StringBuilder sb = new StringBuilder();
            sb.append("cParam=").append(C4822an.m18257y()).append("&selCategoryId=").append(this.f13336f).append("&platformCode=android");
            if (TextUtils.isEmpty(this.f13337g)) {
                this.f13337g = Spam.ACTIVITY_CANCEL;
            }
            sb.append("&selItemId=").append(this.f13337g);
            if (this.f13336f == 1) {
                sb.append("&fileType=png&pixelSize=240");
                String str2 = Spam.ACTIVITY_CANCEL;
                if (TextUtils.isEmpty(this.f13338h)) {
                    this.f13338h = Spam.ACTIVITY_CANCEL;
                    if (this.f13337g.equals(Spam.ACTIVITY_CANCEL)) {
                        str2 = Spam.ACTIVITY_REPORT;
                    }
                }
                sb.append("&selAniconId=").append(this.f13338h).append("&symbolType=").append(str2);
            }
            str = "/shop/getDetail?" + ((Object) sb);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("getRequestUrl(), requestUrl: %s", str), f13331a);
        }
        return str;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f13341k = null;
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
        if (this.f13339i != null) {
            this.f13339i.cancel(true);
        }
    }

    @Override // com.sec.chaton.shop.AbstractChatONShopFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected WebView onCreateWebView(View view) {
        this.f13333c = new C3733f();
        this.f13334d = getAttachedActivity();
        return super.onCreateWebView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13985a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13984a(String str, int i) {
        if (i == 1) {
            C5179v.m19811a(getActivity(), str, 1).show();
        } else {
            C5179v.m19811a(getActivity(), str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m13977a(long j) {
        switch ((int) j) {
            case 1:
                return EnumC2258bd.Anicon.m10123a();
            case 2:
            case 4:
            default:
                return null;
            case 3:
                return EnumC2258bd.Skin.m10123a();
            case 5:
                return EnumC2258bd.Font.m10123a();
            case 6:
                return EnumC2258bd.Sound.m10123a();
            case 7:
                return EnumC2258bd.AmsTemplate.m10123a();
            case 8:
                return EnumC2258bd.AmsBackground.m10123a();
            case 9:
                return EnumC2258bd.AmsStamp.m10123a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13990b(String str, String str2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("startForwardActivity() msgType[" + str + "]", f13331a);
        }
        switch (Integer.parseInt(str)) {
            case 1:
                Intent intent = new Intent(this.f13334d, (Class<?>) ChatForwardActivity.class);
                intent.putExtra("content_type", EnumC2214ab.ANICON.m10076a());
                intent.putExtra("inboxNO", "");
                intent.putExtra("download_uri", str2);
                intent.putExtra("sub_content", str2);
                intent.putExtra("is_forward_mode", true);
                intent.putExtra("forward_chat_message", true);
                startActivity(intent);
                break;
            default:
                if (C4904y.f17872b) {
                    C4904y.m18639b("startForwardActivity :: msgType[" + str + "] is not handled and do nothing.", f13331a);
                    break;
                }
                break;
        }
    }
}
