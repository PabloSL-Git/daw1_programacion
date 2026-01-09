package array;

public class OrganizarBurbujas {
    public static void main(String[] args) {

        int[] numerosArray = { 6, 5, 3, 1, 2 };

        for (int i = 0; i < numerosArray.length - 1; i++) {
            for (int j = 0; j < numerosArray.length - 1; j++) {

                if (numerosArray[j] > numerosArray[j + 1]) {
                    int temp = numerosArray[j];
                    numerosArray[j] = numerosArray[j + 1];
                    numerosArray[j + 1] = temp;

                }

            }
        }

        for (int i = 0; i < numerosArray.length; i++) {
            System.out.println(numerosArray[i]);
        }

    }

}
