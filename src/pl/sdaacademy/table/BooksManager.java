package pl.sdaacademy.table;

import org.hibernate.Session;
import pl.sdaacademy.api.ActionAdapter;
import pl.sdaacademy.api.Executor;
import pl.sdaacademy.model.Book;

import java.util.List;

public class BooksManager extends BaseManager<Book> {
	public BooksManager(Executor executor) {
		super(executor);
	}

	@Override
	public void add(Book object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				session.save(object);
			}
		});

	}

	@Override
	public void update(Book object) {

	}

	@Override
	public void delete(Book object) {

	}

	@Override
	public List<Book> getList() {
		return null;
	}

	@Override
	public String getSelectQuery() {
		return null;
	}
}
