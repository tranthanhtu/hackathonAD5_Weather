package vn.tranthanhtu.weather.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dell latitude E6520 on 12/15/2016.
 */

public interface WeatherSevice {
    @GET("/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=\"hochiminh\")&format=json")
    Call<Weather> callQuery();

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

        public ItemW getItemW() {
            return itemW;
        }
    }

    class ItemW {

        @SerializedName("title")
        private String title;

        public String getTitle() {
            return title;
        }

        @SerializedName("forecast")
        private List<ForecastItem> itemList;

        public List<ForecastItem> getItemList() {
            return itemList;
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
