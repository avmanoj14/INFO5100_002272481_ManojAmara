import java.util.UUID;

public class University {
     String universityId;
     String name;
     String location;
     int foundingYear;
     String accreditation;
     int totalStudents;
     boolean isOpen;
     String deanName;

    // Nested class for students in the university
    public class Student {
         String studentId;
         String name;
         int age;
         String major;
         boolean isEnrolled;
         int creditsEarned;
         boolean isInternational;
         String advisorName;

        public Student(String name, int age, String major, boolean isEnrolled, int creditsEarned, boolean isInternational, String advisorName) {
            this.studentId = UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.age = age;
            this.major = major;
            this.isEnrolled = true;
            this.creditsEarned = creditsEarned;
            this.isInternational = true;
            this.advisorName = advisorName;
            System.out.println("Student instance created. Student ID: " + this.studentId);
        }

        public void enrollInUniversity() {}

        public void takeCourse() {}

        public void graduate() {
            System.out.println(name + " is graduating!");
        }
    }

    public class Professor {
         String professorId;
         String name;
         String department;
         int yearsOfExperience;
         boolean isTenured;

        public Professor(String name, String department, int yearsOfExperience, boolean isTenured) {
            this.professorId = UUID.randomUUID().toString().substring(0, 8);
            this.name = name;
            this.department = department;
            this.yearsOfExperience = yearsOfExperience;
            this.isTenured = isTenured;
            System.out.println("Professor instance created. Professor ID: " + this.professorId);
        }

        public void conductResearch() {
            System.out.println(name + " is conducting research.");
        }

        public void teachCourse() {
        }

        public void publishPaper() {
        }

    }




    public University(String name, String location, int foundingYear, String accreditation, int totalStudents, boolean isOpen, String deanName) {
        this.universityId = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.location = location;
        this.foundingYear = foundingYear;
        this.accreditation = accreditation;
        this.totalStudents = totalStudents;
        this.isOpen = true;
        this.deanName = deanName;
        System.out.println("University instance created. University ID: " + this.universityId);
    }

    public void admitStudent() {
        System.out.println("Admitted student is from " + name);
    }

    public void offerCourse() {}

    public void closeUniversity() {}
}