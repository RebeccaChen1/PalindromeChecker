import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}

public String RemoveNonAlpha(String str)
{
  String AlphaOnly="";
   for (int i = 0; i < str.length(); i++)
  {
    if (str.charAt(i)!= ' ' 
      && str.charAt(i)!= ',' 
      && str.charAt(i)!= '.'
      && str.charAt(i)!= '?' 
      && str.charAt(i) != '!'
      && str.charAt(i) != ';'
      && str.charAt(i) != '\'')
    {
      AlphaOnly= AlphaOnly + str.charAt(i);
    }
  }
  return AlphaOnly;
}
public boolean palindrome(String word)
{
  word=RemoveNonAlpha(word.toLowerCase());
  int first=0;
  int last=word.length()-1;
  while(first<=last)
  {
    if(word.charAt(first)==(word.charAt(last)))
    {
      first++;
      last--;
    }
    else 
    {
      return false;
    }
  }
  return true;
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
