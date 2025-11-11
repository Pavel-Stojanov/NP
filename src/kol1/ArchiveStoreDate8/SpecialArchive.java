package kol1.ArchiveStoreDate8;

import java.util.Date;

public class SpecialArchive extends Archive {
    private int maxOpen;
    private int timesOpened;
    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        timesOpened = 0;
    }

    @Override
    public void open(Date date, StringBuilder log) {
        if (timesOpened >= maxOpen) {
            log.append(String.format("Item %d cannot be opened more than %d times\n", id, maxOpen));
        }else{
            log.append(String.format("Item %d opened at %s\n", id, date));
            timesOpened++;
        }
    }
}
