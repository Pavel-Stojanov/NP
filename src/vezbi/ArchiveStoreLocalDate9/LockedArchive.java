package vezbi.ArchiveStoreLocalDate9;

import java.time.LocalDate;

public class LockedArchive extends Archive {
    private LocalDate dateToOpen;

    public LockedArchive(int id, LocalDate dateToOpen) {
        super(id);
        this.dateToOpen = dateToOpen;
    }

    @Override
    public void open(LocalDate date, StringBuilder log) {
        if (date.isBefore(dateToOpen)) {
            log.append(String.format("Item %d cannot be opened before %s\n", id, dateToOpen));
        } else {
            log.append(String.format("Item %d opened at %s\n", id, date));
        }
    }
}
