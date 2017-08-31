package pl.sdaacademy.api;


import org.hibernate.Session;
import pl.sdaacademy.model.Author;
import pl.sdaacademy.model.BaseModel;

import java.util.List;


/**
 * Adapter which is covering {@link Action} interface and allow to not override whole method list
 */
public abstract class ActionAdapter<T extends BaseModel> implements Action<T> {

    public ActionAdapter() {
        super();
    }

    @Override
    public void onExecute(Session session) {
    }

    @Override
    public List<T> onExecuteQuery(Session session) {
        return null;
    }
}
