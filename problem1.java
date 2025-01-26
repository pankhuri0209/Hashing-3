import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class problem1 {
// Time Complexity: O(n)
// Space Complexity: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allseq= new HashSet<String>();
        HashSet<String> result= new HashSet<>();
        int n =  s.length();

        for (int i = 0; i < n-9; i++) {
            String seq= s.substring(i,i+9);
            if (allseq.contains(seq)) {
                result.add(seq);
            }
            else {
                allseq.add(seq);
            }
        }

        return new ArrayList<String>(result);
    }
 //
 public List<String> findRepeatedDnaSequences1(String s) {
     HashSet<Long> allseq= new HashSet<Long>();
     HashSet<String> result= new HashSet<>();
     int n =  s.length();

     HashMap<Character, Integer> map= new HashMap<>();
     map.put('A',1);
     map.put('C',2);
     map.put('G',3);
     map.put('T',4);
     Long hash = 0l;
     long posFac= (long) Math.pow(4,10);
     for (int i = 0; i < n; i++) {
         char in= s.charAt(i);
         hash= (hash*4) + map.get(in);

         if(i>=10)
         {
             char out = s.charAt(i-10);
             hash= hash- (posFac *map.get(out));
         }
         if (allseq.contains(hash)) {
             result.add(s.substring(i-9,i+1));
         }
         else {
             allseq.add(hash);
         }
     }

     return new ArrayList<String>(result);
 }
}