
class StringLinearSearch {

    public static void main(String[] args) {
        String str = "dharani";
        System.out.println("Element found in: " + findInString(str, 'i'));
        System.out.println("Element found in: " + convertStringToArrayAndFind(str, 'h'));
        System.out.println("Element found in: " + findInString(str, 'o'));
        System.out.println("Element found in: " + convertStringToArrayAndFind(str, 'o'));

    }

    static int findInString(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    static int convertStringToArrayAndFind(String str, char target)
    {
      char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                return i;
            }
      } 

      return -1;
    }
}
