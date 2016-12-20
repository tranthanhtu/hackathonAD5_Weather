package vn.tranthanhtu.weather.data;

import org.json.JSONObject;

/**
 * Created by Dell latitude E6520 on 11/30/2016.
 */

public class Item implements JSONPopulator {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
