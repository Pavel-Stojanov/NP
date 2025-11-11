package kol1.FileSystem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Folder implements IFile{
    private String name;
    private long size;
    private List<IFile> files;

    public Folder(String s) {
        name = s;
        size = 0;
        files = new ArrayList<>();
    }

    public void addFile(IFile file) throws FileNameExistsException{
        for (IFile f : files) {
            if (f.getFileName().equals(file.getFileName())) {
                throw new FileNameExistsException(file.getFileName(), this.name);
            }
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
    public String getFileInfo(String indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%sFolder name: %10s Folder size: %10d", indent, name, getFileSize()));
        for (IFile file : files){
            sb.append("\n").append(file.getFileInfo(indent+"    "));
        }
        return sb.toString();
    }

    @Override
    public void sortBySize() {
        files.sort(Comparator.comparing(IFile::getFileSize));
        files.forEach(IFile::sortBySize);
    }

    @Override
    public long findLargestFile() {
        return files.stream().mapToLong(IFile::findLargestFile).max().orElse(0L);
    }

    public List<IFile> getFiles() {
        return files;
    }
}
