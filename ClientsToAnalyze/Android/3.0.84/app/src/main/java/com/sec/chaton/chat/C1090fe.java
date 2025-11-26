package com.sec.chaton.chat;

import android.os.Handler;
import com.sec.chaton.p025d.p026a.C1186bn;
import com.sec.chaton.p035io.entry.ChatListInfoEntry;
import com.sec.chaton.p035io.p036a.C1537b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.provider.p049a.C2037a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: GetChatListInfo.java */
/* renamed from: com.sec.chaton.chat.fe */
/* loaded from: classes.dex */
public class C1090fe {

    /* renamed from: a */
    private Handler f4352a;

    /* renamed from: b */
    private long f4353b;

    public C1090fe(Handler handler, long j) {
        this.f4352a = handler;
        this.f4353b = j;
    }

    /* renamed from: a */
    public void m5375a() {
        String strM10979a = C3159aa.m10962a().m10979a("uid", "");
        String strM11045a = C3171am.m11045a();
        if (C3250y.f11733a) {
            C3250y.m11456e("UID : " + strM10979a + ", IMEI : " + strM11045a + ", lastUpdateTime : " + String.valueOf(this.f4353b), getClass().getSimpleName());
        }
        C2037a.m8127d();
        C1582j c1582jM6717b = new C1582j(EnumC3219cg.CONTACT, "/chat/broadcastinfoall").m6710a(EnumC1583k.GET).m6714a("uid", strM10979a).m6714a("imei", strM11045a).m6714a("lastupdatetime", String.valueOf(this.f4353b)).m6714a(RtspHeaders.Values.MODE, ChannelPipelineCoverage.ALL).m6709a(2301).m6712a(ChatListInfoEntry.class).m6717b(C1537b.class);
        if (this.f4353b == 0) {
            c1582jM6717b.m6714a("excludeexitchat", "true");
        }
        C1595w.m6742a().m6747d().m6723a(new C1186bn(this.f4352a, c1582jM6717b.m6708a()));
    }
}
