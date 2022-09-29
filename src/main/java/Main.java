import java.io.*;
import java.util.ArrayList;

//https://github.com/davidmoralesluis/TextoDelimitado.git
public class Main {
    public static void main(String[] args) throws IOException {

        String[] cod={"p1","p2","p3"};
        String[] desc={"parafusos","cravos","tachas"};
        int[] prezo={3,4,5};
        String textoTotal="";
        String unaLine="";

        for (int i = 0; i < cod.length; i++) {
            textoTotal+=cod[i]+"\t"+desc[i]+"\t"+prezo[i]+"\n";
        }
        System.out.println(textoTotal);

        PrintWriter escribir = new PrintWriter(new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"/src/main/java/produtos.txt"))));

        escribir.write(textoTotal);
        escribir.flush();
        escribir.close();

        BufferedReader leer=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/produtos.txt"));


        while((unaLine=leer.readLine())!= null){
            String[] stringArray = unaLine.split("\t");
            System.out.println("Codigo:\t\t"+stringArray[0]);
            System.out.println("Descricion:\t"+stringArray[1]);
            System.out.printf("Prezo:\t\t%.2f €\n\n",Double.parseDouble(stringArray[2]));
        }

    }
}
