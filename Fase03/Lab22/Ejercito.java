import java.util.*;
class Ejercito {   
    private ArrayList<ArrayList<Soldado>> army;
    private String kingdom;
    public Ejercito(){
    }
    public Ejercito(ArrayList<ArrayList<Soldado>> army, String kingdom){
        this.army = army;
        this.kingdom = kingdom;
    }
    public void viewSoldiers(String armyespe, int num, ArrayList<ArrayList<Soldado>> army){
        int numbersoldiers = 0;
        System.out.println("El Ejercito " + armyespe + " del " + num + " ejercito sus soldados son :");
        for(int i = 0; i < 10; i++){ //ITERACION
            for(int j = 0; j < 10 ; j++){//ITERACION
                if(army.get(i).get(j) != null){
                    System.out.println("\n*********************************");
                    System.out.println("El " + (numbersoldiers + 1) + " soldado es: ");
                    System.out.println(army.get(i).get(j).toString());
                    numbersoldiers++;
                }
            }
        }
    }
    public void longerLife(ArrayList<ArrayList<Soldado>> army, String kingdom){
        int mayor = 0;//METODO CREADO PARA PODER PERMITIRNOS A CONOCER EL SOLDADO CON MAYOR VIDA DE CADA EJERCITO 
        Soldado soldier = null;
        for(int i = 0; i < army.size(); i++){
            for(int j = 0; j < army.get(i).size(); j++){
                if(army.get(i).get(j) != null){ //COMPROBACION QUE HACEMOS PARA PODER DECIR QUE EL CASILLERO DONDE ESTAMOS ES UN SOLDADO QUE EXISTE
                    if(army.get(i).get(j).getLifeActual() > mayor){ //COMPARAMOS PUNTOS DE VIDA DE CADA SOLDADO PARA VER QUIEN ES EL MAYOR 
                        mayor = army.get(i).get(j).getLifeActual();
                        soldier = army.get(i).get(j);
                    }
                }
            }
        }
        System.out.println("El soldado con mayor vida del Ejercito " + kingdom + " es: ");
        System.out.println(soldier.toString());//IMPRIMIMOS SUS DATOS PARA PODER VER DE QUE SOLDADO SE TRATA 
        System.out.println("*********************************");
    }
    public double averageLife(ArrayList<ArrayList<Soldado>> army , String kingdom){
        int sum = 0;
        int count = 0;
        System.out.println("El promedio de puntos de vida del Ejercito " + kingdom + " es: ");
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get(i).get(j) != null){ 
                    sum += army.get(i).get(j).getLifeActual();
                    count++;
                }
            }
        }
        if(sum != 0){
            double avg = sum / (count * 1.0);
            System.out.println(avg); // DAMOS A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO 
            System.out.println("*********************************");
            return avg;
        }else{
            double avg = 0;
            System.out.println(avg); // DAMOS A CONOCER EL PROMEDIO DE VIDA DE CADA EJERCITO 
            System.out.println("*********************************");
            return avg;
        }
    }
    public void rankingInsercionLife(ArrayList<ArrayList<Soldado>> army , String kingdom){
        System.out.println("\nEl Ejercito " + kingdom + " ordenando por metodo insercion: ");
        int count = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS DE CADA EJERCITO
                if(army.get(i).get(j) != null){ 
                   count++;
                }
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Mostrando Ranking del Ejercito " + kingdom + " ..... ////// --->");
        Soldado[] soldados = new Soldado[count];
        int x = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){ //ITERACION LA CUAL NOS AYUDA A PASAR POR TODOS LOS SOLDADOS AL ARRAY SOLDADO PARA PODER USAR EL USO DEL METODO DE ORDENACION INSERCION
                if(army.get(i).get(j) != null){ 
                    if(count - count + x == count){
                        break;
                    }else{
                        soldados[count - count + x] = army.get(i).get(j); //LA MISMA LOGICA QUE EL ANTERIOR METODO SOLO QUE EN ESTE LO USARIAMOS DE MANERA DIFERENTE YA QUE ESTE SERIA DE FORMA DE INSERCION
                    }
                    x++;   
                }
            }
        }
        int n = soldados.length;
        for (int i = 1; i < n; i++) {
            Soldado actual = soldados[i];
            int j = i - 1;
            while (j >= 0 && soldados[j].getLifeActual() < actual.getLifeActual()) { //ORDENAMOS EL EJERCITO RESPECTIVAMENTE MEDIANTE EL METODO QUE NOS OFRECE INSERCION EL CUAL ES ESTE CODIGO
                soldados[j + 1] = soldados[j];
                j--;
            }
            soldados[j + 1] = actual;
        }
        for(int i = 0; i < soldados.length; i++){
            System.out.print("\n" + "Puesto " + (i + 1));
            System.out.println(soldados[i].toString()); //PUBLICAMOS RESULTADOS
            System.out.println("------------------");
        }
        System.out.println("*********************************");
    }
    public void setArmy(ArrayList<ArrayList<Soldado>> army){
        this.army = army;
    }
    public void setKingdom(String kingdom){
        this.kingdom = kingdom;
    }
    public String getKingdom(){
        return kingdom;
    }
}
