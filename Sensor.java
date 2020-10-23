class Sensor{
    public static Sensor sensores[] = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;
    private String tipo;
    private double valor;
    int[] arregloSensor = new int[8];
    public Sensor(){

    }

    public Sensor(String t, double v){
        Sensor sensorA = new Sensor();
        sensorA.setTipo(t);
        sensorA.setValor(v);
        this.sensores[posAnadir] = sensorA;
        this.posAnadir = posAnadir + 1;
    }

    public String getTipo(){
        return this.tipo;
    }

    public double getValor(){
        return this.valor;
    }

    public void setTipo(String t){
        this.tipo = t;
    }

    public void setValor(double v){
        this.valor = v;
    }

    public String toString(){
        return "( " + this.tipo + "," + this.valor +  ")" ;
    }

    public static String toStringSensores(){
        String cadenaSensores = "";
        String tipo;
        double valor;
        for(int i = 0; i < posAnadir; i++){
            tipo = sensores[i].getTipo();
            valor = sensores[i].getValor();
            cadenaSensores = cadenaSensores + "(" + tipo + "-" + valor + ")";
        }
        return cadenaSensores;
    }

    public static String toStringSensores2(){
        String cadenaSensores = "";
        String tipo;
        double valor;
        for(int i = 0; i < posAnadir; i++){
            tipo = sensores[i].getTipo();
            valor = sensores[i].getValor();
            if(tipo.equals("Temperatura") || tipo.equals("temperatura")){
                cadenaSensores = cadenaSensores + "(" + tipo + "-" + valor + ")";
            }
        }
        return cadenaSensores;
    }

    public static Sensor[] temp(){

        Sensor[] sensoresTemp = new Sensor[8];

        int a = 0;

        int pos_menor;

        Sensor objeto_temporal = new Sensor();

        for(int i = 0;i < posAnadir;i++){

            if(sensores[i].getTipo().equals("temperatura") || sensores[i].getTipo().equals("Temperatura")){
                sensoresTemp[a] = sensores[i];
                a++;

            }

        }

        for (int i = 0; i < a - 1; i++) {
            pos_menor = i;
            for (int j = i + 1; j < a; j++) {
                if (sensoresTemp[j].getValor() < sensoresTemp[pos_menor].getValor()){
                    pos_menor = j;
                }
            }
            objeto_temporal = sensoresTemp[i];
            sensoresTemp[i] = sensoresTemp[pos_menor];
            sensoresTemp[pos_menor]= objeto_temporal;
        }

        return sensoresTemp;

    }

    public static int cantidadSensores(){
        return posAnadir;

    }

}
