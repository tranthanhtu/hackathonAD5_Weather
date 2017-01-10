package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class ChannelW {
    @SerializedName("item")
    private ItemW itemW;

    @SerializedName("wind")
    private WindW windW;

    @SerializedName("atmosphere")
    private Atmosphere atmosphere;

    @SerializedName("astronomy")
    private Astronomy astronomy;

    public WindW getWindW() {
        return windW;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public ItemW getItemW() {
        return itemW;
    }
}
