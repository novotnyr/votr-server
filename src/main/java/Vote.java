import java.util.Date;
import java.util.UUID;


public class Vote {
	private UUID id;
	
	private String name;
	
	private String description;
	
	private Date deadline;

	public Vote() {
		this.id = UUID.randomUUID();
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
}
