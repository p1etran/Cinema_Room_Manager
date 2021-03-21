class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        try {
            System.out.println(array[index] * array[index]);
        } catch (NullPointerException e) {
            System.out.println("Exception!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception!");
        }
    }
}
