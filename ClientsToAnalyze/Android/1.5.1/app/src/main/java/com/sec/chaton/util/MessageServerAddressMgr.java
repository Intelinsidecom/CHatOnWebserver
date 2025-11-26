package com.sec.chaton.util;

import android.os.Handler;
import android.os.Looper;
import com.sec.chaton.control.GLDControl;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class MessageServerAddressMgr {

    /* renamed from: a */
    private ServerAddressMgr.ServerType f3694a = ServerAddressMgr.ServerType.PRIMARY;

    /* renamed from: b */
    private ServerAddressInfo f3695b = new ServerAddressInfo(ServerAddressMgr.m3636e(), ServerAddressMgr.m3640g().intValue());

    public class ServerAddressInfo {

        /* renamed from: b */
        private String f3697b;

        /* renamed from: c */
        private int f3698c;

        public ServerAddressInfo(String str, int i) {
            this.f3697b = str;
            this.f3698c = i;
        }

        /* renamed from: a */
        public synchronized String m3603a() {
            return this.f3697b;
        }

        /* renamed from: a */
        public synchronized void m3604a(int i) {
            this.f3698c = i;
        }

        /* renamed from: a */
        public synchronized void m3605a(String str) {
            this.f3697b = str;
        }

        /* renamed from: b */
        public synchronized int m3606b() {
            return this.f3698c;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SERVER : ").append(this.f3697b).append("\n").append("PORT : ").append(Integer.toString(this.f3698c));
            return sb.toString();
        }
    }

    /* renamed from: c */
    private void m3599c() {
        switch (C0616n.f3787a[this.f3694a.ordinal()]) {
            case 1:
                this.f3695b.m3605a(ServerAddressMgr.m3639f());
                this.f3695b.m3604a(ServerAddressMgr.m3641h().intValue());
                this.f3694a = ServerAddressMgr.ServerType.SECONDARY;
                ChatONLogWriter.m3506b("change server PRIMARY --> SECONDARY :" + this.f3695b.toString(), getClass().getSimpleName());
                break;
            case 2:
                this.f3695b.m3605a(ServerAddressMgr.m3636e());
                this.f3695b.m3604a(ServerAddressMgr.m3640g().intValue());
                this.f3694a = ServerAddressMgr.ServerType.PRIMARY;
                ChatONLogWriter.m3506b("change server SECONDARY --> PRIMARY:" + this.f3695b.toString(), getClass().getSimpleName());
                new GLDControl(new Handler(Looper.getMainLooper())).m2000a();
                ChatONLogWriter.m3506b("request GLD", getClass().getSimpleName());
                break;
        }
    }

    /* renamed from: a */
    public void m3600a() {
        switch (C0616n.f3787a[this.f3694a.ordinal()]) {
            case 1:
                this.f3695b.m3605a(ServerAddressMgr.m3636e());
                this.f3695b.m3604a(ServerAddressMgr.m3640g().intValue());
                break;
            case 2:
                this.f3695b.m3605a(ServerAddressMgr.m3639f());
                this.f3695b.m3604a(ServerAddressMgr.m3641h().intValue());
                break;
        }
        ChatONLogWriter.m3506b("updateCurrentServer : " + this.f3695b.toString(), getClass().getSimpleName());
    }

    /* renamed from: a */
    public void m3601a(String str, int i) {
        ChatONLogWriter.m3506b("request to change the server( old info ) : " + this.f3695b.toString(), getClass().getSimpleName());
        if (str.equals(this.f3695b.m3603a()) && i == this.f3695b.m3606b()) {
            m3599c();
        }
    }

    /* renamed from: b */
    public ServerAddressInfo m3602b() {
        return this.f3695b;
    }
}
