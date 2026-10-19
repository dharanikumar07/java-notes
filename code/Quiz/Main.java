
class Main {

    public static void main(String[] args) {
        QuestionService ques = new QuestionService();

        String[] questions = {
            "Which keyword is used to create an object in Java?",
            "Which of the following is not a primitive data type in Java?",
            "What is the default value of an int variable in Java?",
            "Which keyword is used to inherit a class in Java?",
            "Which method is the entry point of a Java program?"
        };

        String[][] options = {
            {"new", "create", "object", "instance"},
            {"int", "float", "String", "boolean"},
            {"0", "null", "1", "-1"},
            {"implements", "extends", "inherits", "super"},
            {"start()", "main()", "run()", "execute()"}
        };

        String[] answers = {
            "new",
            "String",
            "0",
            "extends",
            "main()"
        };
        ques.declareQuestions(questions, options, answers);
        ques.showQuestionsAndValidate();
        ques.calculateScore();
    }
}
