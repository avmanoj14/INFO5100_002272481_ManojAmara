public class Main {
    public static void main(String[] args) {
        Session session = new Session();


        String[] partTimeNames = {
                "Max", "Alice", "Bob", "Charlie", "David",
                "Eva", "Frank", "Grace", "Harry", "Ivy",
                "Jack", "Katie", "Leo", "Mia", "Noah"
        };

        String[] fullTimeNames = {"Manoj", "Rahul", "Yadhu", "Venky", "Raj"};


        for (int i = 0; i < 15; i++) {
            PartTimeStudent partTimeStudent = new PartTimeStudent(partTimeNames[i]);
            for (int j = 0; j < 15; j++) {
                partTimeStudent.addQuizScore(j, (int) (Math.random() * 100));
            }
            session.addStudent(i, partTimeStudent);
        }

        for (int i = 0; i < 5; i++) {
            FullTimeStudent fullTimeStudent = new FullTimeStudent(fullTimeNames[i],
                    (int) (Math.random() * 100), (int) (Math.random() * 100));
            for (int j = 0; j < 15; j++) {
                fullTimeStudent.addQuizScore(j, (int) (Math.random() * 100));
            }
            session.addStudent(i, fullTimeStudent);
        }



        System.out.println("Average Quiz Scores: " + session.calAverageQuizScore());

        session.printQuizScoresAscending();
        session.printPartTimeStudents();
        session.printExamScores();

    }
}
