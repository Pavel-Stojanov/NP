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
    public String getFileInfo(String indent) {
        return String.format("%sFile name: %10s File size: %10d",indent, name, size) ;
    }

    @Override
    public void sortBySize() {

    }

    @Override
    public long findLargestFile() {
        return size;
    }
}
