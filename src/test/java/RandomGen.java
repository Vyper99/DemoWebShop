import java.util.Random;

public class RandomGen {
        String random;
        int n;
    String aToZ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateRandom(int n) {
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i=0; i<n; i++){
            int randIndex=rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
    }
          return random=res.toString();
//        System.out.println(res.toString());


    }
    public void getRandom(){
        System.out.println(random);
    }

        }

