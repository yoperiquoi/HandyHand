package Core.StubPersistence.Local;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ExecutableManager implements JSONManager {
    private final LocalManager localManager = new LocalManager();

    @Override
    public FileManager getParent() {
        return localManager;
    }

    @Override
    public Path getPath() {
        return Paths.get(this.getParent().getPath() + File.separator + "executable.config");
    }

    @Override
    public void createFile() throws IOException {
        if(!getParent().exists()) getParent().createFile();
        Files.createFile(getPath());
        save(new Gson().toJson(new HashMap[]{}, Map.class));
    }

    @Override
    public Map.Entry<String,String>[] getAll() {
        try {
            checkExistence();
            List<Map.Entry<String,String>> returnVal = new LinkedList<>();
            var result = new Gson().fromJson(new FileReader(getPath().toString()), Map.class).entrySet().toArray();
            for (var entry: result) {
                returnVal.add((Map.Entry<String,String>)entry);
            }
            return returnVal.toArray(new Map.Entry[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String,String> getAllMap(){
        return Arrays.stream(this.getAll()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
