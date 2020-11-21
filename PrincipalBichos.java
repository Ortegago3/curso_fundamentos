import java.util.Scanner;
public class PrincipalBichos
{
    public static void main(String args[]) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        System.out.println("1 Para iniciar el juego");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean gameOver = false;
        if(num == 1){
            Bicho.crearBichos();
            Bicho.mostrarTablero();
            while(gameOver == false){
                System.out.println("Ingrese coordenadas de disparo");
                System.out.println("Posicion en X");
                int pos1 = scan.nextInt();
                System.out.println("Posicion en Y");
                int pos2 = scan.nextInt();
                Bicho.disparar(pos1, pos2);
                gameOver = Bicho.gameOver();
                Bicho.mostrarTablero();
            }
            System.out.println("GAME OVER!");
        }
    }
}
