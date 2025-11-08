package vezbi.FileSystem;

public class FileSystem {
    Folder rootDirectory;

    public FileSystem() {
        rootDirectory = new Folder("root");
    }

    public void addFile(IFile file) {
        rootDirectory.addFile(file);
    }

    public void sortBySize() {

    }

    @Override
    public String toString() {
        return String.format("Folder name: %10s File size: %10d", "root", rootDirectory.getFileSize()) ;
    }

    public long findLargestFile (){
        return 0;
    }
}
