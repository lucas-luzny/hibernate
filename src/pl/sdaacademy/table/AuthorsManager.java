package pl.sdaacademy.table;

import org.hibernate.Session;
import pl.sdaacademy.api.ActionAdapter;
import pl.sdaacademy.api.Executor;
import pl.sdaacademy.model.Author;

import java.util.List;

public class AuthorsManager extends BaseManager<Author> {

	public AuthorsManager(Executor executor) {
		super(executor);
	}

	@Override
	public void add(Author object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				session.save(object);
			}
		});
	}

	@Override
	public void update(Author object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				//Author author = (Author )session.get(Author.class, object.getId());
				Author author = (Author) session.get(Author.class, "4028b8815e3e31d8015e3e32620e0000");
				author.setFirstName(object.getFirstName());
				author.setLastName(object.getLastName());
				author.setYearOfBirth(object.getYearOfBirth());
				session.update(author);
			}
		});
	}

	@Override
	public void delete(Author object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				//Author author = (Author )session.get(Author.class, object.getId());
				Author author = (Author) session.get(Author.class, "4028b8815e3e31d8015e3e32620e0000");
				session.delete(author);
			}
		});

	}

	@Override
	public List<Author> getList() {
		List authors = executor.executeQuery(new ActionAdapter() {
			@Override
			public List onExecuteQuery(Session session) {
				List<Author> authors2 = session.createQuery(getSelectQuery()).list();
				return authors2;
			}
		});
		return authors;
	}

	@Override
	public String getSelectQuery() {
		return "FROM Author";
	}
}
