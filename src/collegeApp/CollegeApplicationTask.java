package collegeApp;
import java.util.UUID;

import javax.persistence.*;

public class CollegeApplicationTask implements collegeApp.appData.IAppObject{

	public static final String TableName = "COLLEGEAPPLICATIONTASKS";
	
	// TODO NOT USE
	public CollegeApplicationTask()
	{
		
	}
	
	public CollegeApplicationTask(long parentId)
	{
		this.parentId = parentId;
		this.id = UUID.randomUUID().getMostSignificantBits();
	}
	
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	protected Long id;

	public Long getParentId() {	return this.parentId; }
	public void setParentId(Long parentId) { this.parentId = parentId; }
	protected Long parentId;

}
