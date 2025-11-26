package com.sec.chaton.control;

import com.sec.chaton.control.TaskContainer;

/* renamed from: com.sec.chaton.control.w */
/* loaded from: classes.dex */
/* synthetic */ class C0208w {

    /* renamed from: a */
    static final /* synthetic */ int[] f1702a = new int[TaskContainer.TaskType.values().length];

    static {
        try {
            f1702a[TaskContainer.TaskType.HttpTask.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1702a[TaskContainer.TaskType.NetTask.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
