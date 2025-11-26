package com.sec.chaton.util;

import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/* compiled from: HanziToPinyin.java */
/* renamed from: com.sec.chaton.util.at */
/* loaded from: classes.dex */
public class C3178at {

    /* renamed from: d */
    private static C3178at f11510d;

    /* renamed from: e */
    private final boolean f11514e;

    /* renamed from: a */
    public static final char[] f11507a = {21621, 21710, 23433, 32942, 20985, 20843, 25344, 25203, 37030, 21253, 21329, 22868, 20283, 23620, 36793, 26631, 24971, 37024, 27103, 30326, 23788, 22163, 23111, 39137, 20179, 25805, 20874, 23934, 22092, 21449, 38039, 36799, 20261, 25220, 36710, 25275, 26621, 21507, 20805, 25277, 20986, 27451, 25571, 24029, 30126, 21561, 26486, 36916, 30133, 21254, 20945, 31895, 27718, 23828, 37032, 25619, 21649, 22823, 30136, 24403, 20992, 28098, 24471, 25189, 28783, 27664, 22002, 30008, 20993, 29241, 20163, 19999, 19996, 21783, 22047, 20595, 22534, 37907, 22810, 23104, 35830, 22848, 38821, 32780, 21457, 24070, 26041, 39134, 20998, 20016, 35205, 20175, 32017, 20245, 26094, 35813, 29976, 20872, 30347, 25096, 32102, 26681, 24218, 24037, 21246, 20272, 29916, 32619, 20851, 20809, 24402, 34926, 21593, 21704, 21683, 39032, 33472, 33983, 35779, 40658, 25323, 20136, 22135, 21565, 40769, 21282, 33457, 24576, 29375, 24031, 28784, 26127, 21529, 19980, 21152, 25099, 27743, 33405, 38454, 24062, 21156, 20866, 21244, 21258, 23071, 22104, 20891, 21652, 24320, 21002, 38390, 23611, 21308, 21067, 32943, 38444, 31354, 25248, 21043, 22840, 33967, 23485, 21281, 20111, 22372, 25193, 22403, 26469, 20848, 21879, 25438, 20162, 21202, 22596, 21013, 20486, 22849, 33391, 25769, 21015, 25294, 12295, 28316, 40857, 30620, 22108, 23048, 30055, 25249, 32599, 21603, 22920, 38718, 23258, 37017, 29483, 40636, 27794, 38376, 30015, 21674, 30496, 21941, 21673, 27665, 21517, 35884, 25720, 21726, 27626, 25295, 23419, 22241, 22218, 23404, 35767, 39297, 24641, 33021, 22958, 25288, 23330, 40479, 25423, 24744, 23425, 22942, 20892, 32698, 22900, 22907, 34384, 25386, 21908, 35764, 36276, 25293, 30469, 20051, 25243, 21624, 21943, 21257, 19989, 20559, 21117, 27669, 23000, 20050, 38027, 21078, 20166, 19971, 25488, 21315, 21595, 24708, 30335, 20405, 38737, 37019, 19992, 26354, 24366, 32570, 22795, 21605, 31331, 23046, 24825, 20154, 25172, 26085, 33592, 21433, 22914, 22567, 26741, 38384, 33509, 20200, 27618, 19977, 26706, 25531, 33394, 26862, 20711, 26432, 31579, 23665, 20260, 24368, 22882, 30003, 21319, 23608, 21454, 20070, 21047, 25684, 38377, 21452, 35841, 21550, 22913, 21430, 24554, 25436, 33487, 29435, 22794, 23385, 21766, 20182, 33492, 22349, 38132, 22834, 24529, 29093, 21076, 22825, 20347, 24086, 21381, 22258, 20599, 37568, 28237, 25512, 21534, 25176, 25366, 27498, 24367, 23594, 21361, 22637, 32705, 25373, 20800, 22805, 34430, 20186, 20065, 28785, 20123, 24515, 26143, 20982, 20241, 26100, 36713, 30134, 21195, 20011, 24697, 22830, 24186, 32822, 19968, 27437, 24212, 21727, 20323, 20248, 25180, 40482, 26352, 26197, 21277, 28797, 31948, 29250, 20654, 21017, 36156, 24590, 22679, 21522, 25434, 27838, 24352, 38026, 34567, 36126, 20105, 20043, 20013, 24030, 26417, 25235, 36329, 19987, 22918, 38585, 23442, 21331, 23388, 23447, 37049, 31199, 38075, 21404, 23562, 26152};

    /* renamed from: b */
    public static final byte[][] f11508b = {new byte[]{65, 0, 0, 0, 0, 0}, new byte[]{65, 73, 0, 0, 0, 0}, new byte[]{65, 78, 0, 0, 0, 0}, new byte[]{65, 78, 71, 0, 0, 0}, new byte[]{65, 79, 0, 0, 0, 0}, new byte[]{66, 65, 0, 0, 0, 0}, new byte[]{66, 65, 73, 0, 0, 0}, new byte[]{66, 65, 78, 0, 0, 0}, new byte[]{66, 65, 78, 71, 0, 0}, new byte[]{66, 65, 79, 0, 0, 0}, new byte[]{66, 69, 73, 0, 0, 0}, new byte[]{66, 69, 78, 0, 0, 0}, new byte[]{66, 69, 78, 71, 0, 0}, new byte[]{66, 73, 0, 0, 0, 0}, new byte[]{66, 73, 65, 78, 0, 0}, new byte[]{66, 73, 65, 79, 0, 0}, new byte[]{66, 73, 69, 0, 0, 0}, new byte[]{66, 73, 78, 0, 0, 0}, new byte[]{66, 73, 78, 71, 0, 0}, new byte[]{66, 79, 0, 0, 0, 0}, new byte[]{66, 85, 0, 0, 0, 0}, new byte[]{67, 65, 0, 0, 0, 0}, new byte[]{67, 65, 73, 0, 0, 0}, new byte[]{67, 65, 78, 0, 0, 0}, new byte[]{67, 65, 78, 71, 0, 0}, new byte[]{67, 65, 79, 0, 0, 0}, new byte[]{67, 69, 0, 0, 0, 0}, new byte[]{67, 69, 78, 0, 0, 0}, new byte[]{67, 69, 78, 71, 0, 0}, new byte[]{67, 72, 65, 0, 0, 0}, new byte[]{67, 72, 65, 73, 0, 0}, new byte[]{67, 72, 65, 78, 0, 0}, new byte[]{67, 72, 65, 78, 71, 0}, new byte[]{67, 72, 65, 79, 0, 0}, new byte[]{67, 72, 69, 0, 0, 0}, new byte[]{67, 72, 69, 78, 0, 0}, new byte[]{67, 72, 69, 78, 71, 0}, new byte[]{67, 72, 73, 0, 0, 0}, new byte[]{67, 72, 79, 78, 71, 0}, new byte[]{67, 72, 79, 85, 0, 0}, new byte[]{67, 72, 85, 0, 0, 0}, new byte[]{67, 72, 85, 65, 0, 0}, new byte[]{67, 72, 85, 65, 73, 0}, new byte[]{67, 72, 85, 65, 78, 0}, new byte[]{67, 72, 85, 65, 78, 71}, new byte[]{67, 72, 85, 73, 0, 0}, new byte[]{67, 72, 85, 78, 0, 0}, new byte[]{67, 72, 85, 79, 0, 0}, new byte[]{67, 73, 0, 0, 0, 0}, new byte[]{67, 79, 78, 71, 0, 0}, new byte[]{67, 79, 85, 0, 0, 0}, new byte[]{67, 85, 0, 0, 0, 0}, new byte[]{67, 85, 65, 78, 0, 0}, new byte[]{67, 85, 73, 0, 0, 0}, new byte[]{67, 85, 78, 0, 0, 0}, new byte[]{67, 85, 79, 0, 0, 0}, new byte[]{68, 65, 0, 0, 0, 0}, new byte[]{68, 65, 73, 0, 0, 0}, new byte[]{68, 65, 78, 0, 0, 0}, new byte[]{68, 65, 78, 71, 0, 0}, new byte[]{68, 65, 79, 0, 0, 0}, new byte[]{68, 69, 0, 0, 0, 0}, new byte[]{68, 69, 73, 0, 0, 0}, new byte[]{68, 69, 78, 0, 0, 0}, new byte[]{68, 69, 78, 71, 0, 0}, new byte[]{68, 73, 0, 0, 0, 0}, new byte[]{68, 73, 65, 0, 0, 0}, new byte[]{68, 73, 65, 78, 0, 0}, new byte[]{68, 73, 65, 79, 0, 0}, new byte[]{68, 73, 69, 0, 0, 0}, new byte[]{68, 73, 78, 71, 0, 0}, new byte[]{68, 73, 85, 0, 0, 0}, new byte[]{68, 79, 78, 71, 0, 0}, new byte[]{68, 79, 85, 0, 0, 0}, new byte[]{68, 85, 0, 0, 0, 0}, new byte[]{68, 85, 65, 78, 0, 0}, new byte[]{68, 85, 73, 0, 0, 0}, new byte[]{68, 85, 78, 0, 0, 0}, new byte[]{68, 85, 79, 0, 0, 0}, new byte[]{69, 0, 0, 0, 0, 0}, new byte[]{69, 73, 0, 0, 0, 0}, new byte[]{69, 78, 0, 0, 0, 0}, new byte[]{69, 78, 71, 0, 0, 0}, new byte[]{69, 82, 0, 0, 0, 0}, new byte[]{70, 65, 0, 0, 0, 0}, new byte[]{70, 65, 78, 0, 0, 0}, new byte[]{70, 65, 78, 71, 0, 0}, new byte[]{70, 69, 73, 0, 0, 0}, new byte[]{70, 69, 78, 0, 0, 0}, new byte[]{70, 69, 78, 71, 0, 0}, new byte[]{70, 73, 65, 79, 0, 0}, new byte[]{70, 79, 0, 0, 0, 0}, new byte[]{70, 79, 85, 0, 0, 0}, new byte[]{70, 85, 0, 0, 0, 0}, new byte[]{71, 65, 0, 0, 0, 0}, new byte[]{71, 65, 73, 0, 0, 0}, new byte[]{71, 65, 78, 0, 0, 0}, new byte[]{71, 65, 78, 71, 0, 0}, new byte[]{71, 65, 79, 0, 0, 0}, new byte[]{71, 69, 0, 0, 0, 0}, new byte[]{71, 69, 73, 0, 0, 0}, new byte[]{71, 69, 78, 0, 0, 0}, new byte[]{71, 69, 78, 71, 0, 0}, new byte[]{71, 79, 78, 71, 0, 0}, new byte[]{71, 79, 85, 0, 0, 0}, new byte[]{71, 85, 0, 0, 0, 0}, new byte[]{71, 85, 65, 0, 0, 0}, new byte[]{71, 85, 65, 73, 0, 0}, new byte[]{71, 85, 65, 78, 0, 0}, new byte[]{71, 85, 65, 78, 71, 0}, new byte[]{71, 85, 73, 0, 0, 0}, new byte[]{71, 85, 78, 0, 0, 0}, new byte[]{71, 85, 79, 0, 0, 0}, new byte[]{72, 65, 0, 0, 0, 0}, new byte[]{72, 65, 73, 0, 0, 0}, new byte[]{72, 65, 78, 0, 0, 0}, new byte[]{72, 65, 78, 71, 0, 0}, new byte[]{72, 65, 79, 0, 0, 0}, new byte[]{72, 69, 0, 0, 0, 0}, new byte[]{72, 69, 73, 0, 0, 0}, new byte[]{72, 69, 78, 0, 0, 0}, new byte[]{72, 69, 78, 71, 0, 0}, new byte[]{72, 77, 0, 0, 0, 0}, new byte[]{72, 79, 78, 71, 0, 0}, new byte[]{72, 79, 85, 0, 0, 0}, new byte[]{72, 85, 0, 0, 0, 0}, new byte[]{72, 85, 65, 0, 0, 0}, new byte[]{72, 85, 65, 73, 0, 0}, new byte[]{72, 85, 65, 78, 0, 0}, new byte[]{72, 85, 65, 78, 71, 0}, new byte[]{72, 85, 73, 0, 0, 0}, new byte[]{72, 85, 78, 0, 0, 0}, new byte[]{72, 85, 79, 0, 0, 0}, new byte[]{74, 73, 0, 0, 0, 0}, new byte[]{74, 73, 65, 0, 0, 0}, new byte[]{74, 73, 65, 78, 0, 0}, new byte[]{74, 73, 65, 78, 71, 0}, new byte[]{74, 73, 65, 79, 0, 0}, new byte[]{74, 73, 69, 0, 0, 0}, new byte[]{74, 73, 78, 0, 0, 0}, new byte[]{74, 73, 78, 71, 0, 0}, new byte[]{74, 73, 79, 78, 71, 0}, new byte[]{74, 73, 85, 0, 0, 0}, new byte[]{74, 85, 0, 0, 0, 0}, new byte[]{74, 85, 65, 78, 0, 0}, new byte[]{74, 85, 69, 0, 0, 0}, new byte[]{74, 85, 78, 0, 0, 0}, new byte[]{75, 65, 0, 0, 0, 0}, new byte[]{75, 65, 73, 0, 0, 0}, new byte[]{75, 65, 78, 0, 0, 0}, new byte[]{75, 65, 78, 71, 0, 0}, new byte[]{75, 65, 79, 0, 0, 0}, new byte[]{75, 69, 0, 0, 0, 0}, new byte[]{75, 69, 73, 0, 0, 0}, new byte[]{75, 69, 78, 0, 0, 0}, new byte[]{75, 69, 78, 71, 0, 0}, new byte[]{75, 79, 78, 71, 0, 0}, new byte[]{75, 79, 85, 0, 0, 0}, new byte[]{75, 85, 0, 0, 0, 0}, new byte[]{75, 85, 65, 0, 0, 0}, new byte[]{75, 85, 65, 73, 0, 0}, new byte[]{75, 85, 65, 78, 0, 0}, new byte[]{75, 85, 65, 78, 71, 0}, new byte[]{75, 85, 73, 0, 0, 0}, new byte[]{75, 85, 78, 0, 0, 0}, new byte[]{75, 85, 79, 0, 0, 0}, new byte[]{76, 65, 0, 0, 0, 0}, new byte[]{76, 65, 73, 0, 0, 0}, new byte[]{76, 65, 78, 0, 0, 0}, new byte[]{76, 65, 78, 71, 0, 0}, new byte[]{76, 65, 79, 0, 0, 0}, new byte[]{76, 69, 0, 0, 0, 0}, new byte[]{76, 69, 73, 0, 0, 0}, new byte[]{76, 69, 78, 71, 0, 0}, new byte[]{76, 73, 0, 0, 0, 0}, new byte[]{76, 73, 65, 0, 0, 0}, new byte[]{76, 73, 65, 78, 0, 0}, new byte[]{76, 73, 65, 78, 71, 0}, new byte[]{76, 73, 65, 79, 0, 0}, new byte[]{76, 73, 69, 0, 0, 0}, new byte[]{76, 73, 78, 0, 0, 0}, new byte[]{76, 73, 78, 71, 0, 0}, new byte[]{76, 73, 85, 0, 0, 0}, new byte[]{76, 79, 78, 71, 0, 0}, new byte[]{76, 79, 85, 0, 0, 0}, new byte[]{76, 85, 0, 0, 0, 0}, new byte[]{76, 85, 65, 78, 0, 0}, new byte[]{76, 85, 69, 0, 0, 0}, new byte[]{76, 85, 78, 0, 0, 0}, new byte[]{76, 85, 79, 0, 0, 0}, new byte[]{77, 0, 0, 0, 0, 0}, new byte[]{77, 65, 0, 0, 0, 0}, new byte[]{77, 65, 73, 0, 0, 0}, new byte[]{77, 65, 78, 0, 0, 0}, new byte[]{77, 65, 78, 71, 0, 0}, new byte[]{77, 65, 79, 0, 0, 0}, new byte[]{77, 69, 0, 0, 0, 0}, new byte[]{77, 69, 73, 0, 0, 0}, new byte[]{77, 69, 78, 0, 0, 0}, new byte[]{77, 69, 78, 71, 0, 0}, new byte[]{77, 73, 0, 0, 0, 0}, new byte[]{77, 73, 65, 78, 0, 0}, new byte[]{77, 73, 65, 79, 0, 0}, new byte[]{77, 73, 69, 0, 0, 0}, new byte[]{77, 73, 78, 0, 0, 0}, new byte[]{77, 73, 78, 71, 0, 0}, new byte[]{77, 73, 85, 0, 0, 0}, new byte[]{77, 79, 0, 0, 0, 0}, new byte[]{77, 79, 85, 0, 0, 0}, new byte[]{77, 85, 0, 0, 0, 0}, new byte[]{78, 65, 0, 0, 0, 0}, new byte[]{78, 65, 73, 0, 0, 0}, new byte[]{78, 65, 78, 0, 0, 0}, new byte[]{78, 65, 78, 71, 0, 0}, new byte[]{78, 65, 79, 0, 0, 0}, new byte[]{78, 69, 0, 0, 0, 0}, new byte[]{78, 69, 73, 0, 0, 0}, new byte[]{78, 69, 78, 0, 0, 0}, new byte[]{78, 69, 78, 71, 0, 0}, new byte[]{78, 73, 0, 0, 0, 0}, new byte[]{78, 73, 65, 78, 0, 0}, new byte[]{78, 73, 65, 78, 71, 0}, new byte[]{78, 73, 65, 79, 0, 0}, new byte[]{78, 73, 69, 0, 0, 0}, new byte[]{78, 73, 78, 0, 0, 0}, new byte[]{78, 73, 78, 71, 0, 0}, new byte[]{78, 73, 85, 0, 0, 0}, new byte[]{78, 79, 78, 71, 0, 0}, new byte[]{78, 79, 85, 0, 0, 0}, new byte[]{78, 85, 0, 0, 0, 0}, new byte[]{78, 85, 65, 78, 0, 0}, new byte[]{78, 85, 69, 0, 0, 0}, new byte[]{78, 85, 79, 0, 0, 0}, new byte[]{79, 0, 0, 0, 0, 0}, new byte[]{79, 85, 0, 0, 0, 0}, new byte[]{80, 65, 0, 0, 0, 0}, new byte[]{80, 65, 73, 0, 0, 0}, new byte[]{80, 65, 78, 0, 0, 0}, new byte[]{80, 65, 78, 71, 0, 0}, new byte[]{80, 65, 79, 0, 0, 0}, new byte[]{80, 69, 73, 0, 0, 0}, new byte[]{80, 69, 78, 0, 0, 0}, new byte[]{80, 69, 78, 71, 0, 0}, new byte[]{80, 73, 0, 0, 0, 0}, new byte[]{80, 73, 65, 78, 0, 0}, new byte[]{80, 73, 65, 79, 0, 0}, new byte[]{80, 73, 69, 0, 0, 0}, new byte[]{80, 73, 78, 0, 0, 0}, new byte[]{80, 73, 78, 71, 0, 0}, new byte[]{80, 79, 0, 0, 0, 0}, new byte[]{80, 79, 85, 0, 0, 0}, new byte[]{80, 85, 0, 0, 0, 0}, new byte[]{81, 73, 0, 0, 0, 0}, new byte[]{81, 73, 65, 0, 0, 0}, new byte[]{81, 73, 65, 78, 0, 0}, new byte[]{81, 73, 65, 78, 71, 0}, new byte[]{81, 73, 65, 79, 0, 0}, new byte[]{81, 73, 69, 0, 0, 0}, new byte[]{81, 73, 78, 0, 0, 0}, new byte[]{81, 73, 78, 71, 0, 0}, new byte[]{81, 73, 79, 78, 71, 0}, new byte[]{81, 73, 85, 0, 0, 0}, new byte[]{81, 85, 0, 0, 0, 0}, new byte[]{81, 85, 65, 78, 0, 0}, new byte[]{81, 85, 69, 0, 0, 0}, new byte[]{81, 85, 78, 0, 0, 0}, new byte[]{82, 65, 78, 0, 0, 0}, new byte[]{82, 65, 78, 71, 0, 0}, new byte[]{82, 65, 79, 0, 0, 0}, new byte[]{82, 69, 0, 0, 0, 0}, new byte[]{82, 69, 78, 0, 0, 0}, new byte[]{82, 69, 78, 71, 0, 0}, new byte[]{82, 73, 0, 0, 0, 0}, new byte[]{82, 79, 78, 71, 0, 0}, new byte[]{82, 79, 85, 0, 0, 0}, new byte[]{82, 85, 0, 0, 0, 0}, new byte[]{82, 85, 65, 78, 0, 0}, new byte[]{82, 85, 73, 0, 0, 0}, new byte[]{82, 85, 78, 0, 0, 0}, new byte[]{82, 85, 79, 0, 0, 0}, new byte[]{83, 65, 0, 0, 0, 0}, new byte[]{83, 65, 73, 0, 0, 0}, new byte[]{83, 65, 78, 0, 0, 0}, new byte[]{83, 65, 78, 71, 0, 0}, new byte[]{83, 65, 79, 0, 0, 0}, new byte[]{83, 69, 0, 0, 0, 0}, new byte[]{83, 69, 78, 0, 0, 0}, new byte[]{83, 69, 78, 71, 0, 0}, new byte[]{83, 72, 65, 0, 0, 0}, new byte[]{83, 72, 65, 73, 0, 0}, new byte[]{83, 72, 65, 78, 0, 0}, new byte[]{83, 72, 65, 78, 71, 0}, new byte[]{83, 72, 65, 79, 0, 0}, new byte[]{83, 72, 69, 0, 0, 0}, new byte[]{83, 72, 69, 78, 0, 0}, new byte[]{83, 72, 69, 78, 71, 0}, new byte[]{83, 72, 73, 0, 0, 0}, new byte[]{83, 72, 79, 85, 0, 0}, new byte[]{83, 72, 85, 0, 0, 0}, new byte[]{83, 72, 85, 65, 0, 0}, new byte[]{83, 72, 85, 65, 73, 0}, new byte[]{83, 72, 85, 65, 78, 0}, new byte[]{83, 72, 85, 65, 78, 71}, new byte[]{83, 72, 85, 73, 0, 0}, new byte[]{83, 72, 85, 78, 0, 0}, new byte[]{83, 72, 85, 79, 0, 0}, new byte[]{83, 73, 0, 0, 0, 0}, new byte[]{83, 79, 78, 71, 0, 0}, new byte[]{83, 79, 85, 0, 0, 0}, new byte[]{83, 85, 0, 0, 0, 0}, new byte[]{83, 85, 65, 78, 0, 0}, new byte[]{83, 85, 73, 0, 0, 0}, new byte[]{83, 85, 78, 0, 0, 0}, new byte[]{83, 85, 79, 0, 0, 0}, new byte[]{84, 65, 0, 0, 0, 0}, new byte[]{84, 65, 73, 0, 0, 0}, new byte[]{84, 65, 78, 0, 0, 0}, new byte[]{84, 65, 78, 71, 0, 0}, new byte[]{84, 65, 79, 0, 0, 0}, new byte[]{84, 69, 0, 0, 0, 0}, new byte[]{84, 69, 78, 71, 0, 0}, new byte[]{84, 73, 0, 0, 0, 0}, new byte[]{84, 73, 65, 78, 0, 0}, new byte[]{84, 73, 65, 79, 0, 0}, new byte[]{84, 73, 69, 0, 0, 0}, new byte[]{84, 73, 78, 71, 0, 0}, new byte[]{84, 79, 78, 71, 0, 0}, new byte[]{84, 79, 85, 0, 0, 0}, new byte[]{84, 85, 0, 0, 0, 0}, new byte[]{84, 85, 65, 78, 0, 0}, new byte[]{84, 85, 73, 0, 0, 0}, new byte[]{84, 85, 78, 0, 0, 0}, new byte[]{84, 85, 79, 0, 0, 0}, new byte[]{87, 65, 0, 0, 0, 0}, new byte[]{87, 65, 73, 0, 0, 0}, new byte[]{87, 65, 78, 0, 0, 0}, new byte[]{87, 65, 78, 71, 0, 0}, new byte[]{87, 69, 73, 0, 0, 0}, new byte[]{87, 69, 78, 0, 0, 0}, new byte[]{87, 69, 78, 71, 0, 0}, new byte[]{87, 79, 0, 0, 0, 0}, new byte[]{87, 85, 0, 0, 0, 0}, new byte[]{88, 73, 0, 0, 0, 0}, new byte[]{88, 73, 65, 0, 0, 0}, new byte[]{88, 73, 65, 78, 0, 0}, new byte[]{88, 73, 65, 78, 71, 0}, new byte[]{88, 73, 65, 79, 0, 0}, new byte[]{88, 73, 69, 0, 0, 0}, new byte[]{88, 73, 78, 0, 0, 0}, new byte[]{88, 73, 78, 71, 0, 0}, new byte[]{88, 73, 79, 78, 71, 0}, new byte[]{88, 73, 85, 0, 0, 0}, new byte[]{88, 85, 0, 0, 0, 0}, new byte[]{88, 85, 65, 78, 0, 0}, new byte[]{88, 85, 69, 0, 0, 0}, new byte[]{88, 85, 78, 0, 0, 0}, new byte[]{89, 65, 0, 0, 0, 0}, new byte[]{89, 65, 78, 0, 0, 0}, new byte[]{89, 65, 78, 71, 0, 0}, new byte[]{89, 65, 79, 0, 0, 0}, new byte[]{89, 69, 0, 0, 0, 0}, new byte[]{89, 73, 0, 0, 0, 0}, new byte[]{89, 73, 78, 0, 0, 0}, new byte[]{89, 73, 78, 71, 0, 0}, new byte[]{89, 79, 0, 0, 0, 0}, new byte[]{89, 79, 78, 71, 0, 0}, new byte[]{89, 79, 85, 0, 0, 0}, new byte[]{89, 85, 0, 0, 0, 0}, new byte[]{89, 85, 65, 78, 0, 0}, new byte[]{89, 85, 69, 0, 0, 0}, new byte[]{89, 85, 78, 0, 0, 0}, new byte[]{90, 65, 0, 0, 0, 0}, new byte[]{90, 65, 73, 0, 0, 0}, new byte[]{90, 65, 78, 0, 0, 0}, new byte[]{90, 65, 78, 71, 0, 0}, new byte[]{90, 65, 79, 0, 0, 0}, new byte[]{90, 69, 0, 0, 0, 0}, new byte[]{90, 69, 73, 0, 0, 0}, new byte[]{90, 69, 78, 0, 0, 0}, new byte[]{90, 69, 78, 71, 0, 0}, new byte[]{90, 72, 65, 0, 0, 0}, new byte[]{90, 72, 65, 73, 0, 0}, new byte[]{90, 72, 65, 78, 0, 0}, new byte[]{90, 72, 65, 78, 71, 0}, new byte[]{90, 72, 65, 79, 0, 0}, new byte[]{90, 72, 69, 0, 0, 0}, new byte[]{90, 72, 69, 78, 0, 0}, new byte[]{90, 72, 69, 78, 71, 0}, new byte[]{90, 72, 73, 0, 0, 0}, new byte[]{90, 72, 79, 78, 71, 0}, new byte[]{90, 72, 79, 85, 0, 0}, new byte[]{90, 72, 85, 0, 0, 0}, new byte[]{90, 72, 85, 65, 0, 0}, new byte[]{90, 72, 85, 65, 73, 0}, new byte[]{90, 72, 85, 65, 78, 0}, new byte[]{90, 72, 85, 65, 78, 71}, new byte[]{90, 72, 85, 73, 0, 0}, new byte[]{90, 72, 85, 78, 0, 0}, new byte[]{90, 72, 85, 79, 0, 0}, new byte[]{90, 73, 0, 0, 0, 0}, new byte[]{90, 79, 78, 71, 0, 0}, new byte[]{90, 79, 85, 0, 0, 0}, new byte[]{90, 85, 0, 0, 0, 0}, new byte[]{90, 85, 65, 78, 0, 0}, new byte[]{90, 85, 73, 0, 0, 0}, new byte[]{90, 85, 78, 0, 0, 0}, new byte[]{90, 85, 79, 0, 0, 0}};

    /* renamed from: c */
    private static final Collator f11509c = Collator.getInstance(Locale.CHINA);

    /* renamed from: f */
    private static int f11511f = -1;

    /* renamed from: g */
    private static int f11512g = -1;

    /* renamed from: h */
    private static int f11513h = -1;

    protected C3178at(boolean z) {
        this.f11514e = z;
    }

    /* renamed from: a */
    public static C3178at m11103a() {
        C3178at c3178at;
        int i = 0;
        synchronized (C3178at.class) {
            if (f11510d != null) {
                c3178at = f11510d;
            } else {
                Locale[] availableLocales = Collator.getAvailableLocales();
                while (true) {
                    if (i < availableLocales.length) {
                        if (!availableLocales[i].equals(Locale.CHINA)) {
                            i++;
                        } else {
                            f11510d = new C3178at(true);
                            c3178at = f11510d;
                            break;
                        }
                    } else {
                        C3250y.m11455d("There is no Chinese collator, HanziToPinyin is disabled", "HanziToPinyin");
                        f11510d = new C3178at(false);
                        c3178at = f11510d;
                        break;
                    }
                }
            }
        }
        return c3178at;
    }

    /* renamed from: a */
    private C3180av m11105a(char c) {
        int i;
        int i2;
        C3180av c3180av = new C3180av();
        String string = Character.toString(c);
        c3180av.f11518b = string;
        int length = -1;
        if (c < 256) {
            c3180av.f11517a = 1;
            c3180av.f11519c = string;
            return c3180av;
        }
        if (c < 13312) {
            c3180av.f11517a = 3;
            c3180av.f11519c = string;
            return c3180av;
        }
        int iCompare = f11509c.compare(string, "阿");
        if (iCompare < 0) {
            c3180av.f11517a = 3;
            c3180av.f11519c = string;
            return c3180av;
        }
        if (iCompare == 0) {
            c3180av.f11517a = 2;
            length = 0;
        } else {
            iCompare = f11509c.compare(string, "蓙");
            if (iCompare > 0) {
                c3180av.f11517a = 3;
                c3180av.f11519c = string;
                return c3180av;
            }
            if (iCompare == 0) {
                c3180av.f11517a = 2;
                length = f11507a.length - 1;
            }
        }
        c3180av.f11517a = 2;
        if (length < 0) {
            int i3 = length;
            int i4 = 0;
            int i5 = iCompare;
            int length2 = f11507a.length - 1;
            int iCompare2 = i5;
            while (true) {
                if (i4 > length2) {
                    i2 = iCompare2;
                    i = i3;
                    break;
                }
                i3 = (i4 + length2) / 2;
                iCompare2 = f11509c.compare(string, Character.toString(f11507a[i3]));
                if (iCompare2 == 0) {
                    i2 = iCompare2;
                    i = i3;
                    break;
                }
                if (iCompare2 > 0) {
                    i4 = i3 + 1;
                } else {
                    length2 = i3 - 1;
                }
            }
        } else {
            int i6 = iCompare;
            i = length;
            i2 = i6;
        }
        if (i2 < 0) {
            i--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < f11508b[i].length && f11508b[i][i7] != 0; i7++) {
            sb.append((char) f11508b[i][i7]);
        }
        c3180av.f11519c = sb.toString();
        return c3180av;
    }

    /* renamed from: a */
    public ArrayList<C3180av> m11117a(String str) {
        ArrayList<C3180av> arrayList = new ArrayList<>();
        if (!this.f11514e || TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                if (sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
            } else if (cCharAt < 256) {
                if (i != 1 && sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
                sb.append(cCharAt);
                i = 1;
            } else if (cCharAt < 13312) {
                if (i != 3 && sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
                sb.append(cCharAt);
                i = 3;
            } else {
                C3180av c3180avM11105a = m11105a(cCharAt);
                if (c3180avM11105a.f11517a == 2) {
                    if (sb.length() > 0) {
                        m11108a(sb, arrayList, i);
                    }
                    arrayList.add(c3180avM11105a);
                    i = 2;
                } else {
                    if (i != c3180avM11105a.f11517a && sb.length() > 0) {
                        m11108a(sb, arrayList, i);
                    }
                    i = c3180avM11105a.f11517a;
                    sb.append(cCharAt);
                }
            }
        }
        if (sb.length() > 0) {
            m11108a(sb, arrayList, i);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m11108a(StringBuilder sb, ArrayList<C3180av> arrayList, int i) {
        String string = sb.toString();
        arrayList.add(new C3180av(i, string, string));
        sb.setLength(0);
    }

    /* renamed from: a */
    public static void m11107a(String str, String str2) {
        try {
            C1360d.m6038b(GlobalApplication.m11493l().getContentResolver(), str, str2);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static int m11110b() {
        return f11511f;
    }

    /* renamed from: c */
    public static int m11114c() {
        return f11512g;
    }

    /* renamed from: d */
    public static int m11115d() {
        return f11513h;
    }

    /* renamed from: e */
    public static void m11116e() {
        f11511f = -1;
        f11512g = -1;
        f11513h = -1;
    }

    /* renamed from: a */
    private static C3179au m11104a(ArrayList<C3180av> arrayList, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return new C3179au(-1, "");
        }
        String lowerCase = str.toLowerCase();
        while (i < arrayList.size()) {
            String strM11112b = m11112b(arrayList.get(i).f11519c.toLowerCase(), lowerCase);
            if (strM11112b == null) {
                i++;
            } else {
                return new C3179au(i, strM11112b);
            }
        }
        return new C3179au(-1, "");
    }

    /* renamed from: a */
    private static int m11102a(ArrayList<C3180av> arrayList) {
        if (0 >= arrayList.size() || !arrayList.get(0).f11519c.toLowerCase().equals(arrayList.get(0).f11518b.toLowerCase())) {
            return 0;
        }
        return arrayList.get(0).f11518b.length() + 0;
    }

    /* renamed from: a */
    public static void m11109a(ArrayList<C3180av> arrayList, String str) {
        int i;
        String strReplaceFirst;
        if (str != "") {
            ArrayList<C3180av> arrayListM11117a = m11103a().m11117a(str);
            String str2 = "";
            for (int i2 = 0; i2 < arrayListM11117a.size(); i2++) {
                str2 = str2 + arrayListM11117a.get(i2).f11519c.toLowerCase();
            }
            String str3 = "";
            int i3 = 0;
            while (i3 < arrayList.size()) {
                String str4 = str3 + arrayList.get(i3).f11519c;
                i3++;
                str3 = str4;
            }
            if (str3.toLowerCase().contains(str2)) {
                i = 0;
                loop2: while (i < arrayList.size()) {
                    for (int i4 = 0; i4 < str2.length(); i4++) {
                        if (arrayList.get(i).f11519c.toLowerCase().equals(str2.substring(0, i4))) {
                            break loop2;
                        }
                    }
                    i++;
                }
                i = 0;
            } else {
                i = 0;
            }
            String lowerCase = str2.toLowerCase();
            if (m11113b(arrayList, lowerCase)) {
                String str5 = "";
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    str5 = str5 + arrayList.get(i5).f11519c;
                }
                f11513h = m11111b(str5);
                return;
            }
            int iM11102a = m11102a(arrayList);
            String str6 = "";
            int i6 = 0;
            while (i6 < arrayList.size()) {
                String str7 = str6 + arrayList.get(i6).f11518b;
                i6++;
                str6 = str7;
            }
            ArrayList<C3180av> arrayListM11117a2 = m11103a().m11117a(str6.substring(iM11102a));
            f11513h = iM11102a;
            int i7 = i;
            for (String str8 = lowerCase; i7 < arrayListM11117a2.size() && !TextUtils.isEmpty(str8); str8 = strReplaceFirst) {
                if (arrayListM11117a2.get(i7).f11519c.length() >= str8.length()) {
                    C3179au c3179auM11104a = m11104a(arrayListM11117a2, i7, str8);
                    if (c3179auM11104a.f11515a != -1) {
                        strReplaceFirst = c3179auM11104a.f11516b;
                        if (f11511f == -1) {
                            f11511f = c3179auM11104a.f11515a;
                            f11512g = c3179auM11104a.f11515a;
                        } else {
                            if (c3179auM11104a.f11515a - f11512g != 1) {
                                f11511f = -1;
                                f11512g = -1;
                                return;
                            }
                            f11512g = c3179auM11104a.f11515a;
                        }
                    } else {
                        strReplaceFirst = str8;
                    }
                    if (c3179auM11104a.f11515a == -1 && !strReplaceFirst.substring(0, 1).equals(" ")) {
                        f11511f = -1;
                        f11512g = -1;
                        return;
                    } else if (i7 == arrayListM11117a2.size() - 1 && !strReplaceFirst.equals("")) {
                        f11511f = -1;
                        f11512g = -1;
                        return;
                    }
                } else {
                    if (str8.contains(arrayListM11117a2.get(i7).f11519c.toLowerCase())) {
                        strReplaceFirst = str8.replaceFirst(arrayListM11117a2.get(i7).f11519c.toLowerCase(), "");
                        if (f11511f == -1) {
                            f11511f = i7;
                            f11512g = i7;
                        } else {
                            if (i7 - f11512g != 1) {
                                f11511f = -1;
                                f11512g = -1;
                                return;
                            }
                            f11512g = i7;
                        }
                    } else {
                        strReplaceFirst = str8;
                    }
                    if (i7 == arrayListM11117a2.size() - 1 && !strReplaceFirst.equals("")) {
                        f11511f = -1;
                        f11512g = -1;
                        return;
                    }
                }
                i7++;
            }
        }
    }

    /* renamed from: b */
    private static boolean m11113b(ArrayList<C3180av> arrayList, String str) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < arrayList.size() && i3 < str.length()) {
            if (arrayList.get(i4).f11519c.toLowerCase().charAt(0) == str.charAt(i3)) {
                if (f11511f == -1) {
                    f11511f = i4;
                    f11512g = i4;
                } else {
                    f11512g = i4;
                }
                i2 = i3 + 1;
                int i6 = i4;
                i = i5;
                i5 = i6;
            } else {
                i = i5 + 1;
                f11511f = -1;
                f11512g = -1;
                i2 = 0;
            }
            int i7 = i5 + 1;
            i5 = i;
            i4 = i7;
            i3 = i2;
        }
        if ((f11512g - f11511f) + 1 < str.length()) {
            f11511f = -1;
            f11512g = -1;
            return false;
        }
        if (f11511f != -1) {
            return true;
        }
        f11511f = -1;
        f11512g = -1;
        return false;
    }

    /* renamed from: b */
    private static String m11112b(String str, String str2) {
        if (str.length() == str2.length() && !str.equals(str2)) {
            return null;
        }
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 <= str2.length() && i2 <= str.length(); i2++) {
            if (!str2.substring(0, i2).equals("") && str.substring(0, i2).contains(str2.substring(0, i2))) {
                z = true;
                i = i2;
            }
        }
        if (z) {
            return str2.substring(i);
        }
        return null;
    }

    /* renamed from: b */
    public static int m11111b(String str) {
        char cCharAt;
        int i = 0;
        for (int i2 = 0; i2 < str.length() && (('A' > (cCharAt = str.charAt(i2)) || cCharAt > 'Z') && ('a' > cCharAt || cCharAt > 'z')); i2++) {
            i = i2;
        }
        return i;
    }

    /* renamed from: c */
    public boolean m11118c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList<C3180av> arrayListM11117a = m11103a().m11117a(str.replace(" ", ""));
        boolean z = false;
        for (int i = 0; i < arrayListM11117a.size(); i++) {
            if (!arrayListM11117a.get(i).f11519c.toLowerCase().equals(arrayListM11117a.get(i).f11518b.toLowerCase())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: d */
    public String m11119d(String str) {
        ArrayList<C3180av> arrayList = new ArrayList<>();
        if (!this.f11514e || TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                if (sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
            } else if (cCharAt < 256) {
                if (i != 1 && sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
                sb.append(cCharAt);
                i = 1;
            } else if (cCharAt < 13312) {
                if (i != 3 && sb.length() > 0) {
                    m11108a(sb, arrayList, i);
                }
                sb.append(cCharAt);
                i = 3;
            } else {
                C3180av c3180avM11105a = m11105a(cCharAt);
                if (c3180avM11105a.f11517a == 2) {
                    if (sb.length() > 0) {
                        m11108a(sb, arrayList, i);
                    }
                    arrayList.add(c3180avM11105a);
                    i = 2;
                } else {
                    if (i != c3180avM11105a.f11517a && sb.length() > 0) {
                        m11108a(sb, arrayList, i);
                    }
                    i = c3180avM11105a.f11517a;
                    sb.append(cCharAt);
                }
            }
        }
        if (sb.length() > 0) {
            m11108a(sb, arrayList, i);
        }
        String str2 = "";
        int i3 = 0;
        while (i3 < arrayList.size()) {
            String str3 = str2 + arrayList.get(i3).f11519c.toLowerCase();
            if (!arrayList.get(i3).f11519c.toLowerCase().equals(arrayList.get(i3).f11518b.toLowerCase())) {
            }
            i3++;
            str2 = str3;
        }
        return str2;
    }

    /* renamed from: a */
    public static HashMap<String, String> m11106a(int i) {
        HashMap<String, String> map = new HashMap<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i2 = 0; i2 < i; i2++) {
            StringBuilder sb = new StringBuilder();
            String str = "";
            int i3 = 0;
            while (i3 < random.nextInt(5) + 1) {
                int iNextInt = random.nextInt(f11507a.length);
                String str2 = str + Character.toString(f11507a[iNextInt]);
                for (int i4 = 0; i4 < f11508b[iNextInt].length && f11508b[iNextInt][i4] != 0; i4++) {
                    sb.append((char) f11508b[iNextInt][i4]);
                }
                i3++;
                str = str2;
            }
            map.put(str, sb.toString());
        }
        while (map.keySet().iterator().hasNext()) {
        }
        return map;
    }
}
