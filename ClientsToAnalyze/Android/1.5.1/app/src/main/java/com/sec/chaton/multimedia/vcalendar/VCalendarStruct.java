package com.sec.chaton.multimedia.vcalendar;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VCalendarStruct {

    /* renamed from: a */
    public List f2235a;

    public class EventStruct {

        /* renamed from: a */
        public String f2236a;

        /* renamed from: b */
        public String f2237b;

        /* renamed from: c */
        public String f2238c;

        /* renamed from: d */
        public String f2239d;

        /* renamed from: e */
        public String f2240e;

        /* renamed from: f */
        public String f2241f;

        /* renamed from: g */
        public String f2242g;

        /* renamed from: h */
        public String f2243h;

        /* renamed from: i */
        public String f2244i;

        /* renamed from: j */
        public String f2245j;

        /* renamed from: k */
        public String f2246k;

        /* renamed from: l */
        public String f2247l;

        /* renamed from: m */
        public String f2248m;

        public class RemainderStruct {
        }
    }

    /* renamed from: a */
    public void m2601a(EventStruct eventStruct) {
        if (this.f2235a == null) {
            this.f2235a = new ArrayList();
        }
        this.f2235a.add(eventStruct);
    }
}
