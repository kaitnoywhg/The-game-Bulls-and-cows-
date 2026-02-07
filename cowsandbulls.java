import java.util.HashSet;
import java.util.Random;
import static javax.swing.JOptionPane.*;

public class cowsandbulls {
    public static void main(String[] args){
        final int n=4;
        Random rand=new Random();
        int [] nums = new int[n];
        nums[0]=rand.nextInt(9)+1; 
        HashSet<Integer>exists=new HashSet<>();
        exists.add(nums[0]);
        for(int i=1;i<n;i++){
            int a;
            do { 
                a=rand.nextInt(10);
            } while (exists.contains(a));
            nums[i]=a;
            exists.add(a);
        }
        int attempt=0;
        boolean win=false;
        String ans;
        StringBuilder right =new StringBuilder();
        for(int num:nums){
            right.append(num);
        }
        while(attempt<12 && !win){
            ans=showInputDialog(null,
            "Guess a 4-digit number (the digits are different, from 0 to 9)\nThe first digit is not 0\n🐂The bull is a digit in its place\n 🐄The cow is a digit in the number, but it`s not in the right place",
            "Game menu",
            INFORMATION_MESSAGE);
            if(ans.length()!=4){
                showMessageDialog(null,"Incorrect number input, guess a 4-digit number","Error❗️ ",ERROR_MESSAGE);
                continue;
            }if(ans.charAt(0)=='0'){
                showMessageDialog(null,"The first digit is not 0", "Error❗️",ERROR_MESSAGE);
                continue;
            }
            boolean digits=true;
            for(char a:ans.toCharArray()){
                if(!Character.isDigit(a)){
                    digits=false;
                    break;
                }
            }
            if(!digits){
                showMessageDialog(null,"The symbols are not digits","Error❗️", ERROR_MESSAGE);
                continue;
            }
            HashSet<Character>uni=new HashSet<>();
            boolean clone=false;
            for(char a:ans.toCharArray()){
                if(!uni.add(a)){
                    clone=true;
                    break;
                }
            }
            if(clone){
                showMessageDialog(null,"The digits are not different","Error❗️", ERROR_MESSAGE);
                continue;
            }
            attempt++;
            int cows=0,bulls=0;
                int[] test=new int[n];
                for(int i=0;i<4;i++){
                    test[i]=Character.getNumericValue(ans.charAt(i));
                }
                for(int i=0;i<nums.length;i++){
                    if(test[i]==nums[i]){
                        bulls++;
                    }
                }
                for(int i=0;i<nums.length;i++){
                    for(int j=0;j<test.length;j++){
                        if((i!=j)&&(nums[i]==test[j])){
                            if(nums[j]!=test[j]){
                            cows++;}
                        }
                    }
                }
                if(bulls==4){
                    win=true;
                    showMessageDialog(null,
                    "You quessed, that number: "+ans+
                    "\nCows: "+cows+
                    "\nBulls: "+bulls+
                    "\nAttempts: "+attempt,
                    "🎉Victory🎉",
                    INFORMATION_MESSAGE
                    );
                }if(!win){showMessageDialog(null,
                    "You didn`t guess right, try again\nThe entered number "+ans+
                    "\nCows: "+cows+
                    "\nBulls: "+bulls+
                    "\nAttempts: "+attempt,
                    "Game",
                    INFORMATION_MESSAGE);
                }
            }
                if(attempt>12){
                    showMessageDialog(null,
                    "❌You`ve lost, that number❌: "+right.toString()+
                    "Attempts: "+attempt,
                    "Defeat",
                    INFORMATION_MESSAGE);
                }
        }
    }

