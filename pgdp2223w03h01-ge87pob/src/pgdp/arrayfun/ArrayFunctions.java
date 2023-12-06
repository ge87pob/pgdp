package pgdp.arrayfun;

import java.util.Arrays;


public class ArrayFunctions {

    protected ArrayFunctions() {
        throw new IllegalStateException("Don't create objects of type 'ArrayFunctions'!");
    }

    public static void main(String[] args) {
        //example call
        //System.out.println(Arrays.toString(zip(new int[]{2, 3, 4, 5, 6}, new int[]{2, 4, 3})));
        //System.out.println(sumOfSquares(new int [] {2143433483, 2143434894, 2143434198, 2143994348}));
        /*int [] a = new int [] {1, 2, 3, 4, 5};
        rotate(a, 6);
        System.out.println(Arrays.toString(a));
         */
        //System.out.println(Arrays.toString(zipMany(new int[][] {{1, 3}, {}, {-2}, {}})));
        //System.out.println(Arrays.toString(zipMany(new int [10][0])));



        int [][] a = new int [][] {{1, 1}, {2, 1}, {3, 54545}, {3, 2}, {2, 0}};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            s.append(Arrays.toString(a[i]) +'\n');
        }
        System.out.println(s);
    }

    /** Berechnet für das übergebene Array die Summe der Quadrate der Einträge.
     *  Gibt dabei einen Fehler aus und -1 zurück, wenn ein Overflow entsteht.
     *
     * @param array Ein beliebiges Integer-Array.
     * @return Die Summe der Quadrate, wenn diese in einen 'long' passt, -1 sonst.
     */
    public static long sumOfSquares(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            long factor = array[i];
            long square = factor * factor;
            sum += square;
            if (sum < array[i]) {
                System.out.print("Overflow!");
                return -1;
            }
        }
        return sum;
    }


    /** Methode, die zwei Arrays zu einem verbindet, indem sie abwechselnd Einträge des ersten und des zweiten Input-
     *  Arrays verwendet.
     *
     * @param a Ein beliebiges Integer-Array.
     * @param b Ein beliebiges Integer-Array.
     * @return 'a' und 'b' zusammengezipped.
     */
    public static int[] zip(int[] a, int[] b) {
        int [] c = new int [a.length + b.length];
        int min = a.length;
        if (b.length < a.length) {
            min = b.length;
        }

        //first complete array of size double of smallest array
        for (int i = 0; i < min * 2; i++) {
            if (i % 2 == 0) {
                c[i] = a[i/2];
            }
            else {
                c[i] = b[(i)/2];
             }
        }
        //concatenate rest of array
        if (a.length < b.length) {
            for (int i = a.length; i < b.length; i++) {
                c[i + a.length] = b[i];
            }
        }
        else if (a.length > b.length) {
            for (int i = b.length; i < a.length; i++) {
                c[i + b.length] = a[i];
            }
        }


        return c;
    }

    /** Methode, die eine beliebige Zahl an Arrays (dargestellt als Array von Arrays) zu einem einzigen Array verbindet,
     *  indem sie abwechselnd von jedem Array einen Eintrag nimmt, bis alle aufgebraucht sind.
     *
     * @param arrays Array von Integer-Arrays
     * @return Die Arrays in 'arrays' zusammengezipped
     */
    public static int[] zipMany(int[][] arrays) {
        // count array length
        if (arrays.length == 0) {
            return new int [0];
        }
        int length = 0;
        int max = arrays[0].length;
        for (int i = 0; i < arrays.length; i++) {
            length += arrays[i].length;
            if (arrays[i].length > max) {
                max = arrays[i].length;
            }
        }
        //create new array
        int [] b = new int [length];
        int index = 0;
        //go through every array value with format arrays[j][i]
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arrays.length; j++) {
                //if value at i in arrays[j][i] is out of range because array at arrays[j] is too small continue to next instance
                if (i >= arrays[j].length) {
                    continue;
                }
                b[index] = arrays[j][i];
                index++;
            }
        }
        return b;
    }

    /** Behält aus dem übergebenen Array nur die Einträge, die innerhalb der übergebenen Grenzen liegen.
     *  Gibt das Ergebnis als neues Array zurück.
     *
     * @param array Ein beliebiges Integer-Array
     * @param min Ein beliebiger Integer
     * @param max Ein beliebiger Integer
     * @return Das gefilterte Array
     */
    public static int[] filter(int[] array,int min,int max) {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                length++;
            }
        }

        int [] b = new int [length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                b[index] = array[i];
                index++;
            }
        }
        return b;
    }

    /** Rotiert das übergebene Array um die übergebene Anzahl an Schritten nach rechts.
     *  Das Array wird In-Place rotiert. Es gibt keine Rückgabe.
     *
     * @param array Ein beliebiges Integer-Array
     * @param amount Ein beliebiger Integer
     */
    public static void rotate(int[] array, int amount) {
        //TODO
        int [] b = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            if (amount >= 0) {
                b[(i + amount) % array.length] = array[i];
            }
            else {
                b[i] = array[(i - amount) % array.length];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = b[i];
        }
    }

    /** Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
     *  Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
     *  die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
     *  Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
     *  Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
     *  im übergebenen Array auftauchen.
     *
     * @param array Ein beliebiges Integer-Array
     * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
     */
    public static int[][] quantities(int[] array) {
        //Anzahl unterschiedlicher Elemente, array länge der länge immer 2
        int [][] b = new int [numdistinct(array)][2];
        int [] c = new int [array.length];
        //durch
        int temp = 0;
        int count = 0;
        int index = 0;
        int i = 0;

            //herausfinden ob unique
            A: for (int j = 0; j < array.length; j++) {
                if (i == numdistinct(array)) {
                    break;
                }
                boolean distinct = true;
                for (int k = 0; k < index; k++) {
                    //TODO extra array einführen wo unique wiedergegeben wird
                    if (array[j] == c[k]) {
                        distinct = false;
                        continue A;
                    }
                }
                //TODO Zahl an Stelle array[j], wenn neu und einzigartig dann hinzufügen
                if (distinct) {
                    temp = array[j];
                    b[i][0] = array[j];
                    c[index] = array[j];
                    index++;
                }

                //TODO dann Anzahl hinzufügen
                count = 0;
                for (int l = 0; l < array.length; l++) {
                    if (temp == array[l]) {
                        count++;
                    }
                }
                b[i][1] = count;
                i++;
            }
        return b;
    }

    //Code von W03P01 distinct() Methode
    public static int numdistinct (int [] a) {
        int [] b = new int [a.length];
        int size = 0;
        for (int i = 0; i < a.length; i++) {
            boolean distinct = true;
            for (int j = 0; j < size; j++) {
                if (b[j] == a[i]) {
                    distinct = false;
                    break;
                }
            }
            if (distinct) {
                b[size] = a[i];
                size++;
            }
        }
        return size;
    }
}
