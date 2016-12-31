package vn.tranthanhtu.weather.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dell latitude E6520 on 12/15/2016.
 */

public interface WeatherSevice {
    @GET("/v1/public/yql")
    Call<Weather> callQuery(@Query("q") String q, @Query("format") String format);

    class Weather {
        @SerializedName("query")
        private QueryW query;

        public QueryW getQuery() {
            return query;
        }
    }

    class QueryW {
        @SerializedName("results")
        private ResultW resultW;

        public ResultW getResultW() {
            return resultW;
        }
    }

    class ResultW {
        @SerializedName("channel")
        private ChannelW channelW;

        public ChannelW getChannelW() {
            return channelW;
        }
    }

    class ChannelW {
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

    class Astronomy {
        @SerializedName("sunrise")
        private String sunrise;
        @SerializedName("sunset")
        private String sunset;

        public String getSunrise() {
            return sunrise;
        }

        public String getSunset() {
            return sunset;
        }
    }

    class Atmosphere {
        @SerializedName("humidity")
        private String humiditi;
        @SerializedName("pressure")
        private String pressure;
        @SerializedName("rising")
        private String rising;
        @SerializedName("visibility")
        private String visibility;

        public String getHumiditi() {
            return humiditi;
        }

        public String getPressure() {
            return pressure;
        }

        public String getRising() {
            return rising;
        }

        public String getVisibility() {
            return visibility;
        }
    }

    class WindW {
        @SerializedName("chill")
        private String chill;
        @SerializedName("direction")
        private String direction;
        @SerializedName("speed")
        private String speed;

        public String getChill() {
            return chill;
        }

        public String getDirection() {
            return direction;
        }

        public String getSpeed() {
            return speed;
        }
    }

    class ItemW {

        @SerializedName("title")
        private String title;

        public String getTitle() {
            return title;
        }

        @SerializedName("condition")
        private ConditionW conditionW;

        public ConditionW getConditionW() {
            return conditionW;
        }

        @SerializedName("forecast")
        private List<ForecastItem> itemList;

        public List<ForecastItem> getItemList() {
            return itemList;
        }
    }

    class ConditionW {
        @SerializedName("code")
        private String code;
        @SerializedName("temp")
        private int temp;
        @SerializedName("text")
        private String text;

        public String getCode() {
            return code;
        }

        public int getTemp() {
            return temp;
        }

        public String getText() {
            return text;
        }
    }

    class ForecastItem {
        @SerializedName("day")
        private String day;

        @SerializedName("text")
        private String mtext;

        @SerializedName("high")
        private String high;

        @SerializedName("low")
        private String low;

        @SerializedName("code")
        private String code;

        public String getCode() {
            return code;
        }

        public String getMtext() {
            return mtext;
        }

        public String getHigh() {
            return high;
        }

        public String getLow() {
            return low;
        }

        public String getDay() {
            return day;
        }
    }
}
