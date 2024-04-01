package pe.ironman.parallel.utils;

import pe.ironman.parallel.data.clientapi.studentcareers.models.ApiStudentCareer;
import pe.ironman.parallel.data.clientapi.studentcourses.models.ApiStudentCourse;

public class Constant {
    public static final ApiStudentCareer API_STUDENT_CAREER_DEFAULT = ApiStudentCareer.builder().build();
    public static final ApiStudentCareer API_STUDENT_CAREER_DEFAULT_WHEN_ERROR = ApiStudentCareer.builder()
            .apiWarningMessage("No fue posible verificar")
            .build();

    public static final ApiStudentCourse API_STUDENT_COURSE_DEFAULT_WHEN_ERROR = ApiStudentCourse.builder()
            .apiWarningMessage("No fue posible verificar")
            .build();
}
