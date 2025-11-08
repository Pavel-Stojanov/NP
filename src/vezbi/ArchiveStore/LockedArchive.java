package vezbi.ArchiveStore;

import java.util.Date;

public class LockedArchive extends Archive {
    private Date dateToOpen;

    public LockedArchive(int id, Date dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    @Override
    public void open(Date date, StringBuilder log) {
        if (date.before(dateToOpen)) {
            log.append(String.format("Item %d cannot be opened before %s\n", id, dateToOpen));
        } else {
            log.append(String.format("Item %d opened at %s\n", id, date));
        }
    }
}
