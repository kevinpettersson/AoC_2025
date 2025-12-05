package day_2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day2 {

    public static void main(String[] args) throws java.io.IOException {
        // Linux
        //String input = Files.readString(Path.of("/home/kevinpe/Repos/advent_of_code/2025/day_2/input.txt"));

        // Windows
        String input = Files.readString(Path.of("C:/Repos/AoC_2025/2025/day_2/input.txt"));

        String[] ids = input.split(",");

        // PART 1
        ArrayList<String> evenStrings = filterOddLengths(ids);
        ArrayList<String> invalidIDs = getInvalidIDs(evenStrings);
        long res = sumIDs(invalidIDs);
        System.out.println(res);

        // Part 2
        ArrayList<String> InvalidIDs2 = filterInvalid(ids);
        long res2 = sumIDs(InvalidIDs2);
        System.out.println(res2);
    }

    private static ArrayList<String> filterOddLengths(String[] ids){
        ArrayList<String> evenStrings = new ArrayList<>();

        for(String s : ids){

            String[] range = s.split("-");
            String start = range[0];
            String stop  = range[1];

            long n_start = Long.parseLong(start);
            long n_stop  = Long.parseLong(stop);

            for(long i = n_start; i <= n_stop; i++){
                String tmp = Long.toString(i);

                if(tmp.length() % 2 == 0){
                    evenStrings.add(tmp);
                }
            }
        }
        return evenStrings;
    }

    static ArrayList<String> getInvalidIDs(ArrayList<String> ids){
        ArrayList<String> invalid = new ArrayList<>();

        for(String s : ids){
            int halve = s.length()/2;
            String p1 = s.substring(0, halve);
            String p2 = s.substring(halve, halve*2);

            if(p1.equals(p2)){
                invalid.add(s);
            }
        }
        return invalid;
    }

        private static ArrayList<String> filterInvalid(String[] ids){
        ArrayList<String> invalid = new ArrayList<>();

        for(String s : ids){

            String[] range = s.split("-");
            String start = range[0];
            String stop  = range[1];

            long n_start = Long.parseLong(start);
            long n_stop  = Long.parseLong(stop);

            for(long i = n_start; i <= n_stop; i++){
                String tmp = Long.toString(i);

                for(int j = 1; j <= tmp.length()/2; j++){

                    if(tmp.length() % j == 0){
                        String tmp2 = tmp.substring(0, j);

                        if(tmp.equals(tmp2.repeat(tmp.length()/j))){
                            invalid.add(tmp);
                            break;
                        }
                    }
                }
            }
        }
        return invalid;
    }

    static long sumIDs(ArrayList<String> ids){

        long sum = 0;

        for(String s : ids){
            long val = Long.parseLong(s);
            sum += val;
        }

        return sum;
    }
    
}
