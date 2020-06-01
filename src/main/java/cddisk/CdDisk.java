package cddisk;

public class CdDisk {
    private final String title;
    private final String artist;
    private final String country;
    private final String company;
    private final String price;
    private final String year;

    public CdDisk(String title, String artist, String country, String company, String price, String year) {
        this.title = title;
        this.artist = artist;
        this.country = country;
        this.company = company;
        this.price = price;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public String getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "CdDisk{" +
            "title='" + title + '\'' +
            ", artist='" + artist + '\'' +
            ", country='" + country + '\'' +
            ", company='" + company + '\'' +
            ", price='" + price + '\'' +
            ", year='" + year + '\'' +
            '}';
    }
}
