package pe.ironman.parallel.data.clientapi.students.services.impl;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ironman.parallel.data.clientapi.students.models.ApiStudent;
import pe.ironman.parallel.data.clientapi.students.services.ApiStudentService;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ApiStudentServiceImpl implements ApiStudentService {
    @Override
    public Observable<ApiStudent> getStudentByDocumentNumber(String documentNumber) {
        var id = 1000L;
        if (documentNumber.matches("\\d+")) {
             id = Long.parseLong(documentNumber);
        }

        var student = ApiStudent.builder()
                .id(id)
                .documentNumber(documentNumber)
                .name("John Doe")
                .email("jdoe@gmail.com")
                .phone("123456789")
                .address("123 Main St")
                .build();

        return Observable.just(student)
                .doOnNext(item -> log.info("getStudentByDocumentNumber executed on thread: {}", Thread.currentThread().getName()))
                .delay(1, TimeUnit.SECONDS)
                ;
    }
}

