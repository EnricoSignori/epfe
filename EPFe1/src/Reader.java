/**
 * Created by Marcos Ricardo on 29/06/2016.
 */
import java.io.*;
import java.lang.*;
import java.util.ArrayList;

public class Reader {

    public static ArrayList<Inimigo> leituraInimigo (String arquivo){

        String  thisLine = null;
        int vidaJogador = 0;
        int nroFases = 0;
        int contador = 0;
        ArrayList<String> configs = new ArrayList<String>();
        ArrayList<Inimigo> listaInimigos = new ArrayList<Inimigo>();

        try{
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while ((thisLine = br.readLine()) != null) {

                if(contador == 0){
                    vidaJogador = Integer.parseInt(thisLine);
                }
                else if(contador == 1){
                    nroFases = Integer.parseInt(thisLine);
                }
                else {
                    int array = 0;
                    configs.add(thisLine);
                }
                contador++;
             //   System.out.println(thisLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        String novoArquivo = null;
        for (int i = 0; i<configs.size(); i++){


           try {
               BufferedReader arq = new BufferedReader(new FileReader(configs.get(i) + ".txt"));

               while ((novoArquivo = arq.readLine()) != null) {
                   String[] s = novoArquivo.split(" ");
                   if(s[0].equals("CHEFE")){
                       Inimigo temp = new Inimigo(configs.get(i),s[0],Integer.parseInt(s[1]),Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]),Integer.parseInt(s[2]));
                       listaInimigos.add(temp);
                   }
                   else {
                       Inimigo temp = new Inimigo(configs.get(i),s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]));
                       listaInimigos.add(temp);
                   }
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        }
        return listaInimigos;
    }



    public static int leituraVidaJogador (String arquivo) {

        String thisLine = null;
        int vidaJogador = 0;
        int contador = 0;

        try {
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while ((thisLine = br.readLine()) != null) {

                if (contador == 0) {
                    vidaJogador = Integer.parseInt(thisLine);
                }
                contador++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vidaJogador;
    }

    public static int leituraNroFases (String arquivo) {

        String thisLine = null;
        int nroFases = 0;
        int contador = 0;

        try{
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while ((thisLine = br.readLine()) != null) {

                if(contador == 1){
                    nroFases = Integer.parseInt(thisLine);
                }
                contador++;
                //   System.out.println(thisLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nroFases;
    }
}

class Inimigo{ //Classe auxiliar

    private String fase;
    private String tipoInimigo;
    private int tipo;
    private int quando;
    private int x;
    private int y;
    private int vida;

    public Inimigo(String fase, String tipoInimigo, int tipo, int quando, int x, int y, int vida){
        this.tipoInimigo = tipoInimigo;
        this.fase = fase;
        this.tipo = tipo;
        this.quando = quando;
        this.x = x;
        this.y = y;
        this.vida = vida;
    }

    public Inimigo(String fase, String tipoInimigo, int tipo, int quando, int x, int y){
        this.tipoInimigo = tipoInimigo;
        this.fase = fase;
        this.tipo = tipo;
        this.quando = quando;
        this.x = x;
        this.y = y;
    }

    public String getFase() {
        return fase;
    }

    public String getTipoInimigo() {
        return tipoInimigo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getQuando() {
        return quando;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public int getVida() {
        return vida;
    }
}
