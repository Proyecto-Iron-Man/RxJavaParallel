package pe.ironman.parallel.data.clientapi.students.services;

import io.reactivex.rxjava3.core.Observable;
import pe.ironman.parallel.data.clientapi.students.models.ApiStudent;

public interface ApiStudentService {

    Observable<ApiStudent> getStudentByDocumentNumber(String documentNumber);
}
