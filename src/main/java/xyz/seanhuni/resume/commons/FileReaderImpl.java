package xyz.seanhuni.resume.commons;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Log4j2
@Component
public class FileReaderImpl implements FileReaderService {

    private String version;

    public FileReaderImpl() {
        InputStream inputStream = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File("version.txt");
            inputStream = new FileInputStream(file);

            this.version = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
        } catch (FileNotFoundException e) {
            log.error(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
    }

    public String getVersion() {
        return version;
    }
}
