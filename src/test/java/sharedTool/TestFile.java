package sharedTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.asList;

public class TestFile {

    private File temporaryDirectory;
    private Path path;

    public TestFile(File temporaryDirectory){
        this.temporaryDirectory = temporaryDirectory;
    }

    public void prepare(String fileName, String contents) {
        try {
            File myFile = new File(temporaryDirectory, fileName);
            path = myFile.toPath();
            Files.write(path, asList(contents.split(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPathAsString() {
        return path.toString();
    }
}
