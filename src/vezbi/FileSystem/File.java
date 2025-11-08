package vezbi.FileSystem;

public class File implements IFile {
    private String name;
    private long size;
    public File(String part, long l) {
        name = part;
        size = l;
    }

    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }

    @Override
    public String getFileInfo(IFile f) {
        return String.format("\tFile name: %10s File size: %10d", name, f.getFileSize()) ;
    }

    @Override
    public void sortBySize() {

    }

    @Override
    public long findLargestFile() {
        return 0;
    }
}
