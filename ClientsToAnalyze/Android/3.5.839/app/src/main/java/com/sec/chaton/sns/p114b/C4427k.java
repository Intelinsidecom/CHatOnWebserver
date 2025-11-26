package com.sec.chaton.sns.p114b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.sns.C4363a;
import com.sec.chaton.sns.p113a.AbstractC4369f;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.sns.p115ui.DialogC4446a;
import com.sec.chaton.sns.p115ui.odnoklassniki.p116a.C4495a;
import com.sec.chaton.sns.p115ui.odnoklassniki.p116a.C4496b;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import com.sec.spp.push.dlc.api.DlcApi;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010b.p012b.C0280i;

/* compiled from: OdnoklassnikiManager.java */
/* renamed from: com.sec.chaton.sns.b.k */
/* loaded from: classes.dex */
public class C4427k extends AbstractC4369f {

    /* renamed from: c */
    public static final String f15986c = C4427k.class.getSimpleName();

    /* renamed from: e */
    private static C4496b f15987e;

    /* renamed from: f */
    private static C0280i f15988f;

    /* renamed from: d */
    public Context f15989d;

    /* renamed from: g */
    private String f15990g;

    /* renamed from: h */
    private InterfaceC4367d f15991h;

    /* renamed from: i */
    private int f15992i;

    /* renamed from: j */
    private Random f15993j;

    public C4427k(Context context, InterfaceC4367d interfaceC4367d) {
        super(context, interfaceC4367d, f15986c);
        this.f15990g = null;
        this.f15993j = new Random();
        this.f15989d = context;
        this.f15991h = interfaceC4367d;
        if (f15987e == null) {
            f15987e = C4496b.m17030a(context, "223397120", "29341535E6AFF6362750637B", "CBAGMBFOABABABABA");
        }
    }

    /* renamed from: a */
    public void m16782a(int i) {
        new DialogC4446a(this.f15989d, m16764a("VALUABLE ACCESS"), new C4431o(this, i)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m16780h() {
        new AsyncTaskC4428l(this).execute(new Void[0]);
    }

    /* renamed from: b */
    public boolean m16785b() {
        return C4363a.m16556e(this.f15989d);
    }

    /* renamed from: c */
    public String m16786c() {
        return C4363a.m16558g(this.f15989d);
    }

    /* renamed from: d */
    public String m16788d() {
        return C4363a.m16560i(this.f15989d);
    }

    /* renamed from: e */
    public String m16789e() {
        return C4363a.m16559h(this.f15989d);
    }

    /* renamed from: f */
    public String m16790f() {
        return C4363a.m16549b(this.f15989d);
    }

    /* renamed from: b */
    public void m16784b(int i) {
        new AsyncTaskC4429m(this, i).execute(new Void[0]);
    }

    @Override // com.sec.chaton.sns.p113a.AbstractC4369f
    /* renamed from: a */
    public void mo16570a(int i, boolean z) throws NoSuchAlgorithmException {
        if (z) {
            m16784b(i);
            return;
        }
        String strM16781i = m16781i();
        List<C4495a> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(strM16781i)) {
            if ("NeedUserLoginAgain".equals(strM16781i)) {
                this.f15991h.mo16563a(i, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
                return;
            }
            arrayList = m16775e(strM16781i);
        }
        if (arrayList != null && arrayList.size() >= 0) {
            this.f15991h.mo16563a(i, -1, arrayList);
        } else {
            this.f15991h.mo16563a(i, DlcApi.RC_SVC_NOT_CONNECTED, null);
        }
    }

    /* renamed from: c */
    public void m16787c(int i) {
    }

    /* renamed from: a */
    public static void m16765a(Context context) {
        C4363a.m16557f(context);
        C4368e.m16564a(context).m16565a(C4368e.f15818d, false);
        C4809aa.m18108a("register_od_sns_type", "");
    }

    /* renamed from: a */
    public void m16783a(Context context, int i) {
        f15987e.m17034b(context);
        C4363a.m16557f(context);
        C4368e.m16564a(this.f15989d).m16565a(C4368e.f15818d, false);
        this.f15991h.mo16563a(i, -1, null);
    }

    /* renamed from: a */
    private final String m16764a(String... strArr) {
        String str;
        String strEncode = URLEncoder.encode("okauth://ok223397120");
        if (Build.VERSION.SDK_INT > 16) {
            str = String.format("http://odnoklassniki.ru/oauth/authorize?client_id=%s&response_type=%s&redirect_uri=%s&layout=m&tkn=%s", "223397120", "code", strEncode, Integer.valueOf(this.f15993j.nextInt(9999)));
        } else {
            str = String.format("https://odnoklassniki.ru/oauth/authorize?client_id=%s&response_type=%s&redirect_uri=%s&layout=m&tkn=%s", "223397120", "code", strEncode, Integer.valueOf(this.f15993j.nextInt(9999)));
        }
        if (strArr != null && strArr.length > 0) {
            return str + "&scope=" + URLEncoder.encode(TextUtils.join(Config.KEYVALUE_SPLIT, strArr));
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m16771c(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C4363a.m16554d(this.f15989d, jSONObject.getString("uid"));
                C4363a.m16552c(this.f15989d, jSONObject.getString("name"));
                C4363a.m16555e(this.f15989d, jSONObject.getString("pic_1"));
                this.f15991h.mo16563a(this.f15992i, -1, null);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        this.f15991h.mo16563a(this.f15992i, DlcApi.RC_SVC_NOT_CONNECTED, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public String m16781i() throws NoSuchAlgorithmException {
        String strM17032a;
        String strM16777f = null;
        try {
            f15987e.m17033a(this.f15989d);
            strM17032a = f15987e.m17032a("friends.get", null, "get");
        } catch (IOException e) {
            e.printStackTrace();
            strM17032a = null;
        } catch (IllegalArgumentException e2) {
            C4904y.m18634a(e2.getMessage(), "[OdnoKlassnikiManager]");
            return "NeedUserLoginAgain";
        }
        if (strM17032a == null || strM17032a.equals("[]")) {
            return null;
        }
        Log.i("Get user friends result: " + strM17032a, "");
        try {
            strM16777f = m16777f(strM17032a);
            Log.i("Get user  friendsId: " + strM16777f, "");
            return strM16777f;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return strM16777f;
        }
    }

    /* renamed from: d */
    private List<C4495a> m16773d(String str) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    new StringBuilder();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C4495a c4495a = new C4495a();
                    c4495a.m17022a(jSONObject.getString("uid"));
                    c4495a.m17026c(jSONObject.getString("first_name"));
                    c4495a.m17024b(jSONObject.getString("last_name"));
                    c4495a.m17028d(jSONObject.getString("name"));
                    c4495a.m17029e(jSONObject.getString("pic_1"));
                    arrayList.add(c4495a);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public List<C4495a> m16775e(String str) throws NoSuchAlgorithmException {
        String strM17032a;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            HashMap map = new HashMap();
            map.put("uids", str);
            map.put(VKApiConst.FIELDS, "uid,last_name,first_name,name,pic_1");
            try {
                strM17032a = f15987e.m17032a("users.getInfo", map, "get");
            } catch (IOException e) {
                e.printStackTrace();
                strM17032a = null;
            }
            if (strM17032a != null) {
                try {
                    return m16773d(strM17032a);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: f */
    private String m16777f(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(',').append(jSONArray.getString(i));
        }
        return sb.toString();
    }
}
