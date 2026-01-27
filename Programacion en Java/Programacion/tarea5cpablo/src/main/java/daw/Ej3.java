package daw;

public class Ej3 {
    public static String[][] AsientosAvion(){
    

        String[][] matrizAvion = new String[30][6];
        for (int i = 0; i < matrizAvion.length; i++) {
            for (int j = 0; j < matrizAvion[i].length; j++) {
                    matrizAvion[i][j] = "L";
                System.out.print(matrizAvion[i][j] + " ");
            }
            System.out.println();
        }
        return matrizAvion;
    }
}
