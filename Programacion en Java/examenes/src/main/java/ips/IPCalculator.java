package ips;

import java.util.*;

public class IPCalculator {

    static Scanner sc = new Scanner(System.in);

    // ---------------------------
    // Conversion IP -> Binario
    // ---------------------------
    public static String ipToBinary(String ip) {

        String[] parts = ip.split("\\.");
        StringBuilder binary = new StringBuilder();

        for (String part : parts) {

            int num = Integer.parseInt(part);
            String bin = String.format("%8s", Integer.toBinaryString(num)).replace(' ', '0');

            binary.append(bin).append(".");
        }

        return binary.substring(0, binary.length() - 1);
    }

    // ---------------------------
    // Binario -> IP
    // ---------------------------
    public static String binaryToIp(String binary) {

        String[] parts = binary.split("\\.");
        StringBuilder ip = new StringBuilder();

        for (String part : parts) {

            int num = Integer.parseInt(part, 2);
            ip.append(num).append(".");
        }

        return ip.substring(0, ip.length() - 1);
    }

    // ---------------------------
    // CIDR -> Mascara
    // ---------------------------
    public static String cidrToMask(int cidr) {

        int mask = 0xffffffff << (32 - cidr);

        return ((mask >>> 24) & 255) + "." +
               ((mask >>> 16) & 255) + "." +
               ((mask >>> 8) & 255) + "." +
               (mask & 255);
    }

    // ---------------------------
    // Mascara -> CIDR
    // ---------------------------
    public static int maskToCidr(String mask) {

        String[] parts = mask.split("\\.");
        int cidr = 0;

        for (String part : parts) {
            cidr += Integer.bitCount(Integer.parseInt(part));
        }

        return cidr;
    }

    // ---------------------------
    // Bits necesarios para subredes
    // ---------------------------
    public static int bitsSubredes(int subredesNecesarias) {

        int bits = 0;

        while (Math.pow(2, bits) < subredesNecesarias) {
            bits++;
        }

        return bits;
    }

    // ---------------------------
    // Hosts por subred
    // ---------------------------
    public static int hostsPorSubred(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }

    // ---------------------------
    // IP a entero
    // ---------------------------
    public static long ipToLong(String ip) {

        String[] parts = ip.split("\\.");
        long result = 0;

        for (int i = 0; i < 4; i++) {

            result <<= 8;
            result |= Integer.parseInt(parts[i]);
        }

        return result;
    }

    // ---------------------------
    // entero a IP
    // ---------------------------
    public static String longToIp(long ip) {

        return ((ip >> 24) & 255) + "." +
               ((ip >> 16) & 255) + "." +
               ((ip >> 8) & 255) + "." +
               (ip & 255);
    }

    // ---------------------------
    // Network Address
    // ---------------------------
    public static String networkAddress(String ip, int cidr) {

        long ipLong = ipToLong(ip);
        long mask = 0xffffffffL << (32 - cidr);

        return longToIp(ipLong & mask);
    }

    // ---------------------------
    // Broadcast
    // ---------------------------
    public static String broadcast(String ip, int cidr) {

        long ipLong = ipToLong(ip);
        long mask = 0xffffffffL << (32 - cidr);

        long broadcast = (ipLong & mask) | (~mask & 0xffffffffL);

        return longToIp(broadcast);
    }

    // ---------------------------
    // Primer host
    // ---------------------------
    public static String firstHost(String ip, int cidr) {

        long net = ipToLong(networkAddress(ip, cidr));
        return longToIp(net + 1);
    }

    // ---------------------------
    // Ultimo host
    // ---------------------------
    public static String lastHost(String ip, int cidr) {

        long broad = ipToLong(broadcast(ip, cidr));
        return longToIp(broad - 1);
    }

    // ---------------------------
    // Generar subredes
    // ---------------------------
    public static void generarSubredes() {

        System.out.print("IP de red: ");
        String network = sc.nextLine();

        System.out.print("CIDR original: ");
        int cidr = sc.nextInt();

        System.out.print("Subredes necesarias: ");
        int necesarias = sc.nextInt();
        sc.nextLine();

        int bits = bitsSubredes(necesarias);

        int total = (int) Math.pow(2, bits);

        int nuevoCidr = cidr + bits;

        int hosts = hostsPorSubred(nuevoCidr);

        System.out.println("\nBits necesarios: " + bits);
        System.out.println("Subredes totales: " + total);
        System.out.println("Subredes sin usar: " + (total - necesarias));
        System.out.println("Nuevo CIDR: /" + nuevoCidr);
        System.out.println("Hosts por subred: " + hosts);

        long base = ipToLong(network);

        long salto = (long) Math.pow(2, 32 - nuevoCidr);

        System.out.println("\nSubredes:");

        for (int i = 0; i < necesarias; i++) {

            long subnet = base + (salto * i);

            System.out.println("Subred " + (i + 1) + ": " + longToIp(subnet) + "/" + nuevoCidr);
        }
    }

    // ---------------------------
    // Tabla de subredes
    // ---------------------------
    public static void tablaSubredes() {

        System.out.print("IP de red: ");
        String network = sc.nextLine();

        System.out.print("CIDR: ");
        int cidr = sc.nextInt();

        System.out.print("Número de subredes: ");
        int num = sc.nextInt();
        sc.nextLine();

        int bits = bitsSubredes(num);
        int nuevoCidr = cidr + bits;

        long base = ipToLong(network);

        long salto = (long) Math.pow(2, 32 - nuevoCidr);

        System.out.println("\nSubred | Network | First Host | Last Host | Broadcast");

        for (int i = 0; i < num; i++) {

            long net = base + salto * i;
            String netIp = longToIp(net);
            String first = longToIp(net + 1);
            String broad = longToIp(net + salto - 1);
            String last = longToIp(net + salto - 2);

            System.out.println((i + 1) + " | " + netIp + " | " + first + " | " + last + " | " + broad);
        }
    }

    // ---------------------------
    // Superred
    // ---------------------------
    public static void calcularSuperred() {

        System.out.print("Número de redes: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] ips = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("IP red " + (i + 1) + ": ");
            ips[i] = sc.nextLine();
        }

        String bin = ipToBinary(ips[0]).replace(".", "");

        int prefix = 32;

        for (int i = 1; i < n; i++) {

            String other = ipToBinary(ips[i]).replace(".", "");

            for (int j = 0; j < prefix; j++) {

                if (bin.charAt(j) != other.charAt(j)) {

                    prefix = j;
                    break;
                }
            }
        }

        System.out.println("Prefijo común: /" + prefix);
        System.out.println("Máscara: " + cidrToMask(prefix));
    }

    // ---------------------------
    // MENU
    // ---------------------------
    public static void menu() {

        while (true) {

            System.out.println("\n==== CALCULADORA DE REDES ====");
            System.out.println("1. IP -> Binario");
            System.out.println("2. Binario -> IP");
            System.out.println("3. CIDR -> Mascara");
            System.out.println("4. Mascara -> CIDR");
            System.out.println("5. Calcular Subredes");
            System.out.println("6. Tabla de Subredes");
            System.out.println("7. Network Address");
            System.out.println("8. Broadcast");
            System.out.println("9. Primer Host");
            System.out.println("10. Ultimo Host");
            System.out.println("11. Hosts por Subred");
            System.out.println("12. Calcular Superred");
            System.out.println("0. Salir");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("IP: ");
                    System.out.println(ipToBinary(sc.nextLine()));
                    break;

                case 2:
                    System.out.print("Binario: ");
                    System.out.println(binaryToIp(sc.nextLine()));
                    break;

                case 3:
                    System.out.print("CIDR: ");
                    System.out.println(cidrToMask(sc.nextInt()));
                    sc.nextLine();
                    break;

                case 4:
                    System.out.print("Mascara: ");
                    System.out.println(maskToCidr(sc.nextLine()));
                    break;

                case 5:
                    generarSubredes();
                    break;

                case 6:
                    tablaSubredes();
                    break;

                case 7:
                    System.out.print("IP: ");
                    String ip = sc.nextLine();
                    System.out.print("CIDR: ");
                    int cidr = sc.nextInt();
                    sc.nextLine();
                    System.out.println(networkAddress(ip, cidr));
                    break;

                case 8:
                    System.out.print("IP: ");
                    ip = sc.nextLine();
                    System.out.print("CIDR: ");
                    cidr = sc.nextInt();
                    sc.nextLine();
                    System.out.println(broadcast(ip, cidr));
                    break;

                case 9:
                    System.out.print("IP: ");
                    ip = sc.nextLine();
                    System.out.print("CIDR: ");
                    cidr = sc.nextInt();
                    sc.nextLine();
                    System.out.println(firstHost(ip, cidr));
                    break;

                case 10:
                    System.out.print("IP: ");
                    ip = sc.nextLine();
                    System.out.print("CIDR: ");
                    cidr = sc.nextInt();
                    sc.nextLine();
                    System.out.println(lastHost(ip, cidr));
                    break;

                case 11:
                    System.out.print("CIDR: ");
                    System.out.println("Hosts: " + hostsPorSubred(sc.nextInt()));
                    sc.nextLine();
                    break;

                case 12:
                    calcularSuperred();
                    break;

                case 0:
                    return;
            }
        }
    }

    public static void main(String[] args) {

        menu();
    }
}
