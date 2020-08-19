package com.tsayun.formalspeech.business.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadSectionsDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadSectionsDatabase.class);

    @Bean
    CommandLineRunner initEmployeesDatabase(SectionRepository repository) {

        return args -> {
//            log.info("Preloading database " + repository.save(new Section("com.sample", "Sample component", )));
        };
    }
}
