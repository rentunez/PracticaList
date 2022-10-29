import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PracticaConLista {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("No se ingreso el nombre del archivo");
        }else{
            FileReader fileReader=null;
            try{
                fileReader = new FileReader(args[0]);
            }catch(FileNotFoundException ex){
                System.out.println("No se encontro el archivo");
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String textLine = null;
            String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";
            ArrayList<String> al = new ArrayList<String>();
            try{
                while((textLine=bufferedReader.readLine())!=null){
                    if(textLine.trim().length()==0) continue;
                    String words[] = textLine.split(delimiters);
                    for(String p:words){
                        p = p.toLowerCase().trim();
                        al.add(p);
                    }
                }
            }catch(IOException e){
                System.out.println("Excepcion io");
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese una palabra: ");
            String palabra = sc.nextLine();
            int n=0;
            for(String s:al){
                if(s.equals(palabra)){
                    n++;
                }
            }
            System.out.format("\"%s\" aparece %d veces en el texto %s.",palabra,n,args[0]);
        }
    }
}