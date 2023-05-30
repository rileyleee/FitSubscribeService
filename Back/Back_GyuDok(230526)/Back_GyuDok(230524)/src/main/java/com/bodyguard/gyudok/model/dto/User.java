package com.bodyguard.gyudok.model.dto;

public class User {

	private String id;
	private String password;
	private String username;
	private String nickname;
	private String email;
	private String phone;
	private int age;
	private String address1;
	private String address2;
	private String gender;
	private int expert;
	private String goal;
	private String certificate;
	private String award;
	private String career1;
	private String career2;
	private String career3;
	private int totalcareer;
	private String profile;
	private String fileName;
	private String filePath;
	private String img;
	private float rating;
	private float temperature;

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getExpert() {
		return expert;
	}

	public void setExpert(int expert) {
		this.expert = expert;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getCareer1() {
		return career1;
	}

	public void setCareer1(String career1) {
		this.career1 = career1;
	}

	public String getCareer2() {
		return career2;
	}

	public void setCareer2(String career2) {
		this.career2 = career2;
	}

	public String getCareer3() {
		return career3;
	}

	public void setCareer3(String career3) {
		this.career3 = career3;
	}

	public int getTotalcareer() {
		return totalcareer;
	}

	public void setTotalcareer(int totalcareer) {
		this.totalcareer = totalcareer;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + ", nickname=" + nickname
				+ ", email=" + email + ", phone=" + phone + ", age=" + age + ", address1=" + address1 + ", address2="
				+ address2 + ", gender=" + gender + ", expert=" + expert + ", goal=" + goal + ", certificate="
				+ certificate + ", award=" + award + ", career1=" + career1 + ", career2=" + career2 + ", career3="
				+ career3 + ", totalcareer=" + totalcareer + ", profile=" + profile + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", img=" + img + ", rating=" + rating + ", temperature=" + temperature
				+ "]";
	}

}
