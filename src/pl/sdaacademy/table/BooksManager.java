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
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				Book book = (Book) session.get(Book.class, " ");
				book.setAuthor(object.getAuthor());
				book.setBookType(object.getBookType());
				book.setName(object.getName());
				session.update(book);
			}
		});
	}

	@Override
	public void delete(Book object) {
		executor.execute(new ActionAdapter() {
			@Override
			public void onExecute(Session session) {
				Book book = (Book) session.get(Book.class, " ");
				session.delete(book);
			}
		});
	}

	@Override
	public List<Book> getList() {
		List books = executor.executeQuery(new ActionAdapter() {
			@Override
			public List onExecuteQuery(Session session) {
				List<Book> books2 = session.createQuery(getSelectQuery()).list();
				return books2;
			}
		});
		return books;
	}

	@Override
	public String getSelectQuery() {
		return "FROM Book";
	}
}
