export class Course {
    courseCode: string;
    courseName: string;
    instructorId: string;
    availableSeats: number;

    constructor(  courseCode: string,
        courseName: string,
        instructorId: string,
        availableSeats: number){

        this.courseCode =courseCode;
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.availableSeats =availableSeats;


    }


}