package DTOs;

import java.util.List;

public class DTORandomUser {
    private List<Result> results;
    private Info info;

    public List<Result> getResults(){
        return results;
    }
    public class Result {

        private String gender;
        private Name name;
        private Location location;
        private String email;
        private Login login;
        private Dob dob;
        private Registered registered;
        private String phone;
        private String cell;
        private Id id;
        private Picture picture;
        private String nat;

        public String getGender(){
            return gender;
        }
        public String getName(){
            return name.toString();
        }
    }


    public class Name {

        private String title;
        private String first;
        private String last;

        @Override
        public String toString(){
            return first+" "+last;

        }
    }



    public class Location {

        private Street street;
        private String city;
        private String state;
        private String postcode;
        private Coordinates coordinates;
        private Timezone timezone;
    }


    public class Login {

        private String uuid;
        private String username;
        private String password;
        private String salt;
        private String md5;
        private String sha1;
        private String sha256;
    }


    public class Dob {

        private String date;
        private Integer age;
    }


    public class Registered {

        private String date;
        private Integer age;
    }


    public class Id {

        private String name;
        private String value;
    }


    public class Picture {

        private String large;
        private String medium;
        private String thumbnail;
    }


    public class Timezone {

        private String offset;
        private String description;
    }


    public class Info {

        private String seed;
        private Integer results;
        private Integer page;
        private String version;
    }

    public class Street{

        private Integer number;
        private String name;
    }

    public class Coordinates {

        private String latitude;
        private String longitude;
    }
}
