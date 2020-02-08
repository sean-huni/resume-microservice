package xyz.seanhuni.resume.command;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.persistence.repo.QAndARepo;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    private final QAndARepo qAndARepo;

    public ApplicationRunner(QAndARepo qAndARepo) {
        this.qAndARepo = qAndARepo;
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
