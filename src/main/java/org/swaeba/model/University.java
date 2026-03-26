package org.swaeba.model;

public class University {
    private int id;
    private String name;
    private String program;
    private String city;
    private String country;
    private int ranking;
    private int fee;
    private int duration;

    public University(int id, String name, String program, String city,
                      String country, int ranking, int fee, int duration) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.city = city;
        this.country = country;
        this.ranking = ranking;
        this.fee = fee;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", ranking=" + ranking +
                ", fee=" + fee +
                ", duration=" + duration +
                '}';
    }
}
