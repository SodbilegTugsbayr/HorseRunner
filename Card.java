package Assignment1;

public class Card implements ICard{
  private String question;
  private String answer;

  public Card(String theQuestion, String theAnswer){
    question = theQuestion;
    answer = theAnswer;
  }

  public String getQuestion(){
    return question;
  }

  public String getAnswer(){
    return answer;
  }

  public boolean checkAnswer(String theAnswer){
    return theAnswer.equals(answer);
  }
}
