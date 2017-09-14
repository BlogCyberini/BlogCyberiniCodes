/*
 * Code by Henrique Felipe (GitHub: HenriqueIni)
 * https://blogcyberini.blogspot.com/
 */
public class LinearSearch {
    /**
     * Search an object <code>key</code> in the vector <code>a</code>.
     * @param a an array
     * @param key search key
     * @return the index of the key or -1, if the key isn't in the vector
     */
    public static int linearSearch(Object[] a, Object key){
        for(int i = 0; i < a.length; i++){
            if(a[i].equals(key)){
                return i; //the value was found, return the index
            }
        }
        return -1; //the value wasn't found
    }
    /**
     * Search the value <code>key</code> in the vector <code>a</code>.
     * @param a an array
     * @param key search key
     * @return the index of the key or -1, if the key isn't in the vector
     */
    public static int linearSearch(int[] a, int key){
        for(int i = 0; i < a.length; i++){
            if(a[i] == key){
                return i; //the value was found, return the index
            }
        }
        return -1; //the value wasn't found
    }
    /*
     * Teste codes     
     */
    public static void main(String[] args) {
        int[] a1 = {2, 3, 8, -1, -4, 20, 0, 5};
        String[] a2 = {"Hello", "World"};
        System.out.println("Key = 20, Index = " + linearSearch(a1, 20));
        System.out.println("Key = \"World\", Index = " + linearSearch(a2, "World"));
        System.out.println("Key = 9, Index = " + linearSearch(a1, 9));
        System.out.println("Key = \"Java\", Index = " + linearSearch(a2, "Java"));
    }
}
