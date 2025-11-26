package com.sec.chaton.control;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.task.AbstractNetTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Iterator;

/* renamed from: com.sec.chaton.control.m */
/* loaded from: classes.dex */
class HandlerC0184m extends Handler {

    /* renamed from: a */
    final /* synthetic */ MessageControl f1424a;

    HandlerC0184m(MessageControl messageControl) {
        this.f1424a = messageControl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        TaskContainerResultEntry taskContainerResultEntry = (TaskContainerResultEntry) message.obj;
        TaskContainer taskContainer = (TaskContainer) this.f1424a.f1376n.get(Long.valueOf(taskContainerResultEntry.m2092b()));
        if (taskContainer == null) {
            switch (message.what) {
                case 2:
                    MessageResultEntry messageResultEntry = (MessageResultEntry) taskContainerResultEntry.m2091a();
                    if (messageResultEntry.m1963a() == 3003) {
                        this.f1424a.m2050a(messageResultEntry.f1327c, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                        this.f1424a.m2056c(Long.MAX_VALUE);
                        ChatONLogWriter.m3506b("inboxNO : " + messageResultEntry.f1327c, getClass().getSimpleName());
                        this.f1424a.f1375m = true;
                        break;
                    }
                    break;
                case 6:
                    if (this.f1424a.f1375m) {
                        this.f1424a.m2058e();
                        this.f1424a.f1375m = false;
                    }
                    if (this.f1424a.f1378p.size() > 0) {
                        Iterator it = this.f1424a.f1378p.iterator();
                        while (it.hasNext()) {
                            TaskContainer taskContainer2 = (TaskContainer) this.f1424a.f1376n.get(Long.valueOf(((Long) it.next()).longValue()));
                            if (taskContainer2 != null) {
                                taskContainer2.m2088d();
                            }
                        }
                        this.f1424a.f1378p.clear();
                        break;
                    }
                    break;
                case 1026:
                    if (this.f1424a.f1375m) {
                        this.f1424a.m2058e();
                        this.f1424a.f1375m = false;
                    }
                    if (this.f1424a.f1378p.size() > 0) {
                        Iterator it2 = this.f1424a.f1378p.iterator();
                        while (it2.hasNext()) {
                            TaskContainer taskContainer3 = (TaskContainer) this.f1424a.f1376n.get(Long.valueOf(((Long) it2.next()).longValue()));
                            if (taskContainer3 != null) {
                                taskContainer3.m2088d();
                            }
                        }
                        this.f1424a.f1378p.clear();
                        break;
                    }
                    break;
                default:
                    this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                    break;
            }
        }
        switch (message.what) {
            case 0:
            case 12:
            case 18:
                MessageResultEntry messageResultEntry2 = (MessageResultEntry) taskContainerResultEntry.m2091a();
                if (messageResultEntry2.f1326b != ResultEntry.Result.NETWORKFAIL) {
                    if (!messageResultEntry2.f1325a) {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                        break;
                    } else if (!taskContainer.m2089e()) {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                        break;
                    } else {
                        taskContainer.m2088d();
                        break;
                    }
                } else {
                    AbstractNetTask abstractNetTask = (AbstractNetTask) taskContainer.m2087c();
                    if (abstractNetTask != null && abstractNetTask.m2111b()) {
                        taskContainer.m2088d();
                        break;
                    } else {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        break;
                    }
                }
                break;
            case 2:
                MessageResultEntry messageResultEntry3 = (MessageResultEntry) taskContainerResultEntry.m2091a();
                if (messageResultEntry3.m1963a() != 3003) {
                    if (messageResultEntry3.f1326b != ResultEntry.Result.NETWORKFAIL) {
                        if (!messageResultEntry3.f1325a) {
                            this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                            this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                            break;
                        } else if (!taskContainer.m2089e()) {
                            this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                            this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                            break;
                        } else {
                            taskContainer.m2088d();
                            break;
                        }
                    } else {
                        AbstractNetTask abstractNetTask2 = (AbstractNetTask) taskContainer.m2087c();
                        if (abstractNetTask2 != null && abstractNetTask2.m2111b()) {
                            taskContainer.m2088d();
                            break;
                        } else {
                            this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                            this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                            break;
                        }
                    }
                } else {
                    this.f1424a.m2050a(messageResultEntry3.f1327c, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    this.f1424a.m2056c(Long.MAX_VALUE);
                    ChatONLogWriter.m3506b("inboxNO : " + messageResultEntry3.f1327c, getClass().getSimpleName());
                    this.f1424a.f1375m = true;
                    if (!taskContainer.m2089e()) {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                        break;
                    } else {
                        this.f1424a.f1378p.add(Long.valueOf(taskContainerResultEntry.m2092b()));
                        Message messageObtain = Message.obtain();
                        messageObtain.arg1 = message.arg1;
                        messageObtain.arg2 = message.arg2;
                        messageObtain.what = 1026;
                        messageObtain.obj = new TaskContainerResultEntry(-1L, taskContainerResultEntry.m2093c(), taskContainerResultEntry.m2091a());
                        this.f1424a.f1379r.sendMessageDelayed(messageObtain, 5000L);
                        break;
                    }
                }
                break;
            case 4:
            case 1025:
                MessageResultEntry messageResultEntry4 = (MessageResultEntry) taskContainerResultEntry.m2091a();
                if (messageResultEntry4.f1326b != ResultEntry.Result.NETWORKFAIL) {
                    if (messageResultEntry4.m1963a() != 3003) {
                        if (messageResultEntry4.m1963a() != 10000) {
                            if (!messageResultEntry4.f1325a) {
                                this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                                this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                                break;
                            } else if (!taskContainer.m2089e()) {
                                this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                                this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                                break;
                            } else {
                                taskContainer.m2088d();
                                break;
                            }
                        } else {
                            this.f1424a.f1378p.add(Long.valueOf(taskContainerResultEntry.m2092b()));
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.arg1 = message.arg1;
                            messageObtain2.arg2 = message.arg2;
                            messageObtain2.what = 1026;
                            messageObtain2.obj = new TaskContainerResultEntry(-1L, taskContainerResultEntry.m2093c(), taskContainerResultEntry.m2091a());
                            this.f1424a.f1379r.sendMessageDelayed(messageObtain2, 5000L);
                            break;
                        }
                    } else {
                        this.f1424a.m2050a(messageResultEntry4.f1327c, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                        this.f1424a.m2056c(Long.MAX_VALUE);
                        this.f1424a.f1375m = true;
                        this.f1424a.f1378p.add(Long.valueOf(taskContainerResultEntry.m2092b()));
                        Message messageObtain3 = Message.obtain();
                        messageObtain3.arg1 = message.arg1;
                        messageObtain3.arg2 = message.arg2;
                        messageObtain3.what = 1026;
                        messageObtain3.obj = new TaskContainerResultEntry(-1L, taskContainerResultEntry.m2093c(), taskContainerResultEntry.m2091a());
                        this.f1424a.f1379r.sendMessageDelayed(messageObtain3, 5000L);
                        break;
                    }
                } else {
                    AbstractNetTask abstractNetTask3 = (AbstractNetTask) taskContainer.m2087c();
                    if (abstractNetTask3 != null && abstractNetTask3.m2111b()) {
                        taskContainer.m2088d();
                        break;
                    } else {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        break;
                    }
                }
                break;
            case 8:
                MessageResultEntry messageResultEntry5 = (MessageResultEntry) taskContainerResultEntry.m2091a();
                if (messageResultEntry5.f1326b != ResultEntry.Result.NETWORKFAIL) {
                    if (messageResultEntry5.m1963a() != 3003 && messageResultEntry5.m1963a() != 10000) {
                        if (!messageResultEntry5.f1325a) {
                            this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                            this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                            break;
                        } else if (!taskContainer.m2089e()) {
                            this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                            this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                            break;
                        } else {
                            taskContainer.m2088d();
                            break;
                        }
                    } else {
                        this.f1424a.f1378p.add(Long.valueOf(taskContainerResultEntry.m2092b()));
                        Message messageObtain4 = Message.obtain();
                        messageObtain4.arg1 = message.arg1;
                        messageObtain4.arg2 = message.arg2;
                        messageObtain4.what = 1026;
                        messageObtain4.obj = new TaskContainerResultEntry(-1L, taskContainerResultEntry.m2093c(), taskContainerResultEntry.m2091a());
                        this.f1424a.f1379r.sendMessageDelayed(messageObtain4, 5000L);
                        break;
                    }
                } else {
                    AbstractNetTask abstractNetTask4 = (AbstractNetTask) taskContainer.m2087c();
                    if (abstractNetTask4 != null && abstractNetTask4.m2111b()) {
                        taskContainer.m2088d();
                        break;
                    } else {
                        this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                        break;
                    }
                }
                break;
            case 801:
                HttpEntry httpEntry = (HttpEntry) taskContainerResultEntry.m2091a();
                if ((httpEntry.m1951b() == HttpResultCode.SUCCESS || httpEntry.m1951b() == HttpResultCode.NO_CONTENT) && taskContainer.m2089e()) {
                    taskContainer.m2088d();
                    break;
                }
                break;
            default:
                if (!taskContainer.m2089e()) {
                    this.f1424a.m2015a(message.arg1, message.arg2, message.what, taskContainerResultEntry.m2091a());
                    this.f1424a.f1376n.remove(Long.valueOf(taskContainerResultEntry.m2092b()));
                    break;
                } else {
                    taskContainer.m2088d();
                    break;
                }
        }
    }
}
