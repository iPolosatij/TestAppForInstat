package space.digitallab.testappforinstat.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team2 {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name_eng")
    @Expose
    private String nameEng;
    @SerializedName("name_rus")
    @Expose
    private String nameRus;
    @SerializedName("score")
    @Expose
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}