package services;

public class Operador<T> {

    public static <T extends Comparable<T>>void bubbleSort(T[] obj)
    {
        int n = obj.length;
        if (n>0)
        {
            T temp;
            for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                    if(obj[j-1].compareTo(obj[j])>0){
                        temp = obj[j-1];
                        obj[j-1] = obj[j];
                        obj[j] = temp;
                    }
                }
            }
        }
    }
}
