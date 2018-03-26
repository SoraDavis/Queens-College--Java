import java.io.*;
import java.util.*;

public class HW2 {
   
   // Prints a list of words that appear in both files.
   public static void intersection(String filename1, String filename2) 
   {
      try (Scanner in1 = new Scanner(new FileReader(filename1));
            Scanner in2 = new Scanner(new FileReader(filename2))) 
      {
    	  //create a new HashSet
         Set<String> words = new HashSet<>();
   
         //read through file1 and put all words into HashSet
         while (in1.hasNextLine())
         {
             String line = in1.nextLine();
             words.add(line);
         } 
         
         
         //check if each word from file2 is in the set containing words from file1
         while (in2.hasNextLine())
         {
             String line2 = in2.nextLine();

             if(words.contains(line2))
             {
            	//if it is found, print it
            	 System.out.println(line2);
             }

         } 
         System.out.println("********************");
      }
      catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   // Prints all words in the file that occur at least k times
   // (print the word followed by the number of occurrences in parentheses).
   // Each line in the file contains only one word.
   public static void frequentWords(String filename, int k) {
      try (Scanner in = new Scanner(new FileReader(filename))) {
    	  
         //create a new HashMap to store words (key) and # of occurences (value)
    	  Map<String, Integer> words = new HashMap<>();
    	  
    	  //go through the file. check if the current word is already in the HashMap
    	  //if it is not, put it in with a value of 1
    	  //if it is, just update the value +1
    	  
    	  while (in.hasNextLine())
          {
              String line = in.nextLine();
              if(!words.containsKey(line))
              {
            	  words.put(line, 1);
              }
              else
              {
            	  int i = words.get(line);
            	  words.put(line, i+1);
              }
          } 
    	  
    	  //now that the Map is complete, iterate through and print a/t with value > 1 
    	  for (Map.Entry<String, Integer> entry : words.entrySet()) 
    	  {
    		  if(entry.getValue() >= k)
    			  System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
    	  }
    	    
    	  System.out.println("********************");
    	  
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   // Returns the string with the characters sorted alphabetically.
   private static String sortString(String s) {
      char[] array = s.toCharArray();
      Arrays.sort(array);
      return new String(array);
   }

   // Prints all sets of anagrams, one set per line.
   // Each line in the file contains only one word.
   public static void anagrams(String filename) {
      try (Scanner in = new Scanner(new FileReader(filename))) {
    	  
         //create a HashMap with a string for key and a set of strings for value
    	  Map<String,Set<String>> words = new HashMap<>();
    	  
    	  //go through the file
    	  while (in.hasNextLine())
          {
              String line = in.nextLine();
              //sort the word
              String sortLine = sortString(line);
              //check if this sorted word is a key in the map.
              //if not, add the word
              //if yes, update the value (the set) where the matching key is
              if(!words.containsKey(sortLine))
              {
            	  words.put(sortLine, new HashSet<String>()); ;
            	  Set<String> a = words.get(sortLine);
            	  a.add(line);
              }
              
              else
              {
            	  Set<String> a = words.get(sortLine);
            	  a.add(line);
              }
              
          }
    	  
          //iterate through the map
          //if a value set size >= k, print it
          for (Map.Entry<String, Set<String>> entry : words.entrySet()) 
    	  {
    		  if(entry.getValue().size() > 1)
    			  System.out.println(entry.getValue());
    	  }
          
          System.out.println("********************");
    	  
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      System.out.println("***Intersection***");
      intersection("english_words.txt", "french_words.txt");
      
	   System.out.println("***Frequent words***");
	   frequentWords("english_words.txt", 2);
      
      System.out.println("***Anagrams***");
      anagrams("english_words.txt");
   }
}
