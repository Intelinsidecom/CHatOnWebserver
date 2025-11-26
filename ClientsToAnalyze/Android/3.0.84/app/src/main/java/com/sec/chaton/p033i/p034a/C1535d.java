package com.sec.chaton.p033i.p034a;

import com.sec.common.util.log.collector.C3358h;

/* compiled from: LogMessageTestThread.java */
/* renamed from: com.sec.chaton.i.a.d */
/* loaded from: classes.dex */
public class C1535d extends Thread {

    /* renamed from: a */
    private static C1535d f5623a = null;

    /* renamed from: b */
    private static boolean f5624b = false;

    /* renamed from: a */
    public static void m6526a(boolean z) {
        f5624b = z;
    }

    /* renamed from: a */
    public static boolean m6527a() {
        return f5624b;
    }

    private C1535d() {
    }

    /* renamed from: b */
    public static C1535d m6528b() {
        if (f5623a == null) {
            f5623a = new C1535d();
        }
        return f5623a;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        super.run();
        while (f5624b) {
            try {
                C3358h.m11842a().m11846a("00030001");
                Thread.sleep(1000L);
            } catch (Exception e) {
            }
            if (f5624b) {
                C3358h.m11842a().m11846a("00030002");
                Thread.sleep(1000L);
                if (f5624b) {
                    C3358h.m11842a().m11846a("00030003");
                    Thread.sleep(1000L);
                    if (f5624b) {
                        C3358h.m11842a().m11846a("00030004");
                        Thread.sleep(1000L);
                        if (f5624b) {
                            C3358h.m11842a().m11846a("00030005");
                            Thread.sleep(1000L);
                            if (f5624b) {
                                C3358h.m11842a().m11846a("00030006");
                                Thread.sleep(1000L);
                                if (f5624b) {
                                    C3358h.m11842a().m11846a("00030007");
                                    Thread.sleep(1000L);
                                    if (f5624b) {
                                        C3358h.m11842a().m11846a("00030008");
                                        Thread.sleep(1000L);
                                        if (f5624b) {
                                            C3358h.m11842a().m11846a("00030009");
                                            Thread.sleep(1000L);
                                            if (f5624b) {
                                                C3358h.m11842a().m11846a("00030015");
                                                Thread.sleep(1000L);
                                                if (f5624b) {
                                                    C3358h.m11842a().m11846a("00030009");
                                                    Thread.sleep(1000L);
                                                    if (f5624b) {
                                                        C3358h.m11842a().m11846a("00030011");
                                                        Thread.sleep(1000L);
                                                        if (f5624b) {
                                                            C3358h.m11842a().m11846a("00030020");
                                                            Thread.sleep(1000L);
                                                            if (f5624b) {
                                                                C3358h.m11842a().m11846a("00050001");
                                                                Thread.sleep(1000L);
                                                                if (f5624b) {
                                                                    C1534c c1534c = new C1534c();
                                                                    c1534c.m11829d("00010002");
                                                                    c1534c.m6525a("1235786123468");
                                                                    C3358h.m11842a().m11845a(c1534c);
                                                                    Thread.sleep(1000L);
                                                                    if (f5624b) {
                                                                        C1534c c1534c2 = new C1534c();
                                                                        c1534c2.m11829d("00050011");
                                                                        c1534c2.m6525a("35135356123468");
                                                                        C3358h.m11842a().m11845a(c1534c2);
                                                                        Thread.sleep(1000L);
                                                                        if (f5624b) {
                                                                            C3358h.m11842a().m11846a("00060001");
                                                                            Thread.sleep(1000L);
                                                                            if (f5624b) {
                                                                                C3358h.m11842a().m11846a("00070001");
                                                                                Thread.sleep(1000L);
                                                                                if (f5624b) {
                                                                                    C3358h.m11842a().m11846a("00080001");
                                                                                    Thread.sleep(1000L);
                                                                                    if (f5624b) {
                                                                                        C3358h.m11842a().m11846a("00090001");
                                                                                        Thread.sleep(1000L);
                                                                                        if (f5624b) {
                                                                                            C3358h.m11842a().m11847a("00100003", "00000002");
                                                                                            Thread.sleep(1000L);
                                                                                            if (f5624b) {
                                                                                                C3358h.m11842a().m11847a("00100003", "00000001");
                                                                                                Thread.sleep(1000L);
                                                                                                if (f5624b) {
                                                                                                    C3358h.m11842a().m11847a("00100003", "00000003");
                                                                                                    Thread.sleep(1000L);
                                                                                                    if (f5624b) {
                                                                                                        C3358h.m11842a().m11847a("00100003", "00000004");
                                                                                                        Thread.sleep(1000L);
                                                                                                        if (f5624b) {
                                                                                                            C3358h.m11842a().m11847a("00100003", "00000005");
                                                                                                            Thread.sleep(1000L);
                                                                                                            if (f5624b) {
                                                                                                                C3358h.m11842a().m11847a("00100003", "00000006");
                                                                                                                Thread.sleep(1000L);
                                                                                                                if (f5624b) {
                                                                                                                    C3358h.m11842a().m11847a("00100013", "00000001");
                                                                                                                    Thread.sleep(1000L);
                                                                                                                    if (f5624b) {
                                                                                                                        C3358h.m11842a().m11847a("00100013", "00000002");
                                                                                                                        Thread.sleep(1000L);
                                                                                                                        if (f5624b) {
                                                                                                                            C3358h.m11842a().m11847a("00100013", "00000003");
                                                                                                                            Thread.sleep(1000L);
                                                                                                                            if (f5624b) {
                                                                                                                                C3358h.m11842a().m11847a("00100013", "00000004");
                                                                                                                                Thread.sleep(1000L);
                                                                                                                                if (f5624b) {
                                                                                                                                    C3358h.m11842a().m11847a("00100011", "00000001");
                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                    if (f5624b) {
                                                                                                                                        C3358h.m11842a().m11847a("00100011", "00000002");
                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                        if (f5624b) {
                                                                                                                                            C3358h.m11842a().m11847a("00100011", "00000001");
                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                            if (f5624b) {
                                                                                                                                                C3358h.m11842a().m11847a("00100011", "00000002");
                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                if (f5624b) {
                                                                                                                                                    C3358h.m11842a().m11847a("00100011", "00000003");
                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                    if (f5624b) {
                                                                                                                                                        C3358h.m11842a().m11847a("00100011", "00000004");
                                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                                        if (f5624b) {
                                                                                                                                                            C3358h.m11842a().m11847a("00100011", "00000005");
                                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                                            if (f5624b) {
                                                                                                                                                                C3358h.m11842a().m11847a("00100011", "00000006");
                                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                                if (f5624b) {
                                                                                                                                                                    C3358h.m11842a().m11847a("00030006", "00000001");
                                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                                    if (f5624b) {
                                                                                                                                                                        C3358h.m11842a().m11847a("00030006", "00000002");
                                                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                                                        if (f5624b) {
                                                                                                                                                                            C3358h.m11842a().m11846a("00090001");
                                                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                                                            if (f5624b) {
                                                                                                                                                                                C3358h.m11842a().m11846a("00060001");
                                                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                                                if (f5624b) {
                                                                                                                                                                                    C3358h.m11842a().m11846a("00070001");
                                                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                                                    if (f5624b) {
                                                                                                                                                                                        C3358h.m11842a().m11846a("00080001");
                                                                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                                                                        if (f5624b) {
                                                                                                                                                                                            C3358h.m11842a().m11846a("00090001");
                                                                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                                                                            if (f5624b) {
                                                                                                                                                                                                C1534c c1534c3 = new C1534c();
                                                                                                                                                                                                c1534c3.m11829d("00010002");
                                                                                                                                                                                                c1534c3.m6525a("1235786123468");
                                                                                                                                                                                                C3358h.m11842a().m11845a(c1534c3);
                                                                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                                                                if (f5624b) {
                                                                                                                                                                                                    C1534c c1534c4 = new C1534c();
                                                                                                                                                                                                    c1534c4.m11829d("00050011");
                                                                                                                                                                                                    c1534c4.m6525a("35135356123468");
                                                                                                                                                                                                    C3358h.m11842a().m11845a(c1534c4);
                                                                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                                                                    if (f5624b) {
                                                                                                                                                                                                        C3358h.m11842a().m11846a("00090001");
                                                                                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                                                                                        if (f5624b) {
                                                                                                                                                                                                            C1533b c1533b = new C1533b();
                                                                                                                                                                                                            c1533b.m11827c("01000011");
                                                                                                                                                                                                            c1533b.m11829d("00010204");
                                                                                                                                                                                                            c1533b.m6524a("CFS-11001");
                                                                                                                                                                                                            C3358h.m11842a().m11845a(c1533b);
                                                                                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                                                                                            if (f5624b) {
                                                                                                                                                                                                                C1533b c1533b2 = new C1533b();
                                                                                                                                                                                                                c1533b2.m11827c("01000002");
                                                                                                                                                                                                                c1533b2.m11829d("00010204");
                                                                                                                                                                                                                c1533b2.m6524a("CFS-11001");
                                                                                                                                                                                                                C3358h.m11842a().m11845a(c1533b2);
                                                                                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                                                                                if (f5624b) {
                                                                                                                                                                                                                    C1533b c1533b3 = new C1533b();
                                                                                                                                                                                                                    c1533b3.m11827c("01000004");
                                                                                                                                                                                                                    c1533b3.m11829d("01010401");
                                                                                                                                                                                                                    c1533b3.m6524a("CFS-11001");
                                                                                                                                                                                                                    C3358h.m11842a().m11845a(c1533b3);
                                                                                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                                                                                    if (f5624b) {
                                                                                                                                                                                                                        C1533b c1533b4 = new C1533b();
                                                                                                                                                                                                                        c1533b4.m11827c("01000016");
                                                                                                                                                                                                                        c1533b4.m11829d("00010404");
                                                                                                                                                                                                                        c1533b4.m6524a("CFS-11001");
                                                                                                                                                                                                                        C3358h.m11842a().m11845a(c1533b4);
                                                                                                                                                                                                                        Thread.sleep(1000L);
                                                                                                                                                                                                                        if (f5624b) {
                                                                                                                                                                                                                            C1532a c1532a = new C1532a();
                                                                                                                                                                                                                            c1532a.m6521a("\"java.lang.ArithmeticException: divide by zero\n\tat com.sec.chaton.msgbox.MsgboxFragment.onTabSelected(MsgboxFragment.java:1483)\n\tat com.sec.chaton.HomeTabFragment.onTabChanged(HomeTabFragment.java:219)\n\tat android.widget.TabHost.invokeOnTabChangeListener(TabHost.java:402)\n\tat android.widget.TabHost.setCurrentTab(TabHost.java:387)\n\tat android.widget.TabHost$2.onTabSelectionChanged(TabHost.java:150)\n\tat android.widget.TabWidget$TabClickListener.onClick(TabWidget.java:560)\n\tat android.view.View.performClick(View.java:4211)\n\tat android.view.View$PerformClick.run(View.java:17267)\n\tat android.os.Handler.handleCallback(Handler.java:615)\n\tat android.os.Handler.dispatchMessage(Handler.java:92)\n\tat android.os.Looper.loop(Looper.java:137)\n\tat android.app.ActivityThread.main(ActivityThread.java:4898)\n\tat java.lang.reflect.Method.invokeNative(Native Method)\n\tat java.lang.reflect.Method.invoke(Method.java:511)\n\tat com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1006)\n\tat com.android.internal.os.ZygoteInit.main(ZygoteInit.java:773)\n\tat dalvik.system.NativeStart.main(Native Method)\n\"");
                                                                                                                                                                                                                            C3358h.m11842a().m11845a(c1532a);
                                                                                                                                                                                                                            Thread.sleep(1000L);
                                                                                                                                                                                                                            if (f5624b) {
                                                                                                                                                                                                                                C1532a c1532a2 = new C1532a();
                                                                                                                                                                                                                                c1532a2.m6521a("\"java.lang.NullPointerException\n\tat com.sec.chaton.msgbox.MsgboxFragment.onTabSelected(MsgboxFragment.java:1483)\n\tat com.sec.chaton.HomeTabFragment.onTabChanged(HomeTabFragment.java:219)\n\tat android.widget.TabHost.invokeOnTabChangeListener(TabHost.java:402)\n\tat android.widget.TabHost.setCurrentTab(TabHost.java:387)\n\tat android.widget.TabHost$2.onTabSelectionChanged(TabHost.java:150)\n\tat android.widget.TabWidget$TabClickListener.onClick(TabWidget.java:560)\n\tat android.view.View.performClick(View.java:4211)\n\tat android.view.View$PerformClick.run(View.java:17267)\n\tat android.os.Handler.handleCallback(Handler.java:615)\n\tat android.os.Handler.dispatchMessage(Handler.java:92)\n\tat android.os.Looper.loop(Looper.java:137)\n\tat android.app.ActivityThread.main(ActivityThread.java:4898)\n\tat java.lang.reflect.Method.invokeNative(Native Method)\n\tat java.lang.reflect.Method.invoke(Method.java:511)\n\tat com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1006)\n\tat com.android.internal.os.ZygoteInit.main(ZygoteInit.java:773)\n\tat dalvik.system.NativeStart.main(Native Method)\n\"");
                                                                                                                                                                                                                                C3358h.m11842a().m11845a(c1532a2);
                                                                                                                                                                                                                                Thread.sleep(1000L);
                                                                                                                                                                                                                                if (f5624b) {
                                                                                                                                                                                                                                    Thread.sleep(1000L);
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                    return;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                return;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            return;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        return;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    return;
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                return;
                                                                                                                                                                                                            }
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            return;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        return;
                                                                                                                                                                                                    }
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    return;
                                                                                                                                                                                                }
                                                                                                                                                                                            } else {
                                                                                                                                                                                                return;
                                                                                                                                                                                            }
                                                                                                                                                                                        } else {
                                                                                                                                                                                            return;
                                                                                                                                                                                        }
                                                                                                                                                                                    } else {
                                                                                                                                                                                        return;
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                                return;
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                            return;
                                                                                                                                                                        }
                                                                                                                                                                    } else {
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                    return;
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                                return;
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        return;
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    return;
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            return;
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        return;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                return;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            return;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    return;
                                                                                                                }
                                                                                                            } else {
                                                                                                                return;
                                                                                                            }
                                                                                                        } else {
                                                                                                            return;
                                                                                                        }
                                                                                                    } else {
                                                                                                        return;
                                                                                                    }
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    return;
                                                                }
                                                            } else {
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
