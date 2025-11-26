package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.control.task.AbstractNetTask;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.MessageIDGenerator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TaskContainer {

    /* renamed from: b */
    private Handler f1390b;

    /* renamed from: c */
    private Handler f1391c;

    /* renamed from: e */
    private TcpContext f1393e;

    /* renamed from: d */
    private int f1392d = 0;

    /* renamed from: a */
    private ArrayList f1389a = new ArrayList();

    /* renamed from: f */
    private long f1394f = MessageIDGenerator.m3598a();

    public enum TaskType {
        HttpTask(0),
        NetTask(1);


        /* renamed from: c */
        private int f1398c;

        TaskType(int i) {
            this.f1398c = i;
        }

        /* renamed from: a */
        public int m2090a() {
            return this.f1398c;
        }
    }

    public TaskContainer(Handler handler, TcpContext tcpContext) {
        this.f1391c = handler;
        this.f1393e = tcpContext;
        m2084a(new HandlerC0177f(this, null));
    }

    /* renamed from: a */
    public long m2083a() {
        return this.f1394f;
    }

    /* renamed from: a */
    public void m2084a(Handler handler) {
        this.f1390b = handler;
    }

    /* renamed from: a */
    public boolean m2085a(TaskType taskType, Object obj) {
        ChatONLogWriter.m3506b("AddTaskToList : " + String.valueOf(taskType.m2090a()), "TaskContainer");
        return this.f1389a.add(new C0211z(this, taskType, obj));
    }

    /* renamed from: b */
    public Handler m2086b() {
        return this.f1390b;
    }

    /* renamed from: c */
    public Object m2087c() {
        C0211z c0211z = (C0211z) this.f1389a.get(this.f1392d);
        if (c0211z == null) {
            return null;
        }
        return c0211z.m2166b();
    }

    /* renamed from: d */
    public boolean m2088d() {
        if (this.f1389a.size() == 0 || this.f1392d >= this.f1389a.size()) {
            return false;
        }
        C0211z c0211z = (C0211z) this.f1389a.get(this.f1392d);
        switch (C0208w.f1702a[c0211z.m2165a().ordinal()]) {
            case 1:
                HttpNetworkQueue.m2745a().offer((AbstractHttpTask2) c0211z.m2166b());
                return true;
            case 2:
                ((AbstractNetTask) c0211z.m2166b()).m2110a(this.f1393e);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public boolean m2089e() {
        this.f1392d++;
        return this.f1392d < this.f1389a.size();
    }
}
