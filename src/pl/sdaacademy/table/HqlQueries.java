package pl.sdaacademy.table;

import pl.sdaacademy.model.BaseModel;

public interface HqlQueries<T extends BaseModel> {

    String getSelectQuery();
}
