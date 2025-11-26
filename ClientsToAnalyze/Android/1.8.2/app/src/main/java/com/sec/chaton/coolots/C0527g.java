package com.sec.chaton.coolots;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;

/* compiled from: GetPolicyInfoService.java */
/* renamed from: com.sec.chaton.coolots.g */
/* loaded from: classes.dex */
public class C0527g extends AbstractC0521a {

    /* renamed from: e */
    private String f2146e;

    /* renamed from: f */
    private String f2147f;

    /* renamed from: g */
    private String f2148g;

    /* renamed from: h */
    private String f2149h;

    /* renamed from: i */
    private String f2150i;

    public C0527g(Context context, InterfaceC0523c interfaceC0523c) {
        this(context, interfaceC0523c, null, null, null, null, null);
    }

    public C0527g(Context context, InterfaceC0523c interfaceC0523c, String str, String str2, String str3, String str4, String str5) throws Resources.NotFoundException {
        super(context, interfaceC0523c, "GetPolicyInfoService");
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
        if (str3 != null) {
            this.f2146e = str;
            this.f2147f = str2;
            this.f2148g = str3.toLowerCase();
            this.f2149h = str4;
            this.f2150i = str5;
            Log.i(this.f2134a, "GetPolicyInfoService " + this.f2146e + "/" + this.f2147f + "/" + this.f2148g + "/" + this.f2149h + "/" + this.f2150i);
        }
    }

    @Override // com.sec.chaton.coolots.AbstractC0521a
    /* renamed from: c */
    protected boolean mo2700c() {
        try {
            if (this.f2146e != null && this.f2147f != null && this.f2148g != null && this.f2149h != null && this.f2150i != null) {
                if (this.f2146e != null) {
                    this.f2137d.mo53b(this.f2146e, this.f2147f, this.f2148g, this.f2149h, this.f2150i);
                }
                Log.i(this.f2134a, "requestServicePolicyInfo ret=false");
                m2699b();
                if (this.f2136c != null) {
                    this.f2136c.mo2366a(false);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            m2699b();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            m2699b();
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            m2699b();
        }
        return false;
    }
}
