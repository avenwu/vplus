package avenwu.net.kotlinandroid.protocol;

/**
 * Created by chaobin on 7/14/15.
 */
public interface RenderAction<T> {
    void onUpdate(T data);
}
