package com.sec.chaton.control;

import com.sec.chaton.control.TaskContainer;

/* loaded from: classes.dex */
public class TaskContainerResultEntry {

    /* renamed from: a */
    private Object f1399a;

    /* renamed from: b */
    private long f1400b;

    /* renamed from: c */
    private TaskContainer.TaskType f1401c;

    public TaskContainerResultEntry(long j, TaskContainer.TaskType taskType, Object obj) {
        this.f1400b = j;
        this.f1401c = taskType;
        this.f1399a = obj;
    }

    /* renamed from: a */
    public Object m2091a() {
        return this.f1399a;
    }

    /* renamed from: b */
    public long m2092b() {
        return this.f1400b;
    }

    /* renamed from: c */
    public TaskContainer.TaskType m2093c() {
        return this.f1401c;
    }
}
