package mileber.gson;

/**
 * Created by Mileber on 2016/10/24.
 */

public class ModelObject {
    String name;
    //value 将会在转换时忽略
    transient int value;
    boolean status;
    double f;

    public ModelObject(String name, int value, boolean status, double f){
        this.name = name;
        this.value = value;
        this.status = status;
        this.f = f;
    }

    public String toString(){
        return "ModelObject [name="+name+", value="+value+", status="+status+", f="+f+"]";
    }
}
