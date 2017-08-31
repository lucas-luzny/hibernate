package pl.sdaacademy.api;

import org.hibernate.Session;
import pl.sdaacademy.model.Author;
import pl.sdaacademy.model.BaseModel;

import java.util.List;

/**
 * Action used by {@link Executor}
 */
public interface Action<T extends BaseModel> {
    void onExecute(Session session);

    List<T> onExecuteQuery(Session session);
}
