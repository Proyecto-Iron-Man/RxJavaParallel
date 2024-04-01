package pe.ironman.parallel.data.clientapi.studentcareers.services;

import io.reactivex.rxjava3.core.Observable;
import pe.ironman.parallel.data.clientapi.studentcareers.models.ApiStudentCareer;

public interface ApiStudentCareerService {
    Observable<ApiStudentCareer> getStudentCareerByStudentId(Long studentId);
}
