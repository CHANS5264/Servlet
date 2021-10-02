package kr.or.ddit.basic.json;

public class SampleVO {
	private int id;
	private String name;
	
	//생성자1
	public SampleVO() {	}
	
	//생성자2
	public SampleVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}