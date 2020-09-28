package ArrayList;
import java.util.*;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of macbeth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> characterCounts;
    
    public CharactersInPlay(){
        characters = new ArrayList<String>();
        characterCounts = new ArrayList<Integer>();
    
    }
    
    public void update(String person){
        //change person to lowercase
        String personUC = person.toUpperCase();
        //update 2 array lists and add character's name if not already there
        if (!characters.contains(personUC)){
            characters.add(personUC);
            characterCounts.add(1);        
        }else{
            //find index of person in characters list
            //add 1 to the same index in counts
            int currIndex = characters.indexOf(personUC);
            int currCount = characterCounts.get(currIndex);
            characterCounts.set(currIndex,currCount+1);
        
        }       
    
    }
    
    public void findAllCharacters(){
        characters.clear();
        characterCounts.clear();
        FileResource fr = new FileResource();
        for (String line: fr.lines()){
            //for each line, find the first period
            int periodIndex = line.indexOf(".");
            //substring of 0 to period index is String name
            if (periodIndex != -1){
                String name = line.substring(0,periodIndex);
                update(name); 
            }
        }
    
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for (int k = 0; k< characters.size(); k++){
            if (characterCounts.get(k) >= num1 && characterCounts.get(k) <= num2){
                System.out.println(characters.get(k) + " has the speaking part count of: "+characterCounts.get(k));
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        charactersWithNumParts(10,15);
    }
    
}
