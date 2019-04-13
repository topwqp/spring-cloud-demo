package domain;

/**
 * @Description 用户domain
 * @Author Wang QiuPeng
 * Date 19/4/7 17:40
 **/
public class User {
    private Integer userId;
    private String  username;

    public User(){

    }

    private User(Builder builder) {
        setUserId(builder.userId);
        setUsername(builder.username);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public static final class Builder {
        private Integer userId;
        private String username;

        public Builder() {
        }

        public Builder userId(Integer val) {
            userId = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
