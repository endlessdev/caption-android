package us.narin.app.caption.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by endlessdev on 6/25/17.
 */

public class RanksResult {

    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("rankType")
    @Expose
    private String rankType;
    @SerializedName("requestDate")
    @Expose
    private String requestDate;
    @SerializedName("data")
    @Expose
    private List<Rank> data = null;

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = rankType;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public List<Rank> getData() {
        return data;
    }

    public void setData(List<Rank> data) {
        this.data = data;
    }
}