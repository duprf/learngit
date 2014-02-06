package dwz.business.common;

public enum AuthorType {
	author("作者"), editor("编者"), translator("译者"), teachingPeople("授课人"), publisher("发表人"), adviser("指导老师"), graduateStudent("研究生"), digester("汇编者");

	private String name;

	AuthorType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
