package com.example.nyesteventure3.travelguide;



    import java.util.ArrayList;
    import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class News_Club {

        @SerializedName("tag")
        @Expose
        private Object tag;
        @SerializedName("success")
        @Expose
        private Integer success;
        @SerializedName("error")
        @Expose
        private Integer error;
        @SerializedName("news")
        @Expose
        private List<News> news = new ArrayList<>();

        public class News {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("place")
            @Expose
            private String place;
            @SerializedName("message")
            @Expose
            private String message;
            @SerializedName("image")
            @Expose
            private String image;
            @SerializedName("date_created")
            @Expose
            private String dateCreated;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(String dateCreated) {
                this.dateCreated = dateCreated;
            }

        }

        public Object getTag() {
            return tag;
        }

        public void setTag(Object tag) {
            this.tag = tag;
        }

        public Integer getSuccess() {
            return success;
        }

        public void setSuccess(Integer success) {
            this.success = success;
        }

        public Integer getError() {
            return error;
        }

        public void setError(Integer error) {
            this.error = error;
        }

        public List<News> getNews() {
            return news;
        }

        public void setNews(List<News> news) {
            this.news = news;
        }

    }


