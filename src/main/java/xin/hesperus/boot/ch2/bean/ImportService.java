package xin.hesperus.boot.ch2.bean;

import org.springframework.context.annotation.Bean;

public class ImportService {

    @Bean
    public SimpleServiceInImportService simpleServiceInImportService() {
        return new SimpleServiceInImportService();
    }
}
