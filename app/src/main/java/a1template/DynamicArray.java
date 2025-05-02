// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

/**
 * Dynamic Array extender of Index Access
 */
public class DynamicArray<T> implements IndexAccess<T>{
    
    // What instance variables do you need?
    public T[] array;
    public int size;
    public int offset;

    /**
     * DynamicArray constructor
     * @param offset how much do we want to offset it?
     * @param baseArray array to start with
     */
    DynamicArray (int offset, T[] baseArray) {
        this.array = baseArray;
        this.size = baseArray.length;
        this.offset = offset;
    }

    /**
     * Index getter
     * @param i index
     * @return the data at that index 
     */
    public T get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("ERROR: Index out of bounds.");
        }
        return array[i];
    }

    /**
     * Getter method adjusted for offset
     * @param i index 
     * @param offset how many to adjust
     * @return data 
     */
    public T get(int i, int offset) {
        int adjustedI = i + offset;
        if (adjustedI < 0) {
            return array[size + adjustedI];
        } else if (adjustedI >= size){
            return array[adjustedI - size];
        } else {
            return this.array[adjustedI];
        }
    }

    /**
     * array size getter
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * setter method
     * @param i index at which to set the value
     * @param val new value to set the index to
     */
    public void set(int i, T val) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("ERROR: Index not in range.");
        }
        this.array[i] = val;
    }

    public static void main(String[] args) {
        Integer[] baseArray = new Integer[10];
        for (int i = 0; i < 10; i++) {
            baseArray[i] = Integer.valueOf(i);
        }
        DynamicArray<Integer> testArray = new DynamicArray(0, baseArray);
        testArray.get(0);
        Class<?> thisClass = testArray.get(0).getClass();
        System.out.println(thisClass.getName());

    }

}