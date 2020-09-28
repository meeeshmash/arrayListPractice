package ArrayList;
import java.util.*;
import edu.duke.*;
import java.io.*;

/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for (String wordO: fr.words()){
            String word = wordO.toLowerCase();
            //if word does not exist in myWords, add to myWords
            if (!myWords.contains(word)){
                myWords.add(word);
                myFreqs.add(1);
            }else{
            //get the index of word in Mywords
            int wIndex = myWords.indexOf(word);
            int currentFreq = myFreqs.get(wIndex);            
            //add 1 to the frequency of the word with same index in MyFreqs
            myFreqs.set(wIndex, currentFreq +1);
           }
        }
    
    }
    
    public int findIndexOfMax(){
        //create new int to store maxvalue and int to store maxIndex
        int maxValue = -1;
        int maxIndex = -1;
        //for each element in myFreqs, compare to maxValue
        for (int k = 0; k < myFreqs.size(); k++){
            if (maxValue == -1){
                maxValue = myFreqs.get(k);
                maxIndex = k;            
            }
            int currentValue = myFreqs.get(k);
            if (currentValue > maxValue){
                maxValue = currentValue;
                maxIndex = k;            
            }
        }
        //return maxIndex
        return maxIndex;
    }
    
    public void tester(){
        findUnique();
        int maxIndex = findIndexOfMax();
        System.out.println("There are "+myWords.size()+" unique words in this file.");
        System.out.println("The most common word is "+ myWords.get(maxIndex)+" with a frequency "+ myFreqs.get(maxIndex));
        for (int k = 0; k< myWords.size(); k++){
            //System.out.println(myWords.get(k) + " : "+ myFreqs.get(k));
        }
    
    }

}
