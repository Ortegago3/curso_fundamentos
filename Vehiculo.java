import java.util.ArrayList;
class Vehiculo {

    public static ArrayList<Vehiculo>vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 0;
    private int id;
    private int modelo;
    private ArrayList<Sensor>sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;

    public Vehiculo(){
        vehiculos.add(this);
        this.id = this.idActual;
        this.idActual += 1;
    }

    public Vehiculo (int mo, String ma, double va){
        this(mo, ma, va, "verde");
    }

    public Vehiculo (int mo, String ma, double va, String co){
        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;
        vehiculos.add(this);
        this.id = this.idActual;
        this.idActual += 1;
    }

    public int getId(){
        return this.id;   
    }

    public int getModelo(){
        return this.modelo;   
    }

    public String getMarca(){
        return this.marca;
    }

    public ArrayList<Sensor> getSensores(){
        return  this.sensores;
    }

    public double getValorComercial(){
        return this.valorComercial;
    }

    public String getColor(){
        return this.color;
    }

    public void setId(int id){
        this.id = id;   
    }

    public void setModelo(int mo){
        this.modelo = mo;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public void setSensores(ArrayList<Sensor> sensores){
        this.sensores = sensores;
    }

    public void setValorComercial(double va){
        this.valorComercial = va;
    }

    public void setColor(String co){
        this.color = co;
    }

    public String toString(){
        return "( " + this.id +"," + this.modelo + "," + this.marca + "," + this.valorComercial + "," + this.color + ")" ;
    }

    public static String toStringVehiculos(){
        String cadenaVehiculos = "";
        for(int i = 0; i < idActual ; i++){
            cadenaVehiculos = cadenaVehiculos + Vehiculo.vehiculos.get(i).toString();
        }
        return cadenaVehiculos;
    }

    public static String toStringVehiculosVerdes(){
        String cadenaVehiculos = "";
        String color;
        for(int i = 0; i < vehiculos.size(); i++){
            color = vehiculos.get(i).getColor();
            if (color.equals("verde") || color.equals("Verde")){
                cadenaVehiculos = cadenaVehiculos + vehiculos.get(i).toString();
            }
        }
        return cadenaVehiculos;
    } 

    public String toStringSensores(){
        String cadenaSensores = "";
        for(int i = 0; i < this.sensores.size(); i++){
            cadenaSensores = cadenaSensores + this.sensores.get(i).toString();
        }
        return cadenaSensores;
    }

    public static String toStringSensoresTemperatura(){
        String cadenaSensores = "";
        String tipo;
        for(int i = 0; i < vehiculos.size(); i++){
            for(int j = 0; j < vehiculos.get(i).cantidadSensores(); j++){
                tipo = vehiculos.get(i).sensores.get(j).getTipo();;
                if(tipo.equals("Temperatura") || tipo.equals("temperatura")){
                    cadenaSensores = cadenaSensores + vehiculos.get(i).sensores.get(j).toString();
                }
            }
        }
        return cadenaSensores;
    }

    public static String mayorCantidadSensores(){
        Vehiculo mayorVehiculo = new Vehiculo();
        for(int i = 0 ; i < vehiculos.size(); i++){
            if(mayorVehiculo.cantidadSensores() < vehiculos.get(i).cantidadSensores()){
                mayorVehiculo = vehiculos.get(i);
            }
        }
        return mayorVehiculo.toString();
    }

    public static int cantidadVehiculos(){
        return vehiculos.size();   
    }

    public int cantidadSensores(){
        return this.sensores.size();   
    }

    public static Vehiculo obtenerVehiculoPorId(int id){
        for(int i = 0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getId() == id){
                return vehiculos.get(i);
            }
        }
        return null;
    }

    public void anadirSensor(Sensor sensor){
        sensores.add(sensor);
    }

    public static ArrayList<Sensor> ordenarSensoresTemperatura(){
        ArrayList<Sensor>sensoresTemp = new ArrayList<Sensor>();

        Sensor objeto_temporal = new Sensor();

        int a = 0;

        int pos_menor;

        for(int i = 0; i < vehiculos.size(); i++){
            for(int j = 0; i < vehiculos.get(i).cantidadSensores(); j++){
                if(vehiculos.get(i).sensores.get(j).getTipo().equals("temperatura") || vehiculos.get(i).sensores.get(j).getTipo().equals("Temperatura")){
                    sensoresTemp.add(vehiculos.get(i).sensores.get(j));
                    a++;

                }
            }
        }

        for (int i = 0; i < a - 1; i++) {
            pos_menor = i;
            for (int j = i + 1; j < a; j++) {
                if (sensoresTemp.get(j).getValor() < sensoresTemp.get(pos_menor).getValor()){
                    pos_menor = j;
                }
            }
            objeto_temporal = sensoresTemp.get(i);
            sensoresTemp.set(i, sensoresTemp.get(pos_menor));
            sensoresTemp.set(pos_menor, objeto_temporal);
        }

        return sensoresTemp;

    }
    
}

