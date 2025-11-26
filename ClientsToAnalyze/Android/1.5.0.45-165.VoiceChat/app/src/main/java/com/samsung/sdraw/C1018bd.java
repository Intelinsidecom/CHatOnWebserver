package com.samsung.sdraw;

import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.bd */
/* loaded from: classes.dex */
class C1018bd implements SpriteCommand {

    /* renamed from: a */
    public AbstractSprite f1556a;

    /* renamed from: b */
    public AbstractStage f1557b;

    public C1018bd(AbstractSprite abstractSprite, AbstractStage abstractStage) throws Throwable {
        int i;
        int size;
        int i2;
        this.f1556a = abstractSprite;
        this.f1557b = abstractStage;
        LinkedList linkedList = new LinkedList();
        int userID = abstractStage.context.setting.getUserID();
        if (abstractStage.getSelectedLayerID() == 0) {
            if (abstractStage.checkHistoryContainKey(userID, true, false)) {
                LinkedList<SpriteCommand> linkedList2 = abstractStage.f839c.get(Integer.valueOf(userID));
                int size2 = linkedList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (linkedList2.get(i3) instanceof C1018bd) {
                        linkedList2.remove(i3);
                    }
                }
            }
            if (abstractStage.checkHistoryContainKey(userID, true, true) && (size = this.f1557b.f840d.get(Integer.valueOf(userID)).size()) > 0) {
                synchronized (Stage.sprites1) {
                    int size3 = this.f1557b.f837a.size() - 1;
                    while (size3 >= 0) {
                        if (size <= 0 || this.f1557b.f837a.get(size3).multiUserID != this.f1557b.context.setting.getUserID()) {
                            i2 = size;
                        } else {
                            this.f1557b.f837a.remove(size3);
                            i2 = size - 1;
                        }
                        size3--;
                        size = i2;
                    }
                }
            }
        } else {
            if (abstractStage.checkHistoryContainKey(userID, false, false)) {
                LinkedList<SpriteCommand> linkedList3 = abstractStage.f841e.get(Integer.valueOf(userID));
                int size4 = linkedList3.size();
                for (int i4 = 0; i4 < size4; i4++) {
                    if (linkedList3.get(i4) instanceof SpriteCreateCommand) {
                        linkedList.add(((SpriteCreateCommand) linkedList3.get(i4)).sprite);
                    } else if (linkedList3.get(i4) instanceof C1018bd) {
                        linkedList3.remove(i4);
                    }
                }
            }
            if (abstractStage.checkHistoryContainKey(userID, false, true)) {
                Iterator<SpriteCommand> it = abstractStage.f842f.get(Integer.valueOf(userID)).iterator();
                i = 0;
                while (it.hasNext()) {
                    if (it.next() instanceof SpriteCreateCommand) {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            if (i > 0) {
                synchronized (Stage.sprites2) {
                    int size5 = this.f1557b.f838b.size() - i;
                    if (size5 >= 0) {
                        for (int size6 = this.f1557b.f838b.size() - 1; size6 >= size5; size6--) {
                            if (linkedList.indexOf(this.f1557b.f838b.get(size6)) == -1) {
                                this.f1557b.f838b.remove(size6);
                            }
                        }
                    }
                }
            }
        }
        ((Stage) this.f1557b).callonObjectDeleted();
        if (abstractStage.getSelectedLayerID() == 0) {
            if (abstractStage.checkHistoryContainKey(userID, true, true)) {
                this.f1557b.f840d.get(Integer.valueOf(userID)).clear();
            }
        } else if (abstractStage.checkHistoryContainKey(userID, false, true)) {
            this.f1557b.f842f.get(Integer.valueOf(userID)).clear();
        }
        this.f1557b.context.initializeSerializeData();
        this.f1557b.context.serializeContext(true);
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() throws Throwable {
        this.f1557b.context.serializeContext(true);
        this.f1557b.context.clearAll();
        if (this.f1557b.getSelectedLayerID() == 0) {
            this.f1557b.clearLayer(0);
        } else if (this.f1557b.getSelectedLayerID() == 3) {
            this.f1557b.clearLayer(3);
        } else {
            this.f1557b.clearLayer(this.f1557b.getSelectedLayerID());
        }
        return new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1557b.f845i.getWidth(), this.f1557b.f845i.getHeight());
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() throws Throwable {
        if (this.f1557b.getSelectedLayerID() == 0) {
            this.f1557b.clearLayer(0);
            this.f1557b.clearLayer(2);
        } else if (this.f1557b.getSelectedLayerID() == 3) {
            this.f1557b.clearLayer(3);
            this.f1557b.clearLayer(4);
        } else {
            this.f1557b.clearLayer(this.f1557b.getSelectedLayerID());
        }
        this.f1557b.context.deserializeContext(true);
        return new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1557b.f845i.getWidth(), this.f1557b.f845i.getHeight());
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return null;
    }
}
