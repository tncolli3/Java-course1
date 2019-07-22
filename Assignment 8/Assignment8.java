//-------------------------------------------------------------------------
// FILENAME:      Assignment8.java
// DESCRIPTION:   This is the test driver for QuizData class. It provides the stduent and quiz statistics for
//				                a class. It reads the data from a file that includes the students' quiz scores.
// FOR:           CSE 110 Assignment 8
// DUE DATE:
// Time Spent:
//-------------------------------------------------------------------------
import java.text.DecimalFormat;
import java.io.*;

public class Assignment8
{
  public static void main(String[] args) throws IOException
  {
    //instantiate a QuizData object by passing the file name
    QuizData cmp = new QuizData("quiz.txt");

    DecimalFormat averageFormat = new DecimalFormat( "0.00" );

    System.out.println(cmp.toString()); // it prints the scores for all stdudents

    //print the average of quiz scores, no quiz is dropped
    System.out.println("\nAverage of all quizzes (no quizzes dropped) = "
                          + averageFormat.format( cmp.quizAverage( ) ) );

    System.out.println("\nStatistics for each quiz " );
    System.out.println(cmp.quizStatistics( ));

    System.out.println("\nA Statistics for each student" );
    System.out.println( cmp.studentStatistics( ) );

  }

}