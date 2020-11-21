import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Principal2 {

    public static void main(String[] args){
        mostrarMenu();
    }

    public static void mostrarMenu(){
        System.out.println("0. Para Salir");
        System.out.println("1. Ingresar Vehiculo");
        System.out.println("2. Mostrar informacion de Vehiculos");
        System.out.println("3. Cantidad Vehiculos");
        System.out.println("4. Mostrar Vehiculos verdes");
        System.out.println("5. Ingresar Id del Vehiculo");
        System.out.println("6. Ingresa Id y el Sensor");
        System.out.println("7. Ingresa Id para mostrar lo sensores de los Vehiculos");
        System.out.println("8. Mostrar informacion de los Sensores de temperatura");
        System.out.println("9. Mostrar informacion del Vehiculo con mas sensores");
        System.out.println("10. Cargar informacion de Vehiculos ficticios");
        System.out.println("666. Mostrar Sensores de temperatura ordenados" );

        Scanner scan = new Scanner (System.in);
        boolean noTerminar = true;

        while (noTerminar){
            int num = scan.nextInt();
            switch (num){
                case 0:
                noTerminar = false;
                break;

                case 1:
                if(num == 1 && Vehiculo.vehiculos.size()<10){

                    int modelo = scan.nextInt();
                    String marca = scan.next();
                    double valorComercial = scan.nextDouble();
                    String color = scan.next();
                    Vehiculo v1 = new Vehiculo(modelo, marca, valorComercial, color);

                }else {
                    System.out.println("Error base de datos llena");
                }
                break;

                case 2:
                System.out.println(Vehiculo.toStringVehiculos());
                break;

                case 3:
                System.out.println(Vehiculo.cantidadVehiculos());
                break;

                case 4:
                System.out.println(Vehiculo.toStringVehiculosVerdes());
                break;

                case 5:
                int id5 = scan.nextInt();
                Vehiculo v5 = Vehiculo.obtenerVehiculoPorId(id5);
                if(v5 != null){
                    System.out.println(v5.toString());
                }else{
                    System.out.println("No existe este vehiculo");   
                }
                break;

                case 6:
                int id6 = scan.nextInt();
                Vehiculo v6 = Vehiculo.obtenerVehiculoPorId(id6);
                if(v6 != null){
                    String tipo = scan.next();
                    double valor = scan.nextDouble();
                    Sensor s6 = new Sensor(tipo, valor);
                    v6.anadirSensor(s6);
                }else{
                    System.out.println("No existe este vehiculo");   
                }
                break;

                case 7:
                int id7 = scan.nextInt();
                Vehiculo v7 = Vehiculo.obtenerVehiculoPorId(id7);
                System.out.println(v7.toStringSensores());
                break;

                case 8:
                System.out.println(Vehiculo.toStringSensoresTemperatura());
                break;

                case 9:
                System.out.println(Vehiculo.mayorCantidadSensores());
                break;

                case 10:

                FileReader input = null;
                File archivo = null;
                try {
                    File file = new File("vehiculos.txt");
                    String line;
                    input = new FileReader(file);
                    BufferedReader bf = new BufferedReader(input);
                    while((line = bf.readLine()) != null){
                        String[] vehiculo = line.split(",");
                        Vehiculo v = new Vehiculo(Integer.parseInt(vehiculo[0]),vehiculo[1],Integer.parseInt(vehiculo[2]),vehiculo[3]);
                    }

                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                break;

                case 666:
                String cadenaSensores = "";
                ArrayList<Sensor> sensoresTemp = Vehiculo.ordenarSensoresTemperatura();
                for(int i = 0; i < sensoresTemp.size(); i++){
                    if(sensoresTemp.get(i) != null){

                        cadenaSensores = cadenaSensores + sensoresTemp.get(i).toString();
                    }
                }
                System.out.println(cadenaSensores);

                break;

            }
        }
    }
}
