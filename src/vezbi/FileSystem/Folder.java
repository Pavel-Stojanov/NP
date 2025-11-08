package vezbi.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFile{
    private String name;
    private long size;
    private List<IFile> files;

    public Folder(String s) {
        name = s;
        size = 0;
        files = new ArrayList<IFile>();
    }

    public void addFile(IFile file) throws FileNameExistsException{
        if (!files.isEmpty()){
            files.forEach(f->{
                if (f.getFileName().equals(file.getFileName())){
                    throw new FileNameExistsException(f.getFileName(),name);
                }
            });
        }
        files.add(file);
        size+=file.getFileSize();

    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }
    //Folder name [името на директориумот со 10 места порамнето на десно] Folder size: [големината на директориумот со 10 места пораменета на десно ]
    @Override
    public String getFileInfo(IFile f) {
        return String.format("\tFolder name: %10s Folder size: %10d", name, f.getFileSize()) ;
    }

    @Override
    public void sortBySize() {

    }

    @Override
    public long findLargestFile() {
        return 0;
    }
}
