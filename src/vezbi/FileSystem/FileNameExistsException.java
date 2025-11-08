package vezbi.FileSystem;

public class FileNameExistsException extends RuntimeException {
    private final String filename;
    private final String foldername;
    public FileNameExistsException(String fileName, String name) {
        filename = fileName;
        foldername = name;
    }

    public String getMessage() {
        return String.format("There is already a file named %s in the folder %s",filename,foldername);
    }
}
