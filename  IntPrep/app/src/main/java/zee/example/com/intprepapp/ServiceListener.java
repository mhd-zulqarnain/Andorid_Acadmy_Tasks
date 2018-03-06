package zee.example.com.intprepapp;

/**
 * Created by Zul Qarnain on 3/5/2018.
 */

public interface ServiceListener<T> {
    public void success(T obj);
    public void error(ServiceError serviceError);
}
