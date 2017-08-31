package pl.sdaacademy.table;

import org.hibernate.Session;
import pl.sdaacademy.api.ActionAdapter;
import pl.sdaacademy.api.Executor;
import pl.sdaacademy.model.Author1;

import java.util.List;

public class Authors1Manager extends BaseManager<Author1> {
	public Authors1Manager(Executor executor) {
		super(executor);
	}

	@Override
	public void add(Author1 object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				System.out.println("before save : author id = "+object.getId());
				session.save(object);
				System.out.println("after save : author id = "+object.getId());
			}
		});
	}

	@Override
	public void update(Author1 object) {

	}

	@Override
	public void delete(Author1 object) {

	}

	@Override
	public List<Author1> getList() {
		return null;
	}

	@Override
	public String getSelectQuery() {
		return null;
	}
}
