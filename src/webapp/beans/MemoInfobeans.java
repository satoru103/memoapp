package webapp.beans;

public class MemoInfobeans {

	private int id;
	private String title;
	private String content;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MemoInfobeans [id=" + id + ", title=" + title + ", content=" + content + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + "]";
	}


}