package kol1.FileSystem3;

public interface IFile {
    String getFileName();
    long getFileSize();
    String getFileInfo(String indent);
    void sortBySize();
    long findLargestFile();
}
