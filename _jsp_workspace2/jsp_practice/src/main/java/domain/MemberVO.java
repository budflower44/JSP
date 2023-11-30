package domain;

public class MemberVO {
	/*  `id` varchar(100) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `age` int DEFAULT '0',
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastlogin` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
	 * */
	
	private String id;
	private String pwd;
	private String email;
	private int age;
	private String regdate;
	private String lastlogin;
	
	public MemberVO() {}
	
	//회원 등록 (join), 회원 정보 수정(modify) : id, pwd, email, age
	public MemberVO(String id, String pwd, String email, int age) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.age = age;
	}
	
	//로그인(login) : id, pwd
	public MemberVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	//회원 상세 조회(detail) : id, pwd, email, age, regdate, lastlogin
	public MemberVO(String id, String pwd, String email, int age, String regdate, String lastlogin) {
		this(id, email, age, regdate, lastlogin);
		this.pwd = pwd;
	}
	
	//회원 리스트 조회(list) : id, email, age, regdate, lastlogin
	public MemberVO(String id, String email, int age, String regdate, String lastlogin) {
		this.id = id;
		this.email = email;
		this.age = age;
		this.regdate = regdate;
		this.lastlogin = lastlogin;
	}
	//회원 삭제 : X
	
	//getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	//toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", email=" + email + ", age=" + age + ", regdate=" + regdate
				+ ", lastlogin=" + lastlogin + "]";
	}
	
	
	
}
