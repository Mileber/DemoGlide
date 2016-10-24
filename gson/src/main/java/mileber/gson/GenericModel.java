package mileber.gson;

/**
 * Created by Mileber on 2016/10/24.
 */

public class GenericModel<T> {
    T value;

    public GenericModel(T value) {
        super();
        this.value = value;
    }

    public String toString(){
        return "GenericModel [value=" + value + "]";
    }
}
