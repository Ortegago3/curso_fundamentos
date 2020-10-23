import java.util.Scanner;
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
        System.out.println("5. Ingresar Sensor");
        System.out.println("6. Mostrar informacion de Sensores");
        System.out.println("7. Cantidad Sensores");
        System.out.println("8. Mostrar informacion de los Sensores de temperatura");
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
                if(num == 1 && Vehiculo.posAnadir<10){

                    int modelo = scan.nextInt();
                    String marca = scan.next();
                    double valorComercial = scan.nextDouble();
                    String color = scan.next();
                    Vehiculo vi = new Vehiculo(modelo, marca, valorComercial, color);

                }else {
                    System.out.println("Error base de datos llena");
                }
                break;

                case 2:
                System.out.println(Vehiculo.ToStringVehiculos());
                break;

                case 3:
                System.out.println(Vehiculo.cantidadVehiculos());
                break;

                case 4:
                System.out.println(Vehiculo.ToStringVehiculos2());
                break;

                case 5:
                if(num == 5 && Sensor.posAnadir<8){

                    String tipo = scan.next();

                    double valor = scan.nextDouble();

                    Sensor vi = new Sensor(tipo, valor);

                }else{
                    System.out.println("Error base de datos llena");

                }
                break;

                case 6:
                System.out.println(Sensor.toStringSensores());
                break;

                case 7:
                System.out.println(Sensor.cantidadSensores());
                break;

                case 8:
                System.out.println(Sensor.toStringSensores2());
                break;

                case 666:
                String cadenaSensores = "";
                String tipo;
                double valor;
                Sensor[] sensoresTemp = Sensor.temp();
                for(int i = 0; i < sensoresTemp.length; i++){
                    if(sensoresTemp[i] != null){
                        tipo = sensoresTemp[i].getTipo();
                        valor = sensoresTemp[i].getValor();
                        cadenaSensores = cadenaSensores + "(" + tipo + "-" + valor + ")";
                    }
                }
                System.out.println(cadenaSensores);

                break;

            }
        }
    }
}
