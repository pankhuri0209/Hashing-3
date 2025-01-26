import java.net.Inet4Address;
import java.util.*;

public class problem2 {
    // Time Complexity: O(songs) + O(user*songs)
// Space Complexity: O(songs)
        public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

            HashMap<String, String> songToGenreMap = new HashMap<>();
            for (String genre : genreMap.keySet()) {
                List<String> songs= genreMap.get(genre);
                for (String song : songs) {
                    songToGenreMap.put(song, genre);
                }
            }
            HashMap<String, List<String>> result = new HashMap<>();
            for (String user : userMap.keySet()) {
                HashMap<String, Integer> freqMap= new HashMap<>();
                List<String> favoriteGenres = new ArrayList<>();

                List<String> songs= userMap.get(user);
                int max=0;
                for (String song: songs) {
                    String genre = songToGenreMap.get(song);
                    freqMap.put(genre, freqMap.getOrDefault(genre, 0) + 1);
                    max=Math.max(max, freqMap.get(genre));
                }
                for (String genre: freqMap.keySet()) {
                    if (freqMap.get(genre) == max) {
                        favoriteGenres.add(genre);
                    }
                }
                result.put(user, favoriteGenres);
            }
            return result;
        }

        public static void main(String[] args) {

            HashMap<String, List<String>> userSongs = new HashMap<>();

            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

            HashMap<String, List<String>> songGenres = new HashMap<>();

            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

            System.out.println(res);

        }


}
