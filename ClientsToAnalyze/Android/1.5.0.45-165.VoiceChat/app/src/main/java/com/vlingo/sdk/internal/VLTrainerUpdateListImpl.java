package com.vlingo.sdk.internal;

import com.vlingo.sdk.internal.lmtt.LMTTContactItem;
import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.lmtt.LMTTPlaylistItem;
import com.vlingo.sdk.internal.lmtt.LMTTSongItem;
import com.vlingo.sdk.training.VLTrainer;
import com.vlingo.sdk.training.VLTrainerUpdateList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VLTrainerUpdateListImpl extends VLTrainerUpdateList {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$training$VLTrainer$TrainerItemType;
    List<LMTTItem> mUpdateList = new ArrayList();

    static /* synthetic */ int[] $SWITCH_TABLE$com$vlingo$sdk$training$VLTrainer$TrainerItemType() {
        int[] iArr = $SWITCH_TABLE$com$vlingo$sdk$training$VLTrainer$TrainerItemType;
        if (iArr == null) {
            iArr = new int[VLTrainer.TrainerItemType.valuesCustom().length];
            try {
                iArr[VLTrainer.TrainerItemType.CONTACT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VLTrainer.TrainerItemType.PLAYLIST.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VLTrainer.TrainerItemType.SONG.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$vlingo$sdk$training$VLTrainer$TrainerItemType = iArr;
        }
        return iArr;
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void addContact(int uid, String firstName, String lastName, String companyName) {
        LMTTContactItem contact = new LMTTContactItem(firstName, lastName, companyName, uid, LMTTItem.ChangeType.INSERT);
        this.mUpdateList.add(contact);
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void removeContact(int uid) {
        LMTTContactItem contact = new LMTTContactItem(uid, LMTTItem.ChangeType.DELETE);
        this.mUpdateList.add(contact);
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void addSong(int uid, String title, String artist, String album, String composer, String genre, int year, String folder) {
        LMTTSongItem song = new LMTTSongItem(title, artist, composer, album, genre, year, folder, uid, LMTTItem.ChangeType.INSERT);
        this.mUpdateList.add(song);
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void removeSong(int uid) {
        LMTTSongItem song = new LMTTSongItem(uid, LMTTItem.ChangeType.DELETE);
        this.mUpdateList.add(song);
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void addPlaylist(int uid, String title) {
        LMTTPlaylistItem playlist = new LMTTPlaylistItem(title, uid, LMTTItem.ChangeType.INSERT);
        this.mUpdateList.add(playlist);
    }

    @Override // com.vlingo.sdk.training.VLTrainerUpdateList
    public void removePlayList(int uid) {
        LMTTPlaylistItem playlist = new LMTTPlaylistItem(uid, LMTTItem.ChangeType.DELETE);
        this.mUpdateList.add(playlist);
    }

    private int removeExistingItemFromList(LMTTItem.LmttItemType type, int uid, int itemIndex) {
        int itemsRemoved = 0;
        int i = 0;
        while (i < itemIndex) {
            LMTTItem item = this.mUpdateList.get(i);
            if (item.type == type && item.uid == uid) {
                this.mUpdateList.remove(i);
                i--;
                itemIndex--;
                itemsRemoved++;
            }
            i++;
        }
        return itemsRemoved;
    }

    public List<LMTTItem> compact() {
        int numItems = this.mUpdateList.size();
        int i = numItems - 1;
        while (i > 0) {
            LMTTItem item = this.mUpdateList.get(i);
            int itemsRemoved = removeExistingItemFromList(item.type, item.uid, i);
            i = (i - itemsRemoved) - 1;
        }
        return this.mUpdateList;
    }

    public boolean isEmpty() {
        return this.mUpdateList.isEmpty();
    }

    public void addNOOPItem(VLTrainer.TrainerItemType trainerType) {
        switch ($SWITCH_TABLE$com$vlingo$sdk$training$VLTrainer$TrainerItemType()[trainerType.ordinal()]) {
            case 1:
                this.mUpdateList.add(new LMTTContactItem(-1, LMTTItem.ChangeType.NOCHANGE));
                break;
            case 2:
                this.mUpdateList.add(new LMTTSongItem(-1, LMTTItem.ChangeType.NOCHANGE));
                break;
            case 3:
                this.mUpdateList.add(new LMTTPlaylistItem(-1, LMTTItem.ChangeType.NOCHANGE));
                break;
        }
    }
}
