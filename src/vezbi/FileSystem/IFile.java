package vezbi.FileSystem;

public interface IFile {
    String getFileName();
    long getFileSize();
    String getFileInfo(IFile f);
    void sortBySize();
    long findLargestFile();
}
