package kol1.FileSystem3;

public class FileSystem {
    Folder rootDirectory;

    public FileSystem() {
        rootDirectory = new Folder("root");
    }

    public void addFile(IFile file) throws FileNameExistsException {
        rootDirectory.addFile(file);
    }

    public void sortBySize() {
        rootDirectory.sortBySize();
    }

    @Override
    public String toString() {
        return rootDirectory.getFileInfo("");
    }


    public long findLargestFile() {
        return rootDirectory.findLargestFile();
    }
}
