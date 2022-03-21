export class RegisteredCourse {

    studentId: string;
    courseCode: string;
    grade: string;
    
    constructor(studentId: string,
        courseCode: string,
        grade: string){

        this.studentId =studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        

}
}
