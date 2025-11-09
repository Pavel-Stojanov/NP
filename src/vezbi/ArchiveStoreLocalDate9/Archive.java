package vezbi.ArchiveStoreLocalDate9;

import java.time.LocalDate;

abstract class Archive {
    protected int id;
    protected LocalDate dateArchived;

    public Archive(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateArchived(LocalDate dateArchived) {
        this.dateArchived = dateArchived;
    }

    public abstract void open(LocalDate date,StringBuilder log);
}
