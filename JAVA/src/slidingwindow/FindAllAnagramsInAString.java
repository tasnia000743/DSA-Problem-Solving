package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public List<Integer>findAnagrams(String s, String p) {
//	Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order

int stringMatch[]	= new int[26];
int patternMatch[]= new int[26];
List<Integer>anagramIndex= new ArrayList<Integer>();

int start=0;
int end;

for(int i=0; i<p.length(); i++) {
	patternMatch[p.charAt(i)-'a']++;
}

for(end=0; end<s.length(); end++) {
	stringMatch[s.charAt(end)-'a']++;
	
	while(end-start+1== p.length()) {
		if(arrayMatch(stringMatch, patternMatch)) {
			System.out.print("baba");
			anagramIndex.add(start);	
		}
		stringMatch[s.charAt(start)-'a']--;
		start++;
	}	
}
return anagramIndex;
}
	
	
	public boolean arrayMatch(int arr1[], int arr2[]) {
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
		}
	
	public static void main(String args[]) {
		FindAllAnagramsInAString anagramFind= new FindAllAnagramsInAString();
		System.out.print("test" +anagramFind.findAnagrams("cbaebabacd", "abc"));
		
	}
}

