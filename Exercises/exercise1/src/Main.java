public class Main {
    public static void main(String[] args) {
        Session session = new Session();


        String[] partTimeNames = {
                "Max", "Alice", "Bob", "Charlie", "David",
                "Eva", "Frank", "Grace", "Harry", "Ivy",
                "Jack", "Katie", "Leo", "Mia", "Noah"
        };

        String[] fullTimeNames = {"Manoj", "Rahul", "Yadhu", "Venky", "Raj"};


        for (String partTimeName : partTimeNames) {
            PartTimeStudent partTimeStudent = new PartTimeStudent(partTimeName);
            for (int j = 0; j < 15; j++) {
                partTimeStudent.addQuizScore(j, (int) (Math.random() * 100));
            }
            session.addStudent(partTimeStudent);
        }

        for (String fullTimeName : fullTimeNames) {
            FullTimeStudent fullTimeStudent = new FullTimeStudent(fullTimeName,
                    (int) (Math.random() * 100), (int) (Math.random() * 100));
            for (int j = 0; j < 15; j++) {
                fullTimeStudent.addQuizScore(j, (int) (Math.random() * 100));
            }
            session.addStudent(fullTimeStudent);
        }



        session.printIndividualQuizScores();
        session.printQuizScoresAscending();
        session.printPartTimeStudents();
        session.printExamScores();

    }
}
