package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class ResultW {
    @SerializedName("channel")
    private ChannelW channelW;

    public ChannelW getChannelW() {
        return channelW;
    }
}
