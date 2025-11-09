package vezbi.ArchiveStoreDate8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ArchiveStore {
    private List<Archive> archives;
    private StringBuilder log;

    public ArchiveStore() {
        archives = new ArrayList<>();
        log = new StringBuilder();
    }

    public void archiveItem(Archive item, Date date) {
        item.setDateArchived(date);
        archives.add(item);
        log.append(String.format("Item %d archived at %s\n", item.getId(), date));
    }

    public void openItem(int id, Date date) throws NonExistingItemException {
        Optional<Archive> item = archives.stream()
                .filter(a->a.getId()==id)
                .findFirst();
        if (item.isPresent()){
            item.get().open(date,log);
        }else{
            throw new NonExistingItemException(String.format("Item with id %d doesn't exist", id));
        }
    }

    public String getLog() {
        return log.toString();
    }
}
