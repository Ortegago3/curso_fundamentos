class Vehiculo {

    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    int[] arregloVehiculo = new int[10];

    public Vehiculo(){

    }

    public Vehiculo (int mo, String ma, double va){
        this(mo, ma, va, "verde");
    }

    public Vehiculo (int mo, String ma, double va, String co){
        Vehiculo vehiculoA = new Vehiculo();
        vehiculoA.setModelo(mo);
        vehiculoA.setMarca(ma);
        vehiculoA.setValorComercial(va);
        vehiculoA.setColor(co);
        this.vehiculos[posAnadir] = vehiculoA;
        this.posAnadir = this.posAnadir + 1;
    }

    public int getModelo(){
        return this.modelo;   
    }

    public String getMarca(){
        return this.marca;
    }

    public double getValorComercial(){
        return this.valorComercial;
    }

    public String getColor(){
        return this.color;
    }

    public void setModelo(int mo){
        this.modelo = mo;
    }

    public void setMarca(String ma){
        this.marca = ma;
    }

    public void setValorComercial(double va){
        this.valorComercial = va;
    }

    public void setColor(String co){
        this.color = co;
    }

    public String ToString(){
        return "( " + this.modelo + "," + this.marca + "," + this.valorComercial + "," + this.color + ")" ;
    }

    public static String ToStringVehiculos(){
        String cadenaVehiculos = "";
        int modelo;
        String marca;
        double valorComercial;
        String color;

        for(int i = 0; i < posAnadir; i++){
            modelo = vehiculos[i].getModelo();
            marca = vehiculos[i].getMarca();
            valorComercial = vehiculos[i].getValorComercial();
            color = vehiculos[i].getColor();
            cadenaVehiculos = cadenaVehiculos + "(" + modelo + "-" + marca + "-" + valorComercial + "-" + color + ")";
        }
        return cadenaVehiculos;
    }

    public static String ToStringVehiculos2(){
        String cadenaVehiculos = "";
        int modelo;
        String marca;
        double valorComercial;
        String color;


        for(int i = 0; i < posAnadir; i++){
            modelo = vehiculos[i].getModelo();
            marca = vehiculos[i].getMarca();
            valorComercial = vehiculos[i].getValorComercial();
            color = vehiculos[i].getColor();
            if (color.equals("verde") || color.equals("Verde")){
                cadenaVehiculos = cadenaVehiculos + "(" + modelo + "-" + marca + "-" + valorComercial + "-" + color + ")";
            }
        }
        return cadenaVehiculos;
    } 

    public static int cantidadVehiculos(){
        return posAnadir;   
    }
}

