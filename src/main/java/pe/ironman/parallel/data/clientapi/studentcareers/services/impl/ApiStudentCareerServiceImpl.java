package pe.ironman.parallel.data.clientapi.studentcareers.services.impl;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.ironman.parallel.data.clientapi.studentcareers.models.ApiStudentCareer;
import pe.ironman.parallel.data.clientapi.studentcareers.services.ApiStudentCareerService;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ApiStudentCareerServiceImpl implements ApiStudentCareerService {
    @Override
    public Observable<ApiStudentCareer> getStudentCareerByStudentId(Long studentId) {
        if(111 == studentId) {
            return Observable.empty();
        }

        if(1111 == studentId) {
            return Observable.error(new RuntimeException("Error getting student career"));
        }


        var career = ApiStudentCareer.builder()
                .careerId(10L)
                .studentId(studentId)
                .careerName("Computer Science")
                .careerCredits(200)
                .percentageCompleted(50)
                .build();

        return Observable.just(career)
                .doOnNext(item -> log.info("getStudentCareerByStudentId executed on thread: " + Thread.currentThread().getName()))
                .delay(1, TimeUnit.SECONDS)
                ;
    }
}
