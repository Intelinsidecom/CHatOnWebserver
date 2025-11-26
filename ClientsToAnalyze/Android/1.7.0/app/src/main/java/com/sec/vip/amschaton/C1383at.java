package com.sec.vip.amschaton;

import android.content.Context;
import android.os.RemoteException;
import android.p000os.IVoIPInterface;
import android.p000os.ServiceManager;
import android.telephony.TelephonyManager;

/* compiled from: AMSCallStateInfo.java */
/* renamed from: com.sec.vip.amschaton.at */
/* loaded from: classes.dex */
public class C1383at {
    /* renamed from: a */
    public static boolean m4964a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    /* renamed from: b */
    public static boolean m4965b(Context context) {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPIdle();
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m4966c(Context context) {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPRingOrDialing();
            } catch (RemoteException e) {
            }
        }
        return false;
    }
}
