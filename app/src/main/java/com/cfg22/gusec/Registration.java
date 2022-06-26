package com.cfg22.gusec;

public class Registration {
    private String id, pass;
    private String name, startup, phone, email;
    private String address, college;
    private Boolean isStudent;
    private String desc, model, pitch, video;
    private String status;

    public Registration(String id, String pass, String name, String startup, String phone, String email, String address, String college, Boolean isStudent, String desc, String model, String pitch, String video) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.startup = startup;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.college = college;
        this.isStudent = isStudent;
        this.desc = desc;
        this.model = model;
        this.pitch = pitch;
        this.video = video;
        this.status = "Pending";
    }

    public Registration() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartup() {
        return startup;
    }

    public void setStartup(String startup) {
        this.startup = startup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
