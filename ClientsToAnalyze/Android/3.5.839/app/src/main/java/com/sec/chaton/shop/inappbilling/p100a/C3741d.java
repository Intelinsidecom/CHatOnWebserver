package com.sec.chaton.shop.inappbilling.p100a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import com.android.p025a.p026a.InterfaceC0354a;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: IabHelper.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.d */
/* loaded from: classes.dex */
public class C3741d {

    /* renamed from: a */
    boolean f13442a = false;

    /* renamed from: b */
    String f13443b = "IabHelper";

    /* renamed from: c */
    boolean f13444c = false;

    /* renamed from: d */
    boolean f13445d = false;

    /* renamed from: e */
    String f13446e = "";

    /* renamed from: f */
    Context f13447f;

    /* renamed from: g */
    InterfaceC0354a f13448g;

    /* renamed from: h */
    ServiceConnection f13449h;

    /* renamed from: i */
    int f13450i;

    /* renamed from: j */
    String f13451j;

    /* renamed from: k */
    String f13452k;

    /* renamed from: l */
    InterfaceC3750m f13453l;

    public C3741d(Context context, String str) {
        this.f13452k = null;
        this.f13447f = context.getApplicationContext();
        this.f13452k = str;
        m14122c("IAB helper created.");
    }

    /* renamed from: a */
    public void m14117a(boolean z) {
        this.f13442a = z;
    }

    /* renamed from: a */
    public void m14111a(InterfaceC3751n interfaceC3751n) {
        if (this.f13444c) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        m14122c("Starting in-app billing setup.");
        this.f13449h = new ServiceConnectionC3742e(this, interfaceC3751n);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (!this.f13447f.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            this.f13447f.bindService(intent, this.f13449h, 1);
        } else if (interfaceC3751n != null) {
            interfaceC3751n.mo14095a(new C3753p(3, "Billing service unavailable on device."));
        }
    }

    /* renamed from: a */
    public void m14108a() {
        m14122c("Disposing.");
        this.f13444c = false;
        m14120b();
        if (this.f13449h != null) {
            m14122c("Unbinding from service.");
            if (this.f13447f != null && this.f13448g != null) {
                this.f13447f.unbindService(this.f13449h);
            }
            this.f13449h = null;
            this.f13448g = null;
            this.f13453l = null;
        }
    }

    /* renamed from: a */
    public void m14109a(Activity activity, String str, int i, InterfaceC3750m interfaceC3750m, String str2) throws IntentSender.SendIntentException {
        m14110a(activity, str, "inapp", i, interfaceC3750m, str2);
    }

    /* renamed from: a */
    public void m14110a(Activity activity, String str, String str2, int i, InterfaceC3750m interfaceC3750m, String str3) throws IntentSender.SendIntentException {
        m14115a("launchPurchaseFlow");
        m14121b("launchPurchaseFlow");
        try {
            m14122c("Constructing buy intent for " + str + ", item type: " + str2);
            Bundle bundleMo1249a = this.f13448g.mo1249a(3, this.f13447f.getPackageName(), str, str2, str3);
            int iM14103a = m14103a(bundleMo1249a);
            if (iM14103a != 0) {
                m14123d("Unable to buy item, Error response: " + m14101a(iM14103a));
                C3753p c3753p = new C3753p(iM14103a, "Unable to buy item");
                if (interfaceC3750m != null) {
                    interfaceC3750m.mo14127a(c3753p, null);
                }
            } else {
                PendingIntent pendingIntent = (PendingIntent) bundleMo1249a.getParcelable("BUY_INTENT");
                m14122c("Launching buy intent for " + str + ". Request code: " + i);
                this.f13450i = i;
                this.f13453l = interfaceC3750m;
                this.f13451j = str2;
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intent intent = new Intent();
                Integer num = 0;
                int iIntValue = num.intValue();
                Integer num2 = 0;
                int iIntValue2 = num2.intValue();
                Integer num3 = 0;
                activity.startIntentSenderForResult(intentSender, i, intent, iIntValue, iIntValue2, num3.intValue());
            }
        } catch (IntentSender.SendIntentException e) {
            m14123d("SendIntentException while launching purchase flow for sku " + str);
            e.printStackTrace();
            C3753p c3753p2 = new C3753p(-1004, "Failed to send intent.");
            if (interfaceC3750m != null) {
                interfaceC3750m.mo14127a(c3753p2, null);
            }
        } catch (RemoteException e2) {
            m14123d("RemoteException while launching purchase flow for sku " + str);
            e2.printStackTrace();
            C3753p c3753p3 = new C3753p(-1001, "Remote exception while starting purchase flow");
            if (interfaceC3750m != null) {
                interfaceC3750m.mo14127a(c3753p3, null);
            }
        }
    }

    /* renamed from: a */
    public boolean m14119a(int i, int i2, Intent intent) {
        if (i != this.f13450i) {
            return false;
        }
        m14115a("handleActivityResult");
        m14120b();
        if (intent == null) {
            m14123d("Null data in IAB activity result.");
            C3753p c3753p = new C3753p(-1002, "Null data in IAB result");
            if (this.f13453l != null) {
                this.f13453l.mo14127a(c3753p, null);
            }
            return true;
        }
        int iM14102a = m14102a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && iM14102a == 0) {
            m14122c("Successful resultcode from purchase activity.");
            m14122c("Purchase data: " + stringExtra);
            m14122c("Data signature: " + stringExtra2);
            m14122c("Extras: " + intent.getExtras());
            m14122c("Expected item type: " + this.f13451j);
            if (stringExtra == null || stringExtra2 == null) {
                m14123d("BUG: either purchaseData or dataSignature is null.");
                m14122c("Extras: " + intent.getExtras().toString());
                C3753p c3753p2 = new C3753p(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.f13453l != null) {
                    this.f13453l.mo14127a(c3753p2, null);
                }
                return true;
            }
            try {
                C3756s c3756s = new C3756s(this.f13451j, stringExtra, stringExtra2);
                String strM14138b = c3756s.m14138b();
                if (!C3757t.m14144a(this.f13452k, stringExtra, stringExtra2)) {
                    m14123d("Purchase signature verification FAILED for sku " + strM14138b);
                    C3753p c3753p3 = new C3753p(-1003, "Signature verification failed for sku " + strM14138b);
                    if (this.f13453l != null) {
                        this.f13453l.mo14127a(c3753p3, c3756s);
                    }
                    return true;
                }
                m14122c("Purchase signature successfully verified.");
                if (this.f13453l != null) {
                    this.f13453l.mo14127a(new C3753p(0, "Success"), c3756s);
                }
            } catch (JSONException e) {
                m14123d("Failed to parse purchase data.");
                e.printStackTrace();
                C3753p c3753p4 = new C3753p(-1002, "Failed to parse purchase data.");
                if (this.f13453l != null) {
                    this.f13453l.mo14127a(c3753p4, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            m14122c("Result code was OK but in-app billing response was not OK: " + m14101a(iM14102a));
            if (this.f13453l != null) {
                this.f13453l.mo14127a(new C3753p(iM14102a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            m14122c("Purchase canceled - Response: " + m14101a(iM14102a));
            C3753p c3753p5 = new C3753p(-1005, "User canceled.");
            if (this.f13453l != null) {
                this.f13453l.mo14127a(c3753p5, null);
            }
        } else {
            m14123d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + m14101a(iM14102a));
            C3753p c3753p6 = new C3753p(-1006, "Unknown purchase response.");
            if (this.f13453l != null) {
                this.f13453l.mo14127a(c3753p6, null);
            }
        }
        return true;
    }

    /* renamed from: a */
    public C3754q m14106a(boolean z, List<String> list) {
        return m14107a(z, list, (List<String>) null);
    }

    /* renamed from: a */
    public C3754q m14107a(boolean z, List<String> list, List<String> list2) throws C3740c {
        int iM14105a;
        m14115a("queryInventory");
        try {
            C3754q c3754q = new C3754q();
            int iM14104a = m14104a(c3754q, "inapp");
            if (iM14104a != 0) {
                throw new C3740c(iM14104a, "Error refreshing inventory (querying owned items).");
            }
            if (z && (iM14105a = m14105a("inapp", c3754q, list)) != 0) {
                throw new C3740c(iM14105a, "Error refreshing inventory (querying prices of items).");
            }
            return c3754q;
        } catch (RemoteException e) {
            throw new C3740c(-1001, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new C3740c(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    /* renamed from: a */
    public void m14118a(boolean z, List<String> list, InterfaceC3752o interfaceC3752o) {
        Handler handler = new Handler();
        m14115a("queryInventory");
        m14121b("refresh inventory");
        new Thread(new RunnableC3743f(this, z, list, handler, interfaceC3752o)).start();
    }

    /* renamed from: a */
    public void m14112a(InterfaceC3752o interfaceC3752o) {
        m14118a(true, (List<String>) null, interfaceC3752o);
    }

    /* renamed from: a */
    void m14113a(C3756s c3756s) throws C3740c {
        m14115a("consume");
        if (!c3756s.f13484a.equals("inapp")) {
            throw new C3740c(-1010, "Items of type '" + c3756s.f13484a + "' can't be consumed.");
        }
        try {
            String strM14140d = c3756s.m14140d();
            String strM14138b = c3756s.m14138b();
            if (strM14140d == null || strM14140d.equals("")) {
                m14123d("Can't consume " + strM14138b + ". No token.");
                throw new C3740c(-1007, "PurchaseInfo is missing token for sku: " + strM14138b + " " + c3756s);
            }
            m14122c("Consuming sku: " + strM14138b + ", token: " + strM14140d);
            int iMo1250b = this.f13448g.mo1250b(3, this.f13447f.getPackageName(), strM14140d);
            if (iMo1250b == 0) {
                m14122c("Successfully consumed sku: " + strM14138b);
            } else {
                m14122c("Error consuming consuming sku " + strM14138b + ". " + m14101a(iMo1250b));
                throw new C3740c(iMo1250b, "Error consuming sku " + strM14138b);
            }
        } catch (RemoteException e) {
            throw new C3740c(-1001, "Remote exception while consuming. PurchaseInfo: " + c3756s, e);
        }
    }

    /* renamed from: a */
    public void m14114a(C3756s c3756s, InterfaceC3748k interfaceC3748k) {
        m14115a("consume");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c3756s);
        m14116a(arrayList, interfaceC3748k, (InterfaceC3749l) null);
    }

    /* renamed from: a */
    public static String m14101a(int i) {
        String[] strArrSplit = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] strArrSplit2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = (-1000) - i;
            return (i2 < 0 || i2 >= strArrSplit2.length) ? String.valueOf(i) + ":Unknown IAB Helper Error" : strArrSplit2[i2];
        }
        if (i < 0 || i >= strArrSplit.length) {
            return String.valueOf(i) + ":Unknown";
        }
        return strArrSplit[i];
    }

    /* renamed from: a */
    void m14115a(String str) {
        if (!this.f13444c) {
            m14123d("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    /* renamed from: a */
    int m14103a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m14122c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        m14123d("Unexpected type for bundle response code.");
        m14123d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
    }

    /* renamed from: a */
    int m14102a(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            m14123d("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        m14123d("Unexpected type for intent response code.");
        m14123d(obj.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
    }

    /* renamed from: b */
    void m14121b(String str) {
        if (this.f13445d) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.f13446e + ") is in progress.");
        }
        this.f13446e = str;
        this.f13445d = true;
        m14122c("Starting async operation: " + str);
    }

    /* renamed from: b */
    void m14120b() {
        m14122c("Ending async operation: " + this.f13446e);
        this.f13446e = "";
        this.f13445d = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b4, code lost:
    
        m14123d("Bundle returned from getPurchases() doesn't contain required fields.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return -1002;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int m14104a(com.sec.chaton.shop.inappbilling.p100a.C3754q r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.shop.inappbilling.p100a.C3741d.m14104a(com.sec.chaton.shop.inappbilling.a.q, java.lang.String):int");
    }

    /* renamed from: a */
    int m14105a(String str, C3754q c3754q, List<String> list) {
        m14122c("Querying SKU details.");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(c3754q.m14135b(str));
        if (list != null) {
            arrayList.addAll(list);
        }
        if (arrayList.size() == 0) {
            m14122c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        Bundle bundleMo1247a = this.f13448g.mo1247a(3, this.f13447f.getPackageName(), str, bundle);
        if (bundleMo1247a == null) {
            return -1002;
        }
        if (!bundleMo1247a.containsKey("DETAILS_LIST")) {
            int iM14103a = m14103a(bundleMo1247a);
            if (iM14103a != 0) {
                m14122c("getSkuDetails() failed: " + m14101a(iM14103a));
                return iM14103a;
            }
            m14123d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return -1002;
        }
        Iterator<String> it = bundleMo1247a.getStringArrayList("DETAILS_LIST").iterator();
        while (it.hasNext()) {
            C3755r c3755r = new C3755r(str, it.next());
            m14122c("Got sku details: " + c3755r);
            c3754q.m14133a(c3755r);
        }
        return 0;
    }

    /* renamed from: a */
    void m14116a(List<C3756s> list, InterfaceC3748k interfaceC3748k, InterfaceC3749l interfaceC3749l) {
        Handler handler = new Handler();
        m14121b("consume");
        new Thread(new RunnableC3745h(this, list, interfaceC3748k, handler, interfaceC3749l)).start();
    }

    /* renamed from: c */
    void m14122c(String str) {
        if (this.f13442a && C4904y.f17872b) {
            C4904y.m18639b(str, this.f13443b);
        }
    }

    /* renamed from: d */
    void m14123d(String str) {
        if (C4904y.f17875e) {
            C4904y.m18634a("In-app billing error: " + str, this.f13443b);
        }
    }

    /* renamed from: e */
    void m14124e(String str) {
        if (C4904y.f17874d) {
            C4904y.m18645d("In-app billing warning: " + str, this.f13443b);
        }
    }
}
