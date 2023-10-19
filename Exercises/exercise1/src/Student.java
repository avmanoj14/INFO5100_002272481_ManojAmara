import java.util.Arrays;


class Student {
    String name;
    int[] quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new int[15];
    }

    public void addQuizScore(int index, int score) {
        if (index >= 0 && index < 15) {
            quizScores[index] = score;
        }
    }

    public double getAverageQuizScore() {
        int sum = 0;
        for (int score : quizScores) {
            sum += score;
        }
        return (double) sum / quizScores.length;
    }

    public String getName() {
        return name;
    }

    public int[] getQuizScores() {
        return quizScores;
    }
}


class PartTimeStudent extends Student {
    public PartTimeStudent(String name) {
        super(name);
    }
}

class FullTimeStudent extends Student {
    int examScore1;
    int examScore2;

    public FullTimeStudent(String name, int examScore1, int examScore2) {
        super(name);
        this.examScore1 = examScore1;
        this.examScore2 = examScore2;
    }

    public int getExamScore1() {
        return examScore1;
    }

    public int getExamScore2() {
        return examScore2;
    }
}


class Session {
    Student[] students;

    public Session() {
        students = new Student[20];
    }

    public void addStudent(int index,Student student) {
        if (index >= 0 && index < 20) {
            students[index] = student;
        }
    }

    public double calAverageQuizScore() {
        double totalAverage = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                totalAverage += student.getAverageQuizScore();
                count++;
            }
        }
        return totalAverage / count;
    }

    public void printQuizScoresAscending() {
        for (Student student : students) {
            if (student != null ) {
                int [] quizScores = student.getQuizScores();
                Arrays.sort(quizScores);
                System.out.println(student.getName() + "'s quiz scores in ascending order: " + Arrays.toString(quizScores));
            }
        }
    }

    public void printPartTimeStudents() {
        System.out.println("Part time students:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.getName());
            }
        }
    }

    public void printExamScores() {
        System.out.println("Full time students Exam scores: ");
        for (Student student : students) {
            if (student instanceof FullTimeStudent fullTimeStudent) {
                System.out.println(student.getName() + ": Exam1 - " + fullTimeStudent.getExamScore1() + ", Exam 2 - " + fullTimeStudent.getExamScore2());
            }
        }
    }
}


