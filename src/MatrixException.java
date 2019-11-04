public class MatrixException {
}
class ArraySizeException extends Exception{
    private int size;

    ArraySizeException(int sz){
        size = sz;
    }

    public String toString(){
        return size+" не является допустимым размером массива";
    }
}


class  elTypeException extends  Exception{
    private String str;

    elTypeException(String strVal){
        str = strVal;
    }

    public String toString(){
        return str+" не является целым числом";
    }
}

