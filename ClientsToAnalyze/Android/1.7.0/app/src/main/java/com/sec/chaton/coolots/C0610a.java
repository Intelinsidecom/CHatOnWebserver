package com.sec.chaton.coolots;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;

/* compiled from: GetPolicyInfoService.java */
/* renamed from: com.sec.chaton.coolots.a */
/* loaded from: classes.dex */
public class C0610a extends AbstractC0617h {

    /* renamed from: a */
    private String f2146a;

    /* renamed from: b */
    private String f2147b;

    /* renamed from: g */
    private String f2148g;

    /* renamed from: h */
    private String f2149h;

    /* renamed from: i */
    private String f2150i;

    public C0610a(Context context, InterfaceC0616g interfaceC0616g) {
        this(context, interfaceC0616g, null, null, null, null, null);
    }

    public C0610a(Context context, InterfaceC0616g interfaceC0616g, String str, String str2, String str3, String str4, String str5) throws Resources.NotFoundException {
        super(context, interfaceC0616g, "GetPolicyInfoService");
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
        if (str3 != null) {
            this.f2146a = str;
            this.f2147b = str2;
            this.f2148g = str3.toLowerCase();
            this.f2149h = str4;
            this.f2150i = str5;
            Log.i(this.f2165c, "GetPolicyInfoService " + this.f2146a + "/" + this.f2147b + "/" + this.f2148g + "/" + this.f2149h + "/" + this.f2150i);
        }
    }

    @Override // com.sec.chaton.coolots.AbstractC0617h
    /* renamed from: a */
    protected boolean mo2830a() {
        try {
            if (this.f2146a != null && this.f2147b != null && this.f2148g != null && this.f2149h != null && this.f2150i != null) {
                if (this.f2146a != null) {
                    this.f2168f.mo53b(this.f2146a, this.f2147b, this.f2148g, this.f2149h, this.f2150i);
                }
                Log.i(this.f2165c, "requestServicePolicyInfo ret=false");
                m2833c();
                if (this.f2167e != null) {
                    this.f2167e.mo2367a(false);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            m2833c();
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            m2833c();
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            m2833c();
        }
        return false;
    }
}
