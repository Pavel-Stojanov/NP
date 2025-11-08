package vezbi.FileSystem;

public interface IFile {
    String getFileName();
    long getFileSize();
    String getFileInfo(String indent);
    void sortBySize();
    long findLargestFile();
}
