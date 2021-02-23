package persistence.website.abstraction;

import java.util.ArrayList;

import model.siteweb.Feedback;

public interface FeedbackDAO {

	public void createTable();
	
	public void insertFeedback(Feedback u);
	
	public ArrayList<Feedback> selectFeedbackByCF(String cf);
}
