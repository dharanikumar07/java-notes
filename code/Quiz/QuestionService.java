
import java.util.Scanner;

class QuestionService
{
  Questions [] questions = new Questions[5];
  Object [] selection = new Object[5];

  public void declareQuestions(String [] ques, String [][] options, String [] answers)
  {
    for(int i=0; i<questions.length; i++)
    {
      questions[i] = new Questions();
      questions[i].setId(i+1);
      questions[i].setQuestion(ques[i]);
      questions[i].setOptions(options[i]);
      questions[i].setAnswer(answers[i]);
    }
  }

  public void showQuestionsAndValidate()
  {
    for(int i=0; i<questions.length; i++)
    {
      System.out.print((i+1) + ".)");
      System.out.println(questions[i].getQuestion());
      System.out.println("Options: ");
      int j=0;
      for(Object elem : questions[i].getOptions()) {
          System.out.print((j+1) + ".)");
          System.out.println(elem);
          j++;
      }
      Scanner sc = new Scanner(System.in);
      selection[i] = sc.nextLine();
    }
  }

  public void calculateScore()
  {
    int score = 0;
    for(int i=0; i<questions.length; i++)
    {
      if(questions[i].getAnswer().equals(selection[i]))
      {
        score++;
      }
    } 

    System.out.println("Your Score is: " + score);
  }
}