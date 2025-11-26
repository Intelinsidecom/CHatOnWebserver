package com.sec.chaton.coolots;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;

/* compiled from: CreateAccountService.java */
/* renamed from: com.sec.chaton.coolots.d */
/* loaded from: classes.dex */
public class C0524d extends AbstractC0521a {

    /* renamed from: e */
    private String f2140e;

    /* renamed from: f */
    private String f2141f;

    /* renamed from: g */
    private String f2142g;

    /* renamed from: h */
    private String f2143h;

    /* renamed from: i */
    private String f2144i;

    public C0524d(Context context, InterfaceC0523c interfaceC0523c) {
        this(context, interfaceC0523c, null, null, null, null, null);
    }

    public C0524d(Context context, InterfaceC0523c interfaceC0523c, String str, String str2, String str3, String str4, String str5) throws Resources.NotFoundException {
        super(context, interfaceC0523c, "CreateAccountService");
        if (str == null) {
            str = C1789u.m6075a().getString("msisdn", null);
            str2 = "1234";
            String string = C1789u.m6075a().getString("country_name", null);
            String[] stringArray = context.getResources().getStringArray(R.array.country);
            String[] stringArray2 = context.getResources().getStringArray(R.array.ISO_country_code_Letter2);
            String[] stringArray3 = context.getResources().getStringArray(R.array.country_code);
            int i = 0;
            while (true) {
                if (i >= stringArray.length) {
                    break;
                }
                if (!stringArray[i].equals(string)) {
                    i++;
                } else {
                    str3 = stringArray2[i];
                    str4 = stringArray3[i];
                    str5 = str.substring(str4.length());
                    break;
                }
            }
        }
        this.f2140e = str;
        this.f2141f = str2;
        this.f2142g = str3.toLowerCase();
        this.f2143h = str4;
        this.f2144i = str5;
        Log.i(this.f2134a, "CreateAccountService " + this.f2140e + "/" + this.f2141f + "/" + this.f2142g + "/" + this.f2143h + "/" + this.f2144i);
    }

    @Override // com.sec.chaton.coolots.AbstractC0521a
    /* renamed from: c */
    protected boolean mo2700c() {
        try {
            boolean zMo49a = this.f2140e != null ? this.f2137d.mo49a(this.f2140e, this.f2141f, this.f2142g, this.f2143h, this.f2144i) : false;
            Log.i(this.f2134a, "createAccount ret=" + zMo49a);
            m2699b();
            if (this.f2136c != null) {
                this.f2136c.mo2366a(zMo49a);
                return zMo49a;
            }
            return zMo49a;
        } catch (RemoteException e) {
            e.printStackTrace();
            m2699b();
            return false;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            m2699b();
            return false;
        }
    }
}
