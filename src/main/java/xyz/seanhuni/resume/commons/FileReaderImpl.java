package xyz.seanhuni.resume.commons;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@PropertySource("classpath:version.yml")
public class FileReaderImpl implements FileReaderService {

    @Value("${version}")
    private String version;

    public String getVersion() {
        return version;
    }
}
