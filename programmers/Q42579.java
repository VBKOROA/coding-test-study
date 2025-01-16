package programmers;

import java.util.*;
import java.util.Map.Entry;

public class Q42579 {
    static class Music implements Comparable<Music> {
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.play = play;
            this.idx = idx;
        }

        @Override
        public int compareTo(Music back) {
            if(this.play != back.play) {
                return back.play - this.play;
            } else {
                return this.idx - back.idx;
            }
        }
    }

    static class Genre implements Comparable<Genre> {
        String name;
        int sum = 0;

        public Genre(String name, int play) {
            this.name = name;
            this.sum = play;
        }

        @Override 
        public int compareTo(Genre back) {
            return back.sum - this.sum;
        } 
    }

    static class Solution {
        static public List<Integer> solution(String[] genres, int[] plays) {
            HashMap<String, Integer> genreMap = new HashMap<>();
            List<Genre> genreList = new ArrayList<>();
            HashMap<String, List<Music>> musicMap = new HashMap<>();

            for(int i = 0; i < genres.length; i++) {
                int play = genreMap.getOrDefault(genres[i], 0);
                play += plays[i];
                genreMap.put(genres[i], play);
                List<Music> musicList = musicMap.getOrDefault(genres[i], null);
                if(musicList == null) {
                    musicList = new ArrayList<>();
                    musicMap.put(genres[i], musicList);
                }
                musicList.add(new Music(genres[i], plays[i], i));
            }

            for(Entry<String, Integer> e : genreMap.entrySet()) {
                genreList.add(new Genre(e.getKey(), e.getValue()));
            }

            Collections.sort(genreList);
            List<Integer> answer = new ArrayList<>();

            for(Genre g : genreList) {
                List<Music> musicList = musicMap.get(g.name);
                Collections.sort(musicList);
                for(int i = 0; i < musicList.size(); i++) {
                    answer.add(musicList.get(i).idx);
                    if(i == 1) {
                        break;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        Object o = Solution.solution(genres, plays);
        System.out.println(o.toString());
    }

    // 분명 해시 알고리즘 쪽인데... 
    // 해시 보단 정렬이 더 걱정되는 코드네;
}
