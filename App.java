import java.util.ArrayList;


class App{
    public static void main(String[] args){
        ArrayList cholotaes = new ArrayList<String>();

        File objFile = new File();
        objFile.ReadFile("chocolate.csv");

        for (ArrayList<String> x : cholotaes){
            for (String y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}