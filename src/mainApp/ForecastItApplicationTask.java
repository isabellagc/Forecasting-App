package mainApp;
import java.util.UUID;


public class ForecastItApplicationTask implements mainApp.appData.IAppObject{

	public static final String TableName = "COLLEGEAPPLICATIONTASKS";
	

	public ForecastItApplicationTask()
	{
		
	}
	
	public ForecastItApplicationTask(long parentId)
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
