package space.digitallab.testappforinstat.net;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BodyUrlResponse {

    @SerializedName("match_id")
    @Expose
    private Integer matchId;
    @SerializedName("sport_id")
    @Expose
    private Integer sportId;

    public BodyUrlResponse(Integer matchId, Integer sportId) {
        this.matchId = matchId;
        this.sportId = sportId;
    }



    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

}