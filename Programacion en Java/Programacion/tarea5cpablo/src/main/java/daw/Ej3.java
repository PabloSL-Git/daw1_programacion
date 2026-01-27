package daw;

public class Ej3 {
    public static char[][] AsientosAvion() {

        char[][] matrizAvion = new char[30][6];
        for (int i = 0; i < matrizAvion.length; i++) {
            for (int j = 0; j < matrizAvion[i].length; j++) {
                matrizAvion[i][j] = 'L';
            }
        }
        return matrizAvion;
    }
}
