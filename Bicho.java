import java.lang.Math; 
public class Bicho
{
    private int sangre;
    public static Bicho[][]  bichos = new Bicho[2][2];
    private static int max = 4; 
    private static int min = 1; 
    private static int rango = max - min + 1; 
    private static int numAleatorio = (int)(Math.random() * rango) + min;

    public Bicho(){

    }

    public Bicho(int sangre){
        this.sangre = sangre;
    }

    public int getSangre(){
        return this.sangre;   
    }

    public void setSangre(int sangre){
        this.sangre = sangre;
    }

    public static void crearBichos(){
        int max = 2;
        int min = 1;
        int rango = max - min + 1;
        System.out.println(numAleatorio);
        for(int i = 0; i < numAleatorio; i++){
            int bichoAleatorio = (int)(Math.random() * rango) + min;
            System.out.println(bichoAleatorio);
            switch (bichoAleatorio){
                case 1:
                BichoNormal bicho1 = new BichoNormal();
                Bicho.agregarBicho(bicho1);
                break;

                case 2:
                BichoAlien bicho2 = new BichoAlien();
                Bicho.agregarBicho(bicho2);
                break;

                default:
                break;
            }
        }

    }

    public static void agregarBicho(Bicho bicho){
        boolean agregado = false;
        for(int i = 0; i < bichos.length; i++){
            for(int j = 0; j < bichos.length; j++){
                if(bichos[i][j] == null && agregado == false){
                    bichos[i][j] = bicho;   
                    agregado = true;
                }
            }
        }
    }

    public static void mostrarTablero(){
        for(int i = 0; i < bichos.length; i++){
            System.out.println("-------------");
            for(int j = 0; j < bichos.length; j++){
                System.out.print("|");
                if(bichos[i][j] == null){
                    System.out.print("     ");
                } else {
                    if(bichos[i][j] instanceof BichoNormal){
                        System.out.print("BN-" + bichos[i][j].getSangre());   
                    }else if(bichos[i][j] instanceof BichoAlien){
                        System.out.print("BA-" + bichos[i][j].getSangre());   
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void disparar(int pos1, int pos2){
        if(bichos[pos1][pos2] != null){
            if(bichos[pos1][pos2].getSangre() != 0){
                bichos[pos1][pos2].setSangre(bichos[pos1][pos2].getSangre() - 5);
            }else{
                System.out.println("Este Bicho ya se le hizo la moricion");   
            }
        }
    }

    public static boolean gameOver(){
        boolean gameOver = true;
        for(int i = 0; i < bichos.length; i++){
            for(int j = 0; j < bichos.length; j++){
                if(bichos[i][j].getSangre() != 0){
                    return false;
                }
            }
        }
        return gameOver;
    }
}
