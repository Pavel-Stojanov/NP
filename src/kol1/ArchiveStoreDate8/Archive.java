package kol1.ArchiveStoreDate8;

import java.util.Date;

abstract class Archive {
    protected int id;
    protected Date dateArchived;

    public Archive(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateArchived(Date dateArchived) {
        this.dateArchived = dateArchived;
    }

    public abstract void open(Date date,StringBuilder log);
}
