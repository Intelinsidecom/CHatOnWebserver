package com.sec.chaton.coolots;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;

/* compiled from: CreateAccountService.java */
/* renamed from: com.sec.chaton.coolots.f */
/* loaded from: classes.dex */
public class C0615f extends AbstractC0617h {

    /* renamed from: a */
    private String f2159a;

    /* renamed from: b */
    private String f2160b;

    /* renamed from: g */
    private String f2161g;

    /* renamed from: h */
    private String f2162h;

    /* renamed from: i */
    private String f2163i;

    public C0615f(Context context, InterfaceC0616g interfaceC0616g) {
        this(context, interfaceC0616g, null, null, null, null, null);
    }

    public C0615f(Context context, InterfaceC0616g interfaceC0616g, String str, String str2, String str3, String str4, String str5) throws Resources.NotFoundException {
        super(context, interfaceC0616g, "CreateAccountService");
        if (str == null) {
            str = C1323bs.m4575a().getString("msisdn", null);
            str2 = "1234";
            String string = C1323bs.m4575a().getString("country_name", null);
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
        this.f2159a = str;
        this.f2160b = str2;
        this.f2161g = str3.toLowerCase();
        this.f2162h = str4;
        this.f2163i = str5;
        Log.i(this.f2165c, "CreateAccountService " + this.f2159a + "/" + this.f2160b + "/" + this.f2161g + "/" + this.f2162h + "/" + this.f2163i);
    }

    @Override // com.sec.chaton.coolots.AbstractC0617h
    /* renamed from: a */
    protected boolean mo2830a() {
        try {
            boolean zMo49a = this.f2159a != null ? this.f2168f.mo49a(this.f2159a, this.f2160b, this.f2161g, this.f2162h, this.f2163i) : false;
            Log.i(this.f2165c, "createAccount ret=" + zMo49a);
            m2833c();
            if (this.f2167e != null) {
                this.f2167e.mo2367a(zMo49a);
                return zMo49a;
            }
            return zMo49a;
        } catch (RemoteException e) {
            e.printStackTrace();
            m2833c();
            return false;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            m2833c();
            return false;
        }
    }
}
