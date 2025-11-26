package com.sec.chaton.p061g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.util.C4809aa;
import com.sec.common.CommonApplication;

/* compiled from: FreeSmsInviteSenderHelper.java */
/* renamed from: com.sec.chaton.g.c */
/* loaded from: classes.dex */
public class C2344c {

    /* renamed from: a */
    Handler f8336a;

    /* renamed from: b */
    private final Context f8337b;

    /* renamed from: c */
    private final String[] f8338c;

    /* renamed from: d */
    private final String[] f8339d;

    /* renamed from: e */
    private final int f8340e;

    /* renamed from: f */
    private Handler f8341f;

    /* renamed from: g */
    private int f8342g;

    /* renamed from: h */
    private int f8343h;

    /* renamed from: i */
    private int f8344i;

    /* renamed from: j */
    private C2097bc f8345j;

    /* renamed from: k */
    private boolean f8346k;

    /* renamed from: l */
    private int f8347l;

    public C2344c(Context context, String[] strArr, String[] strArr2, boolean z) {
        this.f8341f = null;
        this.f8346k = false;
        this.f8347l = 0;
        this.f8336a = new HandlerC2345d(this, Looper.getMainLooper());
        this.f8337b = context;
        this.f8338c = strArr;
        this.f8339d = strArr2;
        this.f8340e = strArr2.length % 20 == 0 ? strArr2.length / 20 : (strArr2.length / 20) + 1;
        this.f8342g = 0;
        this.f8344i = 0;
        this.f8346k = z;
        this.f8347l = 0;
    }

    public C2344c(Context context, String[] strArr, String[] strArr2, Handler handler) {
        this(context, strArr, strArr2, false);
        this.f8341f = handler;
    }

    public C2344c(Context context, String[] strArr, String[] strArr2, boolean z, Handler handler) {
        this(context, strArr, strArr2, z);
        this.f8341f = handler;
    }

    /* renamed from: a */
    public void m10266a() {
        Log.d("FreeSmsInviteSenderHelper", "Total invites requested :" + this.f8339d.length + "  Total no of http requests :" + this.f8340e);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= this.f8340e) {
                int length = i2 == this.f8340e ? this.f8339d.length - ((i2 - 1) * 20) : 20;
                String[] strArr = new String[length];
                String[] strArr2 = new String[length];
                System.arraycopy(this.f8338c, (i2 - 1) * 20, strArr, 0, length);
                System.arraycopy(this.f8339d, (i2 - 1) * 20, strArr2, 0, length);
                new C2342a(this.f8337b, strArr, strArr2, this.f8341f, this).m10265a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void m10267a(boolean z, int i, int i2) {
        this.f8342g++;
        if (z) {
            this.f8343h++;
        } else {
            this.f8344i += i;
            this.f8347l += i2;
        }
        Log.d("FreeSmsInviteSenderHelper", "HTTP Requests Processed :" + this.f8342g + " Requests Failed :" + this.f8343h + "  Total Invite Sent :" + this.f8344i);
        switch (m10269c()) {
            case 800:
            case 801:
                if (this.f8346k) {
                    m10268b();
                } else if (this.f8341f != null) {
                    Message messageObtainMessage = this.f8341f.obtainMessage();
                    messageObtainMessage.what = 100;
                    messageObtainMessage.arg1 = this.f8344i;
                    this.f8341f.sendMessage(messageObtainMessage);
                }
                if (this.f8340e > 1) {
                    this.f8345j = new C2097bc(this.f8336a);
                    this.f8345j.m9369a();
                    break;
                }
                break;
            case 802:
                Toast.makeText(CommonApplication.m18732r(), R.string.error_in_server_response, 0).show();
                break;
        }
    }

    /* renamed from: b */
    public void m10268b() {
        int iIntValue = C4809aa.m18104a().m18120a("free_sms_invitation_count", (Integer) (-1)).intValue();
        int iIntValue2 = C4809aa.m18104a().m18120a("free_sms_reward_base", (Integer) (-1)).intValue();
        if (this.f8347l <= 0) {
            if (C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) (-1)).intValue() >= 200) {
                Toast.makeText(CommonApplication.m18732r(), R.string.freesms_invitation_sent, 0).show();
                return;
            } else {
                Toast.makeText(CommonApplication.m18732r(), this.f8337b.getResources().getString(R.string.freesms_invitation_toast_msg02, Integer.valueOf(iIntValue % iIntValue2), Integer.valueOf(iIntValue2 - (iIntValue % iIntValue2))), 1).show();
                return;
            }
        }
        Toast.makeText(CommonApplication.m18732r(), this.f8337b.getResources().getString(R.string.freesms_invitation_toast_msg01, Integer.valueOf(this.f8347l)), 1).show();
    }

    /* renamed from: c */
    public int m10269c() {
        if (this.f8340e == this.f8342g) {
            if (this.f8343h == 0) {
                return 800;
            }
            if (this.f8343h == this.f8340e) {
                return 802;
            }
            if (this.f8343h < this.f8340e) {
                return 801;
            }
            Log.d("FreeSmsInviteSenderHelper", "Some error while processing the Send Invitation requests.. Please verify");
            return 0;
        }
        return 803;
    }
}
