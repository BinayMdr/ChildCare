package com.example.dell.childcare;

public class Register {
   private String documentId;
   private String nameofparent;
   private String nameofchild;
   private String gender;
   private String birthdate;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Register()
{

}
    public Register(String nameofparent, String nameofchild, String gender, String birthdate) {
        this.nameofparent = nameofparent;
        this.nameofchild = nameofchild;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getNameofparent() {
        return nameofparent;
    }

    public void setNameofparent(String nameofparent) {
        this.nameofparent = nameofparent;
    }

    public String getNameofchild() {
        return nameofchild;
    }

    public void setNameofchild(String nameofchild) {
        this.nameofchild = nameofchild;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
