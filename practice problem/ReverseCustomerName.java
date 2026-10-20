public class ReverseCustomerName {

    /**
     * Reverses a customer name string using character array manipulation.
     * Keeps original string immutable/unchanged.
     *
     * @param customerName original customer name
     * @return reversed customer name
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Displays original and reversed customer names.
     *
     * @param customerName name to reverse and display
     */
    public static void displayReversedName(String customerName) {
        String reversed = reverseCustomerName(customerName);
        System.out.printf("Input: \"%s\"\nOutput:\nOriginal Name: %s\nReversed Name: %s\n",
                customerName, customerName, reversed);
    }
}
